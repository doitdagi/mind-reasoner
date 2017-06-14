package io.mind.reasoner.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.mind.reasoner.app.utility.MomentTypes;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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
