package eip;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WareTapRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new WareTapRoute();
    }

    @Test
    void wareTapRouteTest() throws InterruptedException {
        Thread.sleep(5000);
        File file = new File("data/output/debug");
        assertTrue(file.isDirectory());
    }
}