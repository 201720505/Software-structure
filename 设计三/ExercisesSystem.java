import java.util.Scanner;
/**
 * ʵ������ϰ�⼯ϵͳ
 * */
public class ExercisesSystem {
	public static void main(String[] arge) {
		Exercises ex=new Exercises();
		Scanner s=new Scanner(System.in);
		System.out.println("��ѡ��\n1���������Ŀ \n2.���ļ�����");
		int chose=s.nextInt();
		if(chose==1) {
			ex.init(50);
		}else {
			System.out.println("�������ļ���:");
			s.nextLine();
			String name=s.nextLine();
			Files fp=new Files(name);
			
			ex.setList(fp.read());
			ex.setDone(fp.getDone());
			ex.setCorrect(fp.getCorrect());
		}
		ex.printAll(5);
		System.out.println("\n��ѡ��:\n1.��ʼ����(����������-1�˳�)\n2.������д�");
		chose=s.nextInt();
		if(chose==1) {
			while(ex.getDone()!=50) {
				System.out.println("��"+(ex.getDone()+1)+"�����("+ex.getEquation(ex.getDone())+"):");
				int userAnswer=s.nextInt();
				ex.setDone(ex.getDone()+1);
				if(userAnswer==-1) {
					System.out.println("�������˳�\n1.ȷ��������\n2.ȡ��");
					if(s.nextInt()==1) {
						System.out.println("�����뱣����ļ���:\n");
						s.nextLine();
						Files linfp=new Files(s.nextLine(),ex.getList());
						linfp.setCorrect(ex.getCorrect());
						linfp.setDone(ex.getDone()-1);
						linfp.write();
						System.out.println("\n����ɹ�!\n");
						break;	
					}
				}
				else if(userAnswer==ex.getEquation(ex.getDone()-1).getAnswer()) {
					ex.setCorrect(ex.getCorrect()+1);
					System.out.println("\n�ش���ȷ!\n");
				}else {
					System.out.println("\n�ش����!\n");
				}
			}
			System.out.println("�����:"+ex.getCorrect()+"\n��ȷ��:"+(ex.getCorrect()/50.0));
		}else {
			ex.printAnswer(5);
		}
		s.close();
		
	}
}
