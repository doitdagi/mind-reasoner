package io.mind.reasoner.app.device.list;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.utility.PresenceStates;
import io.mind.reasoner.app.utility.SecurityLevel;

@Entity
@Table(name="PresenceSensor")
@Where(clause = "DTYPE = 'PresenceSensor'")

public class PresenceSensor extends Device {

	private PresenceStates currentState;
	
	private SecurityLevel level;
	
	{
		currentState = PresenceStates.UNDETERMINED;
	}
	
	public PresenceSensor() {
		super();
	}
	
	public PresenceSensor(Device device){
		super(device);
	//	currentState = ranodmState();
	}

	public PresenceStates getCurrentState() {
		//currentState = ranodmState();
		return currentState;
	}

	public void setCurrentState(PresenceStates currentState) {
		this.currentState = currentState;
	}
	
	
//	private PresenceStates ranodmState() { 
//		List<PresenceStates> states = new ArrayList<PresenceStates>((Arrays.asList(PresenceStates.values())));
//		return states.get(ThreadLocalRandom.current().nextInt(0, states.size() ));
//	}
	
}
