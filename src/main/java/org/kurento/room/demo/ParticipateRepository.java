package org.kurento.room.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipateRepository extends JpaRepository<Participate, Integer> {
	List<Participate> findByTeamPrivilegesAndTeam(Integer teamPrivileges, Integer team);
	List<Participate> findByTeam(Integer team);
	List<Participate> findByUser(Integer user);
	List<Participate> findByTeamAndUser(Integer team, Integer user);
}