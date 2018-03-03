package liqp.filters;

class Round extends Filter {

    /*
     * round(input)
     *
     * Rounds the input up to the nearest whole number.
     * Liquid tries to convert the input to a number before the filter is applied.
     */
    @Override
    public Object apply(Object value, Object... params) {

        long precision;

        if (value == null || !super.isNumber(value)) {
            value = 0F;
        }

        if (params == null || params.length == 0 || !super.isInteger(params[0])) {
            precision = 0L;
        } else {
            precision = super.asNumber(params[0]).longValue();
        }

        return String.format("%." + Long.toString(precision) + "f", super.asNumber(value).floatValue());
    }
}
