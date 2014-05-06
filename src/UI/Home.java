package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnForm = new JButton("Form 1");
		btnForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormRequest1 f = new FormRequest1();
				frame.setVisible(false);
				f.setVisible(true);
			}
		});
		btnForm.setBounds(175, 80, 89, 23);
		frame.getContentPane().add(btnForm);
		
		JLabel lblAuthorCollaborations = new JLabel("Author Collaborations");
		lblAuthorCollaborations.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuthorCollaborations.setBounds(134, 11, 172, 44);
		frame.getContentPane().add(lblAuthorCollaborations);
	}
	
	public static void infoBox(String infoMessage, String location)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
    }
}
