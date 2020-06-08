package client;import java.awt.BorderLayout;import java.awt.Container;import java.awt.FlowLayout;import java.awt.Graphics;import java.awt.Image;import java.awt.Toolkit;import javax.swing.GroupLayout;import javax.swing.GroupLayout.Alignment;import javax.swing.GroupLayout.ParallelGroup;import javax.swing.GroupLayout.SequentialGroup;import javax.swing.ImageIcon;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JPanel;import music.MusicPlayer;public class MainScreen extends JFrame {	public final int SCREEN_WIDTH = 1280;	public final int SCREEN_HEIGHT = 720;	private Image gameScreenImg;	private Graphics graphics;	private Image backgroundImg;	private String[] betButtonsName = { "다이", "체크", "콜", "쿼터", "하프", "올인" };	public static void main(String[] args) {		new MainScreen();	}				protected MainScreen()  {    setTitle("섯다 온라인 게임");    setSize(1280, 720);    setLayout(null);    setResizable(false);    setLocationRelativeTo(null);    setVisible(true);    setDefaultCloseOperation(3);        new Thread(new MusicPlayer()).start();                                          Container con = getContentPane();    getContentPane().setLayout(new BorderLayout(0, 0));           this.backgroundImg = new ImageIcon(MainScreen.class.getResource("../img/background.jpg")).getImage();        Toolkit toolkit = Toolkit.getDefaultToolkit();    Image img = toolkit.getImage(MainScreen.class.getResource("../img/titleIcon.jpg"));    setIconImage(img);            JPanel container = new JPanel();    container.setBounds(0, 0, 1200, 50);    add(container);        JButton btn1 = new JButton("다이");    container.add(btn1);    btn1.setBounds(0, 0, 70, 30);  }	public void paint(Graphics g) {		this.gameScreenImg = createImage(1280, 720);		this.graphics = this.gameScreenImg.getGraphics();		screenDraw(this.graphics);		g.drawImage(this.gameScreenImg, 0, 0, null);	}	public void screenDraw(Graphics g) {		g.drawImage(this.backgroundImg, 0, 0, null);		repaint();	}}