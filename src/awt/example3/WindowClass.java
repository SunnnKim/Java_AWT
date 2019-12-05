package awt.example3;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WindowClass extends JFrame {
	
	int rNum[] = new int[3];
	int uNum[] = new int[3];
	int ball=0;
	int strike=0;
	int chance =0;
	JLabel title;
	JTextField num1, num2, num3;
	JTextField result;
	JTextField result2;
	JButton okBtn;
	JButton reset;
	
	public WindowClass() {

		super("Baseball game");
		setLayout(null);
		// 타이틀
		title = new JLabel("Baseball");
		title.setFont(new Font(null, Font.PLAIN, 30));
		title.setSize(500,70);
		title.setLocation(20, 10);
		add(title);
		
		num1 = new JTextField(2);
		num1.setHorizontalAlignment(JTextField.CENTER);
		num2 = new JTextField(2);
		num2.setHorizontalAlignment(JTextField.CENTER);
		num3 = new JTextField(2);
		num3.setHorizontalAlignment(JTextField.CENTER);
		num1.setSize(100, 50);
		num1.setLocation(20,100);
		num2.setSize(100, 50);
		num2.setLocation(140,100);
		num3.setSize(100, 50);
		num3.setLocation(260,100);
		
		add(num1);
		add(num2);
		add(num3);
		
		
		// result 창
		result = new JTextField("게임 시작");
		result.setHorizontalAlignment(JTextField.CENTER);
		result.setBounds(20, 200, 340, 30);
		result.setFont(new Font(null, Font.BOLD, 14));
		result.setEditable(false);
		add(result);
		
		result2 = new JTextField("남은 기회: 10번");
		result2.setHorizontalAlignment(JTextField.CENTER);
		result2.setBounds(20, 230, 340, 30);
		result2.setEditable(false);
		add(result2);
		
		okBtn = new JButton("확인");
		okBtn.setSize(340, 50);
		okBtn.setLocation(20, 320);
		add(okBtn);
		
		// 랜덤넘버 확인용
		rNum = createRNum();
		System.out.println(rNum[0]);
		System.out.println(rNum[1]);
		System.out.println(rNum[2]);
		
		
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(result.getText().equals("Game Clear") || result.getText().equals("Game Over")) {
					JOptionPane.showMessageDialog(null, "게임이 이미 끝났습니다.");
					return;
				}
				
				try {
					uNum[0] = Integer.parseInt(num1.getText());
					uNum[1] = Integer.parseInt(num2.getText());
					uNum[2] = Integer.parseInt(num3.getText());
				} catch (Exception e2) {
					uNum[0] = uNum[1] = uNum[2] = -1;
				}
				// 입력 오류 처리
				if( uNum[0]==-1 ) {
					JOptionPane.showMessageDialog(null, "문자나 공백은 입력할 수 없습니다.");
					return;
				}
				if(uNum[0]==uNum[1]||uNum[0]==uNum[2]||uNum[1]==uNum[2]) {
					JOptionPane.showMessageDialog(null, "같은 수를 두번 이상 입력할 수 없습니다.");
					return;
				}
				
				if((uNum[0]>10 || uNum[0]<1)||(uNum[1]>10 || uNum[1]<1)||(uNum[2]>10 || uNum[2]<1)) {
					JOptionPane.showMessageDialog(null, "숫자를 잘못 입력했습니다.( 1~10까지 입력가능 )");
					return;
				}
			
				
				strike = strike();
				ball = ball();
				if(strike == 3) {
					result.setText("Game Clear");
					JOptionPane.showMessageDialog(null, "정답을 맞추셨습니다!!");
					return;
				}
			
				
				chance++;
				if(chance>10) {
					JOptionPane.showMessageDialog(null, "기회가 없습니다!");
					result.setText("Game Over");
					return;
				}
				result.setText(strike + "Strike, " + ball + "Ball. ");
				result2.setText("남은 기회 : "+ (10-chance)+"회");
				num1.setText("");
				num2.setText("");
				num3.setText("");
				num1.requestFocus();
			}

			
		});
		
		
		
		//reset Button
		 reset = new JButton("Reset");
		 
		 reset.setSize(70, 30);
		reset.setLocation(290,30);
		add(reset);
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rNum = createRNum();
				chance = 0;
				String str = "게임 다시 시작!"+"\n";
				str+= "남은 기회: "+(10-chance) + "회";
				result.setText(str);
			}
		});
	
		setSize(400, 450);	// 윈도우 크기 (폭, 높이)
		setLocation(0, 0);	// 윈도우 실행위치(0,0): 좌측 상단
		setVisible(true);	// 윈도우 시각화
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// 닫기
	}

	public int[] createRNum() {
		int[] num = new int[3];
		boolean b[]= new boolean[10];
		for (int i = 0; i < num.length; i++) {
			int r = (int)(Math.random()*10);
			while(b[r]) {
				r = (int)(Math.random()*10);
			}
			num[i] =r+1;
			b[r] = true;
		}		
		
		
		return num;
	}
	
	public int strike() {
		int s = 0;
		for (int i = 0; i < rNum.length; i++) {
			if(rNum[i] == uNum[i]) s++;
		}
		
		return s;
	}
	private int ball() {
		int b=0;
		for (int i = 0; i < rNum.length; i++) {
			for (int j = 0; j < rNum.length; j++) {
				if(rNum[i]== uNum[j] && j!=i) b++;
			}
		}
		return b;
	}
}


