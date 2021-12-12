import org.apache.camel.builder.RouteBuilder;
import prosessor.CamelDirectExampleProcessor;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
           from("direct:processorInput")
                   .log("Before the process message is ${body} ")
                   .process(new CamelDirectExampleProcessor())
                   .log("Received Message after process  is ${body} and Headers are ${headers}")
                   .to("file:data/output?fileName=output.txt")
                   .to("mock:output");
    }
}
