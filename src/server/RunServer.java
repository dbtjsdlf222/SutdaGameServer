package server;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.ServerDAO;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunServer {
	public static final int MAXPLAYER = 10;
	public static final int MAXROOM = MAXPLAYER;
	public static int i = 0;

	private int port = 4886;

	public static void main(String[] args) {
		new RunServer().run();
	}

	public void run() {
		ServerDAO sdao = new ServerDAO();
		// 쓰레드풀 생성
		ExecutorService pool = Executors.newFixedThreadPool(MAXPLAYER);

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				sdao.initMoneyChage(); //파산시 돈을 지급하는 회생 찬스 하루마다 횟수 초기화
			}
		};
		
		//
		timer.schedule(task, 0, 24 * 60 * 60 * 1000); // 24시간 마다 실행
		// timer.schedule(task, 0, 60*1000); // 1분 마다 실행

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				Socket socket = serverSocket.accept(); // 접속한 소켓 받는다
				Runnable r = new ServerReceiver(socket);
				pool.execute(r);
			} // while

		} catch (BindException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
		} catch (IOException e) {
		} finally {
			pool.shutdown();
		}

	} // run();

} // Accept();