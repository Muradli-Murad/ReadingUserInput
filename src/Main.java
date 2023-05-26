import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int currentYear = 2023;

        try {
            System.out.println(getInputFromConsole(currentYear));
        } catch (NullPointerException e) {
            System.out.println("in catch");
            System.out.println(getInputFromScanner(currentYear));
        }
    }

    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("Hi, What is your name? ");
        System.out.println("Hi " + name + ", Thanks for taking this course.");
        String dateOfBirth2 = System.console().readLine("What year you were born in ?");
        int age = checkData(currentYear, dateOfBirth2);
        return "So you are " + age + " year old.";
    }

    public static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, What is your name? ");
        String name = scanner.nextLine();
        System.out.println("Hi " + name + ", Thanks for taking this course.");
        System.out.println("What year you were born in ?");

        boolean validDOB = false;
        int age = 0;
        do {
            try {
                System.out.println("Enter a year of birth >= " + (currentYear - 125) + " and <= " + currentYear);
                age = checkData(currentYear, scanner.nextLine());
                validDOB = age >= 0;
            } catch (NumberFormatException badUserData) {
                System.out.println("Enter correct Date of Birth"
                );
            }
        } while (!validDOB);

        return "So you are " + age + " year old.";
    }

    public static int checkData(int currentYear, String dateOfBirth2) {
        int dob = Integer.parseInt(dateOfBirth2);
        int minimumYear = currentYear - 125;

        if ((dob > currentYear) || dob < minimumYear) {
            return -1;
        }
        return currentYear - dob;
    }
}