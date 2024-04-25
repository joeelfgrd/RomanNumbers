package romansnumbers.Calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import romansnumbers.EnumRomansNumbers.RomanNumbersValues;
import romansnumbers.RomansRegex.RomanNumbersRegexFilter;

public class RomanNumber {

    private short decimalNumber = 0;
    private final String romanNum;
    private final RomanNumbersRegexFilter regexList;

    public RomanNumber(String romanNumber) {
        this.romanNum = romanNumber;
        this.regexList = new RomanNumbersRegexFilter();
    }

    private Matcher createMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(this.romanNum);
    }

    public short toDecimal() {
        Matcher matcher = createMatcher(this.regexList.toString());
        while (matcher.find()) {
            String match = matcher.group();
            this.decimalNumber += decimalValue(match);
        }
        return this.decimalNumber;
    }

    public short decimalValue(String romanNumber) {
        for (RomanNumbersValues value : RomanNumbersValues.values()) {
            if (value.name().equals(romanNumber)) {
                return (short) value.getDecimalValue();
            }
        }
        // Manejar el caso en el que no se encuentre el número romano en el enum
        throw new IllegalArgumentException("No se encontró el número romano en el enum: " + romanNumber);
    }
}
