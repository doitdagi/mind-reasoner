package io.mind.reasoner.app.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import io.mind.reasoner.app.model.Room;
@Transactional
public interface RoomDao extends CrudRepository<Room, String> {
	
	

}
