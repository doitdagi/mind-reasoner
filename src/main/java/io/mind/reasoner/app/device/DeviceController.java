package io.mind.reasoner.app.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mind.reasoner.app.room.Room;
import io.mind.reasoner.app.room.RoomService;

@RestController
@RequestMapping("rooms/") 
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private RoomService roomService;
	
	
	/**
	 * Get all devices from the all the rooms
	 */
	@RequestMapping(method = RequestMethod.GET, value = "devices")
	public List<Device> getAllDevices() {
		return deviceService.getAllDevices();
	}
	
	/**
	 * Get all devices from the all the rooms
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{roomName}/devices")
	public List<Device> getAllDevicesFromRoom(@PathVariable String roomName) {
		return deviceService.getDevicesByRoom(roomName);
	}
	
	
	
	/**
	 * Add device into room
	 */
	@RequestMapping(method=RequestMethod.POST, value = "{roomName}/devices")
	public void addDevice(@RequestBody Device device, @PathVariable String roomName) {
		System.err.println("Device:"+device.getName()+"...."+roomName);
//	   Room r = new Room(roomName, null, null);
		Room r = roomService.getRoom(roomName);
		device.setRoom(r);
 		deviceService.addDevice(device);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * get device from room
	 */
	@RequestMapping(method = RequestMethod.GET, value = "{roomName}/devices/{deviceId}")
	public Device getDevice(@PathVariable String roomName, @PathVariable String deviceId) {
		return deviceService.getDevice(deviceId);
	}
	
	
	
	
	
	
	/**
	 * update device room
	 */
	@RequestMapping(method=RequestMethod.PUT, value = "{roomName}/devices/{deviceId}")
	public void updateDevice(@RequestBody Device device, @PathVariable String roomName, @PathVariable String deviceId) {
		//get the room
		//TODO and update the device
		deviceService.updatesDevice(device);
	}
	/**
	 * remove device from room
	 */
	@RequestMapping(method=RequestMethod.DELETE, value = "{roomName}/devices/{deviceId}")
	public void deleteDevice(@PathVariable String deviceID) {
		deviceService.removeDevice(deviceID);
	}
	
	
	

	
	
	

}
