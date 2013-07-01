package zmartonos.zlib.service;

import java.net.Inet4Address;

import zmartonos.zlib.utils.Utils;

/**
 * 
 * @author zootanka
 * 
 */
public class SimpleService extends GenericService {
	
	public SimpleService(){
	}

	public void work() throws Exception {
		System.out.println(SimpleService.class.getName() + " running ..."+getFlagInfo());
		System.out.println("Public ip: "+Utils.getPublicIp());
	}
}
