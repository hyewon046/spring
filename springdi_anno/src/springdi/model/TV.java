package springdi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//bean에서 id="tv"로 또 정의하지 않아도 됨
@Component("tv")
public class TV {
	
	//자동주입
	@Autowired
	//삼성스피커로넣어줘
	//@Qualifier("samsungspeaker")
	@Qualifier("lgspeaker")
	private Speaker speaker;
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public TV() {
		System.out.println("TV객체 생성됨!");
	}

}
