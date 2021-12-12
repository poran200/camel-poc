import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Received Message is ${body} and headers are ${headers}")
                .to("file:sampleOutput?fileName=output.txt");
    }
}
