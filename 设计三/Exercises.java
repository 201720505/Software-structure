import java.util.Random;
import java.util.ArrayList;
import java.util.List;
/**
 * ������汾�ж�ϰ����������ĸ����� getDone setDone setList getList getCorrect setCorrectΪ����ļ���д
 * */
public class Exercises{
	private int done=0;
	private int correct=0;
	private List<Equation> equs=new ArrayList<Equation>();//��¼��ʽ
	public int getDone() {//��ȡ���˼���
		return done;
	}
	public void setCorrect(int correct) {
		this.correct=correct;
	}
	public int getCorrect() {
		return correct;
	}
	public void setDone(int done) {//�����Ѿ����˼���
		this.done=done;
	}
	public void setList(List<Equation>list) {//������ʽ
		equs=list;
	}
	public List<Equation> getList(){//��ȡ��ʽ
		return equs;
	}
	public Equation getEquation(int index) {//��ȡһ����ʽ
		return equs.get(index);
	}
	public void init(int count){//��ʼ��������ʽcount������ʽ����
		equs.clear();
		Random r=new Random();
		int firstLin=0;
		int secondLin=0;
		char charsLin;
		for(int k=0;k<count;k++) {
			if(r.nextInt(2)==0) {
				charsLin='-';
			}else {
				charsLin='+';
			}
			Equation lin;
			if(charsLin=='+') {
				lin=new EquationAdd();
			}else {
				lin=new EquationReles();
			}
			firstLin=r.nextInt(101);
			secondLin=r.nextInt(101);
			lin.setEquation(firstLin, secondLin,charsLin);
			if(isBeing(lin.toString())||lin.getAnswer()>100||lin.getAnswer()<0) {
				k--;
				continue;
			}
			equs.add(lin);
		}
	}
	public int size() {
		return equs.size();
	}
	public void init(int count,char chars){//��ʼ��������ʽcount������ʽ���� charsL�������
		Random r=new Random();
		int firstLin=0;
		int secondLin=0;
		char charsLin=chars;
		for(int k=0;k<count;k++) {
			Equation lin;//��ʱ����
			if(chars=='+') {
				lin=new EquationAdd();
			}else {
				lin=new EquationReles();
			}
			firstLin=r.nextInt(101);
			secondLin=r.nextInt(101);
			lin.setEquation(firstLin, secondLin,charsLin);
			if(isBeing(lin.toString())||lin.getAnswer()>100||lin.getAnswer()<0) {
				k--;
				continue;
			}
			equs.add(lin);
		}
	}
	public char getChar(int index) {//��ȡһ����ʽ�Ǽӷ����Ǽ���
		return equs.get(index).getChars();
	}
	public boolean isBeing(String str) {//�ж�һ��ʽ���Ƿ��Ѿ�������������
		for(int k=0;k<equs.size();k++) {
			if(equs.toString().equals(str))
				return true;
		}
		return false;
	}
	public void printAll(){//������е�ʽ��
		System.out.format("\n*******************************************");
		System.out.format("\n**                 ϰ������                                        **");
		System.out.format("\n*******************************************\n");
		for(int k=0;k<equs.size();k++) {
			System.out.format("%7s  ",equs.get(k).toString());
		}
		
	}
	public void printAll(int turn){//������е�ʽ�� ÿ�����turn ��ʽ��
		System.out.format("\n*******************************************");
		System.out.format("\n**                 ϰ������                                        **");
		System.out.format("\n*******************************************");
		for(int k=0;k<equs.size();k++) {
			if(k%5==0)System.out.println();
			System.out.format("%7s  ",equs.get(k).toString());
		}
	}
	public void printAnswer(){//������д�
		System.out.format("\n*******************************************");
		System.out.format("\n**                 ������                                        **");
		System.out.format("\n*******************************************\n");
		for(int k=0;k<equs.size();k++) {
			System.out.format("% 3d  ",equs.get(k).getAnswer());
		}
	}
	public void printAnswer(int turn){//������д� ÿ�����turn ����
		System.out.format("\n*******************************************");
		System.out.format("\n**                 ������                                        **");
		System.out.format("\n*******************************************");
		for(int k=0;k<equs.size();k++) {
			if(k%5==0)System.out.println();
			System.out.format("% 3d  ",equs.get(k).getAnswer());
		}
	}
}