package io.mind.reasoner.app.device;

import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.DeviceType;
import io.mind.reasoner.app.utility.SensorType;

public class Temperature  extends Sensor{

	public Temperature(String id, String name, String description, DeviceType deviceType, SensorType sensorType,
			Room room) {
		super(id, name, description, deviceType, sensorType, room);
	}

}
