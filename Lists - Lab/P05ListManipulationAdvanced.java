import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String lineInput = scanner.nextLine();

        while (!"end".equals(lineInput)) {
            String[] data = lineInput.split("\\s+");

            switch (data[0]) {
                case "Contains":
                    int contains = Integer.parseInt(data[1]);

                    if (numberList.contains(contains)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    int output = 0;
                    if (data[1].equals("even")) {
                        for (int i = 0; i<numberList.size(); i++ ){
                            if (numberList.get(i) % 2 == 0) {
                                System.out.print(numberList.get(i)+" ");
                            }
                        }

                    } else if (data[1].equals("odd")) {
                        for (int i = 0; i<numberList.size(); i++ ){
                            if (numberList.get(i) % 2 != 0) {
                                System.out.print(numberList.get(i)+" ");
                            }
                        }

                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;

                    for (Integer number : numberList) {
                        sum += number;

                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String outputFilter = "";
                    int num = Integer.parseInt(data[2]);
                    if (data[1].equals("<")) {
                        for (Integer aList : numberList) {
                            if (aList < num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    } else if (data[1].equals(">")) {
                        for (Integer aList : numberList) {
                            if (aList > num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    } else if (data[1].equals(">=")) {
                        for (Integer aList : numberList) {
                            if (aList >= num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    } else if (data[1].equals("<=")) {
                        for (Integer aList : numberList) {
                            if (aList <= num) {
                                outputFilter += String.valueOf(aList) + " ";

                            }
                        }
                        System.out.println(outputFilter);
                    }
                    break;
            }
            lineInput = scanner.nextLine();
        }
    }
}