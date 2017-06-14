package io.mind.reasoner.model;

import io.mind.reasoner.utility.MomentTypes;

public class Room {
	
	private String roomID;
	
	private String moment;
 
	public Room() {
	}
	
	/**
	 * @param roomID
	 * 			Room ID
	 */
	public Room(String roomID) {
		this.roomID = roomID;
	}

	
	public String getMoment() {
		return MomentTypes.DEFAULT.toString();
	}

	public void setMoment(String moment) {
		this.moment = moment;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	
}
