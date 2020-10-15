import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack(); 	//실제 수들이 들어오고 나갈 스택
		ArrayList giho = new ArrayList(); // 기호를 저장할 리스트
		int index = 0; 				// 입력받은 스택수열의 위치를 가리킬 인덱스
		int max =0; // 스택에 들어온 최대값을 찍어줌(중간에 pop한 수 빼고 수열에 넣어주기 위해)
		int jul = sc.nextInt(); 	// 몇줄로 스택수열을 받을지 
		int[] su = new int[jul];	// 입력받은 수택수열
		for(int i=0; i<jul; i++) { su[i] = sc.nextInt();} 	//스택수열을 입력받는다.
		int count = 0; // 조건문들을 반복 시행시키기 위해 카운트 
		while(count < jul) {
		if(stack.empty() == true) { //아무것도 실행되지 않아 스택이 비어있을 때
				for(int i = 1; i<=jul; i++) {
					stack.add(i); giho.add('+'); //스택수열 첫 숫자만큼 스택에 집어넣고 +
					if((int)stack.peek() == su[index]) { //스택에 수를 집어 넣다가 스택 마지막으로 들어오는 값이 인덱스 값 까지 들어왔는지 확인
						index++; //다음 스택수열 값을 가리킴
						max = (int)stack.peek(); //가장 높이 들어왔던 값을 체크해서 빠진수 빼고 스택에 채워넣기 위
						stack.pop();
						giho.add('-');
						count++;
					}
				}
		}
		else if(stack.empty() == false && stack.contains(su[index]) == true ) { //스택이 비어있지 않을 때(스택안에서 수를 뽑아야 할 때)
			int temp = (int)stack.peek()-su[index]; // 스택에 마지막 값이랑 스택수열을 값의 차이가 1이 아닐때 다른 숫자를 뽑아야 해서 스택수열이 만들어지지 않음
			if(temp != 1) { // 뽑을 수 있는 수가 탑에 있지 않을때 
				System.out.println("no");
				break;
			}
			else if(temp == 1){ 
				index++; 
				stack.pop(); //마지막 값을 pop
				giho.add('-'); //기호를 저장해둔 곳에 - 기호 넣기
				count++;
			}
			
		}
			else if(stack.empty() == false && stack.contains(su[index]) == false) { //스택이 비어있지 않을 때(스택수열에 값을 추가하고 찾아야 할 때)
				for(int i= max; i <= su[index]; i++) {
					stack.add(i); giho.add('+');
					if((int)stack.peek() == su[index]) {
						index++;
						max = (int)stack.peek(); // 중간에 빠진 수 빼고 스택에 넣어주기 위해 
						stack.pop();
						giho.add('-');
						count++;
					}
				}
		}
		
			

	}
	for(int i = 0; i < giho.size(); i++) {System.out.println(giho.get(i));}
	}	
}
