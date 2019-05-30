import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class E_Frame {
	TextArea Contents; //파일 내용 출력
	Panel P1;//텍스트 에어리어만 담음
	Panel P2;//버튼만 담음
	static Frame f;
	
	
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
		
		
		Contents=new TextArea(10,50);
		Contents.setEditable(false); //임의로 조작불가
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
		
		f.revalidate();// 객체의 위치를 재저으이 하기위해 사용
		
		button1.addActionListener(new Handler());
		button2.addActionListener(new Handler());
		button3.addActionListener(new Handler());
	}
	
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String name=e.getActionCommand();
			String path="";
			
			FileReader fr=null;
			BufferedReader br=null;
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			
			if(name.equals("파일열기")) {
				Contents.setText("");//텍스트창 초기화
				
				FileDialog fileOpen=new FileDialog(f,"파일열기",FileDialog.LOAD);
				fileOpen.setDirectory("D:\\"); //파일 오픈 경로 지정
				fileOpen.setVisible(true); //파일 창 눈에 보이게 설정
				path=fileOpen.getDirectory()+fileOpen.getFile(); //파일의 경로 및 이름을 얻기 위함
				
				
				try {
					fr=new FileReader(path);//파일에 스트림 설치
					br=new BufferedReader(fr);//파일 스트림에 버퍼 스트림 설치 읽기 속도를 높이기 위해
					
					String line="";
					for(int i=0; (line=br.readLine())!=null; i++) {
						Contents.append(line+"\n");
					}
					br.close();//버퍼 스트림 종료 혹시나 버퍼에 남아 있을 데이터를 모두 출력해냄
				}catch(IOException IE) {}
			}

			else if(name.equals("암호화 하기")) {
				Frame Choice_E=new Frame("암호화 선택");
				Toolkit tk=Toolkit.getDefaultToolkit();
				Dimension screenSize=tk.getScreenSize();//화면의 크기를 구함
				
				Panel P3=new Panel();
				P3.setLayout(new GridLayout(3,1,10,10));//버튼 배치 레이아웃 설징
				Button button4=new Button("CaesarCipher");
				Button button5=new Button("TripleDES");
				Button button6=new Button("AES");
				
				button4.addActionListener(new Handler2());
				button5.addActionListener(new Handler2());
				button6.addActionListener(new Handler2());
				
				P3.add(button4);
				P3.add(button5);
				P3.add(button6);
				
				Choice_E.add(P3);
				
				Choice_E.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						e.getWindow().dispose();//선택창 제거
					}
				});
				
				Choice_E.setSize(250,400);
				Choice_E.setLocation(screenSize.width/2+250,screenSize.height/2-250);
				Choice_E.setVisible(true);
				
			}

			else if(name.equals("복호화 하기")) {

				Frame Choice_E2=new Frame("복호화 선택");
				Toolkit tk=Toolkit.getDefaultToolkit();
				Dimension screenSize=tk.getScreenSize();//화면의 크기를 구함

				Panel P4=new Panel();
				P4.setLayout(new GridLayout(3,1,10,10));//버튼 배치 레이아웃 설징
				Button button7=new Button("CaesarCipher");
				Button button8=new Button("TripleDES");
				Button button9=new Button("AES");

				button7.addActionListener(new Handler3());
				button8.addActionListener(new Handler3());
				button9.addActionListener(new Handler3());

				P4.add(button7);
				P4.add(button8);
				P4.add(button9);

				Choice_E2.add(P4);

				Choice_E2.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						e.getWindow().dispose();//선택창 제거
					}
				});

				Choice_E2.setSize(250,400);
				Choice_E2.setLocation(screenSize.width/2+250,screenSize.height/2-250);
				Choice_E2.setVisible(true);

			}
		}
	}
}


