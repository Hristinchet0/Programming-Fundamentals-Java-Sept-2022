import java.util.Arrays;
import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] len = new int[nums.length];
        int[] prev = new int[nums.length];

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {

            len[currentIndex] = 1;
            prev[currentIndex] = -1;

            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {

                if (nums[prevIndex] < nums[currentIndex] &&
                        len[prevIndex] >= len[currentIndex]) {

                    len[currentIndex] = len[prevIndex] + 1;
                    prev[currentIndex] = prevIndex;
                }
            }
        }

        int lastIndex = -1;
        int maxLen = 0;

        for (int index = 0; index < nums.length; index++) {
            if (maxLen < len[index]) {
                maxLen = len[index];
                lastIndex = index;
            }
        }

        int[] lisElements = new int[maxLen];

        while (lastIndex != -1) {
            lisElements[--maxLen] = nums[lastIndex];
            lastIndex = prev[lastIndex];
        }

        for(int i = 0; i < lisElements.length; i++){
            System.out.print(lisElements[i] + " ");
        }
    }
}
