package com.ayscom.example.complex;

/**
 * Created by lramirez on 17/06/15.
 */

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

//import com.mongodb.DBCollection;


public class MongoComplexArrays {

    private static MongoSetup   mongo      = new MongoSetup( "localhost", 27017, "test" );
    //private static DBCollection collection = null;
    private static MongoCollection collection = null;
    //public XDRS[] xdrs;

    //Constructor
    public MongoComplexArrays() {}

    // Limpia el collection con el nombre indicado. Borra todos los datos
    public static void cleanup(String collectionname ){
        // refresh the collection each time...
        collection = mongo.getCollection( collectionname );
        collection.drop();
        collection = mongo.getCollection( collectionname );
    }


  public XDRS[] setup(){

        collection =mongo.getCollection("test","xdrs_crudos_reducida");
        int length = (int)collection.count();
        XDRS[] xdrs;
        xdrs=new XDRS[length];
        int cont = 0;
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                if(cont< length) {

                    XDRS xdr= new XDRS();
                    xdr.makePojoFromBson(cursor.next());
                    xdrs[cont]= xdr;
                   // System.out.println(cursor.next().toJson());
                    cont++;

                }
            }
        } finally {
            cursor.close();
        }

        return xdrs;
    }


}
