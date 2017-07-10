package io.mind.reasoner.app.device;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mind.reasoner.app.utility.DeviceFactory;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceDAO;
	
	KieSession kieSession ;

	
	private static KieContainer kieContainer = null;
 	
	@Autowired
 	public DeviceService(KieContainer kieContainer) {
		DeviceService.kieContainer = kieContainer;
 	}

	public void addDevice(Device device) {
		Device d = DeviceFactory.getInstance().createProperDevice(device);
		deviceDAO.save(d);
		KieSession kieSession = kieContainer.newKieSession("MomentSession");

		kieSession.insert(device);
		kieSession.fireAllRules();
	}

	public List<Device> getAllDevices() {
		return (List<Device>) deviceDAO.findAll();
	}

	public void removeDevice(String deviceID) {
		deviceDAO.delete(deviceID);
	}

	public Device getDevice(String deviceID) {
		return deviceDAO.findOne(deviceID);
	}

	public void updatesDevice(Device device) {
		deviceDAO.save(device);
	}

	public List<Device> getDevicesByRoom(String roomId) {
		return deviceDAO.getDevicesByRoom(roomId);
	}

}
