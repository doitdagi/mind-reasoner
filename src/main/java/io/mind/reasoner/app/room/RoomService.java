package io.mind.reasoner.app.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Services in spring are singleton, (a single instance of this class will be
 * created when the application run)
 * 
 * @author dagi
 *
 */

@Service    
public class RoomService {

 	@Autowired
	private RoomRepository roomDAO;
	

	public void addRoom(Room room) {
		roomDAO.save(room);
	}

	public List<Room> getAllRooms() {
		return (List<Room>) roomDAO.findAll();
	}

	public void removeRoom(String roomID) {
		roomDAO.delete(roomID);
	}

	public Room getRoom(String roomID) {
	return roomDAO.findOne(roomID);
	}  
		

	public void updateRoom( Room room) {
		roomDAO.save(room);
	}

	
	public String currentMoment(String roomId) {
		// TODO: GET ROOM BY ID, and Return room moment
		for (Room r : getAllRooms()) {
			if (r.getRoomId().equals(roomId)) {
				return r.getCurrentMoment().toString();
			}
		}
		return null;
	}
}
