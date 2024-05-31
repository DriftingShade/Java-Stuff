package com.snosack.notsavetravels.repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.snosack.notsavetravels.models.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long>{
	List<Travel> findAll();

}
