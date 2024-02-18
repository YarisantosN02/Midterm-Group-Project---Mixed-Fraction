package prog2.prelimgroup;

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
        return numerator / denominator;
    }
    private int computeGCD(int num1, int  num2) {
        //Euclidian Algorithm
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
    public String add(int num1, int den1, int num2, int den2){
        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;

        num1 *= (lcd / den1);
        num2 *= (lcd / den2);
        den1 = lcd;
        den2 = lcd;

        int sumNum = num1 + num2;
        double dec = (double) sumNum / lcd;

        return (sumNum + "/" + lcd + " or " + dec);
    }
    public String subtract(int num1, int den1, int num2, int den2){
        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;

        num1 *= (lcd / den1);
        num2 *= (lcd / den2);
        den1 = lcd;
        den2 = lcd;

        int difNum = num1 - num2;
        double dec = (double) difNum / lcd;     // need to make decimal converter method for "or" .2f option in results

        return (difNum + "/" + lcd + " or " + dec);
    }
    public String multiply(int num1, int den1, int num2, int den2){
        int divisor = num1 * num2;
        int dividend = den1 * den2;

        return (divisor + "/" + dividend);
    }
    public String divide(int num1, int den1, int num2, int den2){
        int divisor = num1 * den2;
        int dividend = den1 * num1;

        return (divisor + "/" + dividend);
    }
    public String reduce(int num, int den){
        int gcd = computeGCD(num, den);
        int redNum = num / gcd;
        int redDen = den / gcd;
        return redNum + "/" + redDen;
    }
}
