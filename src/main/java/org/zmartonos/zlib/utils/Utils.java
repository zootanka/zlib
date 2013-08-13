package org.zmartonos.zlib.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * @author zootanka
 *
 */
public class Utils {
	/**
	 * 
	 * @return
	 */
	public static String getPublicIp() {
		String ip= "";
		BufferedReader in = null;
		try{
			URL whatismyip = new URL("http://checkip.amazonaws.com");
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            ip = in.readLine();
        }
		catch(Exception e){
			e.printStackTrace();
		} finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
		return ip;
    }
	
	public static void sleep(final int sleepInterval){
		try {
			Thread.sleep(sleepInterval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		System.out.println(Utils.getPublicIp());
	}
}
