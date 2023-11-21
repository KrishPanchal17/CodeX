public class multiplicationtable{
    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        for (int i=1;i<=10;i++) {
            int result = number * i;
            System.out.println(number + " X " + i + " = " + result);
        }
        scanner.close();
    }
}