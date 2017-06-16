package io.mind.reasoner.app.device.list;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.utility.TempValues;

@Entity
@Table(name = "temperature")
public class TemperatureSensor extends Device {

	private TempValues temperatureValue;
	
	{
		temperatureValue = TempValues.ROOM_TEMP;
		
	}
	
	public TemperatureSensor() {
		super();
	}

	public TemperatureSensor(Device device) {
		super(device);
	}

	public TempValues getTemperatureValue() {
		return temperatureValue;
	}

	public void setTemperatureValue(TempValues temperatureValue) {
		this.temperatureValue = temperatureValue;
	}
	

}
