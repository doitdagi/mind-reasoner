package io.mind.reasoner.app.device;

import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.DeviceType;
import io.mind.reasoner.app.utility.SensorType;

public class Sensor extends Device {
	
	private SensorType sensorType;
	
	public Sensor(String id, String name, String description, DeviceType deviceType,SensorType sensorType, Room room) {
		super(id, name, description, deviceType, room);
		this.sensorType = sensorType;
	}

	public SensorType getSensorType() {
		return sensorType;
	}

	public void setSensorType(SensorType sensorType) {
		this.sensorType = sensorType;
	}

}
