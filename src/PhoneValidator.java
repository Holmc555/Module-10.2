import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    public static void main(String[] args) {
        validatePhoneNumbers("C://Users/Олег/IdeaProjects/Module 10.2/PhoneValid.txt");
    }

    public static void validatePhoneNumbers(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
