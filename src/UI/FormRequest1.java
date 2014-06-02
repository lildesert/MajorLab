package UI;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.SwingConstants;

import fr.dauphine.publications_analytics.src.UserStory2;
import fr.dauphine.publications_analytics_task4.src.Queries;

import java.awt.Font;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JScrollPane;

public class FormRequest1 extends JFrame {

	private JPanel contentPane;
	private JList lbCoAuthor;
	private JList lbAuthor;
	private DefaultListModel dlmCoAuth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRequest1 frame = new FormRequest1();
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
	public FormRequest1() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		UserStory2 us2 = new UserStory2();
		List<String> authList = us2.getAuthor("");

		JButton btnLancerRequte = new JButton("Launch Request");
		btnLancerRequte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlmCoAuth.clear();
				String authSelected = lbAuthor.getSelectedValue().toString();
				HashMap<String, Integer> result = new HashMap();
				Queries queries = new Queries();
				result = queries.getNumberOfAuthorAppearances("", authSelected);
				for (Entry<String, Integer> e : result.entrySet()) {
					String key = e.getKey();
					Object value = e.getValue();
					if (!key.equals(authSelected)) {
						dlmCoAuth.addElement(key + " (" + value.toString()
								+ ")");
					}
				}
			}
		});
		btnLancerRequte.setBounds(152, 100, 132, 23);
		contentPane.add(btnLancerRequte);

		JLabel lblF = new JLabel("FormRequest 1");
		lblF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setBounds(167, 11, 89, 23);
		contentPane.add(lblF);

		dlmCoAuth = new DefaultListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 132, 147);
		contentPane.add(scrollPane);

		lbAuthor = new JList(authList.toArray());
		scrollPane.setViewportView(lbAuthor);
		lbAuthor.setValueIsAdjusting(true);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(355, 181, -78, -56);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(304, 56, 120, 147);
		contentPane.add(scrollPane_2);
		lbCoAuthor = new JList(dlmCoAuth);
		scrollPane_2.setViewportView(lbCoAuthor);
	}
}
