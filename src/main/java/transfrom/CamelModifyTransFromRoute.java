package transfrom;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTransFromRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

     from("direct:transformInput")
             .transform(body().regexReplaceAll(",","*"))
             .to("mock:output");
    }
}
