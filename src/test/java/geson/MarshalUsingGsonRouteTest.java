package geson;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import pojo.Employee;

import static org.junit.jupiter.api.Assertions.*;

class MarshalUsingGsonRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
         return  new MarshalUsingGsonRoute();
    }

    @Test
    void marshalUsingGsonTest() {
        Employee employee = new Employee();
        employee.setAge("12");
        employee.setName("jalal");
        String expectGeson = "{\"name\":\"jalal\",\"age\":\"12\"}";
        String emJson = template.requestBody("direct:marshalGson", employee, String.class);
        System.out.println("emJson = " + emJson);
        assertEquals(expectGeson,emJson);
    }
}