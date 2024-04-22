import java.util.Scanner;
import java.util.regex.Pattern;

public class LoginProgram {

    private static String username;
    private static String password;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        while (!checkUsername(username)) {
           System.out.println("Username must contain at least one underscore ('_') and be no more than 20 characters long.");
           System.out.print("Please enter a new username: ");
            username = scanner.nextLine();
        }

        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        while (!checkPasswordComplexity(password)) {
           System.out.println("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one digit. Special characters are allowed but not required.");
           System.out.print("Please enter a new password: ");
            password = scanner.nextLine();
        }

        System.out.println("Welcome, " + firstName + " " + lastName + "! Your username was successfully captured.");

        System.out.print("Enter your username to log in: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter your password to log in: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccess = loginUser(loginUsername, loginPassword);

        if (loginSuccess) {
          System.out.println("Login successful! Welcome back " + firstName + " " + lastName + ".");
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }

  
    }

    private static boolean checkUsername(String username) {
        return username.matches("^[a-zA-Z0-9]*(_[a-zA-Z0-9]+)*$") && username.length() <= 20;
    }

    private static boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 &&
                Pattern.compile("[a-z]").matcher(password).find() &&
                Pattern.compile("[A-Z]").matcher(password).find() &&
                Pattern.compile("[0-9]").matcher(password).find();
    }

    private static boolean loginUser(String loginUsername, String loginPassword) {
        return loginUsername.equals(username) && loginPassword.equals(password);
    }

}