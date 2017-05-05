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
import com.jcraft.jsch.*;
public class Frame1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
  
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
				}
				textField.setEditable(true);
			}
		});
		
		comboBox.setBounds(12, 32, 123, 24);
		frame.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Select>", "IP address", "Ip List"}));
		
		JLabel lblIpSource = new JLabel("IP source");
		lblIpSource.setBounds(12, 5, 70, 15);
		frame.getContentPane().add(lblIpSource);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userIPInput();
			}

			private void userIPInput() {
				//validate and collect user input
				
			}
		});
		textField.getDocument().addDocumentListener(new MyDocumentListener());
		

		textField.setBounds(12, 68, 123, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 117, 114, 15);
		frame.getContentPane().add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 139, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 170, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 193, 114, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCommands = new JLabel("Commands");
		lblCommands.setBounds(315, 5, 100, 15);
		frame.getContentPane().add(lblCommands);
		
		textField_3 = new JTextField();
		textField_3.setBounds(260, 35, 155, 50);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(260, 190, 117, 25);
		frame.getContentPane().add(btnConnect);
		
		btnConnect.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
			//	if(textField_3)
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
			  
		      btnConnect.setEnabled(false);
		     }
		     else {
		       System.out.println("not interpreted as empty with a value of" + e.getDocument().getLength());
		    	 //loginButton.setEnabled(true);
		    }
	}
}
