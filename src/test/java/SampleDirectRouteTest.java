import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SampleDirectRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    void sampleRouteTest() throws InterruptedException {
        template.sendBody("direct:sampleInput","1234,Poran Chowdury");
        Thread.sleep(5000);
        File file = new File("sampleOutput");
        assertTrue(file.isDirectory());
        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals("output.txt",exchange.getIn().getHeader("CamelFileName"));
    }
}