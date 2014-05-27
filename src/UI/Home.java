package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fr.dauphine.publications_analytics.src.UserStory2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import java.util.List;

public class Home implements ItemListener {

	private JFrame frame;
	private JPanel cards;
	
	final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
	
	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private void createAndShowGUI(Home window) {
        //Create and set up the window.
        frame = new JFrame("CardLayoutDemo");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        window.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public void addComponentToPane(Container pane) {
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        comboBoxPane.setBounds(100, 100, 450, 300);
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        //Create the "cards".
        JPanel formRequest1 = new JPanel();
        FillFormRequest1(formRequest1);
        
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(formRequest1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

	/**
	 * Create the application.
	 */
	public Home() {
		createAndShowGUI(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnForm = new JButton("Form 1");
		btnForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormRequest1 f = new FormRequest1();
				f.setVisible(true);
			}
		});
		btnForm.setBounds(175, 80, 89, 23);
		frame.getContentPane().add(btnForm);
		
		JLabel lblAuthorCollaborations = new JLabel("Author Collaborations");
		lblAuthorCollaborations.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAuthorCollaborations.setBounds(134, 11, 172, 44);
		frame.getContentPane().add(lblAuthorCollaborations);*/
	}
	
	public static void infoBox(String infoMessage, String location)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
    }
	
	public void FillFormRequest1(JPanel contentPane) {

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
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
