package prosessor;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.bson.Document;
import restToMongo.MongoDb;

import java.util.UUID;

import static restToMongo.RestToMongoDbRoute.COUNTIES;

public class MongoDbDataProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        MongoCollection<Document> databaseCollection = MongoDb.getmongodb().getCollection(COUNTIES);
        InsertOneResult insertOneResult = databaseCollection.insertOne(new Document().append(UUID.randomUUID().toString(), exchange.getIn()));
        System.out.println("insertOneResult = " + insertOneResult.getInsertedId());
    }
}