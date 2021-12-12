import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
         return  new CamelModifyDirectProcessorRoute();
    }

    @Test
    void modifyDirectProcessorRouteTests() {
        String expectedValue = "123:poran:chowdury\n" +
                "124:sha:jalal\n" +
                "125:asif:ahmed\n" +
                "126:ezaj:molla";
        String inputValue = "123,poran,chowdury\n" +
                "124,sha,jalal\n" +
                "125,asif,ahmed\n" +
                "126,ezaj,molla";
        String output = (String) template.requestBody("direct:processorInput", inputValue);
        assertEquals(expectedValue,output);
    }

    @Test
    void processorDirectUsingMockedTest() throws InterruptedException {
        String expectedValue = "123:poran:chowdury\n" +
                "124:sha:jalal\n" +
                "125:asif:ahmed\n" +
                "126:ezaj:molla";
        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(expectedValue);

        String inputValue = "123,poran,chowdury\n" +
                "124,sha,jalal\n" +
                "125,asif,ahmed\n" +
                "126,ezaj,molla";
        template.sendBody("direct:processorInput",inputValue);
        assertMockEndpointsSatisfied();
    }
}