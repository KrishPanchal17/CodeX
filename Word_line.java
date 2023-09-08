class word_line {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.next();
        scanner.nextLine();
        System.out.print("Enter a line: ");
        String line = scanner.nextLine();
        System.out.println(word + " " + line);
        scanner.close();
    }
}
