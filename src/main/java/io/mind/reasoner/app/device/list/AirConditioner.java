package io.mind.reasoner.app.device.list;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.mind.reasoner.app.device.Device;
import io.mind.reasoner.app.utility.ACValues;

@Entity
@Table(name = "airconditioner")
public class AirConditioner extends Device {

	private ACValues acValue;
	
	{
		acValue = ACValues.UNDETERMINED;
		
	}
	
	public AirConditioner() {
		super();
		
	}

	public AirConditioner(Device device) {
		super(device);
	}

	public ACValues getAcValue() {
		return acValue;
	}

	public void setAcValue(ACValues acValue) {
		this.acValue = acValue;
	}

}
