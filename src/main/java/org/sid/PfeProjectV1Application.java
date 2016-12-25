package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

@SpringBootApplication
public class PfeProjectV1Application {

	public static void main(String[] args) {
		ApplicationContext context =   SpringApplication.run(PfeProjectV1Application.class, args);
		MongoClient client = (MongoClient) context.getBean("mongoClient");
		DB db = client.getDB("SDRDF_DB");
		db.createCollection("tab1", new BasicDBObject());
		/*DBCollection collection = db.getCollection("tab1");
		collection.insert(new BasicDBObject().append("title", "Systeme distribué de recolte des données bourciere"));*/
	}
}
