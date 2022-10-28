package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Money{
    static final int[] moneyList = {50000,10000,5000,1000,500,100,50,10,1};
    static final String invalidArgument = "InvalidArgument";
}
class validateMoney extends calculateMoney{
    public static boolean isDivide(int money){
        return (money/divideMoney)>0;
    }
    public static boolean isValidAmount(int money){
        return (money>=1)&&(money<=1_000_000);
    }
}
class calculateMoney{
    static int divideMoney;
    public static void setDivideMoney(int money){
        divideMoney = money;
    }
    public static int divide(int money){
        return  money/divideMoney;
    }
    public static int remainder(int money){
        return money%divideMoney;
    }
}
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
