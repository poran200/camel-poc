package prosessor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


public class CamelFileExampleProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange in Processors is " + exchange.getMessage().getBody());
        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();
        List<String> readFileToString = FileUtils.readLines(file.getFile(), StandardCharsets.UTF_8);
        String collect = readFileToString.stream().map(s -> s.replace(",", ":")).collect(Collectors.joining("\n"));
        System.out.println(collect);
        exchange.getIn().setBody(collect);
    }
}
