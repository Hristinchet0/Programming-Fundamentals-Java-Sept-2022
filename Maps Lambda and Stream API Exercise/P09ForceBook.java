import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        //запис: група (side) -> списък с user
        Map<String, List<String>> map = new LinkedHashMap<>();
        while (!command.equals("Lumpawaroo")) {

            if (command.contains(" | ")) {
                //command = "{force_side} | {force_user}".split(" | ")
                String group = command.split("\\s+\\|\\s+")[0];
                String user = command.split("\\s+\\|\\s+")[1];
                //1.Ако нямаме такава група
                if (!map.containsKey(group)) {
                    //група -> празен списък
                    map.put(group, new ArrayList<>());
                }
                //2.ако имаме такава група -> добавяме към групата user, ако го няма в никоя друга група
                boolean isExistUser = false; //дали usera го има в дадена група
                for (List<String> listUsers : map.values()) { //обхождаме всички списъци с users в групите
                    if (listUsers.contains(user)) {
                        //user го има в някоя група
                        isExistUser = true;
                        break;
                    }
                }
                if (!isExistUser) {
                    //usera го няма в никоя група
                    map.get(group).add(user);
                }
            } else if (command.contains(" -> ")) {
                //command = "{force_user} -> {force_side}"
                String user = command.split("\\s+->\\s+")[0];
                String group = command.split("\\s+->\\s+")[1];
                //1.ако даедния user го има в дадена група -> премахваме го от текущата група
                //запис: група (key) -> списък с users (value)
                map.entrySet().forEach(entry -> entry.getValue().remove(user));
                //2. проверяваме дали имае такава група
                if (map.containsKey(group)) {
                    //ако групата я има, добавяме user-a в списъка
                    map.get(group).add(user);
                } else {
                    //ако нямаме такава група в която иска да отиде -> създаваме я
                    map.put(group, new ArrayList<>()); //създаваме нова група
                    map.get(group).add(user); //добавяме user-a
                }

                System.out.printf("%s joins the %s side!%n", user, group);

            }
            command = scanner.nextLine();
        }

        //запис: група -> списък с users
        //1.да филтрираме записте -> списъка с хората не е празен (бр.хората е > 0)
        //оставяме само записите които отговарят на условието users > 0
        map.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                            //"Side: {forceSide}, Members: {forceUsers.Count}
                            //! {forceUser}....
                            //entry: groupName(key) -> list of users (value)
                            //entry: groupName(key) -> list of users (value)
                            //"Side: {forceSide}, Members: {forceUsers.Count}
                            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                            entry.getValue().forEach(user -> System.out.println("! " + user));
                        }
                );

    }
}
