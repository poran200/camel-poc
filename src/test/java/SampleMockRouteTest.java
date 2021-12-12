import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

class SampleMockRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleMockRoute();
    }

    @Test
    void mockRouTeTest() throws InterruptedException {
        String hello = "Hello";
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(hello);
        template.sendBody("direct:sampleInput",hello);
        assertMockEndpointsSatisfied();

    }
}