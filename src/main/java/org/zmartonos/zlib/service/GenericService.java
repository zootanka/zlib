package org.zmartonos.zlib.service;

import org.zmartonos.zlib.utils.Utils;

public class GenericService implements Runnable{
	private int sleepInterval= 3000;
	private boolean hasStopped= false;
	private boolean running= false;
	private boolean shutDown= false;

	public void run() {
		running= true;
		while(!shutDown){
			try {
				work();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Utils.sleep(sleepInterval);
		}
	}
	
	public void work()throws Exception{
	}

	public void setSleepInterval(final int sleepInterval){
		this.sleepInterval= sleepInterval;
	}
	
	public void stop(){
		shutDown= true;
	}
	
	public boolean hasStopped(){
		return hasStopped;
	}
	
	public boolean isRunning(){
		return running;
	}
}
