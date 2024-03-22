package com.rungroup.web.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;
import com.rungroup.web.repository.ClubRepository;
import com.rungroup.web.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService{

	private ClubRepository clubRepository;
	
	
	@Autowired
	public ClubServiceImpl(ClubRepository clubRepository) {
		super();
		this.clubRepository = clubRepository;
	}



	@Override
	public List<ClubDTO> findAllClubs() {
		List<Club> clubs = clubRepository.findAll();
		return clubs.stream().map((club) -> mapToClubDTO(club)).collect(Collectors.toList());
	}



	private ClubDTO mapToClubDTO(Club club) {
		ClubDTO clubDTO = ClubDTO.builder()
				.id(club.getId())
				.title(club.getTitle())
				.photoUrl(club.getPhotoUrl())
				.content(club.getContent())
				.createdOn(club.getCreatedOn())
				.updateOn(club.getUpdateOn())
				.build();
		return clubDTO;
		
	}



	@Override
	public Club saveClub(Club club) {
		
		return clubRepository.save(club);
	}

}
