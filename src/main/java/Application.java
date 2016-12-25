import org.sid.dao.SocieteRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import ma.emsi.Jee.JpaRepository.produitRepository;

public class Application {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		//MongoClient client = (MongoClient) context.getBean("mongoClient");
		MongoDbFactory factory = context.getBean(MongoDbFactory.class);
		
		SocieteRepository societeRepository  = context.getBean(SocieteRepository.class);
		//societeRepository.
		
		DB db = factory.getDb();
		DBCollection collection = db.getCollection("societe");
		collection.insert(new BasicDBObject().append("title", "Systeme distribué de recolte des données finanicere"));
		
		
		
	}

}
