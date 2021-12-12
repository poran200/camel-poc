package geson;

import com.google.gson.Gson;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import pojo.Employee;

public class MarshalUsingGsonRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        GsonDataFormat dataFormat = new GsonDataFormat(Employee.class);
        from("direct:marshalGson")
                .log(" before marshal object is : ${body}")
                .marshal(dataFormat)
                .log(" after marshal object is : ${body}");

    }
}
