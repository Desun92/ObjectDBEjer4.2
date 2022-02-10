package es.iestetuan.acv.objectDBEjer42;

import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinary;
import org.bson.BsonElement;
import org.bson.BsonValue;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import es.iestetuan.acv.dao.jpa.ColorJPA;
import es.iestetuan.acv.dao.vo.Color;

public class AppMongo {

	public static void main(String[] args) {
		
		AppMongo prueba = new AppMongo();
		//prueba.probarAccesoMongo();
		prueba.listarColores();

	}
	
	public void probarAccesoMongo() {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDatabase = mongoClient.getDatabase("pruebaMongo");
		
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("colores");
		
		List<Color> listaColores = new ArrayList<Color>();
		List<Document> listaMongo = new ArrayList<Document>();
		ColorJPA operacionColor = new ColorJPA();
		
		listaColores = operacionColor.consultarLista();
		
		for(Color color : listaColores) {
			Document document = new Document();
			document.put("CodigoColor", color.getCodigoColor());
			
			/*document.put("_id",color.getCodigoColor());
			document.put("Codigo Hexadecimal",color.getCodigoHexadecimal());
			document.put("Nombre",color.getNombre());*/
			
			mongoCollection.deleteMany(document);
			//listaMongo.add(document);
		}
		
		//mongoCollection.insertMany(listaMongo);
	}
	
	public void listarColores() {
		
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
		MongoDatabase mongoDatabase = mongoClient.getDatabase("pruebaMongo");
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("colores");
		
		FindIterable<Document> listaDocumentos = mongoCollection.find();
		List<Color> listaColores = new ArrayList<Color>();
		
		for(Document docu : listaDocumentos) {
			Color color = new Color();
			color.setCodigoColor(docu.getInteger("_id"));
			color.setCodigoHexadecimal(docu.getString("_Codigo Hexadecimal"));
			color.setNombre(docu.getString("Nombre"));
			listaColores.add(color);
		}
		
		for(Color color : listaColores) {
			System.out.println(color);
		}
		
	}	

}
