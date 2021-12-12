package eip;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
       from("file:data/input")
               .multicast()
               .to("file:data/output1", "file:data/output2");
    }
}
