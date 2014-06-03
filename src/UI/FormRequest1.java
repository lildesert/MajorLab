package UI;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FormRequest1 extends JFrame {

	private JPanel contentPane;
	private JList lbCoAuthor;
	private JList lbAuthor;
	private DefaultListModel dlmCoAuth;
	private JTextField tbYearStart;
	private JTextField tbYearEnd;
	private JComboBox cbType;

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
		setBounds(100, 100, 613, 397);
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
		btnRetour.setBounds(498, 325, 89, 23);
		contentPane.add(btnRetour);

		UserStory2 us2 = new UserStory2();
		List<String> authList = us2.getAuthor("");

		JButton btnLancerRequte = new JButton("Launch Request");
		btnLancerRequte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlmCoAuth.clear();

				String authSelected = lbAuthor.getSelectedValue().toString();

				Queries queries = new Queries();
				Map<String, Integer> result = new HashMap<String, Integer>();

				if (!tbYearStart.getText().isEmpty()
						&& !tbYearEnd.getText().isEmpty()) {
					if (cbType.getSelectedIndex() == 0) {
						result = queries.getNumberOfAuthorAppearancesPerYear(
								"", authSelected, tbYearStart.getText(),
								tbYearEnd.getText());
					} else {
						JOptionPane
								.showMessageDialog(contentPane,
										"You have to choose between Year and Publication type params");
						tbYearEnd.setText("");
						tbYearStart.setText("");
						cbType.setSelectedIndex(0);
					}
				} else if (cbType.getSelectedIndex() != 0) {
					if (tbYearStart.getText().isEmpty()
							&& tbYearEnd.getText().isEmpty()) {
						result = queries
								.getNumberOfAuthorAppearancesPerPublicationType(
										"", authSelected, cbType
												.getSelectedItem().toString());
					} else {
						JOptionPane
								.showMessageDialog(contentPane,
										"You have to choose between Year and Publication type params");
						tbYearEnd.setText("");
						tbYearStart.setText("");
						cbType.setSelectedIndex(0);
					}
				} else {
					result = queries.getNumberOfAuthorAppearances("",
							authSelected);
				}

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
		btnLancerRequte.setBounds(229, 258, 132, 23);
		contentPane.add(btnLancerRequte);

		JLabel lblF = new JLabel("FormRequest 1");
		lblF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setBounds(249, 11, 89, 23);
		contentPane.add(lblF);

		dlmCoAuth = new DefaultListModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 56, 145, 147);
		contentPane.add(scrollPane);

		lbAuthor = new JList(authList.toArray());
		scrollPane.setViewportView(lbAuthor);
		lbAuthor.setValueIsAdjusting(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(355, 181, -78, -56);
		contentPane.add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(430, 56, 145, 147);
		contentPane.add(scrollPane_2);
		lbCoAuthor = new JList(dlmCoAuth);
		scrollPane_2.setViewportView(lbCoAuthor);

		JLabel lblParamtres = new JLabel("Params :");
		lblParamtres.setBounds(194, 56, 109, 32);
		contentPane.add(lblParamtres);

		JLabel lblAnne = new JLabel("Years");
		lblAnne.setBounds(278, 88, 104, 14);
		contentPane.add(lblAnne);

		tbYearStart = new JTextField();
		tbYearStart.setBounds(178, 125, 86, 20);
		contentPane.add(tbYearStart);
		tbYearStart.setColumns(10);

		tbYearEnd = new JTextField();
		tbYearEnd.setText("");
		tbYearEnd.setBounds(334, 125, 86, 20);
		contentPane.add(tbYearEnd);
		tbYearEnd.setColumns(10);

		JLabel lblStartYear = new JLabel("Start year :");
		lblStartYear.setBounds(178, 109, 86, 14);
		contentPane.add(lblStartYear);

		JLabel lblEndYear = new JLabel("End year :");
		lblEndYear.setBounds(334, 109, 86, 14);
		contentPane.add(lblEndYear);

		JLabel lblType = new JLabel("Publication type");
		lblType.setBounds(249, 156, 107, 14);
		contentPane.add(lblType);

		cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(new String[] { "",
				"inproceedings", "article", "book", "incollection" }));
		cbType.setBounds(216, 183, 155, 20);
		contentPane.add(cbType);

		JButton btnSeeCoauthors = new JButton("See co-authors");
		btnSeeCoauthors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String s = lbCoAuthor.getSelectedValue().toString()
							.split(" \\(")[0];
					UISingleton.getInstance().setCoAuthSelected(s);

					System.out.println("here");

					CoCoAuthor c = new CoCoAuthor();
					c.setVisible(true);
				} catch (NullPointerException e) {
					JOptionPane
					.showMessageDialog(contentPane,
							"No co-author selected");
				}
			}
		});
		btnSeeCoauthors.setBounds(430, 224, 145, 23);
		contentPane.add(btnSeeCoauthors);

		/*
		 * ListSelectionListener listSelectionListener = new
		 * ListSelectionListener() { public void valueChanged(ListSelectionEvent
		 * listSelectionEvent) {
		 * 
		 * JList list = (JList) listSelectionEvent.getSource(); String s =
		 * list.getSelectedValue().toString().split(" \\(")[0];
		 * UISingleton.getInstance().setCoAuthSelected(s);
		 * 
		 * System.out.println("here");
		 * 
		 * CoCoAuthor c = new CoCoAuthor(); c.setVisible(true); } };
		 * lbCoAuthor.addListSelectionListener(listSelectionListener);
		 */
	}
}
