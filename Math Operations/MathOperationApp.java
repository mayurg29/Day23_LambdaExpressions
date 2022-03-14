// Performing Mathematical operations using Lambda expressions

@FunctionalInterface
interface IMathFunction {
    int calculate(int a, int b);
    static void printResult(int a, int b, String function, IMathFunction fobj) {
        System.out.println("Result of " + function + " is " + fobj.calculate(a, b));
    }
}

public class MathOperationApp {

    public static void main(String[] args) {
        // Using method reference
        IMathFunction add = Integer::sum;

        // Using Lambda Expression
        IMathFunction subtract = (a, b) -> a - b;
        IMathFunction multiply = (a, b) -> a * b;
        IMathFunction divide = (a, b) -> a / b;

        System.out.println("Addition is " + add.calculate(8,4));
        System.out.println("Subtraction is " + subtract.calculate(8,4));
        System.out.println("Multiplication is " + multiply.calculate(8,4));
        System.out.println("Division is " + divide.calculate(8,4));

        // Passing Lambda Expression as function parameter to print result using static function
        IMathFunction.printResult(9,3,"Addition",add);
        IMathFunction.printResult(9,3,"Subtraction",subtract);
        IMathFunction.printResult(9,3,"Multiplication",multiply);
        IMathFunction.printResult(9,3,"Division",divide);
    }
}
