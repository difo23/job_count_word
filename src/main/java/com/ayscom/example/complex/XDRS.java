package com.ayscom.example.complex;

/**
 * Created by lramirez on 16/06/15.
 */

import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBObject;


public class XDRS implements Serializable {

    private ObjectId _id;
    private ObjectId idGroup;
    private Date start_time;
    private Date end_time;
    private String protocol;
    private Long MSISDN;
    private Long IMEI;
    private Long IMSI;
    private String xdr_crudo;
    private ObjectId id_user;
    private String name_user;
    //private String format= "yyyy/MM/dd HH:mm:ss";
    //27/04/2015 14:00:37
    private String format= "dd/MM/yyyy HH:mm:ss";

    public XDRS() {}

    public XDRS(  String start_time, String end_time, String protocol,
                  Long MSISDN, Long IMEI, Long IMSI, String xdr_crudo, String name_user) {

        this.start_time = setDate(start_time,format);
        this.end_time = setDate(end_time,format);
        this.protocol = protocol;
        this.MSISDN = MSISDN;
        this.IMEI = IMEI;
        this.IMSI = IMSI ;
        this.xdr_crudo = xdr_crudo;
        this.name_user = name_user;
    }



    public Date setDate(String date, String format){
        // SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date fecha = null;
        if(date!= null){
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);

            //String strFecha = "2001/07/04 14:00:37";
            String strFecha = date;


            try {
                fecha = formatoDelTexto.parse(strFecha);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }


        return fecha;

    }


    public ObjectId getId() { return this.id_user; }
    public void setId( ObjectId id_user ) { this.id_user = id_user; }
    public void generateId() { if( this.id_user == null ) this.id_user = new ObjectId(); }

    public ObjectId getIdUser() { return this._id; }
    public void setIdUser( ObjectId _id ) { this._id = _id; }
    public void generateIdUser() { if( this._id == null ) this._id = new ObjectId(); }

    public Long getMSISDN() { return this.MSISDN; }
    public void setMSISDN( Long MSISDN ) { this.MSISDN = MSISDN; }

    public String getProtocol() { return this.protocol; }
    public void setProtocol( String protocol ) { this.protocol = protocol; }

    public Long getIMEI() { return this.IMEI; }
    public void setIMEI( Long IMEI ) { this.IMEI = IMEI; }

    public Long getIMSI() { return this.IMSI; }
    public void setIMSI( Long IMSI ) { this.IMSI = IMSI; }

    public Date getStartTime() { return this.start_time; }
    public void setStartTime( Date start_time ) { this.start_time = start_time; }

    public Date getEndTime() { return this.end_time; }
    public void setEndTime( Date end_time ) { this.end_time = end_time; }

    public String getXDRCrudo() { return this.xdr_crudo; }
    public void setXDRCrudo( String xdr_crudo ) { this.xdr_crudo = xdr_crudo; }

    public String getNameUser() { return this.name_user; }
    public void setNameUser( String name_user ) { this.name_user = name_user; }


    public ObjectId getIdGroup() { return this.idGroup; }
    public void setIdGroup( ObjectId idGroup ) { this.idGroup = idGroup; }
    public void generateIdGroup() { if( this.idGroup == null ) this.idGroup = new ObjectId(); }

    public Document bsonFromPojo()
    {
       /* Document document = new Document();
        document.put( "_id",    this._id );
        document.put( "MSISDN", this.MSISDN );
        document.put( "protocol", this.protocol );
        document.put( "IMEI",   this.IMEI );
        document.put( "IMSI",  this.IMSI );
        document.put( "start_time",  this.start_time );
        document.put( "end_time",  this.end_time );
        document.put( "xdr_crudo",  this.xdr_crudo );
        document.put( "idGroup",  this.idGroup );
        */

        Document document = new Document("_id",    this._id)
                .append("MSISDN", this.MSISDN)
                .append("IMEI", this.IMEI)
                .append("IMSI", this.IMSI)
                .append("Protocol", this.protocol)
                .append("Start Time", this.start_time)
                .append("End Time", this.end_time)
                .append("xdr_crudo", this.xdr_crudo)
                .append( "idGroup",  this.idGroup )
                .append("info_user", new Document("id_user",  this.id_user).append("name_user",  this.name_user) );
        return document;
    }

