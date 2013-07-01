package zmartonos.zlib.service;

/**
 * 
 * @author zootanka
 *
 */
interface ServiceInterface{
	//Controls
	public void stop();
	public boolean hasStarted();
	public boolean hasStopped();
	public boolean isSleeping();
	public boolean isRunning();
	public boolean hasCrashed();
	public void sleep();

	//Work
	public void work()throws Exception;
	
	//Setters/Getters
	public void setSleepInterval(int sleepInterval);
}
