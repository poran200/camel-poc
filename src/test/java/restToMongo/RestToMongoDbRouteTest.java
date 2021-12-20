package restToMongo;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

class RestToMongoDbRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return  new RestToMongoDbRoute();
    }

    @Test
    void restToMongo() throws InterruptedException {
        Object requestBody = template.requestBody("direct:restCall","Hello java");
    }
}