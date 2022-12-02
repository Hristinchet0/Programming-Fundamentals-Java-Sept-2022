import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //C:\Internal\training-internal\Template.pptx
        String path = scanner.nextLine();
        String[] pathParts = path.split("\\\\");
        String fullFileName = pathParts[pathParts.length - 1]; // Template.pptx
        String fileName = fullFileName.split("\\.")[0]; //Template
        String extension = fullFileName.split("\\.")[1]; //pptx


        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
