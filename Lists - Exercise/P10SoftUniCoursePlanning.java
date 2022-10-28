import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            String lessonTile = tokens[1];
            switch (command) {
                case "Add":
                    if (!schedule.contains(lessonTile)) {
                        schedule.add(lessonTile);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(lessonTile)) {
                        schedule.add(index, lessonTile);
                    }
                    break;
                case "Remove":
                    if (schedule.contains(lessonTile)) {
                        schedule.remove(lessonTile);
                    }
                    int indexLesson = schedule.indexOf(lessonTile);
                    if (schedule.get(indexLesson + 1).equals(lessonTile + "Exercise")) {
                        schedule.remove(indexLesson + 1);
                    }
                    break;
                case "Swap":
                    String lessonTile2 = input.split(":")[2];
                    if (schedule.contains(lessonTile) && schedule.contains(lessonTile2)) {
                        int lesson1Index = schedule.indexOf(lessonTile);
                        int lesson2Index = schedule.indexOf(lessonTile2);
                        schedule.set(lesson1Index, lessonTile2);
                        schedule.set(lesson2Index, lessonTile);

                        String exOne = lessonTile + "-Exercise";
                        String exTwo = lessonTile2 + "-Exercise";
                        if (schedule.contains(exOne)) {
                            schedule.remove(schedule.indexOf(exOne));
                            schedule.add(schedule.indexOf(lessonTile + 1), exOne);
                        }
                        if (schedule.contains(exTwo)) {
                            schedule.remove(schedule.indexOf(exTwo));
                            schedule.add(schedule.indexOf(lessonTile2) + 1, exTwo);
                        }
                    }
                    break;
                case "Exercise":
                    String exercise = lessonTile + "-Exercise";
                    int indexLessonTile = schedule.indexOf(lessonTile);
                    if (schedule.contains(lessonTile)) {
                        if(indexLessonTile == schedule.size() - 1) {
                            schedule.add(indexLessonTile + 1, exercise);
                        } else if (!schedule.get(indexLessonTile + 1).equals(exercise)) {
                            schedule.add(indexLessonTile + 1, exercise);
                        }
                    } else {
                        schedule.add(lessonTile);
                        schedule.add(exercise);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printList(schedule);
    }
    public static void printList(List<String> elements) {
        int count = 1;
        for (String element : elements) {
            System.out.println(count + "." + element);
            count++;
        }
    }
}
