import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> pop_list = new ArrayList<Integer>(); //pop한 숫자들을 모아서 새로 pop할 숫자가 있으면 'no'반환
		int[] Stack = new int[100];
		int top = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("반복횟수 입력: ");
		int a = sc.nextInt();
		int count = 0;
		while (count<=a) {
			System.out.println("pop할 숫자입력: ");
			int n = sc.nextInt();
			if (top == 0) {			//스택에 아무 값 없을 때
				for(int i=1; i<n+1; i++) {
					Stack[i] = i;
					System.out.println("+");
					top++;
				}
				pop_list.add(Stack[top]);
				top--;
				System.out.println('-');
			}
			else if(Stack[top]<n) { //입력받은 숫자가 탑의 값보다 클때(수열추가하고 마지막 pop)	
				if(pop_list.contains(n) == true) {	//팝할 값이 팝리스트에 있으면 'no'출력
					System.out.println("No");	
				}
				else { //스택에 수열추가하고 마지막값 pop
					
				}
			}
			else if(Stack[top]>n) {//입력받은 숫자가  top의 값보다 작을 때(이미 있는 수열안에서 pop);
				if(pop_list.contains(n) == true) {	//팝할 값이 팝리스트에 있으면 'no'출력
					System.out.println("No");
				}
				else { // 원하는 숫자까지 pop 		
				}
			}
		count++;			
		}
		
	}
}
