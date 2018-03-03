package liqp.filters;

class Escape_Quotes extends Filter {

    /*
     * escape_quotation(input)
     *
     * Prepends quotation marks " with backslashes \
     */
    @Override
    public Object apply(Object value, Object... params) {

        return super.asString(value).replaceAll("[\"]", "\\\\\"");
    }
}
