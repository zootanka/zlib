package zmartonos.zlib.service;

import zmartonos.zlib.utils.Utils;

/**
 * 
 * @author zootanka
 *
 */
public class GenericService implements ServiceInterface, Runnable {
	private boolean halted= false;
	private boolean started= false;
	private boolean stopped= false;
	private boolean running= false;
	private boolean sleeping= false;
	private boolean crashed= false;
	
	private int sleepInterval= 0;

	final public void stop() {
		halted= true;
	}

	final public boolean hasStarted() {
		return started;
	}

	final public boolean hasStopped() {
		return stopped;
	}

	final public boolean isSleeping() {
		return sleeping;
	}
	
	final public boolean isRunning(){
		return started && running;
	}
	
	final public boolean hasCrashed(){
		return crashed;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		started= true;
		running= true;
		try{
			while(!halted){
				work();
				sleep();
			}
		}
		catch (Exception e){
			crashed= true;
		}
		finally{
			//System.exit(0);
			running= false;
			stopped= true;
		}
	}
	
	final public void sleep(){
		if (sleepInterval>0)
			Utils.sleep(sleepInterval);
	}
	
	public void work() throws Exception{
		// TODO Auto-generated method stub		
	}
	
	final public void setSleepInterval(int sleepInterval){
		this.sleepInterval= sleepInterval;
	}
	
	final public String getFlagInfo(){
		return String.format("Started: %s Running: %s Sleeping: %s Halted: %s Stopped: %s", 
				started, running, sleeping, halted, stopped);
	}

}
