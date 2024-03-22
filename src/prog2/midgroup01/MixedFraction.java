package prog2.midgroup01;
import prog2.prelimgroup.Fraction;

public class MixedFraction extends Fraction{
    private int whole;

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
            newWhole = fraction.getNumerator()/fraction.getDenominator() + whole;
            newNumerator = fraction.getNumerator()%fraction.getDenominator();

            this.whole = newWhole;
            setNumerator(newNumerator);
        } else {
            setNumerator(fraction.getNumerator());
        }
    }


    /**
     * Sets the whole number of the Mixed Fraction
     * */
    public void setWholePart(int whole){
        this.whole = whole;
    }

    /**
     * Sets the Fraction part of the Mixed Fraction
     * */
    public void setFractionPart(Fraction fraction){
        if (fraction.getNumerator() > fraction.getDenominator()) {
            int newNumerator, newWhole;
            newWhole = fraction.getNumerator()/ fraction.getDenominator()+ whole;
            newNumerator = fraction.getNumerator()%fraction.getDenominator();

            this.whole = newWhole;
            setNumerator(newNumerator);
        } else {
            setNumerator(fraction.getNumerator());
            setDenominator(fraction.getDenominator());
        }
    }

    /**
     * Returns the whole number of the Mixed Fractions
     * */
    public int getWhole(){
        return whole;
    }


    /**
     * Returns the Fraction Part of the Mixed Fraction
     * */
    public Fraction getFractionPart(){
        return new Fraction(getNumerator(), getDenominator());
    }

    /**
     * Turn the mixed fraction in to an improper fraction
     * */
    public Fraction toFraction(){
        int num = (getDenominator() * whole) + getNumerator();
        int den = getDenominator();
        return new Fraction(num, den);
    }

    /**
     * Returns the given whole number, numerator, and denominator as a String.
     * <br>
     *      <ul>Returns: [whole] [numerator]/[denominator]</ul>
     * */
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

    /**
     * Turns the given Mixed Fraction to a double.
     * */
    @Override
    public double toDouble() {
        double fractionNum= Double.parseDouble(toDecimal(getNumerator(), getDenominator()));
        return whole + fractionNum;
    }

    /** Adds first mixed fraction to the second mixed fraction
     * <br>
     *     <ul> Usage: First_Fraction.add(Second_Fraction)</ul>
     **/
    public MixedFraction add(MixedFraction other){
        Fraction fraction1 = this.getFractionPart();
        Fraction fraction2 = other.getFractionPart();
        int whole1 = this.getWhole(), whole2 = other.getWhole();

        int sumWhole = whole1 + whole2;
        Fraction sumFraction = fraction1.add(fraction2);

        return new MixedFraction(sumWhole, sumFraction);
    }

    /** Subtracts first mixed fraction to the second mixed fraction
     * <br>
     *     <ul> Usage: First_Fraction.subtract(Second_Fraction)</ul>
     **/
    public MixedFraction subtract(MixedFraction other){
        Fraction fraction1 = this.getFractionPart();
        Fraction fraction2 = other.getFractionPart();
        int whole1 = this.getWhole(), whole2 = other.getWhole();

        int diffWhole = whole1 + whole2;
        Fraction diffFraction = fraction1.subtract(fraction2);

        return new MixedFraction(diffWhole, diffFraction);
    }

    /** multiplies first mixed fraction to the second mixed fraction
     * <br>
     *     <ul> Usage: First_Fraction.multiplyBy(Second_Fraction)</ul>
     **/
    public MixedFraction multiplyBy(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        return new MixedFraction(fraction1.multiplyBy(fraction2));
    }

    /** Divides first mixed fraction to the second mixed fraction
     * <br>
     *     <ul> Usage: First_Fraction.divideBy(Second_Fraction)</ul>
     **/
    public MixedFraction divideBy(MixedFraction other){
        Fraction fraction1 = this.toFraction();
        Fraction fraction2 = other.toFraction();

        return new MixedFraction(fraction1.divideBy(fraction2));
    }
}
