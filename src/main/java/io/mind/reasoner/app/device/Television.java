package io.mind.reasoner.app.device;

import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.ActuatorType;
import io.mind.reasoner.app.utility.DeviceType;

public class Television extends Actuator {

	public Television(String id, String name, String description, DeviceType deviceType, ActuatorType actuatorType,
			Room room) {
		super(id, name, description, deviceType, actuatorType, room);
	}

}
