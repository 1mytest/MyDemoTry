package com.eleks.demo.core.web;

import org.openqa.selenium.TimeoutException;

public class Wait<T extends Component<T>> {

	private static final int Default_Timeout = 30000;
	private static final int Default_Retry_Delay = 500;
	private T component;
	
	public Wait(){
		
	}
	public Wait<T> forComponent(T component){
		this.component = component;
		return this;
	}
	
	public T toBeAvailable(){
		int timePassed = 0;
		while (timePassed < Default_Timeout){
			if (this.component.isAvailable()){
				return this.component;
			}
			timePassed = timePassed + delay();
		}
		if (!this.component.isAvailable()){
			throw new TimeoutException("Time out after " + Default_Timeout + "ms. waiting for "+this.component.getClass().getSimpleName());
		}
		return this.component;
	}
	
	private int delay(){
		try {
			Thread.sleep(Default_Retry_Delay);
			return Default_Retry_Delay;
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
