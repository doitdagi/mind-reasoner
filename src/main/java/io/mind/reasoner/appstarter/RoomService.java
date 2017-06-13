package io.mind.reasoner.appstarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.mind.reasoner.model.Room;

/**
 * Services in spring are singleton, (a single instance of this class will be
 * created when the application run)
 * 
 * @author dagi
 *
 */

@Service
public class RoomService {

	private List<Room> rooms = new ArrayList<Room>(Arrays.asList(new Room("room1"), new Room("room2")));


	public void addRoom(Room room) {
		rooms.add(room);
	}

	public List<Room> getAllRooms() {
		return rooms;
	}

	public void removeRoom(String roomID) {
		for (Room r : rooms) {
			if (r.getRoomID().equals(roomID)) {
				rooms.remove(r);
				return;
			}
		}
	}

	public Room getRoom(String roomID) {
		for (Room r : rooms) {
			if (r.getRoomID().equals(roomID)) {
				return r;
			}
		}
		return null;
	}

	public void updateRoom(String id, Room room) {
		for (Room r : rooms) {
			if (r.getRoomID().equals(id)) {
				rooms.set(rooms.indexOf(r), room);
				return ;
			}
		}
	}

	
	public String currentMoment(String roomId) {
		// TODO: GET ROOM BY ID, and Return room moment
		for (Room r : rooms) {
			if (r.getRoomID().equals(roomId)) {
				return r.getMoment().toString();
			}
		}
		return null;
	}

	
	
}
