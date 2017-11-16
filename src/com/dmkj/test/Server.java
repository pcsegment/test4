package com.dmkj.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import org.json.JSONArray;  
import org.json.JSONException;  
import org.json.JSONObject;  


public class Server {

	public static void main(String[] args) {
		//new Server().startup();
	}
	
	public void startup() {
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(5858);
			
			while(true) {
				s =ss.accept();
				ServerThread st = new ServerThread(s);
				new Thread(st).start();//线程建立
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ss!=null) ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private class ServerThread implements Runnable{
		private Socket s = null;
		private BufferedReader br;
		private PrintWriter out;
		private String name;
		private boolean flag = true;
		public ServerThread(Socket s) throws IOException {
			this.s = s;
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = new PrintWriter(s.getOutputStream(),true);
			name = s.getInetAddress().getHostAddress()+":"+s.getPort();
			System.out.println(name+"连接上来了");
		}
		
		private void receive() throws IOException {
			String str = null;
			while((str=br.readLine())!=null) {
				if(str.equalsIgnoreCase("quit")) {
					//关闭操作，进行资源的释放
					stop();
					out.println("disconnect");
					break;
					
				}
				System.out.println(name+":"+str);
				out.println("Receive:"+str);
			}
			
		}
	
		private void stop() {
			System.out.println(name+"已经离开了");
			flag = false;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					if (!flag) break;
					receive();
				}
			} catch (SocketException e) {
				stop();
			    System.out.println(name+"已经非正常离开了");
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(s!=null) s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

}
