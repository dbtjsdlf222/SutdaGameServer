package main;import java.awt.BorderLayout;import java.awt.Container;import java.awt.FlowLayout;import java.awt.Graphics;import java.awt.Image;import java.awt.Toolkit;import javax.swing.GroupLayout;import javax.swing.GroupLayout.Alignment;import javax.swing.GroupLayout.ParallelGroup;import javax.swing.GroupLayout.SequentialGroup;import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JPanel;import music.MusicPlayer;public class MainScreen extends JFrame {	public final int SCREEN_WIDTH = 1280;	public final int SCREEN_HEIGHT = 720;	private Image gameScreenImg;	private Graphics graphics;	private Image backgroundImg;	private String[] betButtonsName = { "다이", "체크", "콜", "쿼터", "하프", "올인" };	protected MainScreen()  {    setTitle("섯다 온라인 게임");    setSize(1280, 720);    setResizable(false);    setLocationRelativeTo(null);    setVisible(true);    setDefaultCloseOperation(3);        new Thread(new MusicPlayer()).start();        Container con = getContentPane();    getContentPane().setLayout(new BorderLayout(0, 0));        JPanel panel = new JPanel();    getContentPane().add(panel, "South");    panel.setLayout(new FlowLayout(1, 5, 5));        JButton button = new JButton("다이");    panel.add(button);        JButton btnNewButton_5 = new JButton("New button");    panel.add(btnNewButton_5);        JButton btnNewButton_4 = new JButton("New button");    panel.add(btnNewButton_4);        JButton btnNewButton_3 = new JButton("New button");    panel.add(btnNewButton_3);        JButton btnNewButton_2 = new JButton("New button");    panel.add(btnNewButton_2);        JButton btnNewButton_1 = new JButton("New button");    panel.add(btnNewButton_1);        JButton btnNewButton = new JButton("New button");        panel.add(btnNewButton);        JPanel panel_1 = new JPanel();    getContentPane().add(panel_1, "West");        JPanel panel_2 = new JPanel();    panel_1.add(panel_2);        JLabel label = new JLabel("카드");    GroupLayout gl_panel_2 = new GroupLayout(panel_2);    gl_panel_2.setHorizontalGroup(      gl_panel_2.createParallelGroup(GroupLayout.Alignment.LEADING)      .addGroup(gl_panel_2.createSequentialGroup()      .addContainerGap()      .addComponent(label)      .addContainerGap(-1, 32767)));        gl_panel_2.setVerticalGroup(      gl_panel_2.createParallelGroup(GroupLayout.Alignment.LEADING)      .addGroup(gl_panel_2.createSequentialGroup()      .addComponent(label)      .addContainerGap(-1, 32767)));        panel_2.setLayout(gl_panel_2);        this.backgroundImg = new ImageIcon(Main.class.getResource("../img/background.jpg")).getImage();        Toolkit toolkit = Toolkit.getDefaultToolkit();    Image img = toolkit.getImage(Main.class.getResource("../img/titleIcon.jpg"));    setIconImage(img);  }	public void paint(Graphics g) {		this.gameScreenImg = createImage(1280, 720);		this.graphics = this.gameScreenImg.getGraphics();		screenDraw(this.graphics);		g.drawImage(this.gameScreenImg, 0, 0, null);	}	public void screenDraw(Graphics g) {		g.drawImage(this.backgroundImg, 0, 0, null);		repaint();	}}