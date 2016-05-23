package com.adam.spring.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private String id;
	private String speech;
	@Override
	public String toString() {
		return "Robot [id=" + id + ", speech=" + speech + "]";
	}

	
	
	public void speak(){
		System.out.println(id + ": " + speech);
	}

	@Autowired
	public void setId(@Value("${jdbc.user}") String id) {
		this.id = id;
	}

	@Autowired
	public void setSpeech(@Value("${jdbc.password}") String speech) {
		this.speech = speech;
	}

	
}
