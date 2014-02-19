package org.sample.shaozhen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Hello world!
 * 
 */
public class Client {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		int numOfUsers = Integer.valueOf(args[0]);
		while(true){
			for(int i=0; i< numOfUsers; i++){
				Thread t = new Thread(new Wrapper());
				t.start();
			}
			Thread.sleep(5000);
		}
	}

	static class Wrapper implements Runnable {

		public void run() {
			try {
					Socket socket = new Socket("localhost", 4321);
					PrintWriter out = new PrintWriter(socket.getOutputStream(),
							true);
					BufferedReader in = new BufferedReader(new InputStreamReader(
							socket.getInputStream()));
					
					out.println("start");
					System.out.println("Server response" + in.readLine());
					Thread.sleep(500);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
