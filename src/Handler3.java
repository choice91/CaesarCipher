import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class Handler3 implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String name3=e.getActionCommand();
		
		String path3="";
		
		FileReader fr3=null;
		BufferedReader br3=null;
		FileWriter fw3=null;
		BufferedWriter bw3=null;
		
		if(name3.equals("CaesarCipher")) {
			FileDialog fileOpen=new FileDialog(E_Frame.f,"파일열기",FileDialog.LOAD);
			fileOpen.setDirectory("D:\\"); //파일 오픈 경로 지정
			fileOpen.setVisible(true); //파일 창 눈에 보이게 설정
			path3=fileOpen.getDirectory()+fileOpen.getFile(); //파일의 경로 및 이름을 얻기 위함
			
			
			try {
				fr3=new FileReader(path3);
				br3=new BufferedReader(fr3);
			
				
				String filename3=fileOpen.getFile();
				filename3=filename3.replace("_Encryption(Caesar).txt","_Decryption(Caesar).txt");//원본 파일 이름을 얻어서 암호문 파일 생성 위함
				File Fi2=new File("D:\\",filename3);
				Fi2.createNewFile();
				
				fw3=new FileWriter(Fi2);//새로 생성된 파일에 스트림 설치
				bw3=new BufferedWriter(fw3);//파일 스트림에 버퍼 스트림 설치
				
				String line="";
				for(int i=0; (line=br3.readLine())!=null; i++) {
					int offset =546541;
				    String cipher = CaesarCipher.encryptCaesarCipher(line, offset);
					bw3.write(cipher+"\r\n");
				}
				br3.close();//입력 스트림 종료
				bw3.close();//출력 스트림 종료
			}catch(IOException IE) {}
		}
	}
}