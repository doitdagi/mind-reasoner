package io.mind.reasoner.app.room;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface RoomRepository extends CrudRepository<Room, String> {
	
	

}
