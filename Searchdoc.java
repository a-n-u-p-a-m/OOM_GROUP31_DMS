package hello;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import javax.swing.JButton;

public class Searchdoc extends JFrame {
	public static List<Document> array = new ArrayList<Document>();
	
	int i,s;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchdoc frame = new Searchdoc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	private class PageActionListener implements ActionListener{
		private int p;
		
		public PageActionListener(int x) {
			this.p=x;
		}
		
		public void actionPerformed(ActionEvent e) {
			Searchfile ac= new Searchfile(p);
			ac.setVisible(true);
		}
	}
	/**
	 * Create the frame.
	 */
	public Searchdoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String fileAddress = "D:\\json\\staff.json";
		java.lang.reflect.Type Review_Type = new TypeToken<List<Document>>() {}.getType();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileAddress));
			 array = gson.fromJson(reader, Review_Type);
			// System.out.println(array.get(2).category.val);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String response;
		
		
		
		response=JOptionPane.showInputDialog("Enter Category");
		String new_category=response;
		int x=20;s=0;
		for(i=0;i<array.size();i++) {
			//	System.out.println(new_topic);
				String a = array.get(i).category.val;
				
				if(a.equals(new_category)) {
					// System.out.println(new_topic);
					JButton btnNewButton = new JButton(array.get(i).topic.val);				
					btnNewButton.addActionListener(new PageActionListener(i));
					
							
							
							
					btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
					btnNewButton.setBounds(131, x, 165, 23);
					contentPane.add(btnNewButton);
					x=x+35;
				}
			}
		
	}
}
