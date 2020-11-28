
import java.net.UnknownHostException;
import java.util.Date;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;


public class App {
  public static void main(String[] args) {

    try {

    MongoClient mongo = new MongoClient("localhost", 27017);


    DB db = mongo.getDB("testdb");

    DBCollection table = db.getCollection("user");

    BasicDBObject document = new BasicDBObject();
    document.put("name", "poli");
    document.put("age", 17);
    document.put("createdDate", new Date());
    table.insert(document);

    BasicDBObject searchQuery = new BasicDBObject();
    searchQuery.put("name", "poli");

    DBCursor cursor = table.find(searchQuery);

    while (cursor.hasNext()) {
        System.out.println(cursor.next());
    }

    BasicDBObject query = new BasicDBObject();
    query.put("name", "poli");

    BasicDBObject newDocument = new BasicDBObject();
    newDocument.put("name", "polip");

    BasicDBObject updateObj = new BasicDBObject();
    updateObj.put("$set", newDocument);

    table.update(query, updateObj);

    BasicDBObject searchQuery2 
        = new BasicDBObject().append("name", "polip");

    DBCursor cursor2 = table.find(searchQuery2);

    while (cursor2.hasNext()) {
        System.out.println(cursor2.next());
    }

    System.out.println("completo");

    } catch (UnknownHostException e) {
    e.printStackTrace();
    } catch (MongoException e) {
    e.printStackTrace();
    }

  }
}





{ "_id" : { "$oid" : "51398e6e30044a944cc23e2e"} , "name" : "poli" , "age" : 17 , "createdDate" : { "$date" : "2013-03-08T07:08:30.168Z"}}
{ "_id" : { "$oid" : "51398e6e30044a944cc23e2e"} , "age" : 17 , "createdDate" : { "$date" : "2013-03-08T07:08:30.168Z"} , "name" : "polip"}
completo