package prog2.midgroup01;

public class MixedFractions extends Fraction {
    private int whole;

    MixedFractions() {
        whole = 0;
    }

//use if user wants to input their own whole number and fraction
    MixedFractions(int whole, Fraction fraction) {
        this.whole = whole;
    }

    /**
     * 1. the whole number is equal to the quotient of the numerator and denominator
     * 2. the new numerator is equal to the remainder
     */

//use if user has inputted a whole number, a numerator, and a denominator
    MixedFractions(int whole, int numerator, int denominator) {
        this.whole = whole;      //mutator

        if (numerator > denominator) {
            this.whole = whole + numerator/denominator;
            setNumerator(numerator % denominator);
        } else {
            this.numerator = numerator;
        }
    }

//use if user wants to turn a fraction to a mixed fraction
    MixedFractions(Fraction fraction) {
        boolean isLessThan1 = fraction.getNumerator()/fraction.getDenominator() < 1;
        if (isLessThan1)
            whole = 0;
        else
            whole = getNumerator()/getDenominator();

        numerator = fraction.getNumerator()%fraction.getDenominator();
        denominator = fraction.getDenominator();
    }
}
