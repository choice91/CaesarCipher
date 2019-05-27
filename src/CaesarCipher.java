public class CaesarCipher {
    public static String encryptCaesarCipher(String plaintext, int offset)
    {
        if(offset >= 26 || offset <= -26)
        {
            offset = offset % 26;
        }

        if(offset == 0)
        {
            return plaintext;
        }

        String s = ""; //리턴값 반환을 위한 변수
        char ch; //newChNum을 s에 저장하기 위한 변수
        int chNum; //문자열의 문자를 받기 위한 변수
        int newChNum;//chNum 변환위한 변수

        for(int i = 0; i < plaintext.length(); i++)
        {
            if(plaintext.charAt(i) != 32 && plaintext.charAt(i) !=9) //띄어쓰기와 들여쓰기 제외
            {
                chNum = plaintext.charAt(i);
                newChNum = chNum + offset;

                if(newChNum > 126)
                {
                    newChNum -= 93;
                }

                if(newChNum < 33)
                {
                    newChNum += 93;
                }
                ch = (char)newChNum;

                s += ch;
            }
            else
            {
            	if(plaintext.charAt(i) == 32)
            		s += " ";
            	else
            		s +="	";
            }
        }
        return s;
    }
}


