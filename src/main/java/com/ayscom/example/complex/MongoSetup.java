package com.ayscom.example.complex;

/**
 * Created by lramirez on 17/06/15.
 */

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

//import com.mongodb.DB;
//import com.mongodb.DBCollection;
//import com.mongodb.Mongo;

public class MongoSetup {

    //Mongo  mongo = null;
    MongoClient  mongoclient = null;

    //DB  database = null;
    MongoDatabase  database = null;

    String databaseName;

    String ip;
    int port;


    public void Close(){
        this.mongoclient.close();
    }

    public MongoSetup(String ip, int port)
    {
        this.ip=ip;
        this.port=port;
        setup();
    }

    public MongoSetup( String ip, int port, String database )
    {
        this.ip=ip;
        this.port=port;
        setup();
        this.databaseName = database;
    }

    private void setup()
    {

        try
        {
            mongoclient = new  MongoClient( ip, port );
        }
        catch( Exception e )
        {
            System.out.println("AQiiiii!" );
        }
    }


    public String getDatabaseName() { return this.databaseName; }

    public void setDatabaseName( String databaseName ) { this.databaseName = databaseName; }

    public MongoDatabase getDatabase() { return this.database; }

    public MongoCollection getCollection( String collection )
    {
        return this.getCollection( this.databaseName, collection );
    }

    public MongoCollection getCollection( String database, String collection )
    {
        this.database = mongoclient.getDatabase( database );
        return this.database.getCollection( collection );
    }

}
