package com.snosack.beltprep.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snosack.beltprep.models.Artist;
import com.snosack.beltprep.repositories.ArtistRepository;

@Service
public class ArtistService {
	@Autowired
	ArtistRepository artRepo;
	
	public List<Artist> allArtists() {
		return artRepo.findAll();
	}
	
	public Artist createArtist(Artist artist) {
		return artRepo.save(artist);
	}
	
	public Artist findArtist(Long id) {
		Optional<Artist> optionalArtist = artRepo.findById(id);
		if (optionalArtist.isPresent()) {
			return optionalArtist.get();
		} else {
			return null;
		}
	}
	
	public Artist updateArtist(Artist artist) {
		return artRepo.save(artist);
	}
	
	public void deleteArtist(Long id) {
		artRepo.deleteById(id);
	}

}
