package awt.example4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class WindowClass extends JFrame {
	private int num=0;
	JLabel label1[] ;
	JButton [] btn;
	JTextField result;
	public WindowClass() {
		
		
		label1 = new JLabel[3];
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setSize(400, 120);
		panel.setLayout(new GridLayout(1,1));
		add(panel);
		label1[0] = new JLabel(num+"");
		label1[0].setHorizontalAlignment(JLabel.CENTER);
		label1[0].setFont(new Font(null, Font.BOLD, 30));
		panel.add(label1[0]);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setLocation(0, 120);
		panel2.setSize(400,100 );
		panel2.setLayout(new GridLayout(1,2,80,0));
		add(panel2);
		
		btn = new JButton[2];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton("");
			btn[i].setBounds(60+(i*170), 250, 50, 50);
			btn[i].setFont(new Font(null, Font.PLAIN, 30));
			panel2.add(btn[i]);
			
		}
		
		btn[0].setText("+");
		btn[1].setText("-");
		
		btn[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num++;
				label1[0].setText(num+"");
				result.setText("UP");
			}
		});
		btn[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				num--;
				label1[0].setText(num+"");
				result.setText("DOWN");
			}
		});
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setLocation(0,300);
		panel3.setSize(400, 100);
		
		
		result = new JTextField("Up / Down");
		result.setHorizontalAlignment(JTextField.CENTER);
		
		panel3.add(result);
		add(panel3);
	
		setSize(400, 400);	// 윈도우 크기 (폭, 높이)
		setLocation(0, 0);	// 윈도우 실행위치(0,0): 좌측 상단
		setVisible(true);	// 윈도우 시각화
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 닫기
	
	}
}
