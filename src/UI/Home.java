package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

public class Home extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton openButton;
	private JFileChooser fc;
	private JLabel lblFile;

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
		btnFormrequest.setBounds(138, 172, 170, 23);
		contentPane.add(btnFormrequest);
		
		openButton = new JButton("Choose XML file...");
		openButton.addActionListener(this);
		openButton.setBounds(10, 61, 140, 23);

		lblFile = new JLabel();
		lblFile.setText(SetFileName(UISingleton.getInstance().getXmlFile()));
		lblFile.setBounds(20, 95, 342, 23);

		contentPane.add(openButton);
		contentPane.add(lblFile);
		FileSystemView vueSysteme = FileSystemView.getFileSystemView();
		// récupération des répertoires
		File defaut = vueSysteme.getDefaultDirectory();

		fc = new JFileChooser(defaut);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		contentPane.add(fc);

		JLabel lblPublicationAnalyticsMenu = new JLabel(
				"Publication Analytics Menu");
		lblPublicationAnalyticsMenu.setFont(new Font("Traditional Arabic",
				Font.PLAIN, 15));
		lblPublicationAnalyticsMenu.setBounds(138, 11, 184, 29);
		contentPane.add(lblPublicationAnalyticsMenu);
	}
	
	public void actionPerformed(ActionEvent e) {

		// Handle open button action.
		if (e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(Home.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				UISingleton.getInstance().setXmlFile(fc.getSelectedFile());
				lblFile.setText(SetFileName(UISingleton.getInstance().getXmlFile()));
			}
		}
	}
	
	private String SetFileName(File f)
	{
		String fileName = "File used : ";
		if (f != null) {
			fileName += UISingleton.getInstance().getXmlFile().getName();
		}
		else
		{
			fileName += "None";
		}
		
		return fileName;
	}
}
