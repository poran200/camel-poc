import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CamelModifyProcessorRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyProcessorRoute();
    }

    @Test
    void processorTest() throws InterruptedException {
        String expectedValue = "123:poran:chowdury\n" +
                "124:sha:jalal\n" +
                "125:asif:ahmed\n" +
                "126:ezaj:molla";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
    }
}