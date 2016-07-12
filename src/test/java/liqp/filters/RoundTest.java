package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoundTest {

    @Test
    public void applyTest() throws RecognitionException {

        String[][] tests = {
                {"{{ 1.2 | round }}", "1"},
                {"{{ 2.7 | round }}", "3"},
                {"{{ \"4.4\" | round }}", "4"},
                {"{{ 5 | round }}", "5"},
                {"{{ wut | round }}", "0"},
                {"{{ wut | round: 1 }}", "0.0"},
                {"{{ 183.357 | round: 2 }}", "183.36"}
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render());

            assertThat(rendered, is(test[1]));
        }
    }
}
