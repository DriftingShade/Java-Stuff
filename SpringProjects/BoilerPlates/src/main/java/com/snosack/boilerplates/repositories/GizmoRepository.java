package com.snosack.boilerplates.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.snosack.boilerplates.models.Gizmo;

@Repository
public interface GizmoRepository extends CrudRepository<Gizmo, Long> {
	List<Gizmo> findAll();
}
