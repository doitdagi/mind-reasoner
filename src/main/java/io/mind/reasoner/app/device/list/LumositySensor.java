package io.mind.reasoner.app.device.list;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.DeviceType;
import io.mind.reasoner.app.utility.LumosityLevel;
@Entity
@Table(name = "lumositysensor")
public class LumositySensor extends Device {
	
	private LumosityLevel level;
	
	{
		level = LumosityLevel.UNDETERMINED;
	}

	public LumositySensor() {
		super();
	}
	
	public LumositySensor(String id, String name, String description, DeviceType deviceType,
			Room room) {
		super(id, name, description, deviceType, room);
	}

	public LumositySensor(Device device) {
		super(device);
	}

	public LumosityLevel getLevel() {
		return level;
	}

	public void setLevel(LumosityLevel level) {
		this.level = level;
	}
	
}
