import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
//import org.joda.time.*;


public class timer2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	int i=0;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timer2 frame = new timer2();
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
	public timer2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("00:00:00");
		label.setBounds(179, 71, 82, 16);
		contentPane.add(label);
	
		
		
		
		JButton btnStart = new JButton("start");
		//int i=0;
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timer t =new Timer(1000,new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{	
						
						SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
						String p = sdf.format(new java.util.Date());
					
						label.setText(sdf.format(new java.util.Date()));
						
						i++;
							System.out.println(i);
							if(i==10)
							{
								JOptionPane.showMessageDialog(null," TIME OUT ","TITLE",JOptionPane.WARNING_MESSAGE);
								dispose();
							}
						}
					
				}
				

				);
				 t.start();
			}
		});
		btnStart.setBounds(190, 161, 97, 25);
		contentPane.add(btnStart);
	}

}
