package prog2.prelimgroup;

/*
Program: Prelim Group Project 1
Members:
    - Barrozo, Sebastian
    - Bernal, Mariella Lyshael Angeli
    - Caramat, Maria Fides Portia
    - Mabalot, Rod Clarenz
    - Palitayan, Ezekial Avensis
    - Vega, Althea Elise
    - Yarisantos, Nicole
 */

import java.util.Scanner;
public class FractionArithmetic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int numerator1, numerator2, denominator1, denominator2;

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        Fraction solve = new Fraction();

        System.out.println("⢀⣀⣀⡤⠤⠤⠖⠒⠒⠒⠲⠤⠤⠤⠤⣀⣀⣀⡀\n" +
                "⢸⠩⣭⣹⣍⣭⣙⡲⣒⠶⠶⠤⠤⠤⣄⣀⣀⠀⠉⢉⣩⡵⠶⡆⠀⠀ ⢀⣀⣀⣀⣀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀       ⢠⣤⡀⠀⠀⠀  ⡀⠀⠀⠀⠀                 ⣀⡀⠀⠀⠀⠀⠀⢀⣤⡄\n" +
                "⢸⡑⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣶⣥⣎⡬⢍⡿⠁⠛⡇⠀⣷⣄ ⠀⠈⠉⢹⡟⠉⠁⠀⣿⣀⣤⣀⠀⠀⢀⣠⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⢿⡆⠀⠀⣀⣀⣠⣄⠀⠀⣀⣠⣍⠀⠀⢀⣀⣿⣇⣀⡀⠀ ⣿⣀⣤⣀⠀⢀⣀⣠⣀⣠⡀⠀⠀⣠⣤⣀⠀⢀⣀⣿⣇⣀⡀⠀⣀⣠⣍⡄⠀⠀⠀⣠⣤⣀\n" +
                "⢸⡔⣿⣿⣿⣿⣿⣿⣿⣿⡿⠙⣿⣿⣿⣿⣷⡊⢼⠀⢙⡇⠀⣺⠀⣷⠀  ⠀⢸⡇⠀⠀⠀⣿⠋⠉⣿⡇ ⣿⣋⣈⣻⡇⠀⠀⠀⠀⠀⠀⠀⣸⡏⠘⣷⠀⠀⣿⡏⠉⢹⡧⠀⠉⠉⣿⠀⠀⠈⠉⣿⡏⠉⠁ ⣿⠏⠉⣿⡇⢸⣿⢹⣯⢹⡿⠀⣿⣋⣈⣻⡇⠈⠉⣿⡏⠉⠁⠀⠉⠉⣿⠀⠀⠀⣾⠏⠉⠛⠇\n" +
                "⠈⡖⡿⠿⣿⣿⣿⣿⣿⢹⢃⡆⢿⣿⣿⣿⣿⡇⢾⠤⠟⠓⠉⣹⢀⣹ ⠀⠀⢸⡇⠀⠀⠀⣿⠀⠀⣿⡇⠀⣿⡉⠉⣉⡁⠀⠀⠀⠀⠀⠀⢀⣿⠟⠛⢿⡆⠀⣿⡇⠀⠀⠀ ⠀⣀⣀⣿⣀⠀⠀ ⣿⣇⣀⡀⠀⣿⡀⠀⣿⡇⢘⣿⢸⣗⢸⣟⠀⣿⡉⠉⣉⡁⠀⠀⣿⣇⣀⡀⠀⣀⣀⣿⣃⣀⠀⣿⣄⠀⣠⡤\n" +
                "⠀⡗⣿⣾⣶⣶⣦⡍⢡⣦⣼⣷⡘⢻⠻⠿⠿⣯⢼⠀⠀⠀⠀ ⢸⠟⢹⠀⠀ ⠘⠛⠀⠀⠀⠛⠃⠀⠛⠃⠀⠈⠛⠛⠋⠀⠀⠀⠀⠀⠀⠀⠘⠛⠀⠀ ⠘⠛⠀⠛⠃⠀⠀⠀⠀⠛⠛⠛⠛⠛⠀⠀ ⠈⠛⠛⠃⠛⠃⠀⠛⠃⠈⠛⠘⠛⠘⠛⠀⠈⠛⠛⠋⠀⠀⠀⠈⠛⠛⠃⠀⠛⠛⠛⠛⠛⠀⠈⠙⠛⠋⠁\n" +
                "⠀⡯⢼⣿⣿⣿⣿⡇⣼⣿⣿⣿⣇⣼⣿⣿⣿⡏⣼⢀⣠⣤⠀⢸⣠⠞\n" +
                "⠀⣟⣘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⣼⠛⠋⣱⠀⣼⠁\n" +
                "⠀⠉⠙⠓⠲⠾⠭⢿⣛⣻⡻⢿⡿⢿⡿⣿⡿⢒⢼⡆⠀⣺⡴⠊⠀⠀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⣀⠀⠀⠀⠀⠀ ⢠⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⣀⣀⣀⣀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢹⢻⣿⠓⠒⠶⠬⠼⢼⠧⠚⠁⠀⠀⠀⠀ ⠀⣿⠉⠉⠉⠁⠀⣀⣀⣤⣄⠀⠀⢀⣠⣤⣀⠀⠀⢀⣠⣤⣀⠀⢠⣄⣿⣇⣠⡄ ⠀⣤⣠⣍⠀⠀⠀⢀⣠⣤⣀⠀⠀⣄⣀⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡏⠉⢻⣧⠀⣄⣀⣤⣄⡀⠀⢀⣠⣄⣀⠀⠀⢀⣠⣄⣀⡄⠀⣠⣀⣠⣄⡀⠀⢀⣠⣤⣀⠀⢀⣤⣠⣀⣤⡀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣸⣻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⣿⣶⣶⣶⠆⠀ ⣿⡏⠈⢻⡷⠀⢛⣫⣌⣿⡇⢀⣿⠋⠈⠛⠃⠈⠉⣿⡏⠉⠁⠀⠉⠉⣿⠀⠀⢀⣿⠋⠉⣿⡇⠀⣿⡏⠈⣿⡇⠀⠀⠀⠀⠀⠀⣿⣧⣤⡾⠏⠀⣿⡏⠉⢹⡷⢄⣿⠏⠈⢻⡇⠀⣿⡏⠈⢿⡇⠀⣽⡏⠁⢹⡷⠀⢛⣋⣌⣽⡇⢰⣿⠈⣿⠈⣿⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢀⣤⢶⢻⡀⠉⠉⣼⢗⣤⡀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⣿⠄⠀⠀ ⠀⠀⣿⡇⠀⠀⠀⠰⣿⡁⢀⣿⡇⠀⣿⣄⠀⣤⡄⠀⠀ ⣿⣇⣀⡀⠀⣀⣀⣿⣀⣀⠈⣿⣄⢀⣿⡇⠀⣿⡆⠀⣿⡇⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀ ⠀⣿⡇⠀⠀⠀⠀ ⣿⣆⢀⣼⡇⠀⢿⣧⣠⣿⡇⠀⣹⡇⠀⠀⠀ ⣿⡉⢀⣽⡇⢰⣿⠀⣿⠀⣿⠀\n" +
                "⠀⠀⠀⠀⠀⢰⣿⢶⠎⠁⠉⡿⣷⠾⠷⣏⢾⣶⡀⠀⠀⠀⠀⠀ ⠀⠀⠀⠉⠀⠀⠀⠀ ⠀⠉⠁⠀⠀ ⠀⠉⠿⠏⠉⠁⠀⠈⠹⠿⠉⠀⠀ ⠀⠈⠉⠉⠁⠀⠉⠹⠉⠉⠉⠀⠈⠹⠿⠉⠀⠀⠉⠁⠀⠉⠁⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀ ⠉⠁⠀⠀⠀⠀ ⠈⠹⠿⠉⠀⠀ ⠀⠉⠁⣾⡇⠀⠉⠁⠀⠀ ⠀⠉⠿⠏⠉⠁⠀⠉⠀⠉⠀⠉⠀\n" +
                "⠀⠀⠀⠀⠀⠈⠫⣻⣦⣄⠀⢧⣿⡄⠀⠈⢓⣌⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           ⠛⠛⠋⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀ ⠒⢟⣳⣮⣿⣧⣒⣯⡿⣞⠋⠁\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⡧⢸⣿⡍⢫⠉⣭⣯⡇⠀⠀⠀⠀⠀⠀⠀⠀⣶⣶⡆⠀⠀⣰⣶⣶⠀⠀⢰⣶⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⢰⣶⣶⣶⣶⣶⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀      ⠀⢰⣶⣶⡆\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠻⠽⠧⠾⣿⣷⢤⡟⣭⣽⢻⡦⠀⠀⠀⠀ ⠀⠀⢼⣿⡇⠀⠀⣿⣿⣿⠀⠀⣸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠘⠛⠛⠛⢻⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⠀⠀ ⠀⢸⣿⣿⡇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⣿⠀⠉⠓⠚⠋⠀⠀⠀⠀⠀⠀⠀ ⠀⢸⣿⣷⠀⢠⣿⣟⣿⡆⠀⣼⣿⡇⠀⠀⠀⣠⣴⣶⣶⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀ ⠀⠀⣠⣴⣶⣶⣶⣶⣤⡀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣶⣦⣤⡀⠀⠀ ⠀⣶⣶⣆⣴⣶⣦⣀⣴⣶⣶⣄⠀⠀⠀⠀⣠⣴⣶⣶⣶⣶⣤⡀⠀⠀ ⠀⢸⣿⣿⠇\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⡏⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠈⣿⣿⠀⢸⣿⠀⣿⡇⠀⣿⣿⠇⠀⢠⣾⣿⡿⠋⠉⠙⢻⣿⣷⡄⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⠟⠛⠛⠻⣿⣿⣦⠀⠀⢀⣾⣿⡿⠟⠛⠛⢿⣿⣿⡄⠀⠀⣿⣿⡟⠉⢻⣿⣿⠉⠙⣿⣿⡆⠀⢀⣾⣿⡿⠛⠉⠙⠻⣿⣿⡄  ⠀⢸⣿⣿⡀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣧⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⣿⣿⡆⣸⣿⠀⣿⣿⠠⣿⣿⠀⠀⣸⣿⣿⣀⣀⣀⣀⣀⣿⣿⡇⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠙⠛⠛⠀⠀⢸⣿⣿⡇⠀  ⠀⠀⠀⣿⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⣃⣀⣀⣀⣀⣿⣿⣿⠀  ⢸⣿⣿⠄\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣽⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⢿⣿⣇⣿⡏⠀⢸⣿⢰⣿⣟⠀⠀⢸⣿⣿⠿⠿⠿⠿⠿⠿⠿⠟⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀   ⠀⠀⣿⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠀⠀ ⢸⣿⣿⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣤⡤⠤⢤⡴⢿⣿⠲⡤⢄⣀⠀⠀⠀⠀⠀ ⠀⠀⠀⢹⣿⣿⣿⡇⠀⢸⣿⣿⣿⡇⠀⠀⢸⣿⣿⡀⠀⠀⠀⠀⣀⣀⡀⠀⠀ ⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⣇⠀⠀⠀⠀⣶⣴⣶⠀⠀⢸⣿⣿⡇⠀  ⠀⠀⢀⣿⣿⡿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⡇⠀⠀⠀⠀⣀⣀⣀\n" +
                "⠀⠀⠀⠀⠀⢀⣴⣿⣟⡻⢷⣮⡵⠶⠶⢛⢳⣖⣚⠛⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠁⠀⠈⣿⣿⣿⡇⠀⠀⠈⢻⣿⣿⣦⣤⣴⣾⣿⡿⠃⠀⠀⠀⠀⠀⠈⢿⣿⣿⣶⣶⣶⣶⡆ ⠀⠻⣿⣿⣶⣶⣶⣾⣿⣿⠋⠀⠀⠀⢻⣿⣿⣶⣶⣶⣿⣿⡿⠃⠀ ⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⠀⠻⣿⣿⣶⣤⣤⣾⣿⡿⠃⠀ ⠀⣶⣿⣿⡆\n" +
                "⠀⠀⠀⠀⠀⠀⠉⠛⠿⢿⣯⣏⣴⣶⣸⡿⠭⢼⢿⣿⠃⠀⠀⠀⠀ ⠀⠀⠀⠛⠛⠛⠀⠀⠀⠛⠛⠛⠁⠀⠀⠀⠀⠈⠛⠛⠛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠛⠛⠛⠃⠀⠀ ⠀⠈⠙⠛⠛⠛⠛⠋⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠉⠀⠀⠀⠀  ⠛⠛⠃⠀⠘⠛⠋⠀⠀⠛⠛⠃⠀⠀⠀⠈⠙⠛⠛⠛⠛⠉⠀⠀⠀ ⠀⠙⠛⠛⠃\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡿⠀⠀⠀⠈⣻⡃\n" +
                "\n                                                          Press [ENTER] to see the Main Menu");
        while (true) {
            int choice = 0;
            if (scn.hasNextLine()) {
                while (choice > 8 || choice < 1) {
                    System.out.println("\nOperation/Action Options\n 1. Input Fraction 1\n 2. Input Fraction 2\n 3. Addition\n 4. Subtraction" +
                            "\n 5. Multiplication\n 6. Division\n 7. Reduction\n 8. Exit\n");
                    System.out.print("Enter Digit Choice: ");
                    choice = scn.nextInt();
                    if (choice > 8 || choice < 1) {
                        System.out.println("Invalid choice! Please try again.");
                    }
                }
                switch (choice) {
                    case 1:
                        System.out.println("Entering data for Fraction 1");
                        System.out.print("Input Numerator: ");
                        numerator1 = scn.nextInt();
                        System.out.print("Input Denominator: ");
                        denominator1 = scn.nextInt();

                        f1.setNumerator(numerator1);
                        f1.setDenominator(denominator1);
                        break;
                    case 2:
                        System.out.println("Entering data for Fraction 2");
                        System.out.print("Input Numerator: ");
                        numerator2 = scn.nextInt();
                        System.out.print("Input Denominator: ");
                        denominator2 = scn.nextInt();

                        f2.setNumerator(numerator2);
                        f2.setDenominator(denominator2);
                        break;
                    case 3:
                        solve.add(f1.getNumerator(), f2.getNumerator(), f1.getDenominator(), f2.getDenominator());
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:
                        System.exit(0);
                }
            }
        }
    }
}
