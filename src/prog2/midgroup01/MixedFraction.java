package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

public class MixedFraction extends Fraction{
    private int whole;

    // fraction instance variable is unnecessary
    // public Fraction methods are already inherited to the MixedFraction class via the extends operator

    public MixedFraction(){
        whole= 0;
    }

    /**
     * User might want to convert an improper fraction to a mixed fraction
     * Use if whole and fraction is given
     * */
    public MixedFraction(int whole, Fraction fraction){
        setDenominator(fraction.getDenominator());
        if (fraction.getNumerator() > fraction.getDenominator()) {
            int newNumerator, newWhole;
            newWhole = fraction.getNumerator()/getDenominator() + whole;
            newNumerator = fraction.getNumerator()%fraction.getDenominator();

            this.whole = newWhole;
            setNumerator(newNumerator);
        } else {
            this.whole = whole;
            setNumerator(fraction.getNumerator());
            setDenominator(fraction.getDenominator());
        }
    }

    /**Use if whole, numerator, and denominator is given*/
    public MixedFraction(int whole, int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("Denominator cannot be 0");
        setDenominator(denominator);

        if (numerator > denominator) {
            int newNumerator, newWhole;
            newWhole = numerator / denominator + whole;
            newNumerator = numerator % denominator;

            this.whole = newWhole;
            setNumerator(newNumerator);
        } else {
            this.whole = whole;
            setNumerator(numerator);
        }
    }
    /**Use if only the fraction is given*/
    public MixedFraction(Fraction fraction){
        setDenominator(fraction.getDenominator());
        if (fraction.getNumerator() > fraction.getDenominator()) {
            int newNumerator, newWhole;
            newWhole = fraction.getNumerator()/getDenominator() + whole;
            newNumerator = fraction.getNumerator()%fraction.getDenominator();

            this.whole = newWhole;
            setNumerator(newNumerator);
        } else {
            setNumerator(fraction.getNumerator());
        }
    }

    public void setWholePart(int whole){
        this.whole = whole;
    }

    public void setFractionPart(Fraction fraction){
        setNumerator(fraction.getNumerator());
        setDenominator(fraction.getDenominator());
    }

    public int getWhole(){
        return whole;
    }

    public Fraction getFractionPart(){
        return new Fraction(getNumerator(), getDenominator());
    }

    public Fraction toFraction(){
        int num = (getDenominator() * whole) + getNumerator();
        int den = getDenominator();
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
        if (getNumerator() == 0) {
            mixedFrac = String.valueOf(whole);
        } else {
            // if whole number is zero
            if (whole == 0)
                mixedFrac = getNumerator()+"/"+getDenominator();
            else
                mixedFrac = whole+ " " + getNumerator() + "/" + getDenominator();

        }
        return mixedFrac;
    }

    @Override
    public double toDouble() {
        double fractionNum= (double) getNumerator() / getDenominator();
        return whole + fractionNum;
    }

    public MixedFraction add(MixedFraction other){
        int num1= this.getNumerator();
        int num2= other.getNumerator();
        int den1= this.getDenominator();
        int den2= other.getDenominator();
        int whole1= this.getWhole();
        int whole2= other.getWhole();

        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;  // computes LCD

        num1 *= (lcd / den1);   // converting numerators to match their denominator
        num2 *= (lcd / den2);

        int sumWhole = whole1+whole2;
        int sumNum = num1 + num2;
        return new MixedFraction(sumWhole,sumNum, lcd);   // displays in main method
    }

    public MixedFraction subtract(MixedFraction other){
        int num1= this.getNumerator();
        int num2= other.getNumerator();
        int den1= this.getDenominator();
        int den2= other.getDenominator();
        int whole1= this.getWhole();
        int whole2= other.getWhole();

        int div = computeGCD(den1, den2);
        int lcd = (den1 * den2) / div;  // computes LCD

        num1 *= (lcd / den1);   // converting numerators to match their denominator
        num2 *= (lcd / den2);

        int sumWhole = whole1 - whole2;
        int sumNum = num1 - num2;
        return new MixedFraction(sumWhole,sumNum, lcd);   // displays in main method
    }

    public MixedFraction multiplyBy(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        int num1= fraction1.getNumerator();
        int num2= fraction2.getNumerator();
        int den1= fraction1.getDenominator();
        int den2= fraction2.getDenominator();

        int num = num1 * num2;
        int den = den1 * den2;

        return new MixedFraction(new Fraction(num,den));
    }

    public MixedFraction divideBy(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        int num1= fraction1.getNumerator();
        int num2= fraction2.getNumerator();
        int den1= fraction1.getDenominator();
        int den2= fraction2.getDenominator();

        int num = num1 * den2;
        int den = den1 + num2;

        return new MixedFraction(new Fraction(num,den));
    }
}
