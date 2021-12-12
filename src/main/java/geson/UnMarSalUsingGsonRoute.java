package geson;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import pojo.Employee;

public class UnMarSalUsingGsonRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:unMarshalGson")
                .log("Recived message is : ${body}")
                .unmarshal(gsonDataFormat)
                .log("Unmarshal message is : ${body}");
    }
}
