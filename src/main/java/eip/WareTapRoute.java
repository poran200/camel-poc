package eip;

import org.apache.camel.builder.RouteBuilder;

public class WareTapRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
          from("file:data/input?noop=true")
                  .wireTap("file:data/output/debug")
                  .to("file:data/output/all");
    }
}
