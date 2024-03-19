package prog2.midgroup01;
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




        }
    }

