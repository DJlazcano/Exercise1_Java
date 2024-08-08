import java.util.Map;
import java.util.OptionalDouble;

public class StudentAvg {

    //Calculate score average using streams methods/functions
    public static OptionalDouble calculateAvg(Map<String, Float> signaturesMap) {
        return signaturesMap.values()
                .stream()
                .mapToDouble(Float::floatValue)
                .average();
    }

    //Print grades report format
    public static void printReport(Map<String, Float> signaturesMap, String name, String grade) {
        OptionalDouble average = calculateAvg(signaturesMap);

        System.out.println("--------------------------------------------------------");
        System.out.printf("Student name: %-30s Grade: %-6s%n", name, grade);
        System.out.println("--------------------------------------------------------");
        signaturesMap.entrySet()
                .stream()
                .forEach(g -> System.out.printf("       Signature: %-25s  Score: %-5.1f%n", g.getKey(), g.getValue()));
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-6s %-6.2f %-40s%n%n", "Final Average:", average.orElse(0), average.getAsDouble() >= 6.0 ? "Status: Passed with good level." : "Status: Did not pass with good level.");
    }
}
