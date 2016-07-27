package liqp.filters;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Money extends Filter {

    /*
     * money(input)
     *
     * Attempts to format a string containing numeric values as currency.
     */
    @Override
    public Object apply(Object value, Object... params) {

        String val = super.asString(value);
        String res;
        Pattern r = Pattern.compile("(.*?)(\\d+)(.*)");
        Matcher m = r.matcher(val);

        if (m.find()) {
            BigDecimal n = new BigDecimal(m.group(2));
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
            DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
            symbols.setGroupingSeparator(' ');
            formatter.setDecimalFormatSymbols(symbols);
            res = m.group(1) + formatter.format(n.longValue()) + m.group(3);
        } else {
            res = super.asString(val);
        }

        return res;
    }
}
