package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnFormrequest = new JButton("FormRequest 1");
		btnFormrequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (UISingleton.getInstance().getXmlFile() == null) {
					JOptionPane.showMessageDialog(contentPane,
							"Please, select first a source file");
				} 
				else {
					setVisible(false);
					FormRequest1 f = new FormRequest1();
					f.setVisible(true);
				}
			}
		});
		btnFormrequest.setBounds(138, 108, 170, 23);
		contentPane.add(btnFormrequest);

		JButton btnChangeXmlSource = new JButton("Choose xml source");
		btnChangeXmlSource.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				ChangeXmlSource f = new ChangeXmlSource();
				f.setVisible(true);
			}
		});
		btnChangeXmlSource.setBounds(138, 63, 170, 23);
		contentPane.add(btnChangeXmlSource);

		JLabel lblPublicationAnalyticsMenu = new JLabel(
				"Publication Analytics Menu");
		lblPublicationAnalyticsMenu.setFont(new Font("Traditional Arabic",
				Font.PLAIN, 15));
		lblPublicationAnalyticsMenu.setBounds(138, 11, 184, 29);
		contentPane.add(lblPublicationAnalyticsMenu);
	}
}
