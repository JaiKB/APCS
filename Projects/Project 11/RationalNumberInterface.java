public interface RationalNumberInterface {
    public int getNumerator();
    public int getDenominator();
    public RationalNumber add(RationalNumber x);
    public RationalNumber add(MixedNumber x);
    public RationalNumber subtract(RationalNumber x);
    public RationalNumber subtract(MixedNumber x);
    public RationalNumber multiply(RationalNumber x);
    public RationalNumber multiply(MixedNumber x);
    public RationalNumber divide(RationalNumber x);
    public RationalNumber divide(MixedNumber x);
    public MixedNumber convertToMixed();
    public String toString();
}