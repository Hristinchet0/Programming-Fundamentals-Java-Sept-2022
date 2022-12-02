import java.util.*;
import java.util.function.Predicate;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> companyInfo = new LinkedHashMap<>();
        while (!input.equals("End")) {
            String companyName = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];

            if(companyInfo.containsKey(companyName)) {
                List<String> employees = companyInfo.get(companyName);
                if(!employees.contains(employeeID)) {
                    employees.add(employeeID);
                }
            } else {
                List<String> employees = new ArrayList<>();
                employees.add(employeeID);
                companyInfo.put(companyName, employees);

            }

            input = scanner.nextLine();
        }

        companyInfo.entrySet()
                .forEach(company -> {
                    System.out.println(company.getKey());
                    company.getValue().forEach(employee -> System.out.println("-- " + employee));
                });
    }
}
