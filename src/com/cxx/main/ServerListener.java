package com.cxx.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while(true){
				//block
				Socket socket=serverSocket.accept();
				//建立链接
				JOptionPane.showMessageDialog(null, "有客户端链接到了本地服务器端口");
				//将socket传递给新线程
				ChatSocket cs=new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
