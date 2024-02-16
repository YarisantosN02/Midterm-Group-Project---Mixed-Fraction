package prog2.prelimgroup;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        numerator = 0;
        denominator = 0;
    }
    public Fraction(int wholeNumVal){   //wtf is the value of wholeNumVal
        numerator = 0;
        denominator = 0;
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
    public int computeGCD(int d1, int d2){
        int gcd = 0;
        for (int i = 1; i <= d1 && i <= d2; i++){
            if (d1 % i == 0 && d2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    public int computeLCD(int d1, int d2){
        int div = computeGCD(d1, d2);
        int lcd = (d1 * d2) / div;
        return lcd;
    }
    public void add(int num1, int den1, int num2, int den2){
        int lcd = computeLCD(den1, den2);
        num1 *= (lcd / den1);
        num2 *= (lcd / den2);
        den1 = lcd;
        den2 = lcd;

        int sumNum = num1 + num2;
        double dec = (double) sumNum / lcd;
        System.out.printf("\n🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀" +
                          "\n🎀                                  🎀" +
                          "\n🎀 Fraction 1: %d/%d                🎀" +
                          "\n🎀 Fraction 2: %d/%d                🎀" +
                          "\n🎀 Sum of Fractions: %d/%d or %.2f  🎀" +
                          "\n🎀                                  🎀" +
                          "\n🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀🎀", num1 , den1, num2, den2, sumNum, lcd, dec);
    }
}
