import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean validatePassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        int categoriesCount = 0;

        // Check for lowercase letters
        if (password.matches(".*[a-z].*")) {
            categoriesCount++;
        }

        // Check for uppercase letters
        if (password.matches(".*[A-Z].*")) {
            categoriesCount++;
        }

        // Check for numbers
        if (password.matches(".*\\d.*")) {
            categoriesCount++;
        }

        // Check for special symbols
        Pattern specialSymbolPattern = Pattern.compile(".*[~!@#$%^&*()\\-=_+].*");
        Matcher specialSymbolMatcher = specialSymbolPattern.matcher(password);
        if (specialSymbolMatcher.matches()) {
            categoriesCount++;
        }

        return categoriesCount >= 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to validate: ");
        String password = scanner.nextLine();

        if (validatePassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}
