import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class E_Frame {
	TextArea Contents; //���� ���� ���
	Panel P1;//�ؽ�Ʈ ���� ����
	Panel P2;//��ư�� ����
	static Frame f;
	
	
	E_Frame(){
		f=new Frame("Encryption");
		f.setLayout(null);
		f.setSize(500,500);

		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();//ȭ���� ũ�⸦ ����

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
		Contents.setEditable(false); //���Ƿ� ���ۺҰ�
		P1.add(Contents);
		f.add(P1);
		
		P2=new Panel();
		P2.setSize(400,200);
		P2.setLocation(50,300);
		
		Button button1=new Button("���Ͽ���");
		Button button2=new Button("��ȣȭ �ϱ�");
		Button button3=new Button("��ȣȭ �ϱ�");
		
		P2.add(button1);
		P2.add(button2);
		P2.add(button3);
		
		f.add(P2);
		
		f.revalidate();// ��ü�� ��ġ�� �������� �ϱ����� ���
		
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
			
			
			if(name.equals("���Ͽ���")) {
				Contents.setText("");//�ؽ�Ʈâ �ʱ�ȭ
				
				FileDialog fileOpen=new FileDialog(f,"���Ͽ���",FileDialog.LOAD);
				fileOpen.setDirectory("D:\\"); //���� ���� ��� ����
				fileOpen.setVisible(true); //���� â ���� ���̰� ����
				path=fileOpen.getDirectory()+fileOpen.getFile(); //������ ��� �� �̸��� ��� ����
				
				
				try {
					fr=new FileReader(path);//���Ͽ� ��Ʈ�� ��ġ
					br=new BufferedReader(fr);//���� ��Ʈ���� ���� ��Ʈ�� ��ġ �б� �ӵ��� ���̱� ����
					
					String line="";
					for(int i=0; (line=br.readLine())!=null; i++) {
						Contents.append(line+"\n");
					}
					br.close();//���� ��Ʈ�� ���� Ȥ�ó� ���ۿ� ���� ���� �����͸� ��� ����س�
				}catch(IOException IE) {}
			}

			else if(name.equals("��ȣȭ �ϱ�")) {
				Frame Choice_E=new Frame("��ȣȭ ����");
				Toolkit tk=Toolkit.getDefaultToolkit();
				Dimension screenSize=tk.getScreenSize();//ȭ���� ũ�⸦ ����
				
				Panel P3=new Panel();
				P3.setLayout(new GridLayout(3,1,10,10));//��ư ��ġ ���̾ƿ� ��¡
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
						e.getWindow().dispose();//����â ����
					}
				});
				
				Choice_E.setSize(250,400);
				Choice_E.setLocation(screenSize.width/2+250,screenSize.height/2-250);
				Choice_E.setVisible(true);
				
			}

			else if(name.equals("��ȣȭ �ϱ�")) {

				Frame Choice_E2=new Frame("��ȣȭ ����");
				Toolkit tk=Toolkit.getDefaultToolkit();
				Dimension screenSize=tk.getScreenSize();//ȭ���� ũ�⸦ ����

				Panel P4=new Panel();
				P4.setLayout(new GridLayout(3,1,10,10));//��ư ��ġ ���̾ƿ� ��¡
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
						e.getWindow().dispose();//����â ����
					}
				});

				Choice_E2.setSize(250,400);
				Choice_E2.setLocation(screenSize.width/2+250,screenSize.height/2-250);
				Choice_E2.setVisible(true);

			}
		}
	}
}