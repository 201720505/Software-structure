public class ExercisesTest{
	public static void main(String[] arge){//����һ����ʽ���ʵ�壬��������һ�ٴβ���
		Exercises e=new Exercises();
		for(int i=0;i<100;i++){
			System.out.println("");
			e.init();
			e.printAll();
			System.out.println("");
			e.printAll(5);
			System.out.println("");
			e.printAnswer();
			System.out.println("");
			e.printAnswer(5);
		}
	}
}