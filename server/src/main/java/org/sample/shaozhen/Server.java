package org.sample.shaozhen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;


public class Server {
	public static void main(String[] args) throws IOException {
		long computationTimes = Long.valueOf(args[0]);
		ServerSocket server = new ServerSocket(4321);
		while (true) {
			Socket socket = server.accept();
			Thread t = new Thread(new Wrapper(socket, computationTimes));
			t.start();
		}

	}

	static class Wrapper implements Runnable {
		private Socket socket;
		private long computationTimes;

		public Wrapper(Socket socket, long computationTimes) {
			this.socket = socket;
			this.computationTimes = computationTimes;
		}

		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(),
						true);
				
				List<String> strings = new ArrayList<String>();
				for(int i= 0; i< 100; i++){
					strings.add(RandomStringUtils.random(10000));
				}
				System.out.println(in.readLine());
//				for (int i = 0; i < computationTimes; i++) {
//					int a = 1 + 1;
//				}
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
				out.println("Hello");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
