package lsd.common.util;

import java.util.UUID;

public class UuidGenerater {
	public static String createUuid(String module){
		return module+createUuid();
	}
	
	public static String createUuid(){
		return UUID.randomUUID().toString().replace("-","");
	}
	
}
