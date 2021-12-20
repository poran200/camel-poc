import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.bson.Document;
import restToMongo.MongoDb;

import java.util.UUID;

import static restToMongo.RestToMongoDbRoute.COUNTIES;

public class Main {


    public static void main(String[] args) throws Exception {
//        CamelContext camelContext = new DefaultCamelContext();
//        camelContext.addRoutes(new HttpRoute());
//        camelContext.start();
//        Thread.sleep(5000);
//        camelContext.stop();
        MongoCollection<Document> databaseCollection = MongoDb.getmongodb().getCollection(COUNTIES);
        InsertOneResult insertOneResult = databaseCollection.insertOne(new Document().append(UUID.randomUUID().toString(), "Hello"));
        System.out.println("insertOneResult = " + insertOneResult.getInsertedId());
    }
}
