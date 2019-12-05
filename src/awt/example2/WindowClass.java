package awt.example2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowClass extends JFrame {
	
		int win =0;
		int lose =0;
		int draw =0;
		
		int rNum=0;
		
		JLabel board;
		JLabel player, com;
		JTextField resultView;
		JTextField playerView, comView;
		JButton bt1, bt2, bt3;
		
		public WindowClass() {
			
			
			super("가위바위보");
			
			JPanel bPanel = new JPanel();
			
			
			board = new JLabel();
			bPanel.setSize(600,50);
			bPanel.setLocation(0, 20);
			board.setText(win+"승 " + lose +"패 " + draw + "무 ");
			board.setFont(new Font(null, Font.BOLD, 20));
			board.setLocation(0, 0);
			bPanel.add(board);
			add(bPanel);
			
			// 플레이어 + 컴 
			JPanel names = new JPanel();
			names.setLayout(new GridLayout(1,2));
			names.setSize(600, 50);
			names.setLocation(0, 50);
			
			player = new JLabel("Player");
			player.setHorizontalAlignment(JLabel.CENTER);
			
			com = new JLabel("Com");
			com.setHorizontalAlignment(JLabel.CENTER);
			names.add(player);
			names.add(com);
			
			add(names);
			
			// 낸 것 표시

			JPanel result = new JPanel();
			result.setSize(400, 50);
			result.setLocation(100, 100);
			result.setLayout(new GridLayout(1,3));
			resultView = new JTextField("-");
			resultView.setFont(new Font("Candara", Font.PLAIN, 20));
			resultView.setHorizontalAlignment(JTextField.CENTER);
			comView = new JTextField("컴퓨터");
			comView.setHorizontalAlignment(JTextField.CENTER);
			playerView = new JTextField("나");
			playerView.setHorizontalAlignment(JTextField.CENTER);
			
			result.add(playerView);
			result.add(resultView);
			result.add(comView);
			
			add(result);
			
			
			
			
			JPanel btns = new JPanel();
			//가위1 바위2 보3
			
			bt1 = new JButton("가위");
			bt1.setSize(600, 100);
			bt1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					rNum = (int)(Math.random()*3)+1;
					playerView.setText("가위");
					if(rNum == 1) {
						comView.setText("가위");
						resultView.setText("Draw");
						draw++;
						
					}else if(rNum ==2){
						comView.setText("바위");
						resultView.setText("Lose");
						lose++;
					}else {
						comView.setText("보");
						resultView.setText("Win");
						win++;
					}
					
					board.setText(win+"승 " + lose +"패 " + draw + "무");
				}
			});
			bt2 = new JButton("바위");
			bt2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					rNum = (int)(Math.random()*3)+1;
					playerView.setText("바위");
					if(rNum == 1) {
						comView.setText("가위");
						resultView.setText("Win");
						win++;
					}else if(rNum ==2){
						comView.setText("바위");
						resultView.setText("Draw");
						draw++;
					}else {
						comView.setText("보");
						resultView.setText("Lose");
						lose++;
					}
					board.setText(win+"승 " + lose +"패 " + draw + "무");
				}
			});
			bt2.setSize(100, 50);
			bt3 = new JButton("보");
			bt3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					rNum = (int)(Math.random()*3)+1;
					playerView.setText("보");
					if(rNum == 1) {
						comView.setText("가위");
						resultView.setText("Lose");
						lose++;
					}else if(rNum ==2){
						comView.setText("바위");
						resultView.setText("Win");
						win++;
					}else {
						comView.setText("보");
						resultView.setText("Draw");
						draw++;
					}
					board.setText(win+"승 " + lose +"패 " + draw + "무");
				}
			});
			bt3.setSize(100, 50);
			
			btns.add(bt1);
			btns.add(bt2);
			btns.add(bt3);
			
			
			
			
			
			
			
			add(btns);
			
			
			
			// container 이용해서 Layout 잡기
			Container contentPane = getContentPane();
			
			contentPane.add(btns, BorderLayout.SOUTH);
			
			
			
			
			setSize(640, 300);	// 윈도우 크기 (폭, 높이)
			setLocation(0, 0);	// 윈도우 실행위치(0,0): 좌측 상단
			setVisible(true);	// 윈도우 시각화
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 닫기
		
		}
		
		
	
}
