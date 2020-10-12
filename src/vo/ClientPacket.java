package vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;


import server.Room;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ClientPacket {
	private String action;		//protocol
	private String motion;		//value
	private PlayerVO playerVO;
	private Map<Integer, Room> roomMap;
	private Map<Integer, PlayerVO> roomPlayerList;
	private ArrayList<PlayerVO> playerList;
	private	float[] card = new float[2];
	private String[] buttonArr = new String[10];
	
	public ClientPacket() {}

	public ClientPacket(String action, PlayerVO playerVO) {
		this.action = action;
		this.playerVO = playerVO;
	}

	public ClientPacket(String action, String motion, PlayerVO playerVO) {
		this.action = action;
		this.motion = motion;
		this.playerVO = playerVO;
	}

	public ClientPacket(String action, String motion) {
		this.action = action;
		this.motion = motion;
	}
	
	public ClientPacket(String protocol) {
		this.action = protocol;
	}

	public ClientPacket(String protocol, String[] buttonArr) {
		this.action = protocol;
		this.buttonArr = buttonArr;
	}

	public ClientPacket(String protocol, String[] buttonArr, String motion) {
		this.action = protocol;
		this.buttonArr = buttonArr;
		this.motion = motion;
	}

	public ClientPacket(String protocol, Map<Integer, PlayerVO> playerMap) {
		this.action = protocol;
		this.roomPlayerList = playerMap;
	}

	public String[] getButtonArr() {
		return buttonArr;
	}
	
	public void setButtonArr(String[] buttonArr) {
		this.buttonArr = buttonArr;
	}

	public float[] getCard() {
		return card;
	}

	public void setCard(float[] card) {
		this.card = card;
	}
	
	@JsonIgnore
	public void setCard_(float card) {
		this.card[0] = card;
	}
	
	@JsonIgnore
	public void setCard_(float card1,float card2) {
		this.card[0]=card1;
		this.card[1]=card2;
	}

	public Map<Integer, PlayerVO> getRoomPlayerList() {
		return roomPlayerList;
	}

	public void setRoomPlayerList(Map<Integer, PlayerVO> roomPlayerList) {
		this.roomPlayerList = roomPlayerList;
	}

	public Map<Integer, Room> getRoomMap() {
		return roomMap;
	}

	public void setRoomMap(Map<Integer, Room> room) {
		this.roomMap = room;
	}

	public ArrayList<PlayerVO> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<PlayerVO> playerList) {
		this.playerList = playerList;
	}

	public PlayerVO getPlayerVO() {
		return playerVO;
	}

	public void setPlayerVO(PlayerVO playerVO) {
		this.playerVO = playerVO;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMotion() {
		return motion;
	}

	public void setMotion(String motion) {
		this.motion = motion;
	}

	@Override
	public String toString() {
		return "Packet [motion=" + motion + ", playerVO=" + playerVO + ", buttonArr=" + Arrays.toString(buttonArr)
				+ "]";
	}

	
}