package io.mind.reasoner.app.device.list;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.DeviceType;
import io.mind.reasoner.app.utility.RollerShutterStatus;
@Entity
@Table(name = "rollershutter")
public class RollerShutter extends Device {

	private RollerShutterStatus status;
	
	{
		status = RollerShutterStatus.OPEN;
	}
	
	public RollerShutter() {
		super();
	}
	
	public RollerShutter(Device device){
		super(device);
	}
	
	public RollerShutter(String id, String name, String description, DeviceType deviceType, Room room) {
		super(id, name, description, deviceType, room);
	}


	public RollerShutterStatus getStatus() {
		return status;
	}


	public void setStatus(RollerShutterStatus status) {
		this.status = status;
	}
}
