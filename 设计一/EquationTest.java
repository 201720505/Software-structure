public class EquationTest{
	public static void main(String[] arge){//����һ����ʽ���ʵ�壬��������һ�ٴβ���
		Equation e=new Equation();
		for(int i=0;i<100;i++){
			e.init();
			System.out.println(e.getMe());
			System.out.println(""+e.getFirst()+" "+e.getChars()+" "+e.getSecond());
			System.out.println(e.getAnswer()+"\n");
			
		}
	}
}