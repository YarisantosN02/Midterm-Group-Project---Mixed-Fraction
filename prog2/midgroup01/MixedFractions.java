package prog2.midgroup01;

public class MixedFractions extends Fraction {
    private int whole;

    MixedFractions() {
        whole = 0;
        //no need to set numerator and denominator.
        //they're already in the parent class
    }

    /*
     * 1. the whole number is equal to the quotient of the numerator and denominator
     * 2. the new numerator is equal to the remainder
     */

    /**use if user wants to input their own whole number and fraction*/
    MixedFractions(int whole, Fraction fraction) {
        if (fraction.getNumerator() > fraction.getDenominator()) {
            //this will throw an Arithmetic Exception if denominator = 0
            this.whole = fraction.getNumerator()/fraction.getDenominator() + whole;
            setNumerator(fraction.getNumerator());
            setDenominator(fraction.getDenominator());
        } else {
            this.whole = whole;
            setNumerator(fraction.getNumerator());
            setDenominator(fraction.getDenominator());
        }
    }

    /**use if user has inputted a whole number, a numerator, and a denominator*/
    MixedFractions(int whole, int numerator, int denominator) {
        if (numerator > denominator) {
            //this will throw an Arithmetic Exception if denominator = 0
            this.whole = whole + numerator/denominator;
            setNumerator(numerator%denominator);
            setDenominator(denominator);
        } else {
            this.whole = whole;
            setNumerator(numerator);
            setDenominator(denominator);
        }
    }

    /**use if user wants to turn a fraction to a mixed fraction*/
    MixedFractions(Fraction fraction) {
        //this will throw an Arithmetic Exception if denominator = 0
        boolean isWholeLessThan1 = fraction.getNumerator()/fraction.getDenominator() < 1;
        if (isWholeLessThan1)
            whole = 0;
        else
            whole = getNumerator()/getDenominator();

        setNumerator(fraction.getNumerator()%fraction.getDenominator());
        setDenominator(fraction.getDenominator());
    }

    /**setters*/

    public void setWhole(int whole) {
        this.whole = whole;
    }

    public void setFractionPart(Fraction fraction) {
        setNumerator(fraction.getNumerator());
        setDenominator(fraction.getDenominator());
    }

    /**getters*/
    public int getWhole() {
        return whole;
    }

    public Fraction getFractionPart() {
        return new Fraction(getNumerator(),getDenominator());
    }


    /**toString, toDouble and toFraction*/
    @Override
    public String toString() {
        if (getNumerator() == 0) {
            return String.valueOf(whole);
        } else {
            if (whole == 0) return getNumerator() + "/" + getDenominator();
            else return whole + " " + getNumerator() + "/" + getDenominator();
        }
    }

    @Override
    public double toDouble() {
        double quotient = (double) getNumerator()/getDenominator();
        return quotient + whole;
    }

    /**use if user wants to turn Mixed Fraction to improper fraction*/
    /* to get improper fraction, multiply the whole number to the denominator
     * and add the old numerator to get the new numerator
     */
    public Fraction toFraction() {
        int newNumerator = whole*getDenominator()+getNumerator();
        return new Fraction(newNumerator, getDenominator());
    }


}
