package romansnumbers.RomansRegex;


import java.util.List;
import java.util.stream.Collectors;

public class RomanNumbersRegexFilter {
    private static final List<String> regexFilter = List.of(
            "((?<!D)[M]|(?<!C)[MD]|(?<!L)[MDC]|(?<!X)[MDCL]|(?<!V)[MDCLX]|(?<!I)[MDCLXV])",
            "(C[DM])|(X[LC])|(I[VX])"
    );

    public static List<String> getRegexFilter() {
        return regexFilter;
    }

    @Override
    public String toString() {
        StringBuilder filtro = new StringBuilder();
        for (String regex : regexFilter) {
            filtro.append(regex)
                    .append("|");
        }
        if (filtro.length() > 0) {
            filtro.deleteCharAt(filtro.length() - 1);
        }
        return filtro.toString();
    }
}