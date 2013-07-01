package zmartonos.zlib.service;

import org.testng.annotations.Test;

import zmartonos.zlib.utils.Utils;

/**
 * 
 * @author zootanka
 *
 */
public class AbstractServiceTest {

	@Test
	public void hasStopped() {
		SimpleService service= new SimpleService();
		service.setSleepInterval(2000);
		Thread runner= new Thread(service);
		
		runner.start();
		while (!service.hasStarted());
		while (service.isRunning()){
			service.stop();
			while (!service.hasStopped()){
				System.out.println("waiting for service to finish: "+service.getFlagInfo());
				Utils.sleep(3000);
			}
		}
	}

	@Test
	public void isSleeping() {
	}

	@Test
	public void isStarted() {
	}

	@Test
	public void run() {
	}

	@Test
	public void stop() {
	}
}
