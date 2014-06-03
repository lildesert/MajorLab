package UI;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

import fr.dauphine.publications_analytics_task4.src.Queries;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoCoAuthor extends JFrame {

	private JPanel contentPane;
	private DefaultListModel dlmCocoAuth;
	private Map<String, Integer> result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoCoAuthor frame = new CoCoAuthor();
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
	public CoCoAuthor() {
		setBounds(100, 100, 226, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 27, 159, 190);
		contentPane.add(scrollPane_1);

		dlmCocoAuth = new DefaultListModel();

		JList lbCocoAuth = new JList(dlmCocoAuth);
		scrollPane_1.setViewportView(lbCocoAuth);

		Queries queries = new Queries();
		result = new HashMap<String, Integer>();
		result = queries.getNumberOfAuthorAppearances("", UISingleton
				.getInstance().getCoAuthSelected());

		for (Entry<String, Integer> e : result.entrySet()) {
			String key = e.getKey();
			Object value = e.getValue();
			if (!key.equals(UISingleton.getInstance().getCoAuthSelected())) {
				dlmCocoAuth.addElement(key + " (" + value.toString() + ")");
			}
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 46, 147, 173);
		contentPane.add(scrollPane);

		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlmCocoAuth.clear();
				setVisible(false);
				// FormRequest1 f = new FormRequest1();
				// f.setVisible(true);
			}
		});
		btnReturn.setBounds(59, 231, 89, 23);
		contentPane.add(btnReturn);

	}
}
