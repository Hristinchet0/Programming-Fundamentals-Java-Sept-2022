import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String firstString = input[0];
        String secondString = input[1];
        
        long sum = calculateSum(firstString, secondString);

        System.out.println(sum);
    }

    private static long calculateSum(String firstString, String secondString) {
        char[] firstArr = firstString.toCharArray();
        char[] secondArr = secondString.toCharArray();
        long sum = 0;
        int minLength = Math.min(firstArr.length, secondArr.length);
        int maxLength = Math.max(firstArr.length, secondArr.length);
        //character codes multiplied (multiply str1[0] with str2[0] and add to the total sum)
        for (int i = 0; i < minLength; i++) {
            sum += (long) firstArr[i] * secondArr[i];
        }
        //If one of the strings is longer than the other,
        // add the remaining character codes to the total sum without multiplication.
        if(maxLength == firstArr.length) {
            for (int i = minLength; i < maxLength; i++) {
                sum += firstArr[i];
            }
        } else {
            for (int i = minLength; i <maxLength ; i++) {
                sum += secondArr[i];
            }
        }
        return sum;
    }
}
