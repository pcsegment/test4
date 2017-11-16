package com.dmkj.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class myFrame extends JFrame {
	static String s[]={"RED","GREEN","BLUE","PINK","YELLOW","CYAN","GRAY"};
//	public final static Map map1 = new HashMap() {{    
//	    put("equipment1", "202.206.159.1");    
//	    put("equipment2", "202.206.159.1");    
//	    put("equipment3", "202.206.159.1"); 
//	    put("equipment4", "202.206.159.1"); 
//	    put("equipment5", "202.206.159.1"); 
//	    put("equipment6", "202.206.159.1"); 
//	}};  

	public static void main(String[] args) {
		myFrame();
		//new Server().startup();
	}
	
	 public static void myFrame() {
		JFrame jf1 = new JFrame();
		jf1.setLocation(200, 200);
		jf1.setSize(600, 400);
		jf1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		   Vector v=new Vector();
		   for(int i =1;i<11;i++) {
			   v.addElement("equipment"+i+":->not on line!");
		   }
	      
	       JList list1=new JList(v);
		   
		   
		   
		    //list1.setListData(s);
		   DefaultListModel listModel2 = new DefaultListModel(); 

//		   Iterator<Map.Entry<String, String>> iterator = map1.entrySet().iterator();
//	        while (iterator.hasNext()) {
//	            Map.Entry<String, String> entry = iterator.next();
//	            listModel2.addElement(entry.getKey()+":"+entry.getValue());
//	        }
		   
		   
		  // list1.setModel(listModel2); 
		   
		   int[] rows = new int[10];
		   for(int i=0;i<10;i++) {
			   rows[i]=i;
		   }
		   
		   list1.setCellRenderer(new MyRenderer(rows,Color.RED));
		   
		   JScrollPane jsp1 = new JScrollPane(list1);
		   
		   
		    JTextPane text=new JTextPane();
		    JScrollPane jsp2 = new JScrollPane(text);
		    
	        StyledDocument d=text.getStyledDocument();
	        
	        
	        SimpleAttributeSet attr_new = new SimpleAttributeSet();  
	        SimpleAttributeSet attr_old = new SimpleAttributeSet();
	        StyleConstants.setForeground(attr_old, Color.BLACK);
	        StyleConstants.setForeground(attr_new, Color.RED);
	        try {
				d.insertString(d.getLength(),"红色\n",attr_old);
				d.insertString(d.getLength(),"红色\n",attr_new);
				d.insertString(d.getLength(),"红色\n",attr_old);
			} catch (BadLocationException e) {
				e.printStackTrace();
			} 
		   
		   
		   JPanel jp1 = new JPanel();
		   JButton jb1 = new JButton("next");
		   jp1.add(jb1);
		   
		   jf1.add(jsp1, BorderLayout.WEST);

		   jf1.add(jsp2, BorderLayout.CENTER);
		   jf1.add(jp1,BorderLayout.SOUTH);
		   jf1.setVisible(true);
	}
	
	}
