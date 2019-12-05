package awt.example1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WindowTest extends JFrame{
	int num=0;
	JLabel label;
	JButton btn1, btn2;
	JButton resetBtn;

	
	public WindowTest() {
		super("Counter");
		
		
		JPanel panel = new JPanel();
		panel.setSize(500, 300);
		add(panel);
		
		label = new JLabel(num+"");
		label.setSize(500,300);
		panel.add(label);
	
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setSize(300, 300);
		add(buttonPane);
		
		
		btn1 = new JButton("+");
		btn1.setSize(300, 150);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "+");
				num++;
				label.setText(num+"");
				
			}
		});
		
		btn2 = new JButton("-");
		btn2.setSize(300, 150);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, "-");
				num--;
				label.setText(num+"");
			}
		});
		
		
		resetBtn = new JButton("reset");
		resetBtn.setSize(300,300);
		resetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num = 0;
				label.setText(num+"");
			}
		});
		
		
		
		
		
		
		
		
		
		buttonPane.add(btn1);	
		buttonPane.add(btn2);	
		add(resetBtn);
		
		
		
		
		Container contentPane = getContentPane();
		
		contentPane.add(panel, BorderLayout.NORTH);	// 중간
		contentPane.add(buttonPane, BorderLayout.CENTER);	// 아래쪽
		contentPane.add(resetBtn, BorderLayout.SOUTH);	// 아래쪽
		
		
		
		setBounds(0, 0, 648, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		

		
	}
}