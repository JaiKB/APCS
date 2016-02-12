public interface MixedNumberInterface {
	public int getNumerator();
	public int getDenominator();
	public int getWhole();
    public MixedNumber add(RationalNumber x);
    public MixedNumber add(MixedNumber x);
    public MixedNumber subtract(RationalNumber x);
    public MixedNumber subtract(MixedNumber x);
    public MixedNumber multiply(RationalNumber x);
    public MixedNumber multiply(MixedNumber x);
    public MixedNumber divide(RationalNumber x);
    public MixedNumber divide(MixedNumber x);
    public RationalNumber convertToRational();
    public String toString();
}