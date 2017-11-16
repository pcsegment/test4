package com.dmkj.test;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;

public class test1 extends JFrame {
JList list;
	
	public test1(){
		super("JList多列显示");
                                //文件数量：fileName.length / 3
		String[] fileName = new String[]{"随风飘去.txt", "1.02MB", "文本文件",
				"Java SE.pdf", "1.02MB", "pdf文件",
				"Java OOP.doc", "1.02MB", "Word文档",
				"Java EE.pdf", "1.02MB", "pdf文件",
				"Java ME.pdf", "1.02MB", "pdf文件"}; 		
		list = new JList(fileName);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);  //设置多行显示
		list.setVisibleRowCount(fileName.length / 3);    //设置行数
		this.setLayout(new FlowLayout());
		this.add(list);
		this.setSize(300, 300);
		this.setVisible(true);		
	}
	
	public static void main(String[] args) {
		new test1();
	}
}
