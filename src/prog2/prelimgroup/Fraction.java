package prog2.prelimgroup;

import java.text.DecimalFormat;
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        numerator = 0;
        denominator = 0;
    }

    /**Assumes the user has inputted a whole number which turns into a fraction. (x = x/1)*/
    public Fraction(int wholeNumVal){
        numerator = wholeNumVal;
        denominator = 1;
    }

    /**The user has inputted a numerator and a denominator in the constructor. Throws an Arithmetic
     * Excpetion if denominator = 0*/
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if (denominator == 0) throw new ArithmeticException("Denominator cannot be 0");
        this.denominator = denominator;
    }
    public void setNumerator(int num){
        numerator = num;
    }
    public int getNumerator(){
        return numerator;
    }
    public void setDenominator(int den){
        if (denominator == 0) throw new ArithmeticException("Denominator cannot be 0");
        denominator = den;
    }
    public int getDenominator(){
        return denominator;
    }
    public String toString(){
        return (numerator + "/" + denominator);
    }
    public double toDouble(){
        return ((double)numerator / denominator);
    }
    public String toDecimal(double num, double den){
        DecimalFormat df = new DecimalFormat("#.##");   // formats decimal places to hundredths

        double dec = num / den; // getting decimal value
        return (df.format(dec));
    }

    public int computeGCD(int num1, int num2){
        //if both numbers are zero, return 0
        if (num1 == 0 || num2 == 0){
            return 0;
        }else {
            //Euclidean Algorithm
            //a is the greater number, b is the lesser number
            int a,b;
            a = Math.max(num1, num2);
            b = Math.min(num1, num2);

            int r = 0; //remainder

            while (a % b != 0) {
                r = a % b;
                a = b; //the previous denominator of a/b will be the dividend
                b = r; //the previous remainder will be the divisor
            }

            return b;
        }
    }
    public Fraction add(Fraction other){
        int num1= this.getNumerator();
        int num2= other.getNumerator();
        int den1= this.getDenominator();
        int den2= other.getDenominator();

        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;  // computes LCD

        num1 *= (lcd / den1);   // converting numerators to match their denominator
        num2 *= (lcd / den2);

        int sumNum = num1 + num2;
        return new Fraction(sumNum, lcd);   // displays in main method
    }
    public Fraction subtract(Fraction other){
        int num1= this.getNumerator();
        int num2= other.getNumerator();
        int den1= this.getDenominator();
        int den2= other.getDenominator();

        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;  // computes LCD

        num1 *= (lcd / den1);   // converting numerators to match their denominator
        num2 *= (lcd / den2);

        int difNum = num1 - num2;
        return new Fraction(difNum, lcd);   // displays in main method
    }
    public Fraction multiply(Fraction other){
        int num1= this.getNumerator();
        int num2= other.getNumerator();
        int den1= this.getDenominator();
        int den2= other.getDenominator();

        int num = num1 * num2;
        int den = den1 * den2;

        return new Fraction(num, den);   // displays in main method
    }
    public Fraction divide(Fraction other){
        int num1= this.getNumerator();
        int num2= other.getNumerator();
        int den1= this.getDenominator();
        int den2= other.getDenominator();

        int divisor = num1 * den2;
        int dividend = den1 * num2;

        return new Fraction(divisor, dividend);   // displays in main method
    }


    public Fraction reduce(Fraction other){
        int num = other.getNumerator();
        int den = other.getDenominator();

        if (num == 0 || den == 0) {
            return new Fraction(0, 1); // Or any non-zero denominator value
        } else {

            int gcd = computeGCD(num, den);
            int redNum = num / gcd;
            int redDen = den / gcd;
            return new Fraction(redNum, redDen);   // displays in main method
        }
    }
}
