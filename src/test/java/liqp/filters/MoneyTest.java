package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoneyTest {

    @Test
    public void applyTest() throws RecognitionException {

        String[][] tests = {
                {"{{ '1000 $' | money }}", "1 000 $"},
                {"{{ '£20000' | money }}", "£20 000"},
                {"{{ 200 | money}}", "200"},
                {"{{ 'Amazing! 1500.50 eur' | money}}", "Amazing! 1 500.50 eur"},
                {"{{ 'wut' | money }}", "wut"},
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render());

            assertThat(rendered, is(test[1]));
        }
    }
}
