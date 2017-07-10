package io.mind.reasoner.app.room;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.utility.DeviceType;
import io.mind.reasoner.app.utility.MomentType;

@Entity
@Table(name = "room")
public class Room {

	@Id
	private String roomId;
	
	private String roomName;

	private String roomDescription;

	private MomentType currentMoment;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<Device> devices;
	
	
	{
		this.currentMoment = MomentType.UNKNOWN;
	}

	public Room() {
	}

	/**
	 * By default room starts form default moment
	 * 
	 * @param roomID
	 *            Room ID
	 * 
	 */
	public Room(String roomId, String roomName,String roomDescription) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}



	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public MomentType getCurrentMoment() {
		return currentMoment;
	}

	public void setCurrentMoment(MomentType currentMoment) {
		this.currentMoment = currentMoment;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", roomDescription=" + roomDescription
				+ ", currentMoment=" + currentMoment + ", devices=" + devices + "]";
	}
	
	
	public Device getDeviceByType(DeviceType devType) {
		for(Device device : devices) {
			if(device.getDeviceType().equals(devType))
				return device;
		}
		return null;
	}
	
	
}
