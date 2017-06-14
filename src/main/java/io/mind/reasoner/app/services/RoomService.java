package io.mind.reasoner.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mind.reasoner.app.dao.RoomDao;
import io.mind.reasoner.app.model.Room;

/**
 * Services in spring are singleton, (a single instance of this class will be
 * created when the application run)
 * 
 * @author dagi
 *
 */

@Service    
//@ComponentScan(basePackages = {"io.mind.reasoner.dao"})
public class RoomService {

 	@Autowired
	private RoomDao roomDAO;
	

	public void addRoom(Room room) {
		roomDAO.save(room);
	}

	public List<Room> getAllRooms() {
		 //java 8 way of converting iterable to list
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

	
	public String currentMoment(String roomName) {
		// TODO: GET ROOM BY ID, and Return room moment
		for (Room r : getAllRooms()) {
			if (r.getRoomName().equals(roomName)) {
				return r.getMoment().toString();
			}
		}
		return null;
	}
}
