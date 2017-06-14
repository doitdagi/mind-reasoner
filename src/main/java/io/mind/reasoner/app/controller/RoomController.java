package io.mind.reasoner.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mind.reasoner.app.model.Room;
import io.mind.reasoner.app.services.RoomService;

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
	@RequestMapping(method = RequestMethod.GET, value = "{roomName}")
    public Room getRoom(@PathVariable String roomName) {
		return roomService.getRoom(roomName);
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
	@RequestMapping(method=RequestMethod.DELETE, value = "{roomName}")
	public void deleteRoom(@PathVariable String roomName) {
		roomService.removeRoom(roomName);
	}
	
	
	/**
	 * Update room
	 * @param room
	 */
	@RequestMapping(method=RequestMethod.PUT, value = "{roomName}")
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