package org.kurento.room.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipateRoomRepository extends JpaRepository<ParticipateRoom, Integer> {
	List<ParticipateRoom> findByRoom(Integer room);
	List<ParticipateRoom> findByUser(Integer user);
	List<ParticipateRoom> findByTeam(Integer team);
	List<ParticipateRoom> findByUserAndRoom(Integer user, Integer room);
	List<ParticipateRoom> findByTeamAndUser(Integer team, Integer user);
}