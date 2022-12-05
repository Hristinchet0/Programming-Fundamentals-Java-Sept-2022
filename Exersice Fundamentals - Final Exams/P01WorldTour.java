import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tripStops = scanner.nextLine();
        //Hawai::Cyprys-Greece

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] commands = input.split(":");
            String command = commands[0];
            String addStop = "";
            String newTrip = "";
            String oldStop = "";
            int startIndex = 0;
            int endIndex = 0;
            switch (command) {
                case "Add Stop":
                    //•	"Add Stop:{index}:{string}":
                    //o	Insert the given string at that index only if the index is valid
                    //Add Stop:7:Rome
                    startIndex = Integer.parseInt(commands[1]);
                    addStop = commands[2];
                    if (startIndex >= 0 && startIndex < tripStops.length()) {
                        newTrip = tripStops.substring(0, startIndex) + addStop + tripStops.substring(startIndex);
                        tripStops = newTrip;
                    }
                    System.out.println(tripStops);
                    break;
                case "Remove Stop":
                    //•	"Remove Stop:{start_index}:{end_index}":
                    //o	Remove the elements of the string from the starting index to the end index (inclusive) if both indices are valid
                    //Remove Stop:11:16
                    startIndex = Integer.parseInt(commands[1]);
                    endIndex = Integer.parseInt(commands[2]);
                    if (startIndex >= 0 && startIndex < tripStops.length() && endIndex >= 0 && endIndex < tripStops.length()) {
                        newTrip = tripStops.substring(startIndex, endIndex + 1);
                        tripStops = tripStops.replace(newTrip, "");
                    }
                    System.out.println(tripStops);
                    break;
                case "Switch":
                    //•	"Switch:{old_string}:{new_string}":
                    //o	If the old string is in the initial string, replace it with the new one (all occurrences)
                    //Switch:Hawai:Bulgaria
                    oldStop = commands[1];
                    addStop = commands[2];
                    if (tripStops.contains(oldStop)) {
                        tripStops = tripStops.replace(oldStop, addStop);
                        System.out.println(tripStops);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", tripStops);
    }
}
