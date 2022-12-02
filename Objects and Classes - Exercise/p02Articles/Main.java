package p02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        String[] articleParts = articleData.split(",\\s+");
        String title = articleParts[0];
        String content = articleParts[1];
        String author = articleParts[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int commandCount = 1; commandCount <= n; commandCount++) {
            String command = scanner.nextLine();
            //"Edit"
            //"Rename"
            //"ChangeAuthor"
            if (command.contains("Edit")) {
                //променя съдържанието на моята статия с даденото
                String newContent = command.split(": ")[1];
                article.edit(newContent); //ново съдържание

            }else if(command.contains("Rename")) {
                //променя заглавието на статията с даденото
                String newTitle = command.split(": ")[1];
                article.rename(newTitle); //ново заглавие

            }else if(command.contains("ChangeAuthor")) {
                String newAuthor = command.split(": ")[1];
                article.changeAuthor(newAuthor); //новия автор
            }
        }

        //Заглавието - Съдържанието: автора
        System.out.println(article.toString());
    }
}
