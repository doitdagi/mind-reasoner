package io.mind.reasoner.app.device;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mind.reasoner.app.device.list.PresenceSensor;
import io.mind.reasoner.app.device.list.Television;
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
	@RequestMapping(method = RequestMethod.GET, value = "{roomId}/devices")
	public List<Device> getAllDevicesFromRoom(@PathVariable String roomId) {
		return deviceService.getDevicesByRoom(roomId);
	}
	
	
	
	/**
	 * Add device into room
	 */
	@RequestMapping(method=RequestMethod.POST, value = "{roomId}/devices")
	public void addDevice(@RequestBody Device device, @PathVariable String roomId) {
		Room r = roomService.getRoom(roomId);
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
	 * Temporary method
	 * update presense sensor room
	 */
	@RequestMapping(method=RequestMethod.PUT, value = "{roomId}/devices/pre/{deviceId}")
	public void updateDevice(@RequestBody PresenceSensor device, @PathVariable String roomId, @PathVariable String deviceId) {
		//get the room
		//TODO and update the device
		Device dd = deviceService.getDevice(deviceId);
		if(dd instanceof PresenceSensor) {
 			((PresenceSensor) dd).setCurrentState(((PresenceSensor)device).getCurrentState());
		}
		deviceService.updatesDevice(dd);
	}
	
	
	/**
	 * Temporary method
	 * update TV sensor room
	 */
	@RequestMapping(method=RequestMethod.PUT, value = "{roomId}/devices/tv/{deviceId}")
	public void updateDevice(@RequestBody Television device, @PathVariable String roomId, @PathVariable String deviceId) {
		//get the room
		//TODO and update the device
		Device dd = deviceService.getDevice(deviceId);
		if(dd instanceof Television) {
 			((Television) dd).setStatus(((Television)device).getStatus());
		}
		deviceService.updatesDevice(dd);
	}
	
	
	
	
	
	
	
	/**
	 * update device room
	 */
	@RequestMapping(method=RequestMethod.PUT, value = "{roomId}/devices/{deviceId}")
	public void updateDevice(@RequestBody Device device, @PathVariable String roomId, @PathVariable String deviceId) {
		//get the room
		//TODO and update the device
		Device dd = deviceService.getDevice(deviceId);
		if(dd instanceof PresenceSensor) {
 			((PresenceSensor) dd).setCurrentState(((PresenceSensor)device).getCurrentState());
		}
		deviceService.updatesDevice(dd);
	}
	/**
	 * remove device from room
	 */
	@RequestMapping(method=RequestMethod.DELETE, value = "{roomId}/devices/{deviceId}")
	public void deleteDevice(@PathVariable String roomId) {
		deviceService.removeDevice(roomId);
	}
	
	

}
