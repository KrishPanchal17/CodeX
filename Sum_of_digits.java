public class sum {
        public static void main(String[] args) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            int sum = 0;
            while (number != 0) {
                int digit = number % 10;
                sum += digit;
                number /= 10;
            }
            System.out.println("Sum of the digits: " + sum);
            scanner.close();
        }
    }
