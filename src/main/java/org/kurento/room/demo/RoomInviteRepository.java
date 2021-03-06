package org.kurento.room.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomInviteRepository extends JpaRepository<RoomInvite, Integer> {
	List<RoomInvite> findByUser(Integer user);
	List<RoomInvite> findByTeam(Integer team);
	List<RoomInvite> findByTeamAndUser(Integer team, Integer user);
}