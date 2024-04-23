package romansnumbers.Calculate;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.checkerframework.common.returnsreceiver.qual.This;
import romansnumbers.EnumRomansNumbers.RomanNumbersValues;
import romansnumbers.RomansRegex.RomanNumbersRegexFilter;


public class CalculateDecimalNumber {

    private short decimalNumber = 0;
    private final String romanNumber;
    private final RomanNumbersRegexFilter regexList;

    public CalculateDecimalNumber(String romanNumbers) {
        this.romanNumber = romanNumbers;
        this.decimalNumber = 0;
        this.regexList = new RomanNumbersRegexFilter();
    }

    public short getDecimalNumber() {
        return this.decimalNumber;
    }

    public short toDecimal() {
        for (String regex : this.regexList.getRegexFilter()) {
            Matcher matcher = createMatcher(regex);
            groupSumatoryToDecimal(matcher);
        }
        return this.getDecimalNumber();
    }

    private void groupSumatoryToDecimal(Matcher matcher) {
        while (matcher.find()) {
            this.decimalNumber += decimalValue(matcher.group());
        }
    }

    private short decimalValue(String numeroRomano) {
        RomanNumbersValues simbolo = Enum.valueOf(RomanNumbersValues.class, String.valueOf(numeroRomano));
        return (short) simbolo.getDecimalValue();
        }
    }

    private Matcher createMatcher(String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.romanNumber);
        return matcher;
    }

}
