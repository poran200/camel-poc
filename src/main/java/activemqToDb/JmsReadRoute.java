package activemqToDb;

import org.apache.camel.builder.RouteBuilder;

public class JmsReadRoute  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
     from("jms:queue:testQueue")
             .to("log:?level=INFO&showBody=true")
             .to("direct:readQueue");
    }
}
