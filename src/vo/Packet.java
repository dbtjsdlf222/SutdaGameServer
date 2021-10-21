package vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnore;
import server.Room;

import java.util.Arrays;
import java.util.Map;

//import server.Room;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Packet {
	private String protocol;		//protocol
	private String motion;			//value
	private PlayerVO playerVO;
	private Map<Integer, Room> roomMap;
	private Map<Integer, PlayerVO> roomPlayerList;
	private Map<String,PlayerVO> playerList;
	private	float[] card = new float[2];
	private String[] buttonArr = new String[10];
	private Room room;
	
	public Packet() {}

	public Room getRoom() { return room; }
	public void setRoom(Room room) { this.room = room; }

	public Packet(String protocol, PlayerVO playerVO) {
		this.protocol = protocol;
		this.playerVO = playerVO;
	}
	
	public Packet(String protocol, Room room) {
		
		this.protocol = protocol;
		this.room = room;
	}

	public Packet(String protocol, String motion, PlayerVO playerVO) {
		this.protocol = protocol;
		this.motion = motion;
		this.playerVO = playerVO;
	}

	public Packet(String protocol, String motion) {
		this.protocol = protocol;
		this.motion = motion;
	}
	
	public Packet(String protocol) {
		this.protocol = protocol;
	}

	public Packet(String protocol, String[] buttonArr) {
		this.protocol = protocol;
		this.buttonArr = buttonArr;
	}

	public Packet(String protocol, String[] buttonArr, String motion) {
		this.protocol = protocol;
		this.buttonArr = buttonArr;
		this.motion = motion;
	}

	public Packet(String protocol, Map<Integer, PlayerVO> playerMap) {
		this.protocol = protocol;
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

	public Map<String, PlayerVO> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(Map<String,PlayerVO> playerList) {
		this.playerList = playerList;
	}

	public PlayerVO getPlayerVO() {
		return playerVO;
	}

	public void setPlayerVO(PlayerVO playerVO) {
		this.playerVO = playerVO;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
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