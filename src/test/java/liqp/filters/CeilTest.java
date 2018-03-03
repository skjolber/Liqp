package liqp.filters;

import liqp.Template;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CeilTest {

    @Test
    public void applyTest() throws RecognitionException {

        String[][] tests = {
                {"{{ 3 | ceil }}", "3"},
                {"{{ 4.4 | ceil }}", "5"},
                {"{{ \"5.1\" | ceil }}", "6"},
                {"{{ wut | ceil }}", "0"},
        };

        for (String[] test : tests) {

            Template template = Template.parse(test[0]);
            String rendered = String.valueOf(template.render());

            assertThat(rendered, is(test[1]));
        }
    }
}
