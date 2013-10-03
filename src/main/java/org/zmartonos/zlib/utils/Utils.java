package org.zmartonos.zlib.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author zootanka
 *
 */
public class Utils {
	public static final String htmlCache= "/var/htmlcache/";
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
	
	public static void writeContentToFile(final String content, final String filePath) throws IOException{
		File file= new File(filePath);
		if(!file.getParentFile().exists())
			file.getParentFile().mkdirs();

		file.createNewFile();
		Path path= file.toPath();
		
		Files.write(path, content.getBytes());
	}
	
	public static boolean fileExists(final String path){
		File file = new File(path);	
		return file.exists();
	}
	
	public static String getFileContent(final String filePath) throws IOException{
		return new String(Files.readAllBytes(new File(filePath).toPath()));
	}

	public static String getMd5Hash(final String string){
		return DigestUtils.md5Hex(string);
	}
	
	public static String getUrlContent(String url){
		String content= "";	
		BufferedReader in = null;
		try{
			URL whatismyip = new URL(url);
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String line;
            while((line=in.readLine())!=null)
            	content += line;
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
		return content;
	}
	
	public static void sleep(final long sleepInterval){
		try {
			Thread.sleep(sleepInterval);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static String getCachedUrlContent(final String url) throws IOException{
		String content= "";
		String cacheLink= htmlCache+Utils.getMd5Hash(url);
		if(Utils.fileExists(cacheLink))
			content= Utils.getFileContent(cacheLink);
		else{
			content= Utils.getUrlContent(url);
			Utils.writeContentToFile(content, cacheLink);
		}
		return content;
	}

	public static void main(String[] args){
		System.out.println(Utils.getPublicIp());
	}
}
