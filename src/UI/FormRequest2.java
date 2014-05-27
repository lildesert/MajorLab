package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fr.dauphine.publications_analytics.src.UserStory2;

public class FormRequest2 extends JPanel {

	private JPanel contentPane;
	/**
	 * Create the panel.
	 */
	public FormRequest2() {

		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
			}
		});
		btnRetour.setBounds(335, 228, 89, 23);
		contentPane.add(btnRetour);
		
		UserStory2 us2 = new UserStory2();
		List<String> authList = us2.getAuthor("dblp_2.xml");
		
		JButton btnLancerRequte = new JButton("Lancer Requ\u00EAte");
		btnLancerRequte.setBounds(145, 101, 132, 23);
		contentPane.add(btnLancerRequte);
		
		JLabel lblF = new JLabel("FormRequest 1");
		lblF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblF.setHorizontalAlignment(SwingConstants.CENTER);
		lblF.setBounds(167, 11, 89, 23);
		contentPane.add(lblF);
		
		JList lbCoAuthor = new JList();
		lbCoAuthor.setBounds(301, 56, 123, 147);
		contentPane.add(lbCoAuthor);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 132, 147);
		contentPane.add(scrollPane);
		
		JList lbAuthor = new JList(authList.toArray());
		scrollPane.setViewportView(lbAuthor);
		lbAuthor.setValueIsAdjusting(true);
	}

}
