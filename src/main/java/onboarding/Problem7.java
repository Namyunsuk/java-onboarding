package onboarding;

import java.util.*;
import java.util.stream.Collectors;

import static onboarding.handleList.copyList;

class scoreConstant{
    static final int friendsFriendScore = 10;
    static final int visitorScore = 1;
}
class usersInformation extends scoreConstant{
    private static String user;
    private static List<List<String>> friends;
    private static List<String> visitors;
    public static void setUser(String name) {
        user = name;
    }
    public static void setFriends(List<List<String>> list) {
        friends = list;
    }
    public static void setVisitors(List<String> list) {
        visitors = list;
    }
    public static String getUser() {
        return user;
    }
    public static List<List<String>> getFriends() {
        return friends;
    }
    public static List<String> getVisitors() {
        return visitors;
    }
}
class handleFriendsInformation extends usersInformation{
    private static List<String> usersFriends;
    private static List<String> friendsFriend;
    public static void setUsersFriends(List<String> list) {
        usersFriends = list;
    }
    public static void setFriendsFriend(List<String> list) {
        friendsFriend = list;
    }
    public static List<String> getFriendsFriend() {
        return friendsFriend;
    }
    public static boolean isIncludeUserOrFriends(String name){
        return (usersFriends.contains(name)||getUser().equals(name))?true:false;
    }
    public static int findFriendsIndex(String user, List<String> friends) {
        return friends.get(0).equals(user) ? 1 : 0;
    }
    public static void findUsersFriend() {
        List<String> usersFriends = getFriends().stream()
                .filter(i -> i.contains(getUser()))
                .map(i -> i.get(findFriendsIndex(getUser(), i)))
                .collect(Collectors.toList());
        setUsersFriends(usersFriends);
    }
    public static void findFriendsFriend() {
        List<String> friendsFriendList=new ArrayList<String>();
        Iterator<String> iterator = usersFriends.iterator();
        while (iterator.hasNext()) {
            String friend = iterator.next();
            List<String> list = getFriends().stream()
                    .filter(i -> i.contains(friend))
                    .map(i -> i.get(findFriendsIndex(friend, i)))
                    .distinct()
                    .collect(Collectors.toList());
            copyList(friendsFriendList, list);
        }
        setFriendsFriend(friendsFriendList);
    }
}
class score extends handleFriendsInformation {
    static Map<String, Integer> recommendedFriends = new HashMap<String, Integer>();
    public static List<String> shortenListIntoFive(List<String> recommendedList){
        List<String>list = recommendedList.stream()
                .limit(5)
                .collect(Collectors.toList());
        return list;
    }
    public static List<String> orderRecommendedList(){
        List<Map.Entry<String, Integer>> entries = recommendedFriends.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());
        List<String> orderedRecommendedList = entries.stream()
                .map(i -> i.getKey())
                .collect(Collectors.toList());
        System.out.println(entries);
        return orderedRecommendedList;
    }
    public static void caseFriendsFriend() {
        Iterator<String> iterator = getFriendsFriend().iterator();
        while (iterator.hasNext()) {
            String recommendedFriend = iterator.next();
            if(isIncludeUserOrFriends(recommendedFriend)){continue;}
            if (recommendedFriends.containsKey(recommendedFriend)) {
                recommendedFriends.put(recommendedFriend, recommendedFriends.get(recommendedFriend) + friendsFriendScore);
                continue;
            }
            recommendedFriends.put(recommendedFriend, friendsFriendScore);
        }
    }
    public static void caseVisitors() {
        //removeFriends(visitors);
        Iterator<String> iterator = getVisitors().iterator();
        while (iterator.hasNext()) {
            String recommendedFriend = iterator.next();
            if(isIncludeUserOrFriends(recommendedFriend)){continue;}
            if (recommendedFriends.containsKey(recommendedFriend)) {
                recommendedFriends.put(recommendedFriend, recommendedFriends.get(recommendedFriend) + visitorScore);
                continue;
            }
            recommendedFriends.put(recommendedFriend, visitorScore);
        }
    }
}
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
