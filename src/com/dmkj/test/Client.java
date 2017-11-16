package com.dmkj.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket s = null;
		BufferedReader sbr = null;
		try {
			s = new Socket("127.0.0.1",5858);
			PrintWriter out = new PrintWriter(s.getOutputStream(),true);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			sbr = new BufferedReader(new InputStreamReader(System.in));
			String str = null;
			while((str=sbr.readLine())!=null) {
				out.println(str);
				String rs = br.readLine();
				System.out.println(rs);
				if(rs.equalsIgnoreCase("disconnect")) {
					break;
				}
				
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(s!=null) s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(sbr!=null) sbr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	
	}
}
