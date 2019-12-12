/**
 * �ļ�������
 * */
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class Files {
	private String name;
	private File fp;
	private int done;
	private int correct;//��¼�����˼���
	private int max;
	private List<Equation> equs=null;
	public Files(String name,List<Equation> equs) {//д�ļ��Ĺ��캯��
		this.name=name;
		this.equs=equs;
		max=equs.size();
		fp=new File(name);
		try {
			if(!fp.exists())//�ļ�����������򴴽�
				fp.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setCorrect(int correct) {
		this.correct=correct;
	}
	public int getCorrect() {
		return correct;
	}
	public void setDone(int done) {
		this.done=done;
	}
	public Files(String name) {//���ļ��Ĺ��캯��
		this.name=name;
		fp=new File(name);
		if(!fp.exists())
			try {
				throw new Exception("�ļ�������");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public List<Equation> read() {//���ļ�
		equs=new ArrayList<Equation>();
		equs.clear();
		int left;
		int right;
		char chars;
		Equation lin=null;
		try {
			Properties pro=new Properties();
			pro.load(new FileInputStream(name));
			max=Integer.parseInt(pro.getProperty("max"));
			done=Integer.parseInt(pro.getProperty("done"));
			correct=Integer.parseInt(pro.getProperty("correct"));
			for(int i=0;i<max;i++) {
				left=Integer.parseInt(pro.getProperty("left"+(i+1)));
				right=Integer.parseInt(pro.getProperty("right"+(i+1)));
				chars=pro.getProperty("chars"+(i+1)).charAt(0);
				if(chars=='+') {
					lin=new EquationAdd();;
					lin.setEquation(left, right, chars);
				}else {
					lin=new EquationReles();
					lin.setEquation(left, right, chars);
				}
				equs.add(lin);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return equs;
	}
	public void write() {//д����
		Properties pro=new Properties();
		try{
			pro.load(Files.class.getResourceAsStream(name));
		}catch(Exception e) {
			e.printStackTrace();
		}
		pro.setProperty("done", done+"");
		pro.setProperty("max", max+"");
		pro.setProperty("correct",correct+"");
		for(int i=0;i<max;i++) {
			pro.setProperty("left"+(i+1), equs.get(i).getFirst()+"");
			pro.setProperty("right"+(i+1), equs.get(i).getSecond()+"");
			pro.setProperty("chars"+(i+1), equs.get(i).getChars()+"");
		}
		try{
			pro.store(new FileOutputStream(name),"");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getDone() {
		return done;
	}
	
}
