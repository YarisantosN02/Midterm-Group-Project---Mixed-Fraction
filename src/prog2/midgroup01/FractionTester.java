package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

import javax.swing.*;

public class FractionTester {
    public static void main(String[] args){
        //call GUI here

        try{
            String whole1Str = num1Field.getText();     // numfield names to be updated after GUI
            String num1Str = num12Field.getText();
            String den1Str = num3Field.getText();
            String whole2Str = num4Field.getText();
            String num2Str = num5Field.getText();
            String den2Str = num6Field.getText();
            String operator = (String) operatorComboBox.getSelectedItem();

            /* if user input is limited:
            if (whole1Str.length() >= 3 || whole2Str.length() >= 3) {
                JOptionPane.showMessageDialog(null, "Whole numbers cannot exceed three [3] digits!" +
                        "\nPlease try again.", "Number Input Limit", JOptionPane.ERROR_MESSAGE);
            } else if (num1Str.length() >= 5 || num2Str.length() >= 5 || den1Str.length() >= 5 || den2Str.length() >= 5) {
                JOptionPane.showMessageDialog(null, "Numerators and denominators cannot exceed five [5] digits!" +
                        "\nPlease try again.", "Number Input Limit", JOptionPane.ERROR_MESSAGE);
            }
             */

            // convert user input strings to numbers
            int wholeFrac1 = Integer.parseInt(whole1Str);
            int numFrac1 = Integer.parseInt(num1Str);
            int denFrac1 = Integer.parseInt(den1Str);
            int wholeFrac2 = Integer.parseInt(whole2Str);
            int numFrac2 = Integer.parseInt(num2Str);
            int denFrac2 = Integer.parseInt(den2Str);

            MixedFraction fraction1 = new MixedFraction(wholeFrac1, numFrac1, denFrac1);
            MixedFraction fraction2 = new MixedFraction(wholeFrac2, numFrac2, denFrac2);

            if (denFrac1 == 0 || denFrac2 == 0) {
                JOptionPane.showMessageDialog(null, "Denominator cannot be zero!" +
                        "\nPlease try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double result = 0;

            // Performs the calculation based on the selected operator
            switch (operator) {
                case "+":
                    MixedFraction sum= fraction1.add(fraction2);
                    break;
                case "-":
                    MixedFraction difference= fraction1.subtract(fraction2);
                    break;
                case "*":
                    MixedFraction product = fraction1.multiplyBy(fraction2);
                    break;
                case "/":
                    MixedFraction quotient= fraction1.divideBy(fraction2);
                    break;
            }
        } catch (NumberFormatException numEx) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ariEx) {   // would be solved by input limits; could be removed
            JOptionPane.showMessageDialog(null, "Output exceeded! \nPlease try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Oh no! It seems like we have encountered an error. \nPlease try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

