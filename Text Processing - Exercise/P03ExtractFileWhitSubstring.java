import java.util.Scanner;

public class P03ExtractFileWhitSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine(); //C:\Internal\training-internal\Template.pptx
        int indexLast = path.lastIndexOf("\\");
        String fullFileName = path.substring(indexLast + 1); // взима подтекста който започва от indexLast + 1
        int indexPoint = fullFileName.indexOf(".");
        String fileName = fullFileName.substring(0, indexPoint);
        String fileExtension = fullFileName.substring(indexPoint + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}
