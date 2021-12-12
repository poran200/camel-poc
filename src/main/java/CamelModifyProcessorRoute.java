import org.apache.camel.builder.RouteBuilder;
import prosessor.CamelFileExampleProcessor;

public class CamelModifyProcessorRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Read file is ${body} adn headers are ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
