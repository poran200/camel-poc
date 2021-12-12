package bean;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .bean(new CamelStringModifyBean(),"map")
                .log("Change message is : ${body}")
                .to("mock:output");


    }
}
