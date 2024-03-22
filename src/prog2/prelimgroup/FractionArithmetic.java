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
import java.text.DecimalFormat;
import java.util.Scanner;
public class FractionArithmetic {
    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner scn = new Scanner(System.in);

        // Declare variables for numerator, denominator, and user input
        int numerator, denominator;
        String enter = null;

        // Creating instances of the Fraction class
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        Fraction solve = new Fraction();

        // Decimal formatter for displaying fractions in decimal form
        DecimalFormat df = new DecimalFormat("#.##");

        // Displaying the menu and initial instructions
        System.out.println( "╭─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮" +
                "     ⢀⣀⣀⡤⠤⠤⠖⠒⠒⠒⠲⠤⠤⠤⠤⣀⣀⣀⡀\n" +
                "     ⢸⠩⣭⣹⣍⣭⣙⡲⣒⠶⠶⠤⠤⠤⣄⣀⣀⠀⠉⢉⣩⡵⠶⡆⠀⠀ ⢀⣀⣀⣀⣀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⢀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀       ⢠⣤⡀⠀⠀⠀  ⡀⠀⠀⠀⠀                 ⣀⡀⠀⠀⠀⠀⠀⢀⣤⡄\n" +
                "     ⢸⡑⣾⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣶⣥⣎⡬⢍⡿⠁⠛⡇⠀⣷⣄ ⠀⠈⠉⢹⡟⠉⠁⠀⣿⣀⣤⣀⠀⠀⢀⣠⣤⡀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣿⢿⡆⠀⠀⣀⣀⣠⣄⠀⠀⣀⣠⣍⠀⠀⢀⣀⣿⣇⣀⡀⠀ ⣿⣀⣤⣀⠀⢀⣀⣠⣀⣠⡀⠀⠀⣠⣤⣀⠀⢀⣀⣿⣇⣀⡀⠀⣀⣠⣍⡄⠀⠀ ⠀⣠⣤⣀\n" +
                "     ⢸⡔⣿⣿⣿⣿⣿⣿⣿⣿⡿⠙⣿⣿⣿⣿⣷⡊⢼⠀⢙⡇⠀⣺⠀⣷⠀  ⠀⢸⡇⠀⠀⠀⣿⠋⠉⣿⡇ ⣿⣋⣈⣻⡇⠀⠀⠀⠀⠀ ⠀⣸⡏⠘⣷⠀⠀⣿⡏⠉⢹⡧⠀⠉⠉⣿⠀⠀⠈⠉⣿⡏⠉⠁ ⣿⠏⠉⣿⡇⢸⣿⢹⣯⢹⡿⠀⣿⣋⣈⣻⡇⠈⠉⣿⡏⠉⠁ ⠀⠉⠉⣿ ⠀ ⣾⠏⠉⠛⠇\n" +
                "     ⠈⡖⡿⠿⣿⣿⣿⣿⣿⢹⢃⡆⢿⣿⣿⣿⣿⡇⢾⠤⠟⠓⠉⣹⢀⣹ ⠀⠀⢸⡇⠀⠀⠀⣿⠀⠀⣿⡇⠀⣿⡉⠉⣉⡁⠀⠀⠀⠀⠀⠀⢀⣿⠟⠛⢿⡆⠀⣿⡇⠀⠀⠀ ⠀⣀⣀⣿⣀⠀⠀ ⣿⣇⣀⡀⠀⣿⡀⠀⣿⡇⢘⣿⢸⣗⢸⣟⠀⣿⡉⠉⣉⡁⠀ ⠀⣿⣇⣀⡀⠀⣀⣀⣿⣃⣀⠀⣿⣄⠀⣠⡤\n" +
                "     ⠀⡗⣿⣾⣶⣶⣦⡍⢡⣦⣼⣷⡘⢻⠻⠿⠿⣯⢼⠀⠀⠀⠀ ⢸⠟⢹⠀⠀ ⠘⠛⠀⠀⠀⠛⠃⠀⠛⠃⠀⠈⠛⠛⠋⠀⠀⠀⠀⠀⠀⠀⠘⠛⠀⠀ ⠘⠛⠀⠛⠃⠀⠀⠀⠀⠛⠛⠛⠛⠛⠀⠀ ⠈⠛⠛⠃⠛⠃⠀⠛⠃⠈⠛⠘⠛⠘⠛⠀⠈⠛⠛⠋⠀⠀⠀  ⠈⠛⠛⠃⠀⠛⠛⠛⠛⠛⠈⠙⠛⠋⠁\n" +
                "     ⠀⡯⢼⣿⣿⣿⣿⡇⣼⣿⣿⣿⣇⣼⣿⣿⣿⡏⣼⢀⣠⣤⠀⢸⣠⠞\n" +
                "     ⠀⣟⣘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⣼⠛⠋⣱⠀⣼⠁\n" +
                "     ⠀⠉⠙⠓⠲⠾⠭⢿⣛⣻⡻⢿⡿⢿⡿⣿⡿⢒⢼⡆⠀⣺⡴⠊⠀⠀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⣀⠀⠀⠀⠀⠀ ⢠⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⣀⣀⣀⣀\n" +
                "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢹⢻⣿⠓⠒⠶⠬⠼⢼⠧⠚⠁⠀⠀⠀⠀ ⠀⣿⠉⠉⠉⠁⠀⣀⣀⣤⣄⠀⠀⢀⣠⣤⣀⠀⠀⢀⣠⣤⣀⠀⢠⣄⣿⣇⣠⡄ ⠀⣤⣠⣍⠀⠀⠀⢀⣠⣤⣀⠀⠀⣄⣀⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡏⠉⢻⣧⠀⣄⣀⣤⣄⡀⠀⢀⣠⣄⣀⠀⠀⢀⣠⣄⣀⡄⠀⣠⣀⣠⣄⡀⠀⢀⣠⣤⣀⠀⢀⣤⣠⣀⣤⡀⠀\n" +
                "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣸⣻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⣿⣶⣶⣶⠆⠀⣿⡏⠈⢻⡷⠀⢛⣫⣌⣿⡇⢀⣿⠋⠈⠛⠃⠈⠉⣿⡏⠉⠁⠀⠉⠉⣿⠀⠀⢀⣿⠋⠉⣿⡇⠀⣿⡏⠈⣿⡇⠀⠀⠀⠀⠀⠀⣿⣧⣤⡾⠏⠀⣿⡏⠉⢹⡷⢄⣿⠏⠈⢻⡇⠀⣿⡏⠈⢿⡇⠀⣽⡏⠁⢹⡷⠀⢛⣋⣌⣽⡇⢰⣿⠈⣿⠈⣿⠀\n" +
                "     ⠀⠀⠀⠀⠀⠀⢀⣤⢶⢻⡀⠉⠉⣼⢗⣤⡀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⣿⠄⠀⠀ ⠀⠀⣿⡇⠀⠀⠀⠰⣿⡁⢀⣿⡇⠀⣿⣄⠀⣤⡄⠀⠀ ⣿⣇⣀⡀⠀⣀⣀⣿⣀⣀⠈⣿⣄⢀⣿⡇⠀⣿⡆⠀⣿⡇⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀ ⠀⣿⡇⠀⠀⠀⠀ ⣿⣆⢀⣼⡇⠀⢿⣧⣠⣿⡇⠀⣹⡇⠀⠀⠀⠀ ⣿⡉⢀⣽⡇⢰⣿⠀⣿⠀⣿⠀\n" +
                "     ⠀⠀⠀⠀⠀⢰⣿⢶⠎⠁⠉⡿⣷⠾⠷⣏⢾⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀ ⠀⠉⠁⠀⠀⠀ ⠀⠉⠿⠏⠉⠁⠀⠈⠹⠿⠉⠀⠀ ⠀⠈⠉⠉⠁⠀⠉⠹⠉⠉⠉⠀⠈⠹⠿⠉⠀⠀⠉⠁⠀⠉⠁⠀⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀ ⠉⠁⠀⠀⠀⠀ ⠈⠹⠿⠉⠀⠀ ⠀⠉⠁⣾⡇⠀⠉⠁⠀⠀⠀ ⠀⠉⠿⠏⠉⠁⠀⠉⠀⠉⠀⠉⠀\n" +
                "     ⠀⠀⠀⠀⠀⠈⠫⣻⣦⣄⠀⢧⣿⡄⠀⠈⢓⣌⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀               ⠛⠛⠋⠀\n" +
                "     ⠀⠀⠀⠀⠀⠀⠀ ⠒⢟⣳⣮⣿⣧⣒⣯⡿⣞⠋⠁\n" +
                "     ⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⡧⢸⣿⡍⢫⠉⣭⣯⡇⠀⠀⠀⠀⠀⠀⠀⠀⣶⣶⡆⠀⠀⣰⣶⣶⠀⠀⢰⣶⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⢰⣶⣶⣶⣶⣶⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀        ⠀⢰⣶⣶⡆\n" +
                "     ⠀⠀⠀⠀⠀⠀⠀⠀⠻⠽⠧⠾⣿⣷⢤⡟⣭⣽⢻⡦⠀⠀⠀⠀ ⠀⠀⢼⣿⡇⠀⠀⣿⣿⣿⠀⠀⣸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠘⠛⠛⠛⢻⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀             ⠀⠀⠀⢸⣿⣿⡇\n" +
                "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⣿⠀⠉⠓⠚⠋⠀⠀⠀⠀⠀⠀⠀ ⠀⢸⣿⣷⠀⢠⣿⣟⣿⡆⠀⣼⣿⡇⠀⠀⠀⣠⣴⣶⣶⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀ ⠀⠀⣠⣴⣶⣶⣶⣶⣤⡀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣶⣦⣤⡀⠀⠀ ⠀⣶⣶⣆⣴⣶⣦⣀⣴⣶⣶⣄⠀⠀⠀⠀⣠⣴⣶⣶⣶⣶⣤⡀⠀⠀ ⠀⢸⣿⣿⠇\n" +
                "     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⡏⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠈⣿⣿⠀⢸⣿⠀⣿⡇⠀⣿⣿⠇⠀⢠⣾⣿⡿⠋⠉⠙⢻⣿⣷⡄⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⠟⠛⠛⠻⣿⣿⣦⠀⠀⢀⣾⣿⡿⠟⠛⠛⢿⣿⣿⡄⠀⠀⣿⣿⡟⠉⢻⣿⣿⠉⠙⣿⣿⡆⠀⢀⣾⣿⡿⠛⠉⠙⠻⣿⣿⡄⠀⠀⢸⣿⣿⡀\n" +
                "⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠀⠀⠀⢸⣧⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⣿⣿⡆⣸⣿⠀⣿⣿⠠⣿⣿⠀⠀⣸⣿⣿⣀⣀⣀⣀⣀⣿⣿⡇⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠙⠛⠛⠀⠀⢸⣿⣿⡇⠀  ⠀⠀⠀⣿⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⣃⣀⣀⣀⣀⣿⣿⣿⠀ ⢸⣿⣿⠄\n" +
                "⠀⠀⠀⠀     ⠀⠀⠀⠀⠀⠀⠀⠀⠸⣽⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⢿⣿⣇⣿⡏⠀⢸⣿⢰⣿⣟⠀⠀⢸⣿⣿⠿⠿⠿⠿⠿⠿⠿⠟⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡇⠀⠀   ⠀⠀⣿⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠀⠀⢸⣿⣿⠀\n" +
                "⠀⠀     ⠀⠀⠀⠀⠀⢀⣤⡤⠤⢤⡴⢿⣿⠲⡤⢄⣀⠀⠀⠀⠀⠀ ⠀⠀⠀⢹⣿⣿⣿⡇⠀⢸⣿⣿⣿⡇⠀⠀⢸⣿⣿⡀⠀⠀⠀⠀⣀⣀⡀⠀⠀ ⠀⠀⠀⢸⣿⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⣇⠀⠀⠀⠀⣶⣴⣶⠀⠀⢸⣿⣿⡇⠀  ⠀⠀⢀⣿⣿⡿⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⢸⣿⣿⡇⠀⠀⠀⠀⣀⣀⣀\n" +
                "⠀⠀     ⠀⠀⠀⢀⣴⣿⣟⡻⢷⣮⡵⠶⠶⢛⢳⣖⣚⠛⡇⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⠁⠀⠈⣿⣿⣿⡇⠀⠀⠈⢻⣿⣿⣦⣤⣴⣾⣿⡿⠃⠀⠀⠀⠀⠀⠈⢿⣿⣿⣶⣶⣶⣶⡆⠀⠻⣿⣿⣶⣶⣶⣾⣿⣿⠋⠀⠀⠀⢻⣿⣿⣶⣶⣶⣿⣿⡿⠃⠀⠀⣿⣿⡇⠀⢸⣿⣿⠀⠀⣿⣿⡇⠀⠀⠻⣿⣿⣶⣤⣤⣾⣿⡿⠃⠀⠀⣶⣿⣿⡆\n" +
                "⠀⠀⠀⠀     ⠀⠀⠉⠛⠿⢿⣯⣏⣴⣶⣸⡿⠭⢼⢿⣿⠃⠀⠀⠀⠀ ⠀ ⠀⠛⠛⠛⠀⠀⠀⠛⠛⠛⠁⠀⠀⠀⠀⠈⠛⠛⠛⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠛⠛⠛⠃⠀⠀ ⠀⠈⠙⠛⠛⠛⠛⠋⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠉⠀⠀⠀⠀ ⠛⠛⠃⠀⠘⠛⠋⠀⠀⠛⠛⠃⠀⠀⠀⠈⠙⠛⠛⠛⠛⠉⠀⠀⠀ ⠀⠙⠛⠛⠃\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⢻⡿⠀⠀⠀⠈⣻⡃\n" +
                "     ════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\n" +
                "                                                            >>> Press [ENTER] to see the Main Menu <<<\n" +
                "╰─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯");
        // While loop waiting for user to press [ENTER]
        while (scn.hasNextLine()) {
            int choice = 0;

            // Validating user's choice
            while (choice > 8 || choice < 1) {
                // Displaying the menu
                System.out.print("╭──────────────────────────────╮\n" + // displays user's choices
                        "| ︵‿︵‿୨♡୧‿︵‿︵‿︵‿︵‿୨♡୧‿︵‿︵ |\n" +
                        "|   OPERATION/ACTION OPTIONS   |\n" +
                        "| ════════════════════════════ |\n" +
                        "| 1. INPUT FRACTION 1  (❓)     |\n"+
                        "| 2. INPUT FRACTION 2  (❓)     |\n" +
                        "| 3. ADDITION          (➕)    |\n" +
                        "| 4. SUBTRACTION       (➖)    |\n" +
                        "| 5. MULTIPLICATION    (✖)     |\n" +
                        "| 6. DIVISION          (➗)    |\n" +
                        "| 7. REDUCTION         (🔻)    |\n" +
                        "| 8. EXIT              (❌)    |\n" +
                        "| ════════════════════════════ |\n" +
                        "╰──────────────────────────────╯\n");
                // Prompting the user to enter a choice
                System.out.print("  ︵‿︵‿୨♡୧‿︵‿︵\n" +
                        "Enter Digit Choice: ");

                // Reading the user's choice
                choice = scn.nextInt();

                // If statement refusing invalid choices
                if (choice > 8 || choice < 1) { // refuses values greater than 8 or less than 1
                    System.out.println("\n╭───────────────────────────────────────────╮" +
                            "\n| ═════════════════════════════════════════ |" +
                            "\n|     Invalid choice! Please try again.     |" +
                            "\n| ═════════════════════════════════════════ |" +
                            "\n╰───────────────────────────────────────────╯");
                }
            }

            // Performs operations based on user's choice
            switch (choice) {
                case 1:
                    System.out.print("╭───────────────────────────────────────────╮\n" +
                            "|     SELECTED ACTION: INPUT FRACTION 1     |\n" +
                            "| ═════════════════════════════════════════ |\n");
                    System.out.print("     Input Numerator: "); // Prompting user for numerator input
                    numerator = scn.nextInt();

                    // Loop for input validation for denominator
                    do {
                        System.out.print("     Input Denominator: "); // Prompting user for denominator input
                        denominator = scn.nextInt();

                        // Validating denominator input
                        if (denominator <= 0){ // Refusing denominator values less than or equal to 0
                            System.out.println("\n╭───────────────────────────────────────────╮" +
                                    "\n| ═════════════════════════════════════════ |" +
                                    "\n|     Invalid input! Please try again.      |" +
                                    "\n| ═════════════════════════════════════════ |" +
                                    "\n| Note: Denominators have a positive value. |" +
                                    "\n╰───────────────────────────────────────────╯");
                        }
                    } while (denominator <= 0);

                    // Setting numerator and denominator for fraction 1
                    f1.setNumerator(numerator);
                    f1.setDenominator(denominator);

                    // Displaying the entered fraction and its decimal value
                    System.out.print("     You have entered: " + f1.toString() + " or " + df.format(f1.toDouble()) +
                            "\n| ═════════════════════════════════════════ |" +
                            "\n| Press [ENTER] to return to the Main Menu. |" +
                            "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                    break;


                case 2:
                    // Similar process as case 1, but for fraction 2
                    System.out.print("╭───────────────────────────────────────────╮\n" +
                            "|     SELECTED ACTION: INPUT FRACTION 2     |\n" +
                            "| ═════════════════════════════════════════ |\n");
                    System.out.print("     Input Numerator: ");
                    numerator = scn.nextInt(); // reads user's input
                    do {
                        System.out.print("     Input Denominator: ");
                        denominator = scn.nextInt();
                        // Validating the denominator input
                        if (denominator <= 0){ // Refusing denominator values less than or equal to 1
                            System.out.println("\n╭───────────────────────────────────────────╮" +
                                    "\n| ═════════════════════════════════════════ |" +
                                    "\n|     Invalid input! Please try again.      |" +
                                    "\n| ═════════════════════════════════════════ |" +
                                    "\n| Note: Denominators have a positive value. |" +
                                    "\n╰───────────────────────────────────────────╯");
                        }
                    } while (denominator <= 0);

                    // Setting numerator and denominator for fraction 2
                    f2.setNumerator(numerator);
                    f2.setDenominator(denominator);

                    // Displaying the entered fraction and its decimal value
                    System.out.print("     You have entered: " + f2.toString() + " or " + df.format(f2.toDouble())+
                            "\n| ═════════════════════════════════════════ |" +
                            "\n| Press [ENTER] to return to the Main Menu. |" +
                            "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                    break;


                case 3:
                    Fraction sum= f1.add(f2);
                    // Performing ADDITION operation on fractions --------------------------------------------------
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                            "|       SELECTED OPERATION: ADDITION        |\n" +
                            "| ═════════════════════════════════════════ |\n" +
                            "       Action: " + f1.toString() + " + " + f2.toString() +
                            "\n       Sum: " + sum.toString() +" or "+ df.format(sum.toDouble()) +
                            "\n| ═════════════════════════════════════════ |" +
                            "\n| Press [ENTER] to return to the Main Menu. |" +
                            "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                    break;


                case 4:
                    Fraction difference= f1.subtract(f2);
                    // Performing SUBTRACTION operation on fractions -----------------------------------------------
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                            "|      SELECTED OPERATION: SUBTRACTION      |\n" +
                            "| ═════════════════════════════════════════ |\n" +
                            "       Action: " + f1.toString() + " - " + f2.toString() +
                            "\n       Difference: " + difference.toString() + " or "+ df.format(difference.toDouble()) +
                            "\n| ═════════════════════════════════════════ |" +
                            "\n| Press [ENTER] to return to the Main Menu. |" +
                            "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                    break;


                case 5:
                    Fraction product= f1.multiplyBy(f2);
                    // Performing MULTIPLICATION operation on fractions --------------------------------------------
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                            "|    SELECTED OPERATION: MULTIPLICATION     |\n" +
                            "| ═════════════════════════════════════════ |\n" +
                            "      Fraction 1: " + f1.toString() + " x " + f2.toString() +
                            "\n       Product: " + product.toString() + " or "+ df.format(product.toDouble()) +
                            "\n| ═════════════════════════════════════════ |" +
                            "\n| Press [ENTER] to return to the Main Menu. |" +
                            "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                    break;


                case 6:
                    Fraction quotient= f1.divideBy(f2);
                    // Performing DIVISION operation on fractions --------------------------------------------------
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                            "|       SELECTED OPERATION: DIVISION        |\n" +
                            "| ═════════════════════════════════════════ |\n" +
                            "       Fraction 1: " + f1.toString() + " ÷ " + f2.toString() +
                            "\n       Quotient: " + quotient.toString() + " or "+ df.format(quotient.toDouble()) +
                            "\n| ═════════════════════════════════════════ |" +
                            "\n| Press [ENTER] to return to the Main Menu. |" +
                            "\n╰───────────────────────────────────────────╯\n");
                    enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                    break;
                case 7:
                    // Performing REDUCTION operation on fractions -------------------------------------------------
                    int fNum = 0; // Store the user's choice of which fraction to reduce
                    System.out.println("╭───────────────────────────────────────────╮\n" +
                            "|       SELECTED OPERATION: REDUCTION       |\n" +
                            "| ═════════════════════════════════════════ |\n" +
                            "       Fraction 1: " + f1.toString() +
                            "\n       Fraction 2: " + f2.toString() +
                            "\n| ═════════════════════════════════════════ |\n");

                    // Loop for choosing the fraction to be reduced
                    do {
                        System.out.print("         Enter Fraction number: ");   // Prompts user to enter a choice
                        fNum = scn.nextInt();

                        // If and else if loop that reduces the entered fraction and displays the result
                        if (fNum == 1) {
                            System.out.println("       Reduced Fraction: " +
                                    solve.reduce(f1) + " or "+ df.format(f1.toDouble()) +
                                    "\n| ═════════════════════════════════════════ |" +
                                    "\n| Press [ENTER] to return to the Main Menu. |" +
                                    "\n╰───────────────────────────────────────────╯");
                            enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                        }
                        else if (fNum == 2) {
                            System.out.println("       Reduced Fraction: " +
                                    solve.reduce(f2) + " or "+ df.format(f2.toDouble()) +
                                    "\n| ═════════════════════════════════════════ |" +
                                    "\n| Press [ENTER] to return to the Main Menu. |" +
                                    "\n╰───────────────────────────────────────────╯");
                            enter = scn.nextLine(); // Pausing the program until [ENTER] is pressed
                        }
                    } while (fNum < 1 || fNum > 2);    // Refuses numbers less than 1 or greater than 2
                    break;
                case 8:
                    // Exiting the program
                    System.out.print("╭────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n" +
                            "   ⠀⠀⠀⠀⠀⠀⠀⢀⡠⢶⢒⠲⡒⢖⠢⡄⠤⠠⠤⠤⢤⠤⡤⢤⣀⢀⡀⣀⣀⣀⣀⣀\n" +
                            "⠀⠀⠀   ⠀⠀⡀⣴⠁⠀⢸⢌⣱⣾⣾⣷⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣶⣥⣶⣠⢃⠾⠀⠀ ⡆⢰⡆ ⢀⣀⣀ ⠘⠒⡆⠀ ⢀⣴⣀⡀ ⢠⣛⠁ ⣀⣀⡀  ⢀⣀⣀⠀⠀⠀⠀⢀⣀⣀⠀ ⢀⣠⣀⠀ ⣀⣀⠀ ⢀⣀⣀⡀ ⣀⣠⡀ ⠀⣀⣀⠀ ⣀⣄⣀\n" +
                            "   ⠀⠀⠀⡄⠊⠀⣇⡀⠀⢸⢆⣺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡜⠸⠀⠀ ⡟⢛⡇ ⢨⠗⢾ ⠀⠀⡇⠀ ⠀⢹⠀⠀⠀ ⢸⠀⠀  ⡏⢘⡇ ⢸⡁⣹⠀⠀⠀⠀⢸⡇⢸⡇ ⢸⠁⠙⠃ ⡏⠈⡷ ⢸⡁⣹ ⠀⣿⠀⠛ ⢨⡕⢺⡇ ⡇⢸⢸\n" +
                            "   ⠀⠀⠀⡇⠀⠀⠋⠁⠀⢸⡌⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⢲⠀⠀ ⠇⠘⠇ ⠘⠶⠺⠀ ⠀⠳⠶ ⠀⠘⠶⠆ ⠲⠾⠶ ⠀⠇⠘⠇ ⠘⠓⣻⠀⠀⠀⠀⢸⡗⠾⠁ ⠸⠀⠀  ⠀⠳⠶⠃ ⠘⠓⣻ ⠀⠻⠀⠀ ⠘⠷⠚⠃ ⠃⠸⠸⠀ ⠺⠂ ⠺⠂ ⠺\n" +
                            "   ⠀⠀⡀⡇⠀⠀⢸⠂⢀⣸⡖⣿⣿⣿⣿⡏⣉⣀⣈⢻⣿⣿⣿⣿⠟⠉⠻⢿⣿⣿⣇⢺⠀⠀   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀        ⠉⠁⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀ ⠀    ⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀  ⢠⣤⣤⠀\n" +
                            "   ⢠⠊⠀⣇⡀⠤⠚⠈⠁⠘⡆⣿⣿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣷⣶⣶⠶⣾⣿⣿⣏⠲⠀ ⠀⢀⣠⣤⣤⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀       ⣤⣤  ⣤⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀    ⠀ ⢸⣿⡟⠀\n" +
                            "   ⠸⠀⠀⡇⠀⠀⠀⠀  ⠀⠀⡇⣿⣿⣿⣿⣇⡈⠹⠿⢿⣿⣿⣿⡿⠿⠋⠀⣸⣿⣿⡧⣙ ⠀⢠⣿⡟⠋⠉⢻⣿⡆ ⠀⠀⠀⢀⣀⣀⠀⠀ ⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⣀⡀ ⠀ ⣿⣿⠀⠀⣿⣿⠀⣀⣀⠀⠀ ⠀⡀⢀⠀⠀⠀⠀⠀⢀⠀⠀⠀  ⢀⣀⣀⠀⠀⠀   ⢸⣿⡇⠀\n" +
                            "   ⢰⡈⡤⡃⠀⠀⠀⣀⣠⠤⡧⣹⣿⣿⣿⣿⣷⣶⣀⣈⣉⠉⡉⠁⣠⣼⣿⣿⣿⣿⡗⢢⠀ ⢸⣿⡇⠀⠀⠀⠀⠀⠀  ⢀⣶⣿⠿⠿⣿⣦⠀ ⠀⢠⣾⡿⠿⠿⣿⣆⠀⠀⣰⣿⡿⠿⢷⣿⣿⠀⠀⣿⣷⠾⠿⢿⣷⡄⠀⠹⣿⣆⠀ ⠀⢰⣿⡟ ⢀⣶⡿⠛⠻⣿⣦⠀  ⢸⣿⡇⠀\n" +
                            "   ⢰⠀⠀⡁⠀⡖⣫⡥⢴⡶⡇⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢼⠀ ⢸⣿⡇⠀ ⣿⣿⣾⡇ ⢺⣿⡇⠀⠀ ⢸⣿⡇⠀⣿⣿⠀⠀⠀ ⢻⣿⠀⣿⣿⠀⠀  ⠀⣿⣿⠀⠀⣿⣿⠀⠀ ⠈⣿⣿⠀⠀⢻⣿⡄⢀⣿⡿⠀⢸⣿⣅⣀ ⣀⣸⣿⡇  ⢸⣿⡇⠀\n" +
                            "   ⠈⠢⢀⢰⠀⡏⢛⣭⣭⢀⣟⠨⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠜⡸⠀ ⢸⣿⡇⠀ ⠀⢰⣿⡇ ⢸⣿⡇⠀⠀ ⢸⣿  ⣿⣿⠀⠀ ⠀⣽⣿⠀⣿⣿⠀⠀  ⠀⣿⣿⠀⠀⣿⣿⠀⠀ ⠀⣿⣿⠀⠀⠀⢿⣷⣼⣿⠃⠀ ⢸⣿⡉⠉⠉⠉⠉⡁⠀⠀⠀⠀\n" +
                            "⠀   ⠀⠀⢱⠀⡇⠘⣿⡻⠀⢯⠒⢭⢋⠟⣛⠻⡛⠿⠿⠿⠿⠿⠿⠿⢟⠻⣛⠻⡍⢎⣱⠀  ⠈⠻⣿⣶⣴⣾⡿⠃⠀ ⠘⢿⣷⣶⣶⣿⠟⠀⠀⠘⢿⣷⣦⣶⣿⠟⠀⠀⠻⣿⣶⣶⡾⣿⣿⠀ ⠀⣿⡟⢶⣴⣾⣿⠇⠀⠀⠀⠘⣿⣿⠇⠀⠀⠀⠈⢿⣷⣦⣴⣾⠟⠁  ⢾⣿⣿⠄\n" +
                            "⠀   ⠀⠀⠸⠠⠧⠔⢚⡓⣉⣉⣉⣉⣉⣉⣉⣩⠙⡛⣩⣉⣉⣙⣉⣉⣉⠹⠴⠗⠚⠒⠉⠀⠀ ⠀ ⠀⠉⠉⠁⠀⠀⠀⠀⠀  ⠀⠉⠉⠀⠀⠀⠀⠀  ⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠉⠁ ⠀⠁⠉⠀⠀⠉⠁ ⠀⠉⠉⠀⠀⠀⠀⠀⢠⣿⡟⠀⠀⠀⠀⠀⠀ ⠈⠉⠉⠀⠀⠀⠀    ⠁\n" +
                            "⠀⠀   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                 ⠀⠚⠛⠁\n" +
                            "╰────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯");
                    System.exit(0);
            }
        }
    }
}
