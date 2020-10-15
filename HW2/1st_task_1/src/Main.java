import java.util.Scanner;

public class Main {
	public static boolean gwalho(String line) {
		int top = -1;
		char[] Stack = new char[50];
		for(int i=0; i<line.length(); i++) {
			char gwal = line.charAt(i);
			if (gwal == '(') {
				top++;
				Stack[top] = gwal;
			}
			else if (gwal == ')') {
				if ( top == -1 || Stack[top] != '(' ) {return false;} //�ڵ尡 ������� �����Ƿ� Stack ������ ���� �˻��ϴ� ������ ���� �Է½�, ))) ���� �����Ұ��, ����÷ο찡 ���� �� ����.
				top--;
			}
		}
		return top == -1; // ()( ���� ������ ������� �ʾ������� ����ؾ���, �Ҹ�Ÿ�Թ�ȯ������ ���� �Լ�;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ݺ�Ƚ���Է�: ");
		int turn = sc.nextInt();
		for (int i =0; i<turn; i++) {
			String typing = sc.next();
			if( gwalho(typing) == false) System.out.println("No");
			else if(gwalho(typing) == true) System.out.println("YES");
		}
		System.out.println("�˻簡 �������ϴ�!");
	}

}
