package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

import java.util.Scanner;

public class FractionTester {
    public static void main(String[] args){
        Scanner kbd= new Scanner(System.in);
      
        System.out.print("Fraction 1 numerator:");
        int numFrac1= kbd.nextInt();
        System.out.print("Fraction 1 denominator:");
        int denFrac1 = kbd.nextInt();
        System.out.print("Fraction 1 whole Number:");
        int wholeFrac1 = kbd.nextInt();
        System.out.print("Fraction 2 numerator:");
        int numFrac2 = kbd.nextInt();
        System.out.print("Fraction 2 denominator:");
        int denFrac2 = kbd.nextInt();
        System.out.print("Fraction 1 whole number:");
        int wholeFrac2 = kbd.nextInt();


        MixedFraction fraction1 = new MixedFraction(wholeFrac1, numFrac1, denFrac1);
        MixedFraction fraction2 = new MixedFraction(wholeFrac2, numFrac2, denFrac2);
        MixedFraction sum= fraction1.add(fraction2);
        MixedFraction dif= fraction1.subtract(fraction2);
        MixedFraction quotient= fraction1.divideBy(fraction2);
        MixedFraction product = fraction1.multiplyBy(fraction2);


        System.out.print("\n Addition: "+ fraction1.toString() +" + "+ fraction2.toString() +" = "+ sum.toString()+" or "+ sum.toDouble());
        System.out.print("\n Subtraction: "+ fraction1.toString() +" - "+ fraction2.toString() +" = "+ dif.toString()+" or "+ dif.toDouble());
        System.out.print("\n Division: "+ fraction1.toString() +" / "+ fraction2.toString() +" = "+ quotient.toString()+" or "+ quotient.toDouble());
        System.out.print("\n Multiplication: "+ fraction1.toString() +" * "+ fraction2.toString() +" = "+ product.toString()+" or "+ product.toDouble());
        System.out.print("\nFraction 1 whole number:"+ fraction1.getWhole());
        System.out.print("\nFraction 1 numerator:"+ fraction1.getNumerator());
        System.out.print("\nFraction 1 denominator:"+ fraction1.getDenominator());

        try{
            //code here
        } catch (NumberFormatException numEx) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ariEx) {
            JOptionPane.showMessageDialog(null, "Zero (0) cannot be a denominator! \nPlease try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Oh no! It seems like we have encountered an error. \nPlease try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

