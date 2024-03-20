package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

public class MixedFraction extends Fraction{
    private int whole;
    private Fraction fraction;

    public MixedFraction(){
        whole= 0;
        fraction= new Fraction();
    }

    public MixedFraction(int whole, Fraction fraction){

        this.whole = whole;
        this.fraction = fraction;

    }

    public MixedFraction(int whole, int numerator, int denominator){
        this.whole = whole;
        fraction = new Fraction(numerator, denominator);
    }

    public MixedFraction(Fraction fraction){
        this.fraction = fraction;
    }

    public void setWholePart(int whole){
        this.whole = whole;
    }

    public void setFractionPart(Fraction fraction){
        this.fraction = fraction;
    }

    public int getWhole(){
        return whole;
    }

    public Fraction getFractionPart(){
        return fraction;
    }

    public Fraction toFraction(){
        int num = (fraction.getDenominator() * whole) + fraction.getNumerator();
        int den = fraction.getDenominator();
        return new Fraction(num, den);
    }

    public MixedFraction toMixedFraction(Fraction frac){
        int den= frac.getDenominator();
        int wholeNum = Math.floorDiv(frac.getNumerator(), den);
        int num= frac.getNumerator() - (wholeNum * den);
        Fraction fractionNum = new Fraction(num, den);

        return new MixedFraction(wholeNum, reduce(fractionNum));
    }

    @Override
    public String toString() {
        String mixedFrac;
        if (fraction.toDouble() == 0) {
            mixedFrac = whole + "";
        } else {
            // if whole number is zero
            if(whole == 0){
                mixedFrac= fraction.toString();
            }else {
                mixedFrac = (whole + " " + fraction.toString());
            }
        }
        return mixedFrac;
    }

    @Override
    public double toDouble() {
        double fractionNum= fraction.toDouble();
        return whole + fractionNum;
    }

    public MixedFraction add(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        Fraction sum = fraction1.add(fraction2);

        return toMixedFraction(sum);
    }

    public MixedFraction subtract(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        Fraction difference = fraction1.subtract(fraction2);

        return toMixedFraction(difference);
    }

    public MixedFraction multiplyBy(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        Fraction product = fraction1.multiply(fraction2);

        return toMixedFraction(product);
    }

    public MixedFraction divideBy(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        Fraction quotient = fraction1.divide(fraction2);

        return toMixedFraction(quotient);
    }
}
