package restToMongo;


import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import static restToMongo.RestToMongoDbRoute.COUNTIES;

public class MongoDb {

    public static MongoDatabase getmongodb(){
        MongoDatabase database = MongoClients.create("mongodb://localhost:27017").getDatabase("test");
      if (database.getCollection(COUNTIES) == null){
          database.createCollection(COUNTIES);
      }

        return database;
    }

}
