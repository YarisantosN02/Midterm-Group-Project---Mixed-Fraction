package prog2.prelimgroup;

import java.text.DecimalFormat;
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        numerator = 0;
        denominator = 0;
    }
    public Fraction(int wholeNumVal){
        numerator = wholeNumVal;
        denominator = 1;
    }
    public Fraction(int num, int den){
        numerator = num;
        denominator = den;
    }
    public void setNumerator(int num){
        numerator = num;
    }
    public int getNumerator(){
        return numerator;
    }
    public void setDenominator(int den){
        denominator = den;
    }
    public int getDenominator(){
        return denominator;
    }
    public String toString(){
        return (numerator + "/" + denominator);
    }
    public double toDouble(){
        return (numerator / denominator);
    }
    public int computeGCD(int a, int b){
        int num;    // acts as temp

        if (a < b){ // arranges values by size; larger value first
            num = a;
            a = b;
            b = num;
        }
        while (a % b != 0){ // uses Euclidean Algorithm
            num = a % b;
            a = b;
            b = num;
        }
        return b;
    }
    public String convertToDecimal(double num, double den){
        DecimalFormat df = new DecimalFormat("#.##");   // formats decimal places to hundredths

        double dec = num / den; // getting decimal value
        return (df.format(dec));
    }
    public String add(int num1, int den1, int num2, int den2){
        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;  // computes LCD

        num1 *= (lcd / den1);   // converting numerators to match their denominator
        num2 *= (lcd / den2);

        int sumNum = num1 + num2;
        return (sumNum + "/" + lcd + " or " + convertToDecimal(sumNum, lcd));   // displays in main method
    }
    public String subtract(int num1, int den1, int num2, int den2){
        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;  // computes LCD

        num1 *= (lcd / den1);   // converting numerators to match their denominator
        num2 *= (lcd / den2);

        int difNum = num1 - num2;
        return (difNum + "/" + lcd + " or " + convertToDecimal(difNum, lcd));   // displays in main method
    }
    public String multiply(int num1, int den1, int num2, int den2){
        int divisor = num1 * num2;
        int dividend = den1 * den2;

        return (divisor + "/" + dividend + " or " + convertToDecimal(divisor, dividend));   // displays in main method
    }
    public String divide(int num1, int den1, int num2, int den2){
        int divisor = num1 * den2;
        int dividend = den1 * num2;

        return (divisor + "/" + dividend + " or " + convertToDecimal(divisor, dividend));   // displays in main method
    }
    public String reduce(int num, int den){
        int gcd = computeGCD(num, den);
        int redNum = num / gcd;
        int redDen = den / gcd;
        return redNum + "/" + redDen + " or " + convertToDecimal(redNum, redDen);   // displays in main method
    }
}
