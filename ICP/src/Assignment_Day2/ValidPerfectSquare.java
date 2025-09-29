package Assignment_Day2;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		  int[] testCases = {16, 14, 1, 1000000, 808201};

	        for (int num : testCases) {
	            System.out.println(num + ":" + isPerfectSquare(num));
	        }
	    }

	    // TC O(log n)
	    // SC O(1)
	    public static boolean isPerfectSquare(int num) {
	        if (num < 2) {
	            return true;
	        }

	        long start = 1, end = num/2;

	        while (start <= end) {
	            long mid = start + (end - start) / 2;
	            long midSquared = mid * mid;

	            if (midSquared == num) {
	                return true;
	            } else if (midSquared < num) {
	                start = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }

	        return false;
	    }
	}
