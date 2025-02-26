package springdi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//bean���� id="tv"�� �� �������� �ʾƵ� ��
@Component("tv")
public class TV {
	
	//�ڵ�����
	@Autowired
	//�Ｚ����Ŀ�γ־���
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
		System.out.println("TV��ü ������!");
	}

}
