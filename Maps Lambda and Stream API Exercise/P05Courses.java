import java.util.*;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, List<String>> courseInformation = new LinkedHashMap<>();

        while(!command.equals("end")) {
            //Programming Fundamentals : John Smith
            String[] data = command.split(" : ");
            String courseName = data[0];
            String studentName = data[1];

            if(!courseInformation.containsKey(courseName)) {
                courseInformation.put(courseName, new ArrayList<>());
            }
            courseInformation.get(courseName).add(studentName);

            command = scanner.nextLine();
        }
        courseInformation.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
        });
    }
}