    public void makePojoFromBson( Document bson )
    {
        Document b =  bson;
        this._id    = ( ObjectId ) b.get( "_id" );
        this.MSISDN   = (Long  )  b.get( "MSISDN" );
        this.protocol = ( String )   b.get( "Protocol" );
        this.IMEI   = ( Long )   b.get( "IMEI" );
        this.IMSI  = ( Long )   b.get( "IMSI" );
        //this.start_time = ( Date )   b.get( "start_time" );
        //this.end_time  = ( Date )   b.get( "end_time" );
        this.start_time = setDate( ( String ) b.get( "Start Time" ),format);
        this.end_time  =   setDate( ( String ) b.get( "End Time" ),format);
        //this.xdr_crudo  = ( String )   b.get( "xdr_crudo" );
        this.xdr_crudo  =   b.toString();
        this.id_user    = ( ObjectId ) b.get( "user" );
        this.name_user   = ( String )   b.get( "name" );
        this.idGroup  = (ObjectId) b.get( "idGroup" );
    }


    public Document bsonFromPojoArray(XDRS xdrs[] )
    {

        int cont=0;
        if(xdrs== null) {
            Document document = new Document("Protocol", "Probleas arreglo null");
            return document;
        }
        XDRS xdr1= new XDRS();
        xdr1.generateId();
        ObjectId _id= xdr1.getId();//xdrs[0]._id;
        ObjectId idGroup= xdrs[1].getIdGroup();
        // Date start_time= xdrs[0].start_time;
        //Date end_time= xdrs[0].end_time;
        //String protocol= xdrs[0].protocol;
        Long MSISDN= xdrs[1].getMSISDN();
        Long IMEI= xdrs[1].getIMEI();
        Long IMSI= xdrs[1].getIMSI();
        String xdr_crudo= "";
        ObjectId id_user= xdrs[1].getIdUser();
        String name_user= xdrs[1].getNameUser();

     while(xdrs.length>cont) {
         if (xdrs[cont] != null){
            xdr_crudo= xdr_crudo.concat(xdrs[cont].getXDRCrudo());
             cont++;
        }
        xdr_crudo.concat("Xdrs crudos estan siendo enviados nulos!");

     }

        Document document = new Document("_id", _id)
                .append("MSISDN", MSISDN)
                .append("IMEI", IMEI)
                .append("IMSI", IMSI)
                //.append("Protocol", protocol)
                //.append("Start Time", start_time)
                //.append("End Time", end_time)
                .append("xdr_crudo", xdr_crudo)
                .append("idGroup", idGroup)
                .append("info_user", new Document("id_user", id_user).append("name_user", name_user));

         return document;
    }



    public void makePojoFromBson2( Document bson )
    {
        Document b =  bson;
        this._id    = ( ObjectId ) b.get( "_id" );
        this.MSISDN   = (Long  )  b.get( "MSISDN" );
        this.protocol = ( String )   b.get( "Protocol" );
        this.IMEI   = ( Long )   b.get( "IMEI" );
        this.IMSI  = ( Long )   b.get( "IMSI" );
        //this.start_time = ( Date )   b.get( "start_time" );
        //this.end_time  = ( Date )   b.get( "end_time" );
        this.start_time = ( Date )  b.get( "Start Time" );
        this.end_time  =   ( Date ) b.get( "End Time" );
        this.xdr_crudo  = ( String )   b.get( "xdr_crudo" );
        //this.xdr_crudo  =   b.toString();
        this.id_user    = ( ObjectId ) b.get( "user" );
        this.name_user   = ( String )   b.get( "name" );
        this.idGroup  = (ObjectId) b.get( "idGroup" );
    }



}
