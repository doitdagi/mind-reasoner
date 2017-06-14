package io.mind.reasoner.app.device;

import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.ActuatorType;
import io.mind.reasoner.app.utility.DeviceType;

public class Actuator extends Device {
	
	private ActuatorType actuatorType;
	
	public Actuator(String id, String name, String description, DeviceType deviceType,ActuatorType actuatorType, Room room) {
		super(id, name, description, deviceType, room);
		this.actuatorType = actuatorType;
	}

	public ActuatorType getActuatorType() {
		return actuatorType;
	}

	public void setActuatorType(ActuatorType actuatorType) {
		this.actuatorType = actuatorType;
	}

}
