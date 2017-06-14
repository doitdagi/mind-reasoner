package io.mind.reasoner.app.room;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.mind.reasoner.app.utility.MomentTypes;

@Entity
@Table(name = "room")
public class Room {


	@Id
	private String roomName;

	private String moment;

	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * By default room starts form default moment
	 * 
	 * @param roomID
	 *            Room ID
	 * 
	 */
	public Room(String roomName, String moment) {
		this.roomName = roomName;
		this.moment = MomentTypes.DEFAULT.toString();
	}

	public String getMoment() {
		return moment;
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
}