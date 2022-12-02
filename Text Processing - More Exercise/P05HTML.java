import java.util.Scanner;

public class P05HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You will receive 3 lines of input. On the first line, you will receive a title of an article.
        // On the next line, you will receive the content of that article.
        // On the next n lines, until you receive "end of comments", you will get the comments about the article.

        String titleOfArticle = scanner.nextLine();
        String contentOfArticle = scanner.nextLine();
        String commentsOfArticle = scanner.nextLine();

        System.out.printf("<h1>\n" +
                "    %s\n" +
                "</h1>\n", titleOfArticle);

        System.out.printf("<article>\n" +
                "    %s\n" +
                "</article>\n", contentOfArticle);

        while (!commentsOfArticle.equals("end of comments")) {
            System.out.printf("<div>\n" +
                    "    %s\n" +
                    "</div>\n", commentsOfArticle);


            commentsOfArticle = scanner.nextLine();
        }
    }
}
