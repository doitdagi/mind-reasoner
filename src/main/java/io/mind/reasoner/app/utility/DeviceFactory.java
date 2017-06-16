package io.mind.reasoner.app.utility;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.device.list.LumositySensor;
import io.mind.reasoner.app.device.list.PresenceSensor;
import io.mind.reasoner.app.device.list.RollerShutter;
import io.mind.reasoner.app.device.list.SecurityDevice;
import io.mind.reasoner.app.device.list.Television;
import io.mind.reasoner.app.device.list.TemperatureSensor;

public class DeviceFactory {

	public static DeviceFactory instance;

	public Device createProperDevice(Device device) {
		Device newDevice;

		switch (device.getDeviceType()) {
		case TEMPERATURE_SENSOR:
			newDevice = new TemperatureSensor(device);
			break;
		case PRESENCE_SENSOR:
			newDevice = new PresenceSensor(device);
			break;
		case LUMINOSITY_SENSOR:
			 newDevice = new LumositySensor(device);
			 break;
		case SECURITY_DEVICE:
			 newDevice = new SecurityDevice(device);
			 break;
		case TELEVISON:
			newDevice = new Television(device);
			 break;
		case ROLLERSHUTTER:
			newDevice = new RollerShutter(device);
			 break;
		default:
			newDevice = device;
			break;
		}
		return newDevice;
	}
	
	
	
	
	public static DeviceFactory getInstance() {
		if(instance==null) {
			instance = new DeviceFactory();
		}
		return instance;
	}
}
