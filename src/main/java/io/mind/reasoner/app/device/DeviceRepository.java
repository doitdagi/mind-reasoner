package io.mind.reasoner.app.device;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface DeviceRepository extends CrudRepository<Device, String> {
	
	public List<Device> getDevicesByRoom(String room);

}
