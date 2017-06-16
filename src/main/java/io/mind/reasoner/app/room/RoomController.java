package io.mind.reasoner.app.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rooms/") 
public class RoomController {
  
	@Autowired
	private RoomService roomService;
	
	/*
	 * Get all rooms
	 * @param roomId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    public List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}
	
	
	/**
	 * Get room
	 * @param roomId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{roomId}")
    public Room getRoom(@PathVariable String roomId) {
		return roomService.getRoom(roomId);
	}
	 
	/**
	 * Add room
	 * @param room
	 */
	@RequestMapping(method=RequestMethod.POST)
   public void addRoom(@RequestBody Room room) {
		roomService.addRoom(room);
	}
	
	/**
	 * Delete room
	 * @param room
	 */
	@RequestMapping(method=RequestMethod.DELETE, value = "{roomId}")
	public void deleteRoom(@PathVariable String roomId) {
		roomService.removeRoom(roomId);
	}
	
	
	/**
	 * Update room
	 * @param room
	 */
	@RequestMapping(method=RequestMethod.PUT, value = "{roomId}")
	public void updateRoom(@RequestBody Room room) {
		roomService.updateRoom(room);
	}
	
	
	
	
	
	
	
	/**
	 * Get moment
	 * @param roomId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{roomId}/moment")
    public String currentMoment(@PathVariable String roomId) {
		return roomService.currentMoment(roomId);
	}
}