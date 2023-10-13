import java.util.Scanner;
public class MathOperations{
    public int addIntegers(int a, int b) {
        return a + b;
    }

    public double addDoubles(double a, double b) {
        return a + b;
    }

    public double addMixed(int a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        int firstInt = scanner.nextInt();

        System.out.print("Enter the second integer: ");
        int secondInt = scanner.nextInt();

        System.out.print("Enter the first double: ");
        double firstDouble = scanner.nextDouble();

        System.out.print("Enter the second double: ");
        double secondDouble = scanner.nextDouble();
        MathOperations math = new MathOperations();
        int intResult = math.addIntegers(firstInt, secondInt);
        System.out.println("Adding two integers: " + intResult);
        double doubleResult = math.addDoubles(firstDouble, secondDouble);
        System.out.println("Adding two doubles: " + doubleResult);
        double mixedResult = math.addMixed(firstInt, secondDouble);
        System.out.println("Adding an integer and a double: " + mixedResult);
        scanner.close();
    }
}
