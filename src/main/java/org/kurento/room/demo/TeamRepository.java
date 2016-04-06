package org.kurento.room.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
	List<Team> findByName(String name);
}