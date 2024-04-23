package romansnumbers.EnumRomansNumbers;

public enum RomanNumbersValues {

    I (1),
    V (5),
    X (10),
    L (50),
    C (100),
    D (500),
    M (1000);

    private int DecimalValue;

    private  RomanNumbersValues(int DecimalValue) {
        this.DecimalValue = DecimalValue;
    }

    public int getDecimalValue() {
        return this.DecimalValue;
    }
}
