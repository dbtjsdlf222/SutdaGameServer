package server;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dao.ServerDAO;
import operator.RoomOperator;
import util.Packing;
import util.Protocol;
import vo.Packet;
import vo.PlayerVO;

public class ServerMethod {
	@JsonIgnore protected PlayerVO thisPlayerVO = new PlayerVO();
	@JsonIgnore protected static Map<String, PlayerVO> lobbyPlayerList = new ConcurrentHashMap<String,PlayerVO>();
	@JsonIgnore protected RoomOperator ro = RoomOperator.getInstance(); 
	@JsonIgnore protected ServerDAO serverDAO = new ServerDAO();
	@JsonIgnore protected static Map<String, PrintWriter> playerOnlineList = new ConcurrentHashMap<String, PrintWriter>();
	
	public void exitPlayer() {

		if (thisPlayerVO.getRoomNo() != 0) {
			ro.getRoom(thisPlayerVO.getRoomNo()).exitPlayer(thisPlayerVO);
		} else if(thisPlayerVO.getNic()==null) {
			return;
		} else {
			lobbyExitBroadcast();
		}
		playerOnlineList.remove(thisPlayerVO.getNic());
	} //exitPlayer

	public void lobbyBroadcast(Packet packet) {
		for (Entry<String,PlayerVO> e : lobbyPlayerList.entrySet()) {
			Packing.sender(e.getValue().getPwSocket(), packet);
		}
	} //broadcast

	public void extraMoney() {
		serverDAO.extraMoney(thisPlayerVO);
	}
	
	public void lobbyExitBroadcast() {
		
		lobbyPlayerList.remove(thisPlayerVO.getNic());
		
		Packet packet = new Packet();
		packet.setProtocol(Protocol.RELOAD_LOBBY_LIST);
		packet.setPlayerList(lobbyPlayerList);
		packet.setRoomMap(ro.getAllRoom());
		lobbyBroadcast(packet);
	}
	
	public void lobbyReloadBroadcast() {
		Packet packet = new Packet();
		packet.setProtocol(Protocol.RELOAD_LOBBY_LIST);
		packet.setPlayerList(lobbyPlayerList);
		packet.setRoomMap(ro.getAllRoom());
		lobbyBroadcast(packet);
	}
	
	public void infoReloadcast() {
		Packet packet = new Packet();
		packet.setProtocol(Protocol.RELOAD_INFO_MONEY);
		packet.setPlayerList(lobbyPlayerList);
		packet.setRoomMap(ro.getAllRoom());
		lobbyBroadcast(packet);
	}

	public PlayerVO getThisPlayerVO() { return thisPlayerVO; }

	public static Map<String, PlayerVO> getLobbyPlayerList() {
		return lobbyPlayerList;
	}
	
}