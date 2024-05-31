package com.snosack.boilerplates.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snosack.boilerplates.models.Gizmo;
import com.snosack.boilerplates.repositories.GizmoRepository;



@Service
public class GizmoService {
	@Autowired
	GizmoRepository gizmoRepo;
	
	public List<Gizmo> allGizmos() {
		return gizmoRepo.findAll();
	}
	
	public Gizmo createGizmo(Gizmo gizmo) {
		return gizmoRepo.save(gizmo);
	}
	
	public Gizmo findGizmo(Long id) {
		Optional<Gizmo> optionalGizmo = gizmoRepo.findById(id);
		if (optionalGizmo.isPresent()) {
			return optionalGizmo.get();
		} else {
			return null;
		}
	}
	
	public Gizmo updateGizmo(Gizmo gizmo) {
		return gizmoRepo.save(gizmo);
	}
	
	public void deleteGizmo(Long id) {
		gizmoRepo.deleteById(id);
	}
}
