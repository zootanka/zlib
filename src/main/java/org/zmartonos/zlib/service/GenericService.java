package org.zmartonos.zlib.service;

public class GenericService implements Runnable{
	private int sleepInterval= 3000;
	private boolean hasStopped= false;

	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void setSleepInterval(final int sleepInterval){
		this.sleepInterval= sleepInterval;
	}
	
	public void stop(){
	}
	
	public boolean hasStopped(){
		return hasStopped;
	}
}
