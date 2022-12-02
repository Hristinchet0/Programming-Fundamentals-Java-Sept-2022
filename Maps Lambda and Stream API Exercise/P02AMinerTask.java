import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();


        Map<String, Integer> listResources = new LinkedHashMap<>();

        while(!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if(!listResources.containsKey(resource)) {
                listResources.put(resource, quantity);
            } else {
                listResources.put(resource, listResources.get(resource) + quantity);
            }

            resource = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : listResources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }

    }
}
