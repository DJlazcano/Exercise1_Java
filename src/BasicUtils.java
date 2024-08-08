import java.util.*;
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
        int encodeOption = scanner.nextInt();
        String inputString;
        Scanner scannerInput = new Scanner(System.in);

        switch (encodeOption) {
            case 1:
                System.out.println("Please enter the string to encode:");
                inputString = scannerInput.nextLine();
                String encodedString = "";

                if (!inputString.strip().isEmpty()) {
                    encodedString = Base64.getEncoder().encodeToString(inputString.getBytes());
                }
                System.out.println("Encoded String is: " + encodedString + "\n");

                break;
            case 2:
                System.out.println("Please enter the string to decode:");
                inputString = scannerInput.nextLine();
                String decodedString = "";

                if (!inputString.strip().isEmpty()) {
                    byte[] decodeB = Base64.getDecoder().decode(inputString);
                    decodedString = new String(decodeB);
                }
                System.out.println("Decoded String is: " + decodedString + "\n");

                break;
            default:
                break;
        }
    }

    public static void studentAverage(Scanner scanner) {
        Scanner scannerInput = new Scanner(System.in);

        Map<String, Float> signaturesMap = new HashMap<>();
        String name, grade, signature;
        int numSignatures;
        float score;

        System.out.println("Please enter your name:");
        name = scannerInput.nextLine();

        System.out.println("Please enter your grade:");
        grade = scannerInput.nextLine();

        System.out.println("Please enter the number of signatures to enroll:");
        numSignatures = scannerInput.nextInt();
        scannerInput.nextLine();

        for (int i = 1; i <= numSignatures; i++) {
            System.out.println("Please enter the name of the signature " + i + ":");
            signature = scannerInput.nextLine();

            System.out.println("Please enter the score for " + signature + ":");
            score = scannerInput.nextFloat();

            signaturesMap.put(signature.strip(), score);
            scannerInput.nextLine();

        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("Student name: %-30s Grade: %-6s%n", name, grade);
        System.out.println("--------------------------------------------------------");
        signaturesMap.entrySet()
                .stream()
                .forEach(g -> System.out.printf("       Signature: %-25s  Score: %-5.1f%n", g.getKey(), g.getValue()));
        System.out.println("----------------------------------------------------");

        OptionalDouble average = signaturesMap.values()
                .stream()
                .mapToDouble(Float::floatValue)
                .average();
        System.out.printf("%-20s%-2.2f Status: %-15s%n%n", "Final Average:", average.orElse(0), average.getAsDouble() >= 6.0 ? "Passed with good level." : "Did not pass with good level.");

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
