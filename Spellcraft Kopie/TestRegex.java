import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String regex = "%([?]{3})(?<Frage>[\\w ßüäö]*)\\1([!]{3})(?<Antwort>[\\w ßüäö]*)\\3%";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String c1 = matcher.group("Frage");
            String c2 = matcher.group("Antwort");

            System.out.println("\nFrage: " + c1 + "?, Antwort:" + c2);
        }

        sc.close();
    }
}
