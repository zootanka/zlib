package org.zmartonos.zlib.db;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDb {
	private final String host;
	private final int port;
	private final String user;
	private final String pass;
	private String dbName;
	
	private MongoClient client;
	private DB db;
	
	/**
	 * 
	 * @param host
	 * @param port
	 * @param user
	 * @param pass
	 * @param dbName
	 */
	public MongoDb(String host, int port, String user,String pass,String dbName ) {
		super();
		this.host = host;
		this.port = port;
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
	}
	
	public void connect() throws UnknownHostException{
		client= new MongoClient(host,port);
		db= client.getDB(dbName);
	}
	
	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
	
	public DB getDb(){
		return db;
	}
}
