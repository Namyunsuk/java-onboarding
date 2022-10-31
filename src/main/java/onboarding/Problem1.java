package onboarding;

import java.util.List;

class Calculation {
	public static int sumOfPageNumbers(int pageNumber) {
		int sum = 0;
		while (pageNumber > 0) {
			sum += pageNumber % 10;
			pageNumber /= 10;
		}
		return sum;
	}

	public static int mulOfPageNumbers(int pageNumber) {
		int mul = 1;
		while (pageNumber > 0) {
			mul *= pageNumber % 10;
			pageNumber /= 10;
		}
		return mul;
	}
}

class FindingMax {
	public static int findMaxValue(int left, int right) {
		int leftMaxValue =
			Calculation.sumOfPageNumbers(left) > Calculation.mulOfPageNumbers(left)
				? Calculation.sumOfPageNumbers(left) : Calculation.mulOfPageNumbers(left);
		int rightMaxValue =
			Calculation.sumOfPageNumbers(right) > Calculation.mulOfPageNumbers(right)
				? Calculation.sumOfPageNumbers(right) : Calculation.mulOfPageNumbers(right);
		return leftMaxValue > rightMaxValue ? leftMaxValue : rightMaxValue;
	}
}

class FindingWinner {
	public static int winner(int pobiMaxNumber, int crongMaxNumber) {
		if (pobiMaxNumber == crongMaxNumber) {
			return 0;
		}
		return pobiMaxNumber > crongMaxNumber ? 1 : 2;
	}
}

class Exception {
	public static boolean invalidPageNumber(int left, int right) {
		if (left < 1 || left > 400 || right < 1 || right > 400) {
			return true;
		}
		if ((right - left) != 1) {
			return true;
		}
		return false;
	}
}

public class Problem1 {
	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int pobiLeftPageNumber = pobi.get(0);
		int pobiRightPageNumber = pobi.get(1);
		int crongLeftPageNumber = crong.get(0);
		int crongRightPageNumber = crong.get(1);
		int answer = -1;
		int pobiMaxNumber;
		int crongMaxNumber;
		if (!Exception.invalidPageNumber(pobiLeftPageNumber, pobiRightPageNumber)
			&& !Exception.invalidPageNumber(crongLeftPageNumber, crongRightPageNumber)) {
			pobiMaxNumber = FindingMax.findMaxValue(pobiLeftPageNumber, pobiRightPageNumber);
			crongMaxNumber = FindingMax.findMaxValue(crongLeftPageNumber, crongRightPageNumber);
			answer = FindingWinner.winner(pobiMaxNumber, crongMaxNumber);
		}
		return answer;
	}
}
