package restToMongo;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.bson.Document;

import java.util.UUID;

public class RestToMongoDbRoute extends RouteBuilder {

    public static final String COUNTIES = "counties";

    @Override
    public void configure() throws Exception {


        from("direct:restCall")
                .to("log:?level=INFO&showBody=true")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
//                .setHeader(Exchange.HTTP_URI, simple("https://restcountries.eu/rest/v2/alpha/us"))
                .to("https://restcountries.com/v3.1/all")
                .convertBodyTo(String.class)
                .to("log:?level=INFO&showBody=true")
                .process(exchange -> {

                    MongoCollection<Document> databaseCollection = MongoDb.getmongodb().getCollection(COUNTIES);
                    Document document = new Document();
                    document.put(UUID.randomUUID().toString(), exchange.getIn().getBody());
                    InsertOneResult insertOneResult = databaseCollection.insertOne(document);
                    System.out.println("insertOneResult = " + insertOneResult.getInsertedId());
                })
                .to("log:?level=INFO&showBody=true");
    }
}
