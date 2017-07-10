package io.mind.reasoner.app.room;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mind.reasoner.app.utility.MomentType;

/**
 * Services in spring are singleton, (a single instance of this class will be
 * created when the application run)
 * 
 * @author dagi
 *
 */

@Service    
public class RoomService {

 	@Autowired
	private RoomRepository roomDAO;
 	
 	
 	
 	private static KieContainer kieContainer = null;
 	
	@Autowired
 	public RoomService(KieContainer kieContainer) {
 		RoomService.kieContainer = kieContainer;
 	}
	

	public void addRoom(Room room) {
		roomDAO.save(room);
	}

	public List<Room> getAllRooms() {
		return (List<Room>) roomDAO.findAll();
	}

	public void removeRoom(String roomID) {
		roomDAO.delete(roomID);
	}

	public Room getRoom(String roomID) {
	return roomDAO.findOne(roomID);
	}  
		

	public void updateRoom( Room room) {
		roomDAO.save(room);
	}

	
	public MomentType currentMoment(String roomId) {
		MomentType currentMoment = MomentType.UNKNOWN;
		Room room = getRoom(roomId);
		
		try {
			// kiesession stateful session 
			KieSession kieSession = kieContainer.newKieSession("MomentSession");

			kieSession.insert(room);
			kieSession.fireAllRules();

			//TODO Check why we need to use this, instead of updating the room moment form the rule file
			// currentMoment = findMessage(kieSession);
			currentMoment = room.getCurrentMoment();
			//TODO, WHY WE NEED TO UPDATE HERE, INSTED OF JUST UPDATING IT FROM THE ROOM, NEED TO BE ANSWERERD?
			updateRoom(room);
			System.err.println(room.getCurrentMoment()+"....."+currentMoment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentMoment;

	}
	
	/**
	 * Search the {@link KieSession} for bus passes.
	 */
	private MomentType findMessage(KieSession kieSession) {
		// Find all BusPass facts and 1st generation child classes of BusPass.
				ObjectFilter messageFilter = new ObjectFilter() {
					//@Override
					public boolean accept(Object object) {
						if (MomentType.class.equals(object.getClass())) return true;
						if (MomentType.class.equals(object.getClass().getSuperclass())) return true;
						return false;
					}
				};

				// printFactsMessage(kieSession);

				List<MomentType> facts = new ArrayList<MomentType>();
				for (FactHandle handle : kieSession.getFactHandles(messageFilter)) {
					facts.add((MomentType) kieSession.getObject(handle));
				}
				if (facts.size() == 0) {
					return null;
				}
				// Assumes that the rules will always be generating a single bus pass. 
				return facts.get(0);	}
}
