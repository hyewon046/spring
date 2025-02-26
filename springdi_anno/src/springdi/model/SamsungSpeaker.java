package springdi.model;

import org.springframework.stereotype.Component;

@Component("samsungspeaker")
public class SamsungSpeaker implements Speaker{
	
	@Override
	public void printName() {
		System.out.println("»ï¼Û ½ºÇÇÄ¿!");
	}

}
