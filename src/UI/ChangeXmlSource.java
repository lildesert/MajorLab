package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

public class ChangeXmlSource extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton openButton;
	private JButton saveButton;
	private JFileChooser fc;
	private JLabel lblFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeXmlSource frame = new ChangeXmlSource();
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
	public ChangeXmlSource() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		openButton = new JButton("Choose XML file...");
		openButton.addActionListener(this);
		openButton.setBounds(152, 108, 140, 23);

		lblFile = new JLabel();
		lblFile.setText(SetFileName(UISingleton.getInstance().getXmlFile()));
		lblFile.setBounds(82, 39, 342, 23);

		contentPane.add(openButton);
		contentPane.add(lblFile);
		FileSystemView vueSysteme = FileSystemView.getFileSystemView();
		// récupération des répertoires
		File defaut = vueSysteme.getDefaultDirectory();

		fc = new JFileChooser(defaut);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		contentPane.add(fc);
		
		JButton btnRetour = new JButton("Return");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home h = new Home();
				h.setVisible(true);
			}
		});
		btnRetour.setBounds(335, 228, 89, 23);
		contentPane.add(btnRetour);
	}

	public void actionPerformed(ActionEvent e) {

		// Handle open button action.
		if (e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(ChangeXmlSource.this);

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
