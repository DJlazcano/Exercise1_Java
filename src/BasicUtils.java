import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class BasicUtils {

    public static void basicCalculator(Scanner scanner) throws Exception {
        BasicCalculator calculator = new BasicCalculator();
        int operation = scanner.nextInt();

        System.out.println("Please chose an option:");
        System.out.println("1.- Sum (a + b)\n2.- Substract (a - b)\n3.- Multiply (a x b)\n4.- Divide (a / b)");
        System.out.println("Please enter the value for a:");
        double aVal = scanner.nextDouble();
        System.out.println("Please enter the value for b:");
        double bVal = scanner.nextDouble();
        double result = calculator.operationResult(aVal, bVal, operation);
        System.out.printf("The result is: %.2f\n\n", result);
    }

    public static void string64Encoder(Scanner scanner) {
        Scanner scannerInput = new Scanner(System.in);
        String inputString;

        System.out.println("Please chose an option:");
        System.out.println("1. Encode a String to Base64.\n2. Decode a String to Base 64");
        int encodeOption = scanner.nextInt();
        System.out.printf("Please enter the string to %s:%n", encodeOption == 1 ? "encode" : "decode");
        inputString = scannerInput.nextLine();

        String finalString = encodeOption == 1 ? StringEncoderB64.encode64(inputString) : StringEncoderB64.decode64(inputString);
        System.out.printf("%s String is: %s%n%n", encodeOption == 1 ? "Encoded" : "Decoded", finalString);
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

        StudentAvg.printReport(signaturesMap, name, grade);
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
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
