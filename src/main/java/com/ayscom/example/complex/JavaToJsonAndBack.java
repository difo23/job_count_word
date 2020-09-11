package com.ayscom.example.complex;

/**
 * Created by lramirez on 15/06/15.
 */

public class JavaToJsonAndBack {

    public static void main(String[] args) {

        XDRS[] xdrs;
        MongoComplexArrays complex = new MongoComplexArrays();

        xdrs= complex.setup();
        xdrs[8].generateId();
        xdrs[8].generateIdGroup();
        xdrs[8].generateIdUser();
        xdrs[8].setNameUser("Ruben");

        System.out.println(xdrs[8].getId());
        System.out.println(xdrs[8].getIdUser());
        System.out.println(xdrs[8].getNameUser());
        System.out.println(xdrs[8].getMSISDN());
        System.out.println(xdrs[8].getIMSI());
        System.out.println(xdrs[8].getIMEI());
        System.out.println(xdrs[8].getProtocol());
        System.out.println(xdrs[8].getStartTime());
        System.out.println(xdrs[8].getEndTime());
        System.out.println(xdrs[8].getXDRCrudo());
        System.out.println(xdrs[8].bsonFromPojo().toJson());

        /*
        XDRS xdr= new XDRS();
        xdr.makePojoFromBson2(xdrs[8].bsonFromPojo());
        System.out.println(xdr.getId());
        System.out.println(xdr.getIdUser());
        System.out.println(xdr.getNameUser());
        System.out.println(xdr.getMSISDN());
        System.out.println(xdr.getIMSI());
        System.out.println(xdr.getIMEI());
        System.out.println(xdr.getProtocol());
        System.out.println(xdr.getStartTime());
        System.out.println(xdr.getEndTime());
        System.out.println(xdr.getXDRCrudo());
        System.out.println(xdr.bsonFromPojo().toJson());
*/
       /* Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
       */

/*
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String strFecha = "2001/07/04 14:00:37";
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.out.println(fecha.toString());

        String xdrs = new String();
        String xdrs_json = new String();
        String doc1 = new String();
        String doc2 = new String();

        //xdrs="[{info: {user: 1234567890, name: Ruben }},{xdrs : [ { _id: 5565b4ece0f687668b056d73, Protocol: ISUP.Call, End Time: 27/04/2015 14:00:56, Start Time: 27/04/2015 14:00:37, idgroup: 5565b573de42a0251f000001 }, { _id: 5565b4ece0f687668b056d74, Protocol: ISUP.Call, End Time: 27/04/2015 14:00:56, Start Time: 27/04/2015 14:00:37, idgroup: 5565b573de42a0251f000001 }, { _id: 5565b4ece0f687668b056d75, Protocol: ISUP.Call, End Time: 27/04/2015 13:43:59, Start Time: 27/04/2015 13:43:38, idgroup: 5565b573bf3d54531f000001 }, { _id: 5565b4ece0f687668b056d76, Protocol: ISUP.Call, End Time: 27/04/2015 13:42:43, Start Time: 27/04/2015 13:42:42, idgroup: 5565b5749b5d8b751f000001 }, { _id: 5565b4ece0f687668b056d77, Protocol: ISUP.Call, End Time: 27/04/2015 13:42:05, Start Time: 27/04/2015 13:41:38, idgroup: 5565b574dbc55f711f000001 }, { _id: 5565b4ece0f687668b056d78, Protocol: ISUP.Call, End Time: 27/04/2015 13:36:25, Start Time: 27/04/2015 13:35:45, idgroup: 5565b573d14ca63e1f000001 }]}] ";
        doc1="{user: 1234567890, name: Ruben }";
        doc2="{ _id: 5565b4ece0f687668b056d73, Protocol: ISUP.Call, End Time: 27/04/2015 14:00:56, Start Time: 27/04/2015 14:00:37, idgroup: 5565b573de42a0251f000001 }";
        String doc3= "{ _id: 5565b4ece0f687668b056d74, Protocol: ISUP.Call, End Time: 27/04/2015 14:00:56, Start Time: 27/04/2015 14:00:37, idgroup: 5565b573de42a0251f000001 }";
        String doc4 = "{ _id: 5565b4ece0f687668b056d75, Protocol: ISUP.Call, End Time: 27/04/2015 13:43:59, Start Time: 27/04/2015 13:43:38, idgroup: 5565b573bf3d54531f000001 }";
        String doc5= "{ _id: 5565b4ece0f687668b056d76, Protocol: ISUP.Call, End Time: 27/04/2015 13:42:43, Start Time: 27/04/2015 13:42:42, idgroup: 5565b5749b5d8b751f000001 }";
        //{ _id: 5565b4ece0f687668b056d77, Protocol: ISUP.Call, End Time: 27/04/2015 13:42:05, Start Time: 27/04/2015 13:41:38, idgroup: 5565b574dbc55f711f000001 }, { _id: 5565b4ece0f687668b056d78, Protocol: ISUP.Call, End Time: 27/04/2015 13:36:25, Start Time: 27/04/2015 13:35:45, idgroup: 5565b573d14ca63e1f000001 }]";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        xdrs_json = gson.toJson(doc2);
        Document document = new Document("info",   doc1)
                .append("xdrs", new Document("xdr1", doc2).append("xdr2",doc3).append("xdr3",doc4).append("xdr4",doc5));

        //Document document2 =new Document("XDRS User",   xdrs_json);
        String[] xdrs_array = document.get("xdrs").toString().split("");
        Document documt= (Document) document.get("xdrs");
        //Document documt2= (Document) documt.get("xdr1");
        System.out.println(  ( documt.get("xdr1")).toString());
        //System.out.println( document);
       // System.out.println(document2.get("info").toString());

        MongoClient client //= new MongoClient();
        MongoDatabase database //= client.getDatabase("mydb");
        MongoCollection<Document> collection //= database.getCollection("mycoll");

        String ip = "localhost";
        int port = 27017;
        String namedb= "test";

        client =  new MongoClient( ip , port );
        database = client.getDatabase(namedb);
        collection = database.getCollection("xdrs_crudos_reducida");


        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
              System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        Document myDoc = collection.find().first();
        int length= (int)collection.count();
        System.out.println(length);
        System.out.println(myDoc.get("_id"));


*/
    }
}
