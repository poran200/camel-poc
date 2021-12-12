package geson;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import pojo.Employee;

import static org.junit.jupiter.api.Assertions.*;

class UnMarSalUsingGsonRouteTest extends CamelTestSupport {
 @Override
 protected RoutesBuilder createRouteBuilder() throws Exception {
   return new  UnMarSalUsingGsonRoute();
 }

 @Test
 void unmarSalUsingGsonTests() {
  Employee employee;
  String inputJson = "{\"name\":\"jalal\",\"age\":\"12\"}";
  employee = (Employee) template.requestBody("direct:unMarshalGson", inputJson);
  assertEquals("12",employee.getAge());
 }
}