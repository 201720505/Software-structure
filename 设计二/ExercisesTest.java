public class ExercisesTest{
	public static void main(String[] arge){
		Exercises e=new Exercises();
		e.init(50,0);//����50������
		e.printAll(5);
		e.printAnswer(5);
		e.init(50,1);//����50���ӷ�
		e.printAll(5);
		e.printAnswer(5);
		e.init(50);//����50�����
		e.printAll(5);
		e.printAnswer(5);
	}
}