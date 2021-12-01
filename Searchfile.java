package hello;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Searchfile extends JFrame {
	public static List<Document> array = new ArrayList<Document>();
	private JPanel contentPane;
    
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchfile frame = new Searchfile(2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void getJson(List<Document> user) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			FileWriter writer = new FileWriter("D:\\json\\staff.json");
			gson.toJson(user, writer);
			writer.close();
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Create the frame.
	 */
	public Searchfile(int i) {
		
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
			System.out.println(array.get(2).category.val);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		JButton btnNewButton = new JButton("OPEN");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				{  
					try  
					{  
					//constructor of file class having file as argument  
					File file = new File(array.get(i).data);   
					if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
					{  
					System.out.println("not supported");  
					return;  
					}  
					Desktop desktop = Desktop.getDesktop();  
					if(file.exists())         //checks file exists or not  
					desktop.open(file);              //opens the specified file  
					}  
					catch(Exception exd)
					{  
					exd.printStackTrace();
					}  
					}  
				
			}
		});
		btnNewButton.setBounds(141, 46, 136, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// System.out.println(i);
				 array.remove(i);
			 	getJson(array);
			 	System.out.println("Deleted Succesfully");
			 	hello ac= new hello();
				ac.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(141, 140, 136, 52);
		contentPane.add(btnNewButton_1);
	}
}
