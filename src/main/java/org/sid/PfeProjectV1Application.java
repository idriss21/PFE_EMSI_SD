package org.sid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sid.dao.OrdreRepository;
import org.sid.dao.SocieteRepository;
import org.sid.entities.Achat;
import org.sid.entities.Ordre;
import org.sid.entities.Societe;
import org.sid.entities.Vente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
<<<<<<< HEAD

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
=======
>>>>>>> 0af2fd25ca9c18b05bc05df8498bd97e7f246dd9

@SpringBootApplication
public class PfeProjectV1Application {

	private static OrdreRepository ordreRepository;
	
	public static void main(String[] args) {
<<<<<<< HEAD
		ApplicationContext context =   SpringApplication.run(PfeProjectV1Application.class, args);
		MongoClient client = (MongoClient) context.getBean("mongoClient");
		DB db = client.getDB("SDRDF_DB");
		db.createCollection("tab1", new BasicDBObject());
		/*DBCollection collection = db.getCollection("tab1");
		collection.insert(new BasicDBObject().append("title", "Systeme distribué de recolte des données bourciere"));*/
=======
		ApplicationContext context = SpringApplication.run(PfeProjectV1Application.class, args);

		SocieteRepository societeRepository = context.getBean(SocieteRepository.class);
		
		ordreRepository=context.getBean(OrdreRepository.class);

		

		try {
			Document doc = Jsoup
					.connect(
							"https://www.wafabourse.com/marches/actions/r;jsessionid=7C344089A451D157D9277E17DE3A95D5.2344FEAD2404B9EB24")
					.get();

			Elements trs = doc.getElementsByTag("tbody").get(0).getElementsByTag("tr");
			for (int i = 0; i < trs.size(); i++) {
				Element tr = trs.get(i);
				Elements tds = tr.getElementsByTag("td");
				for (int j = 0; j < tds.size(); j++) {
					Element td = tds.get(j);
					Elements a = td.getElementsByTag("a");
					if (a.size() != 0) {
						String code = a.get(0).attr("href").substring(15, 27);
						String nom = a.text();
						Societe societe = new Societe(code, nom, "");
						societeRepository.save(societe);
						getOrdre(societe);

					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private static void getOrdre(Societe societe) {

		//Ordres de type Achats
		List<Element> elements = new ArrayList<>();
		Document doc = null;
		String code=societe.getCode();
		try {
			doc = Jsoup.connect("https://www.wafabourse.com/trader/market/" + code + "/XCAS/ISIN").timeout(10000).get();

			if (doc.getElementsByTag("table").size() < 5)
				return;
			elements.add(doc.getElementsByTag("table").get(5));
			elements.add(doc.getElementsByTag("table").get(7));

			Element docOrdresAchat = elements.get(0); // Ordres d'achats
			Element docOrdesVente = elements.get(1); // Ordres de vente

			

			Element table = docOrdresAchat.getElementsByTag("table").get(1);
			Element tBody = table.getElementsByTag("tbody").get(0);
			Elements trs = tBody.getElementsByTag("tr");
			for (Element tr : trs) {
				Elements tds = tr.getElementsByTag("td");
				int nombre = 0, quantite = 0;
				double cours = 0;
				try {
					String s = "" + (char) 160;
					nombre = Integer.parseInt(tds.get(0).text().replaceAll(s, ""));
				} catch (NumberFormatException e) {
					nombre = -1;
					// e.printStackTrace();
				}
				try {
					String s = "" + (char) 160;
					quantite = Integer.parseInt(tds.get(1).text().replaceAll(s, ""));
				} catch (NumberFormatException e) {
					quantite = -1;
					// e.printStackTrace();
				}
				try {
					String s = "" + (char) 160;
					cours = Double.parseDouble(tds.get(2).text().replaceAll(s, "").replace(",", "."));
				} catch (NumberFormatException e) {
					cours = -1;
					// e.printStackTrace();
				}

				Ordre ordre =new Achat(nombre,quantite,cours,societe) ;
				ordreRepository.save(ordre);

			}
			//Ordres de type Vente
			table = docOrdesVente.getElementsByTag("table").get(1);
			tBody = table.getElementsByTag("tbody").get(0);
			trs = tBody.getElementsByTag("tr");
			for (Element tr : trs) {
				Elements tds = tr.getElementsByTag("td");
				int nombre = 0, quantite = 0;
				double cours = 0;
				try {
					String s = "" + (char) 160;
					nombre = Integer.parseInt(tds.get(2).text().replaceAll(s, ""));
				} catch (NumberFormatException e) {
					nombre = -1;
					// e.printStackTrace();
				}
				try {
					String s = "" + (char) 160;
					quantite = Integer.parseInt(tds.get(1).text().replaceAll(s, ""));
				} catch (NumberFormatException e) {
					quantite = -1;
					// e.printStackTrace();
				}
				try {
					String s = "" + (char) 160;
					cours = Double.parseDouble(tds.get(0).text().replaceAll(s, "").replace(",", "."));
				} catch (NumberFormatException e) {
					cours = -1;
					// e.printStackTrace();
				}

				
				Ordre ordre =new Vente(nombre,quantite,cours,societe) ;
				ordreRepository.save(ordre);
			}

		} catch (IOException e) {
			e.printStackTrace();

		}
>>>>>>> 0af2fd25ca9c18b05bc05df8498bd97e7f246dd9
	}
}

