import java.util.Scanner;
import java.util.Random;
public class Main {
//변수를 만들때 변수가 무엇을 의미하는지 고민하고 짤것. 
	public static void main(String[] args) {
		System.out.print("n입력: ");
		Scanner scan = new Scanner(System.in);
		Random r = new Random(10);
		int n = scan.nextInt();
		int [] Queue = new int [n*2];
		int [] Stack = new int [n*2];
		//큐에 숫자 넣기
		int Q_size = n*2;
		int Q_rear = n; //맨 뒤보다 한칸 더큰 비어있는 공간을 가리켜야
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
		// 스택에 숫자 넣기
		int S_top = 0;	//인덱스가 가르키는게 다음 들어올 숫자칸인지 아님 마지막 숫자인지 check
		while (Q_rear != Q_front) {
			if(S_top == 0 || Stack[S_top -1] > Queue[Q_front]) {
				Stack[S_top] = Queue[Q_front];
				Q_front = (Q_front+1)%Q_size;
				S_top++;
				System.out.println("큐에서 스택으로!! 프론론트값: " +Q_front +"리어값: "+Q_rear );
				
				
			}
			else if(Stack[S_top-1] < Queue[Q_front]){
				Queue[Q_rear] = Stack[S_top-1];
				Q_rear = (Q_rear+1)%Q_size;
				S_top --;
				System.out.println("스택에서 큐로!! 프론트값:"+Q_front+"리어값: "+Q_rear );
			}	
		}
		for(int i=0; i<n; i++) {
			System.out.println(Stack[i]);
		}
		
	}

}
