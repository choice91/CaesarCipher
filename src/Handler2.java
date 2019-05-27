import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Handler2 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String name2=e.getActionCommand();
		
		String path2="";
		
		FileReader fr2=null;
		BufferedReader br2=null;
		FileWriter fw2=null;
		BufferedWriter bw2=null;
		
		if(name2.equals("CaesarCipher")) {
			FileDialog fileOpen=new FileDialog(E_Frame.f,"파일열기",FileDialog.LOAD);
			fileOpen.setDirectory("D:\\"); //파일 오픈 경로 지정
			fileOpen.setVisible(true); //파일 창 눈에 보이게 설정
			path2=fileOpen.getDirectory()+fileOpen.getFile(); //파일의 경로 및 이름을 얻기 위함
			
			
			try {
				fr2=new FileReader(path2);
				br2=new BufferedReader(fr2);
			
				
				String filename2=fileOpen.getFile();
				filename2=filename2.replace(".txt","_Encryption(Caesar).txt");//원본 파일 이름을 얻어서 암호문 파일 생성 위함
				File Fi2=new File("D:\\",filename2);
				Fi2.createNewFile();
				
				fw2=new FileWriter(Fi2);//새로 생성된 파일에 스트림 설치
				bw2=new BufferedWriter(fw2);//파일 스트림에 버퍼 스트림 설치
				
				String line="";
				for(int i=0; (line=br2.readLine())!=null; i++) {
					int offset =-546541;
				    String cipher = CaesarCipher.encryptCaesarCipher(line, offset);
					bw2.write(cipher+"\r\n");
				}
				br2.close();//입력 스트림 종료
				bw2.close();//출력 스트림 종료
			}catch(IOException IE) {}
		}
		
		
		
	}
}
