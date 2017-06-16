package io.mind.reasoner.app.device.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.utility.PresenceStates;

@Entity
@Table(name="PresenceSensor")
public class PresenceSensor extends Device {

	private PresenceStates currentState;
	
	public PresenceSensor() {
		super();
	}
	
	public PresenceSensor(Device device){
		super(device);
		currentState = ranodmState();
	}

	public PresenceStates getCurrentState() {
		currentState = ranodmState();
		return currentState;
	}

	public void setCurrentState(PresenceStates currentState) {
		this.currentState = currentState;
	}
	
	
	private PresenceStates ranodmState() { 
		List<PresenceStates> states = new ArrayList<PresenceStates>((Arrays.asList(PresenceStates.values())));
		return states.get(ThreadLocalRandom.current().nextInt(0, states.size() ));
	}
	
}
