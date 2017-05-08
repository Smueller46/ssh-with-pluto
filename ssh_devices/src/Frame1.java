import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.jcraft.jsch.*;
public class Frame1 {

	private JFrame frame;
	private JTextField textFieldIP;
	private JTextField textFieldUsername;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private File file;
	static String username = null, password = null, commands = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			});
	
		//connect(username,password,commands);
		
	}

	private static void connect(String username, String password, String commands) {
		
		
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "Ip List") {
					System.out.println("ip list selected");
					JFileChooser fileChoice = new JFileChooser();
					int returnVal = fileChoice.showOpenDialog(comboBox);
					if (returnVal == JFileChooser.APPROVE_OPTION)
					{
						
						file = fileChoice.getSelectedFile();
						System.out.println("opening" + file.getName());
						
						
					}
					}
				else if (comboBox.getSelectedItem() == "IP address") 
					textFieldIP.setEditable(true);;
			}
		});
		
		comboBox.setBounds(12, 32, 123, 24);
		frame.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "IP address", "Ip List"}));
		
		JLabel lblIpSource = new JLabel("IP source");
		lblIpSource.setBounds(12, 5, 70, 15);
		frame.getContentPane().add(lblIpSource);
		
		textFieldIP = new JTextField();
		textFieldIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//}

			//private void userIPInput() {
			
				String IP_addr = textFieldIP.getText();
			System.out.println(textFieldIP.getText());
				
			//}
		}});
		
		

		textFieldIP.setBounds(12, 68, 123, 37);
		frame.getContentPane().add(textFieldIP);
		textFieldIP.setColumns(10);
		textFieldIP.setEditable(false);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 117, 114, 15);
		frame.getContentPane().add(lblUsername);
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(12, 139, 114, 19);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		textFieldUsername.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			username = textFieldUsername.getText();
			}
			
		});
		textFieldUsername.getDocument().addDocumentListener(new MyDocumentListener());
		//textField_1.getDocument().addDocumentListener(new MyDocumentListener());
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 170, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblCommands = new JLabel("Commands");
		lblCommands.setBounds(290, 5, 100, 15);
		frame.getContentPane().add(lblCommands);
		
		textField_3 = new JTextField();
		textField_3.addActionListener(new ActionListener() {
			//get commands seperated by commas
			public void actionPerformed(ActionEvent arg0) {
				String commands = textField_3.getText();
				if (commands.contains(",")) {
				
					String[] commandsArray = commands.split(",");
					
			}
		}});
		textField_3.setBounds(260, 20, 155, 50);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(260, 190, 117, 25);
		frame.getContentPane().add(btnConnect);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
			}
		});
		passwordField.setBounds(12, 193, 94, 19);
		frame.getContentPane().add(passwordField);
		
		btnConnect.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			System.out.println(username);
			}
		});
		
	
	}
	
	}


class MyDocumentListener implements DocumentListener {
	public void changedUpdate(DocumentEvent e) {
		changed(e);
		
	}
	public void removeUpdate(DocumentEvent e) {
		changed(e);
	}
	public void insertUpdate(DocumentEvent e) {
		changed(e);
	}
	public void changed(DocumentEvent e) {
		  if (e.getDocument().getLength() == 0){
			  System.out.println(" input interpreted as empty");
			  
		     // btnConnect.setEnabled(false);
		     }
		     else {
		       System.out.println("not interpreted as empty with a value of" + e.getDocument().getLength());
		    	 //loginButton.setEnabled(true);
		    }
	}
}
