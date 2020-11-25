package server;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.core.JsonProcessingException;

import dao.ServerDAO;

public class RunServer {
	public static final int MAXPLAYER = 10;
	public static final int MAXROOM = MAXPLAYER;
	
	private int port = 4886;

	public static void main(String[] args) throws JsonProcessingException {
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
	    	   sdao.initMoneyChage();
	       }
	    };
	    timer.schedule(task, 0, 24*60*60*1000);
		
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