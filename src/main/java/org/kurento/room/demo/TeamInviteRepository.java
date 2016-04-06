package org.kurento.room.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamInviteRepository extends JpaRepository<TeamInvite, Integer> {
	List<TeamInvite> findByUser(Integer user);
}