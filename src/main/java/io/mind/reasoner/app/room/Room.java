package io.mind.reasoner.app.room;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.utility.MomentTypes;
import io.mind.reasoner.app.utility.SecurityLevel;

@Entity
@Table(name = "room")
public class Room {

	@Id
	private String roomName;

	private MomentTypes moment;

	private String description;

	private SecurityLevel securityLevel;

	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private List<Device> devices;

	public Room() {
	}

	/**
	 * By default room starts form default moment
	 * 
	 * @param roomID
	 *            Room ID
	 * 
	 */
	public Room(String roomName, MomentTypes moment, SecurityLevel securityLevel) {
		this.roomName = roomName;
		this.moment = moment;
		this.securityLevel = securityLevel;
	}

	public MomentTypes getMoment() {
		return moment;
	}

	public void setMoment(MomentTypes moment) {
		this.moment = moment;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SecurityLevel getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(SecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

}
