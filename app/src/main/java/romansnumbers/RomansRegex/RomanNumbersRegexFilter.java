package romansnumbers.RomansRegex;

import java.util.List;
import java.util.stream.Collectors;



public class RomanNumbersRegexFilter {

    final List<String> RegexFilter = List.of(
            "(?<!DM[] | (?<!C[MD] | (?<!L[MDC] | (?<!X[MDCL] | (?<!V[MDCLX] | (?<!I[MDCLXV])",
            "(C[DM])|(X[LC])|(I[VX])"
    );

    public List<String> getRegexFilter() {
        return this.RegexFilter.stream().collect(Collectors.toList());
    }
}

