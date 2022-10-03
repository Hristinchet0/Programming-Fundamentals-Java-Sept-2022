import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Use an array of strings holding the day names:
        // {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
        // "Saturday", "Sunday"}.
        //•	Print the element at index (day-1)
        // when it is in the range [1…7] or "Invalid Day!" otherwise.

        String[] dayOfWeekArr = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        int n = Integer.parseInt(scanner.nextLine());

        if (n >= 1 && n <= 7) {
            System.out.println(dayOfWeekArr[n - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
