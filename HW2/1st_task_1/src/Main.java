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
				if ( top == -1 || Stack[top] != '(' ) {return false;} //코드가 순서대로 읽히므로 Stack 마지막 값을 검사하는 조건을 먼저 입력시, ))) 부터 수행할경우, 언더플로우가 생길 수 있음.
				top--;
			}
		}
		return top == -1; // ()( 같이 완전히 비워지지 않았을때를 고려해야함, 불린타입반환값으로 같는 함수;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("반복횟수입력: ");
		int turn = sc.nextInt();
		for (int i =0; i<turn; i++) {
			String typing = sc.next();
			if( gwalho(typing) == false) System.out.println("No");
			else if(gwalho(typing) == true) System.out.println("YES");
		}
		System.out.println("검사가 끝났습니다!");
	}

}
