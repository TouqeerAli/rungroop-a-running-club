package com.rungroup.web.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rungroup.web.dto.ClubDTO;
import com.rungroup.web.model.Club;


public interface ClubService {
	List<ClubDTO> findAllClubs();
	Club saveClub(Club club);
}
