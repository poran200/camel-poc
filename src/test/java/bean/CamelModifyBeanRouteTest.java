package bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import transfrom.CamelModifyTransFromRoute;

import static org.junit.jupiter.api.Assertions.*;

class CamelModifyBeanRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
         return  new CamelModifyBeanRoute();
    }

    @Test
    void camelModifyByBeanTest() {
        String expectedValue = "123*poran*chowdury\n" +
                "124*sha*jalal\n" +
                "125*asif*ahmed\n" +
                "126*ezaj*molla";
        String inputValue = "123,poran,chowdury\n" +
                "124,sha,jalal\n" +
                "125,asif,ahmed\n" +
                "126,ezaj,molla";
        String acutual = (String) template.requestBody("direct:beanInput", inputValue);
        assertEquals(expectedValue,acutual);
    }
}