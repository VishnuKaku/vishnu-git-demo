package com.ibm.demo;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
public class MongoDbDemo {
	public static void main(String[] args) {
		System.out.println("start");		
		String url = "mongodb://localhost:27017/";
		MongoClient client = MongoClients.create(url);		
		MongoDatabase database = client.getDatabase("IBM");		
		MongoCollection<Document> collection = database.getCollection("restarent");
		long docCount = collection.countDocuments();
		System.out.println(docCount);
		FindIterable<Document> docs = collection.find();		
		Document doc = docs.first();
		System.out.println(doc);
		docs.forEach(oneDoc ->{
			System.out.println(oneDoc);
		});
		System.out.println("End"); 		
	}
}
