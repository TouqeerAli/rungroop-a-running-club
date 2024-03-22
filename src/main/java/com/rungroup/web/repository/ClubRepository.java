package com.rungroup.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long>{
	Optional<Club> findByTitle(String title);
}
