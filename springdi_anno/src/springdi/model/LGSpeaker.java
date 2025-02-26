package springdi.model;

import org.springframework.stereotype.Component;

@Component("lgspeaker")
public class LGSpeaker implements Speaker{
	
	@Override
	public void printName() {
		System.out.println("¿¤Áã ½ºÇÇÄ¿!");
	}

}
