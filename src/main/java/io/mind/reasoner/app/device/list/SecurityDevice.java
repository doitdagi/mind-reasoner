package io.mind.reasoner.app.device.list;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.DeviceType;
import io.mind.reasoner.app.utility.SecurityLevel;


@Entity
@Table(name = "securitydevice")
public class SecurityDevice extends Device {

	private SecurityLevel level;
	
	{
		level = SecurityLevel.UNDETERMINED;
	}
	
	public SecurityDevice() {
	}

	public SecurityDevice(Device device) {
		super(device);
	}

	public SecurityDevice(String id, String name, String description, DeviceType deviceType, Room room) {
		super(id, name, description, deviceType, room);
	}

	public SecurityLevel getLevel() {
		return level;
	}

	public void setLevel(SecurityLevel level) {
		this.level = level;
	}
	

}
