import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BasicUtils {

    public static void basicCalculator(Scanner scanner) throws Exception {
        System.out.println("Please chose an option:");
        System.out.println("1.- Sum (a + b)\n2.- Substract (a - b)\n3.- Multiply (a x b)\n4.- Divide (a / b)");

        int operation = scanner.nextInt();

        BasicCalculatorOperation add = (a, b) -> a + b;
        BasicCalculatorOperation substract = (a, b) -> a - b;
        BasicCalculatorOperation multiply = (a, b) -> a * b;
        BasicCalculatorOperation divide = (a, b) -> {
            if (b == 0) {
                throw new Exception("Cannot Divide by zero");
            } else {
                return a / b;
            }
        };

        System.out.println("Please enter the value for a:");
        double aVal = scanner.nextDouble();
        System.out.println("Please enter the value for b:");
        double bVal = scanner.nextDouble();

        double result = switch (operation) {
            case 1 -> operateCall(aVal, bVal, add);
            case 2 -> operateCall(aVal, bVal, substract);
            case 3 -> operateCall(aVal, bVal, multiply);
            case 4 -> operateCall(aVal, bVal, divide);
            default -> 0;
        };
        System.out.printf("The result is: %.2f\n\n", result);
    }

    private static double operateCall(double a, double b, BasicCalculatorOperation operation) throws Exception {
        return operation.operate(a, b);
    }

    public static void string64Encoder(Scanner scanner) {
        System.out.println("Please chose an option:");
        System.out.println("1. Encode a String to Base64.\n2. Decode a String to Base 64");
    }

    public static void studentAverage(Scanner scanner) {
        System.out.println("Please enter your name:");
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            int num = ThreadLocalRandom.current().nextInt(1, 7);
            System.out.println("Please chose an option:");
            System.out.println("1.- Basic calculator.\n2.- Encoder.\n3.- Student average calculator.");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    basicCalculator(scanner);
                    break;
                case 2:
                    string64Encoder(scanner);
                    break;
                case 3:
                    studentAverage(scanner);
                    break;
                default:
                    break;
            }
        } while (true);
    }
}
