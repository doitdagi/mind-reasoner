package io.mind.reasoner.app.device;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.utility.DeviceType;

@Entity
@Table(name = "device")
public class Device {
	@Id
	private String id;
	
	private String name;
	
	private String description;

	private DeviceType deviceType;

	@OneToMany
	private Room room;
	
	public Device() {
	}


	public Device(String id, String name, String description, DeviceType deviceType, Room room) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.room = room; 
		this.deviceType =deviceType;
	}

	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Room getRoom() {
		return room;
	}


	public void setRoom(Room room) {
		this.room = room;
	}


	public DeviceType getDeviceType() {
		return deviceType;
	}


	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	
	

}
	
