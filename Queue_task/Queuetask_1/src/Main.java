import java.util.Scanner;
import java.util.Random;
public class Main {
//������ ���鶧 ������ ������ �ǹ��ϴ��� ����ϰ� ©��. 
	public static void main(String[] args) {
		System.out.print("n�Է�: ");
		Scanner scan = new Scanner(System.in);
		Random r = new Random(10);
		int n = scan.nextInt();
		int [] Queue = new int [n*2];
		int [] Stack = new int [n*2];
		//ť�� ���� �ֱ�
		int Q_size = n*2;
		int Q_rear = n; //�� �ں��� ��ĭ ��ū ����ִ� ������ �����Ѿ�
		int Q_front = 0;
		for(int i =0; i<n; i++) {
			Queue[i] = r.nextInt(10000);
			for( int j=0; j<i; j++) {
				if(Queue[i] == Queue[j]) {
					i--;
				}
			}
		}
		for(int i =0; i<n; i++) {
			System.out.println(Queue[i]);
		}
		System.out.println();
		// ���ÿ� ���� �ֱ�
		int S_top = 0;	//�ε����� ����Ű�°� ���� ���� ����ĭ���� �ƴ� ������ �������� check
		while (Q_rear != Q_front) {
			if(S_top == 0 || Stack[S_top -1] > Queue[Q_front]) {
				Stack[S_top] = Queue[Q_front];
				Q_front = (Q_front+1)%Q_size;
				S_top++;
				System.out.println("ť���� ��������!! ���з�Ʈ��: " +Q_front +"���: "+Q_rear );
				
				
			}
			else if(Stack[S_top-1] < Queue[Q_front]){
				Queue[Q_rear] = Stack[S_top-1];
				Q_rear = (Q_rear+1)%Q_size;
				S_top --;
				System.out.println("���ÿ��� ť��!! ����Ʈ��:"+Q_front+"���: "+Q_rear );
			}	
		}
		for(int i=0; i<n; i++) {
			System.out.println(Stack[i]);
		}
		
	}

}
