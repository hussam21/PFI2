package uppgift4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class DogsandHumansGUI extends JFrame {
	 private Human human;
	 private JTextArea textArea_1;
	 private JTextArea Error;
	 
	private JPanel contentPane;
	private JTextArea newHuman;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DogsandHumansGUI frame = new DogsandHumansGUI();
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
	public DogsandHumansGUI() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 101, 24);
		contentPane.add(scrollPane);
		
		newHuman = new JTextArea();
		scrollPane.setViewportView(newHuman);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 46, 101, 24);
		contentPane.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		
		
		JButton btnBuyDog = new JButton("Buy dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				human.buyDog(new Dog(textArea_1.getText()));
				}catch(Exception a){
					System.out.println("ingen human");
				}
				
			}
		});
		btnBuyDog.setBounds(150, 48, 89, 23);
		contentPane.add(btnBuyDog);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 126, 382, 50);
		contentPane.add(scrollPane_2);
		
		
		final JTextArea infoTextArea = new JTextArea();
		scrollPane_2.setViewportView(infoTextArea);

		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(22, 96, 46, 14);
		contentPane.add(lblInfo);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 201, 382, 50);
		contentPane.add(scrollPane_3);
		
		Error = new JTextArea();
		scrollPane_3.setViewportView(Error);
		
		JLabel lblError = new JLabel("Error");
		lblError.setBounds(22, 176, 46, 14);
		contentPane.add(lblError);
		
		
JButton btnNewButton = new JButton("New Human");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				human = new Human(newHuman.getText());
				
			}
		});
		btnNewButton.setBounds(150, 13, 89, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnGetInfo = new JButton("Print info");
		btnGetInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	System.out.println(human.getName());
				if(human == null ){
					 
					 Error.setText("Ange en korrekt human \n"); 
					 
					 
				 }else if(  human.getName()==null  ){ // mindre �n 3 bokst�ver
					 
					 Error.append("Ingen human \n");
				
				 }else if(human.dog ==null){ // mindre �n 3 bokst�ver
					 
					 Error.append("Ingen dog \n");
				
				 }else{
				
					 infoTextArea.setText(human.getInfo());
					 
				
				 Error.append(human.error);
			}
				// System.out.println(String.valueOf(human==null) +String.valueOf(human.dog==null) );
			
	 }
		});
		btnGetInfo.setBounds(150, 92, 89, 23);
		contentPane.add(btnGetInfo);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset(Error, infoTextArea, textArea_1, newHuman );
				
			}
		});
		btnReset.setBounds(297, 13, 89, 23);
		contentPane.add(btnReset);
		
		
		
		
		
	}
	
	private void reset(JTextArea Error,JTextArea infoTextArea,JTextArea textArea_1, JTextArea newHuman ){
	 	human=null;
	 	infoTextArea.setText("");
	 	Error.setText("");
	 	textArea_1.setText("");
	 	newHuman.setText("");
		
	}
	
}
