package org.kurento.room.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/teams")
public class TeamRestController {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private ParticipateRepository participateRepository;
	@Autowired
	private ParticipateRoomRepository participateRoomRepository;
	@Autowired
	private RoomInviteRepository roomInviteRepository;
	@Autowired
	private RequestJoinTeamRepository requestJoinTeamRepository;
	@Autowired
	private RequestJoinRoomRepository requestJoinRoomRepository;
	@Autowired
	private ChatMessageRepository chatMessageRepository;
	@Autowired
	private PrivateMessageRepository privateMessageRepository;


	@RequestMapping(method = RequestMethod.GET)
	public List<Team> allTeams(Model model) {
		return teamRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Team> addTeam(@RequestBody Team team) {
			team.setImage("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");
			team.setImageType("image/png");
		
		//team.setImage("images.png");
		//team.setImageType("image/png");
		teamRepository.save(team);
		Participate participate=new Participate();
		participate.setUser(team.getAdmin());
		participate.setTeam(team.getId());
		participate.setTeamPrivileges(2);
		participateRepository.save(participate);
		return new ResponseEntity<>(team,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id) {
		teamRepository.delete(id);
		List<Room> rooms=roomRepository.findByTeam(id);
		for (int i=0;i<rooms.size();i++){
			roomRepository.delete(rooms.get(i).getId());
		}
		List<ParticipateRoom> participateRooms=participateRoomRepository.findByTeam(id);
		for (int i=0;i<participateRooms.size();i++){
			participateRoomRepository.delete(participateRooms.get(i).getId());
		}
		List<RoomInvite> roomInvites=roomInviteRepository.findByTeam(id);
		for (int i=0;i<roomInvites.size();i++){
			roomInviteRepository.delete(roomInvites.get(i).getId());
		}
		List<RequestJoinRoom> requestJoinRooms=requestJoinRoomRepository.findByTeam(id);
		for (int i=0;i<requestJoinRooms.size();i++){
			requestJoinRoomRepository.delete(requestJoinRooms.get(i).getId());
		}
		List<RequestJoinTeam> requestJoinTeams=requestJoinTeamRepository.findByTeam(id);
		for (int i=0;i<requestJoinTeams.size();i++){
			requestJoinTeamRepository.delete(requestJoinTeams.get(i).getId());
		}
		List<ChatMessage> chatMessages=chatMessageRepository.findByTeam(id);
		for (int i=0;i<chatMessages.size();i++){
			chatMessageRepository.delete(chatMessages.get(i).getId());
		}
		List<PrivateMessage> privateMessages=privateMessageRepository.findByTeam(id);
		for (int i=0;i<privateMessages.size();i++){
			privateMessageRepository.delete(privateMessages.get(i).getId());
		}	
		List<Participate> participates=participateRepository.findByTeam(id);
		for (int i=0;i<participates.size();i++){
			participateRepository.delete(participates.get(i).getId());
		}
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Team getTeam(@PathVariable int id) {
		return teamRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Team updateTeam(@PathVariable int id, @RequestBody @Valid Team team) {
		return teamRepository.save(team);
	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public List<Team> getTeamByName(@PathVariable String name) {
		return teamRepository.findByName(name);
	}
	
}