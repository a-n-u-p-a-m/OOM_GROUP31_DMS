package hello;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import java.awt.Desktop;  
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import javax.swing.JButton;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;


public class Newdoc extends JFrame {
	
	public static List<Document> array = new ArrayList<Document>();
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newdoc frame = new Newdoc();
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
	
	public static void readFile(String fileAddress) {
		java.lang.reflect.Type Review_Type = new TypeToken<List<Document>>() {}.getType();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			JsonReader reader = new JsonReader(new FileReader(fileAddress));
			List<Document> array = gson.fromJson(reader, Review_Type);
			System.out.println(array.get(0).category.val);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public Newdoc() {
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
			//System.out.println(array.get(1).category.val);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String response;
		response=JOptionPane.showInputDialog("Enter extension");
		String new_extension=response;
		
		response=JOptionPane.showInputDialog("Enter Topic");
		String new_topic=response;
		
		response=JOptionPane.showInputDialog("Enter Category");
		String new_category=response;
		
		response=JOptionPane.showInputDialog("Enter Tag");
		String new_tag=response;
		
		String filename="D:\\project\\category\\"+new_topic+new_extension;
		
		Category cat1= new Category(new_category);
		Topic to1 = new Topic(new_topic);
		Tag ta1 = new Tag(new_tag);
		array.add(new Document(filename,cat1,to1,ta1));
		// array.remove(4);
		getJson(array);
		JButton btnNew_openButton = new JButton("OPEN THE FILE");
		btnNew_openButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				File file = new File(filename); //initialize File object and passing path as argument  
				boolean result;  
				try   
				{  
				result = file.createNewFile();  //creates a new file  
				if(result)      // test if successfully created a new file  
				{  
				System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
				}  
				else  
				{  
				System.out.println("File already exist at location: "+file.getCanonicalPath());  
				}  
				}   
				catch (IOException ex) 
				{  
			ex.printStackTrace();    //prints exception if any  
				}         
				{  
				try  
				{  
				//constructor of file class having file as argument  
				//File file = new File("C:\\Users\\iam2a\\Downloads\\investment.txt");   
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
		btnNew_openButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNew_openButton.setBounds(122, 60, 157, 46);
		contentPane.add(btnNew_openButton);
		
		JButton btnNewButton = new JButton("GO TO HOME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				hello ac= new hello();
				ac.frame.setVisible(true);
			}
		});
				btnNewButton.setBounds(122, 135, 157, 46);
		contentPane.add(btnNewButton);
	
		
	}
}
