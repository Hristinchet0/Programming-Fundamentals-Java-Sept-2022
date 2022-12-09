import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        Map<String, Integer> heroesMP = new LinkedHashMap<>();
        int countHeroes = Integer.parseInt(scanner.nextLine());

        for (int hero = 0; hero < countHeroes; hero++) {
            String heroInfo = scanner.nextLine();
            //"{hero name} {HP} {MP}"
            String[] heroData = heroInfo.split("\\s+");
            String heroName = heroData[0];
            int hp = Integer.parseInt(heroData[1]);
            int mp = Integer.parseInt(heroData[2]);

            if(hp <= 100) {
                heroesHP.put(heroName, hp);
            }

            if(mp <= 200) {
                heroesMP.put(heroName, mp);
            }
        }

        String commands = scanner.nextLine();

        while (!commands.equals("End")) {

            if(commands.contains("CastSpell")) {
                //"CastSpell – {hero name} – {MP needed} – {spell name}"
                //•	If the hero has the required MP, he casts the spell, thus reducing his MP. Print this message:
                //o	"{hero name} has successfully cast {spell name} and now has {mana points left} MP!"
                //•	If the hero is unable to cast the spell print:
                //o	"{hero name} does not have enough MP to cast {spell name}!"
                String heroName = commands.split("\\s+-\\s+")[1];
                int mpNeeded = Integer.parseInt(commands.split("\\s+-\\s+")[2]);
                String spellName = commands.split("\\s+-\\s+")[3];
                int currentMP = heroesMP.get(heroName);
                if(currentMP >= mpNeeded) {
                    int mpLeft = currentMP - mpNeeded;
                    heroesMP.put(heroName, mpLeft);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }

            } else if (commands.contains("TakeDamage")) {
                //"TakeDamage – {hero name} – {damage} – {attacker}"
                //•	Reduce the hero HP by the given damage amount. If the hero is still alive (his HP is greater than 0) print:
                //o	"{hero name} was hit for {damage} HP by {attacker} and now has {current HP} HP left!"
                //•	If the hero has died, remove him from your party and print:
                //o	"{hero name} has been killed by {attacker}!"
                String heroName = commands.split("\\s+-\\s+")[1];
                int damage = Integer.parseInt(commands.split("\\s+-\\s+")[2]);
                String attacker = commands.split("\\s+-\\s+")[3];
                int currentHP = heroesHP.get(heroName);
                currentHP -= damage;
                if(currentHP > 0) {
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                    heroesHP.put(heroName, currentHP);
                } else {
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    heroesHP.remove(heroName);
                    heroesMP.remove(heroName);
                }

            } else if (commands.contains("Recharge")) {
                //"Recharge – {hero name} – {amount}"
                //•	The hero increases his MP. If it brings the MP of the hero above the maximum value (200), MP is increased to 200. (the MP can't go over the maximum value).
                //•	 Print the following message:
                //o	"{hero name} recharged for {amount recovered} MP!"
                String heroName = commands.split("\\s+-\\s+")[1];
                int amount = Integer.parseInt(commands.split("\\s+-\\s+")[2]);
                int currentMP = heroesMP.get(heroName);
                currentMP += amount;
                if (currentMP > 200) {
                    currentMP = 200;
                }
                System.out.printf("%s recharged for %d MP!%n", heroName, currentMP - heroesMP.get(heroName));
                heroesMP.put(heroName, currentMP);

            } else if (commands.contains("Heal")) {
                //"Heal – {hero name} – {amount}"
                //•	The hero increases his HP. If a command is given that would bring the HP of the hero above the maximum value (100), HP is increased to 100 (the HP can't go over the maximum value).
                //•	 Print the following message:
                //o	"{hero name} healed for {amount recovered} HP!"
                String heroName = commands.split("\\s+-\\s+")[1];
                int amount = Integer.parseInt(commands.split("\\s+-\\s+")[2]);
                int currentHP = heroesHP.get(heroName);
                currentHP += amount;
                if (currentHP > 100) {
                    currentHP = 100;
                }
                System.out.printf("%s healed for %d HP!%n", heroName, currentHP - heroesHP.get(heroName));
                heroesHP.put(heroName, currentHP);
            }

            commands = scanner.nextLine();
        }

        //heroesHP : heroname -> heroHP
        //heroesMP : heroname - heroMP

        heroesHP.entrySet()
                .forEach(entry -> {
                    String heroName = entry.getKey();
                    System.out.println(heroName);
                    System.out.println(" HP: " + entry.getValue());
                    System.out.println(" MP: " + heroesMP.get(heroName));
                });


    }
}
