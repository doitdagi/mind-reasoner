package io.mind.reasoner.app.device.list;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.DeviceType;
import io.mind.reasoner.app.utility.TVStatus;

@Entity
@Table(name = "television")
public class Television extends Device {

	private TVStatus status;
	
	{
		status = TVStatus.UNDETERMINED;
	}

	public Television() {
	}

	public Television(Device device) {
		super(device);
	}

	public Television(String id, String name, String description, DeviceType deviceType, Room room) {
		super(id, name, description, deviceType, room);
	}

	public TVStatus getStatus() {
		return status;
	}

	public void setStatus(TVStatus status) {
		this.status = status;
	}

}
