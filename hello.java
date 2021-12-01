package hello;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JList;



import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Category{
 	String val;
 	 
 	 Category(String s){
 	 	val=s;}
 	 	}
 class Topic{
 	String val;
 	 
 	 Topic(String s){
 	 	val=s;}
 	 	}
 	class Tag{
 	String val;
 	 
 	 Tag(String s){
 	 	val=s;}
 	 	}	
 	 	
    class Document{
    	
	String data;
  Category category;
  Topic topic;
  Tag tag;
  
  Document(String s,Category c,Topic to,Tag t){
  	
  	data=s;
  	category=c;
  	topic=to;
  	tag=t;}
  	
  void display(){
 
  	}
  }
public class hello {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hello window = new hello();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public hello() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Newdoc ac= new Newdoc();
				ac.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(131, 41, 165, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSearch = new JButton("Search by category");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Searchdoc ac= new Searchdoc();
				ac.setVisible(true);
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(131, 85, 165, 23);
		frame.getContentPane().add(btnSearch);
		
		JButton btnNewButton_1 = new JButton("Search by topic");
           btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Searchtopic ac= new Searchtopic();
				ac.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(131, 130, 165, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search by tag");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Searchtag ac= new Searchtag();
				ac.setVisible(true);
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(131, 180, 165, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}