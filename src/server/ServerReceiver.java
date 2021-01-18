package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import util.Packing;
import util.Protocol;
import vo.Packet;

public class ServerReceiver extends Thread { // Server


	private Socket socket;

	public ServerReceiver(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		ServerPacketController packetController = new ServerPacketController(socket);
		ObjectMapper mapper = new ObjectMapper();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			String packetStr = "";
			try {
				while (true) {
					packetStr = br.readLine();
					if (packetStr == null) {
						break;
					}
					Packet packet = mapper.readValue(packetStr, Packet.class);
					packetController.packetAnalysiser(packet); // action에 따라서 동작 실행
				} // while
			} catch (NullPointerException e) {

			} catch (SocketException e) {
				packetController.exitPlayer();
			}

		} catch (IOException e) {
		}
	} // run();

} // ReceiveClientPacket();