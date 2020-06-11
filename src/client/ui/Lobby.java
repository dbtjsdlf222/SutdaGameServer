package client.ui;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import client.Background;
import client.service.ClientPacketController;
import operator.ChattingOperator;
import vo.PlayerVO;
import vo.Protocol;

public class Lobby {
	private JFrame lobbyJF = new JFrame();
	private Background imgP;
	private Container con;
	private JButton exitBtn;
	private JButton newBtn;
	private JButton gBtn;

	
	public static void main(String[] args) {
		
		PlayerVO vo = new PlayerVO();
		vo.setNic("Ddd");
		vo.setWin(2);
		vo.setLose(2);
		vo.setMoney(10000);
		
		new Lobby(vo);
	}
	
	
	public Lobby(PlayerVO vo) {
		vo.setLocation(Protocol.LOBBY);

		// 서버에 로그인된 사람의 정보를 전송
	//	try {
//			vo.getPwSocket().println(new ObjectMapper().writeValueAsString(new Packet(Protocol.FIRSTENTER, vo)));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		lobbyScreen(vo);
	}

	public void lobbyScreen(PlayerVO vo) {
		// 로비 라벨
		JLabel lobbyLbl = new JLabel("L O B B Y");
		lobbyLbl.setFont(new Font("Rosewood Std", Font.PLAIN, 30));
		lobbyLbl.setForeground(new Color(255, 255, 255, 150));
		lobbyLbl.setBounds(340, 20, 200, 30);
		lobbyJF.add(lobbyLbl);

		// 로비 판넬
		JPanel lobbyPan = new JPanel();
		
		lobbyPan.setBackground(new Color(0, 0, 0, 120));
		lobbyPan.setBounds(5, 60, 818, 290);
		lobbyPan.setBorder(new TitledBorder(new LineBorder(Color.orange, 3)));
		lobbyPan.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 40));
		lobbyJF.add(lobbyPan);

		// 채팅 라벨
		JLabel lbl = new JLabel("C H A T T I N G");
		lbl.setFont(new Font("Rosewood Std", Font.PLAIN, 30));
		lbl.setForeground(new Color(255, 255, 255, 150));
		lbl.setBounds(300, 370, 280, 30);
		lobbyJF.add(lbl);
	
		// 채팅 판넬
		JPanel chatPan = new JPanel();
		chatPan.setBounds(5, 410, 658, 260);
		chatPan.setBackground(new Color(0, 0, 0, 120));
		chatPan.setLayout(null);
		lobbyJF.add(chatPan);
		chatPan.setBorder(new TitledBorder(new LineBorder(Color.orange, 3)));
	
		// 채팅 필드
		JTextField chatText = new JTextField();
		chatText.setBounds(10, 225, 560, 25);
		chatPan.add(chatText);
		chatText.requestFocus();
		chatText.setFont(new Font("Rosewood Std", Font.PLAIN, 12));
		ChattingOperator co = ChattingOperator.getInstance();
		ChattingOperator.chatArea.setEditable(false);
		ChattingOperator.chatArea.setLineWrap(true);
		chatPan.add(ClientPacketController.scrollPane);
		ClientPacketController.scrollPane.setBorder(new TitledBorder(new LineBorder(Color.orange, 3)));
		
		// 채팅 보내기 버튼
		JButton chatBtn = new JButton("보내기");
		chatBtn.setBounds(578, 225, 70, 25);
		chatPan.add(chatBtn);
		JRootPane rootPane = lobbyJF.getRootPane();
		rootPane.setDefaultButton(chatBtn);

		chatBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == chatBtn) {
					if (!(chatText.getText().equals(""))) {
						co.chatting(chatText.getText(), vo);
						chatText.requestFocus();
						chatText.setText("");
					}
				}
			}
		});

		// 플레이어 라벨
		JLabel playerLbl = new JLabel("P L A Y E R");
		playerLbl.setFont(new Font("Rosewood Std", Font.PLAIN, 30));
		playerLbl.setForeground(new Color(255, 255, 255, 150));
		playerLbl.setBounds(970, 20, 200, 30);
		lobbyJF.add(playerLbl);
	
		// 플레이어 판넬
		JPanel playerPan = new JPanel();
		playerPan.setBounds(850, 60, 390, 610);
		playerPan.setBackground(new Color(0, 0, 0, 120));
		playerPan.setLayout(null);
		lobbyJF.add(playerPan);
		playerPan.setBorder(new TitledBorder(new LineBorder(Color.orange, 3)));

	
//		JTable list = new JTable();
//		playerPan.add(list);
		
		
		// 로비에 플레이어 접속자 목록

		String b[] =  {"닉네임", "판수", "돈"};
		
		for (int i = 0; i < 10; i++) {
			String a[] = 
					{vo.getNic(),(vo.getWin()+vo.getLose())+"",vo.getMoney()+""};
		
		}
		
	
		
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(b, 0);
		JTable jT = new JTable(defaultTableModel);
		JScrollPane plScroll = new JScrollPane(jT);
		plScroll.getViewport().setBackground(new Color(0, 0, 0, 0));
		jT.getTableHeader().setReorderingAllowed(false); 
		jT.getTableHeader().setResizingAllowed(false);
		plScroll.setOpaque(false);
		plScroll.setBounds(10, 10, 370, 590);
		
	
		plScroll.setBorder(new TitledBorder(new LineBorder(Color.orange, 3)));
		playerPan.add(plScroll);
		
				
		// 귓속말 버튼
		gBtn = new JButton("귓속말");
		gBtn.setBounds(681, 410, 150, 50);
		lobbyJF.add(gBtn);

		// 방만들기 버튼
		newBtn = new JButton("방만들기");
		newBtn.setBounds(681, 515, 150, 50);
		lobbyJF.add(newBtn);
		
		
		
		
		
		newBtn.addActionListener(new ActionListener() {

	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == newBtn) {
					new MainScreen();
					lobbyJF.dispose();
				}

			}
		
		});

		// 나가기 버튼
		exitBtn = new JButton("나가기");
		exitBtn.setBounds(681, 620, 150, 50);
		lobbyJF.add(exitBtn);

		
		// JFrame 정보
		imgP = new Background();
		imgP.lobbyImage();
		con = lobbyJF.getContentPane();
		con.add(imgP, BorderLayout.CENTER);
		lobbyJF.setSize(1280, 720);
		lobbyJF.setVisible(true);
		lobbyJF.setResizable(false);
		lobbyJF.setLocationRelativeTo(null);
		lobbyJF.setLayout(null);
		lobbyJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}