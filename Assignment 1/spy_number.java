public class spy_number {
        public static void main(String[] args) {
            int number = 123;
            int sumOfDigits = 0;
            int productOfDigits = 1;
            int temp = number;
            while (temp > 0) {
                int digit = temp % 10;
                sumOfDigits += digit;
                productOfDigits *= digit;
                temp /= 10;
            }
            if (sumOfDigits == productOfDigits) {
                System.out.println(number + " is a Spy Number.");
            } else {
                System.out.println(number + " is not a Spy Number.");
            }
        }
    }