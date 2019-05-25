import java.awt.*;
import java.awt.event.*;

public class E_Frame {
	TextArea Contents; //파일 내용 출력
	Panel P1;//텍스트 에어리어만 담음
	Panel P2;//버튼만 담음
	Frame f;
	
	
	E_Frame(){
		f=new Frame("Encryption");
		f.setLayout(null);
		f.setSize(500,500);

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();//화면의 크기를 구함

		f.setLocation(screenSize.width/2-250,screenSize.height/2-250);
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);	
			}
		});
		
		P1=new Panel();
		P1.setSize(400,200);
		P1.setLocation(50,50);
		
		
		Contents=new TextArea("내용 입력",10,50);
		P1.add(Contents);
		f.add(P1);
		
		P2=new Panel();
		P2.setSize(400,200);
		P2.setLocation(50,300);
		
		Button button1=new Button("파일열기");
		Button button2=new Button("암호화 하기");
		Button button3=new Button("복호화 하기");
		
		P2.add(button1);
		P2.add(button2);
		P2.add(button3);
		
		f.add(P2);
		
		f.revalidate();
		
		button1.addActionListener(new Handler());
		button2.addActionListener(new Handler());
		button3.addActionListener(new Handler());
	}
	
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name=e.getActionCommand();
			
			
			if(name.equals("파일열기")) {
				
				FileDialog fileOpen=new FileDialog(f,"파일열기",FileDialog.LOAD);
				fileOpen.setDirectory("C:\\");
				fileOpen.setVisible(true);
				
			}
			else if(name.equals("암호화 하기")) {
				
			}
			else if(name.equals("복호화 하기")) {
				
			}
		}
	}
}
