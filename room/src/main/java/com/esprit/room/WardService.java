package com.esprit.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardService {
	
	@Autowired
	private WardRepository wardRepository ;
	
	public Ward addWard(Ward ward) {
		return wardRepository.save(ward);
	}
	
	public Ward updateWard(int id, Ward newWard) {
		if (wardRepository.findById(id).isPresent()) {
			Ward existingWard = wardRepository.findById(id).get();
			existingWard.setName(newWard.getName());
			return wardRepository.save(existingWard);

		} else {
			return null;
		}
	}
	
	public String deleteWard(int id) {
		if (wardRepository.findById(id).isPresent()) {
			wardRepository.deleteById(id);
			return "ward deleted";
		} else {
			return "ward not deleted";
		}
	}

}
