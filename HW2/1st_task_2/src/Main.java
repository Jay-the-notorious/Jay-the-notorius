import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> pop_list = new ArrayList<Integer>(); //pop�� ���ڵ��� ��Ƽ� ���� pop�� ���ڰ� ������ 'no'��ȯ
		int[] Stack = new int[100];
		int top = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("�ݺ�Ƚ�� �Է�: ");
		int a = sc.nextInt();
		int count = 0;
		while (count<=a) {
			System.out.println("pop�� �����Է�: ");
			int n = sc.nextInt();
			if (top == 0) {			//���ÿ� �ƹ� �� ���� ��
				for(int i=1; i<n+1; i++) {
					Stack[i] = i;
					System.out.println("+");
					top++;
				}
				pop_list.add(Stack[top]);
				top--;
				System.out.println('-');
			}
			else if(Stack[top]<n) { //�Է¹��� ���ڰ� ž�� ������ Ŭ��(�����߰��ϰ� ������ pop)	
				if(pop_list.contains(n) == true) {	//���� ���� �˸���Ʈ�� ������ 'no'���
					System.out.println("No");	
				}
				else { //���ÿ� �����߰��ϰ� �������� pop
					
				}
			}
			else if(Stack[top]>n) {//�Է¹��� ���ڰ�  top�� ������ ���� ��(�̹� �ִ� �����ȿ��� pop);
				if(pop_list.contains(n) == true) {	//���� ���� �˸���Ʈ�� ������ 'no'���
					System.out.println("No");
				}
				else { // ���ϴ� ���ڱ��� pop 		
				}
			}
		count++;			
		}
		
	}
}
