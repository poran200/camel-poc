package eip;

import org.apache.camel.builder.RouteBuilder;

public class ContentBaseRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
           from("file:data/input?noop=true")
                   .to("log:?level=INFO&showBody=true&showHeaders=true")
                   .choice()
                   .when(header("CamelFileNameConsumed").endsWith(".html"))
                   .to("file:data/output/html")
                   .when(header("CamelFileNameConsumed").endsWith(".txt"))
                   .to("file:data/output/txt")
                   .when(header("CamelFileNameConsumed").endsWith(".json"))
                   .to("file:data/output/json")
                   .end()
                           .to("file:data/output/all");

    }
}
