import java.util.Random;
public class Equation{
	int first;
	int second;
	int chars;
	public void init(){//���������
		Random r=new Random();
		first=r.nextInt(101);
		second=r.nextInt(101);
		chars=r.nextInt(2);
	}
	public int getFirst(){//��ȡ��һ����
		return first;
	}
	public int getSecond(){//��ȡ�ڶ�����
		return second;
	}
	public int getChars(){//��ȡ����
		return chars;
	}
	public String getMe(){//��ȡ��ʽ
		if(chars==0)
			return ""+first+"-"+second;
		else
			return ""+first+"+"+second;
	}
	public int getAnswer(){//��ȡ��
		if(chars==0)
			return first-second;
		else
			return first+second;
	}
}