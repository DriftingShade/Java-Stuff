package com.snosack.beltprep.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.snosack.beltprep.models.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	List<Artist> findAll();
}
