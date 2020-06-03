package main;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

import javax.swing.*;

public class Login extends JFrame {
	Pattern idPt = null;
	Matcher match;
	
	String DBID = "lee";
	String DBPW = "lee";
	String DBNIC = "lee";

	public void login() {

		JFrame logJF = new JFrame("로 그 인 창");
		logJF.setSize(416, 220);
		logJF.setLocation(550, 300);
		logJF.setLayout(null);
		

		JLabel lbl = new JLabel("아이디와 비밀번호를 입력해주세요");
		lbl.setBounds(100, 0, 1100, 30);
		logJF.add(lbl);

		JButton adminBtn = new JButton(new ImageIcon(Login.class.getResource("../img/admin.jpg")));
		adminBtn.setBounds(380, 0, 20, 20);
		logJF.add(adminBtn);
		
		adminBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==adminBtn) {
					JFrame adminJF = new JFrame("관리자");
					adminJF.setSize(300, 200);
					adminJF.setLocation(610, 280);
					adminJF.setLayout(null);
					
					JLabel adminLbl = new JLabel("관리자 모드");
					adminJF.add(adminLbl);
					adminLbl.setBounds(100, 10, 100, 20);
					
					JButton adLogBtn = new JButton("로그인");
					adLogBtn.setBounds(200, 40, 70, 90);
					adminJF.add(adLogBtn);
					
					JPanel adIdPal = new JPanel();
					JLabel adIdLbl = new JLabel("아이디");
					JTextField adIdTxt = new JTextField(10);
					adIdPal.setBounds(6, 50, 200, 30);
					adminJF.add(adIdPal);
					adIdPal.add(adIdLbl);
					adIdPal.add(adIdTxt);
					
					JPanel adPwPal = new JPanel();
					JLabel adPwLbl = new JLabel("비밀번호");
					JPasswordField adPwTxt = new JPasswordField(10);
					adPwPal.setBounds(0, 90, 200, 30);
					adminJF.add(adPwPal);
					adPwPal.add(adPwLbl);
					adPwPal.add(adPwTxt);
					adPwTxt.setEchoChar('*');
					
					
					dispose();
					adminJF.setVisible(true);
				}
			}
		});

		JPanel idPal = new JPanel();
		JLabel idLbl = new JLabel("아이디");
		JTextField idTxt = new JTextField(10);
		idPal.setBounds(-5, 50, 215, 30);
		logJF.add(idPal);
		idPal.add(idLbl);
		idPal.add(idTxt);

		JPanel pwPal = new JPanel();
		JLabel pwLbl = new JLabel("비밀번호");
		JPasswordField pwTxt = new JPasswordField(10);
		pwPal.setBounds(-11, 80, 215, 30);
		logJF.add(pwPal);
		pwPal.add(pwLbl);
		pwPal.add(pwTxt);
		pwTxt.setEchoChar('*');

		JLabel logLbl = new JLabel();
		logLbl.setBounds(15, 110, 230, 30);
		logLbl.setForeground(Color.red);
		logJF.add(logLbl);

		JButton logBtn = new JButton("로그인");
		logBtn.setBounds(210, 40, 70, 100);
		logJF.add(logBtn);
		logBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == logBtn) {
					if (idTxt.getText().equals(DBID) && pwTxt.getText().equals(DBPW)) {

						logJF.setVisible(false);
						JFrame listJF = new JFrame("방 목록");
						listJF.setSize(400, 600);
						listJF.setLocation(550, 150);
						listJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						listJF.setVisible(true);
					} else if (idTxt.getText().equals("") || (pwTxt.getText().equals(""))) {
						logLbl.setText("아이디 또는 비밀번호를 입력하세요.");
					} else
						logLbl.setText("아이디 또는 비밀번호가 틀립니다.");
				}
			}

		});

		JButton joinBtn = new JButton("회원가입");
		joinBtn.setBounds(290, 40, 85, 100);
		logJF.add(joinBtn);
		joinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == joinBtn) {
					JFrame joinJF = new JFrame("회 원 가 입");
					joinJF.setSize(350, 380);
					joinJF.setLocation(600, 200);
					joinJF.setLayout(null);

					JLabel jLbl = new JLabel("새롭게 만들 아이디와 비밀번호를 입력해주세요");
					jLbl.setBounds(35, 5, 1100, 30);
					jLbl.setForeground(Color.PINK);
					joinJF.add(jLbl);

					JLabel exLbl = new JLabel("아이디는 5 ~ 10자리  비밀번호는 영어 + 숫자로만 가능합니다.");
					exLbl.setBounds(15, 30, 1100, 30);
					exLbl.setFont(exLbl.getFont().deriveFont(11.0f));
					exLbl.setForeground(Color.PINK);
					joinJF.add(exLbl);

					JPanel joIdPal = new JPanel();
					JLabel joIdLbl = new JLabel("아이디");
					JTextField joIdTxt = new JTextField(10);
					joIdPal.setBounds(19, 60, 200, 30);
					joinJF.add(joIdPal);
					joIdPal.add(joIdLbl);
					joIdPal.add(joIdTxt);

					JLabel joLbl = new JLabel();
					joLbl.setBounds(40, 85, 200, 30);
					joLbl.setForeground(Color.red);
					joinJF.add(joLbl);

					JButton orBtn = new JButton("중복체크");
					orBtn.setBounds(220, 65, 85, 20);
					joinJF.add(orBtn);

					orBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == orBtn) {
								idPt = Pattern.compile("^[a-zA-Z0-9]*$");
								match = idPt.matcher(joIdTxt.getText());
								if (match.find()) {
									if (joIdTxt.getText().equals(DBID)) {
										joLbl.setText("이미 생성된 아이디 입니다.");
									} else if (joIdTxt.getText().length() <= 10 && joIdTxt.getText().length() >= 5) {
										joLbl.setText("생성 가능한 아이디 입니다.");
									} else if (joIdTxt.getText().equals("")) {
										joLbl.setText("아이디를 입력해주세요.");
									} else if (joIdTxt.getText().length() > 10 || joIdTxt.getText().length() < 5) {
										joLbl.setText("5 ~ 10자리 이하만 가능합니다.");
									}
								} else
									joLbl.setText("영어와 숫자로 입력 가능합니다.");
							}

						}
					});

					JPanel joPwPal = new JPanel();
					JLabel joPwLbl = new JLabel("비밀번호");
					JPasswordField joPwTxt = new JPasswordField(10);
					joPwPal.setBounds(13, 115, 200, 30);
					joinJF.add(joPwPal);
					joPwPal.add(joPwLbl);
					joPwPal.add(joPwTxt);
					joPwTxt.setEchoChar('*');

					JPanel joPwPal2 = new JPanel();
					JLabel joPwLbl2 = new JLabel("비밀번호 확인");
					JPasswordField joPwTxt2 = new JPasswordField(10);
					joPwPal2.setBounds(-1, 170, 200, 30);
					joPwLbl2.setFont(joPwLbl2.getFont().deriveFont(12.0f));
					joinJF.add(joPwPal2);
					joPwPal2.add(joPwLbl2);
					joPwPal2.add(joPwTxt2);
					joPwTxt2.setEchoChar('*');

					JLabel joLbl2 = new JLabel("일치하지 않습니다.");
					joLbl2.setBounds(65, 195, 200, 30);
					joLbl2.setForeground(Color.red);
					joinJF.add(joLbl2);

					joPwTxt2.addKeyListener(new KeyListener() {

						@Override
						public void keyTyped(KeyEvent e) {
						}

						@Override
						public void keyReleased(KeyEvent e) {
							if (joPwTxt.getText().equals(joPwTxt2.getText())) {
								joLbl2.setText("일치");
							} else {
								joLbl2.setText("불일치");
							}
						}

						@Override
						public void keyPressed(KeyEvent e) {
						}

					});

					JPanel joNicPal = new JPanel();
					JLabel joNicLbl = new JLabel("닉네임");
					JTextField joNicTxt = new JTextField(10);
					joNicPal.setBounds(19, 225, 200, 30);
					joinJF.add(joNicPal);
					joNicPal.add(joNicLbl);
					joNicPal.add(joNicTxt);

					JButton joOrBtn2 = new JButton("중복체크");
					joOrBtn2.setBounds(220, 230, 85, 20);
					joinJF.add(joOrBtn2);

					JLabel joLbl3 = new JLabel();
					joLbl3.setBounds(40, 250, 180, 30);
					joLbl3.setForeground(Color.red);
					joinJF.add(joLbl3);

					joOrBtn2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == joOrBtn2) {
								idPt = Pattern.compile("^[a-zA-Z0-9가-힣]*$");
								match = idPt.matcher(joNicTxt.getText());
								if (match.find()) {
									if (joNicTxt.getText().equals(DBNIC)) {
										joLbl3.setText("이미 생성된 닉네임 입니다.");
									} else if (joNicTxt.getText().length() <= 6 && joNicTxt.getText().length() >= 2) {
										joLbl3.setText("생성 가능한 닉네임 입니다.");
									} else if (joNicTxt.getText().equals("")) {
										joLbl3.setText("닉네임을 입력해주세요.");
									} else if (joNicTxt.getText().length() > 7 || joNicTxt.getText().length() < 2) {
										joLbl3.setText("2 ~ 7자리 미만만 가능합니다.");
									}
								} else {
									joLbl3.setText("특수문자는 불가능합니다.");
								}
							}
						}
					});

					JButton joBtn2 = new JButton("가 입 완 료");
					joBtn2.setBounds(50, 280, 150, 40);
					joinJF.add(joBtn2);

					joBtn2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (e.getSource() == joBtn2) {
								
							}

						}
					});

					dispose();
					joinJF.setVisible(true);
				}
			}
		});

		logJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logJF.setVisible(true);

	}

	public static void main(String[] args) {

		Login log = new Login();
		log.login();

	}

}