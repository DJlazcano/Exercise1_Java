public class BasicCalculator {
    //Functional interface operations declarations
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

    //Functional interface operation implementation
    private static double operateCall(double a, double b, BasicCalculatorOperation operation) throws Exception {
        return operation.operate(a, b);
    }

    //Call and execute corresponding operation
    public double operationResult(double aVal, double bVal, int operation) throws Exception {
        double result = switch (operation) {
            case 1 -> operateCall(aVal, bVal, this.add);
            case 2 -> operateCall(aVal, bVal, this.substract);
            case 3 -> operateCall(aVal, bVal, multiply);
            case 4 -> operateCall(aVal, bVal, divide);
            default -> 0;
        };
        return result;
    }
}
