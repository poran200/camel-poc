package eip;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ContentBaseRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ContentBaseRoute();
    }

    @Test
    void contentBaseRouteTest() throws InterruptedException {
        Thread.sleep(5000);
        File html = new File("data/output/html");
        assertTrue(html.isDirectory());
        File text = new File("data/output/txt");
        assertTrue(text.isDirectory());
        File json = new File("data/output/json");
        assertTrue(json.isDirectory());
    }
}