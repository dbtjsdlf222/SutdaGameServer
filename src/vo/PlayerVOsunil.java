package vo;

import java.net.Socket;

public class PlayerVOsunil {
	
	private Socket socket;
	private int no;
	private String id = null;
	private String pw = null;
	private String nic = null;
	private int money = 0;
	private boolean admin;
	private int win = 0;
	private int lose = 0;
	private boolean online = false;
	private int cha;
	private boolean live = false;
	private String card1, card2;
	
	
   public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public String getCard1() {
		return card1;
	}

	public void setCard1(String card1) {
		this.card1 = card1;
	}

	public String getCard2() {
		return card2;
	}

	public void setCard2(String card2) {
		this.card2 = card2;
	}

public PlayerVOsunil(int no, String id, String pw, String nic, int money, boolean admin, int win, int lose,
         boolean online, int cha) {
      this.no = no;
      this.id = id;
      this.pw = pw;
      this.nic = nic;
      this.money = money;
      this.admin = admin;
      this.win = win;
      this.lose = lose;
      this.online = online;
      this.cha = cha;
   }

   public int getNo() {
      return this.no;
   }

   public void setNo(int no) {
      this.no = no;
   }

   public int getCha() {
      return cha;
   }

   public void setCha(int cha) {
      this.cha = cha;
   }

   public String getId() {
      return this.id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getPw() {
      return this.pw;
   }

   public void setPw(String pw) {
      this.pw = pw;
   }

   public String getNic() {
      return this.nic;
   }

   public void setNic(String nic) {
      this.nic = nic;
   }

   public int getMoney() {
      return this.money;
   }

   public void setMoney(int money) {
      this.money = money;
   }

   public boolean isAdmin() {
      return this.admin;
   }

   public void setAdmin(boolean admin) {
      this.admin = admin;
   }

   public int getWin() {
      return this.win;
   }

   public void setWin(int win) {
      this.win = win;
   }

   public int getLose() {
      return this.lose;
   }

   public void setLose(int lose) {
      this.lose = lose;
   }

   public boolean isOnline() {
      return this.online;
   }

   public void setOnline(boolean online) {
      this.online = online;
   }
}