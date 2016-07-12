package liqp.filters;

class Ceil extends Filter {

    /*
     * ceil(input)
     *
     * Rounds the input up to the nearest whole number.
     * Liquid tries to convert the input to a number before the filter is applied.
     */
    @Override
    public Object apply(Object value, Object... params) {

        if(value == null || !super.isNumber(value)) {
            value = 0;
        }

        return (int) Math.ceil(super.asNumber(value).floatValue());
    }
}
