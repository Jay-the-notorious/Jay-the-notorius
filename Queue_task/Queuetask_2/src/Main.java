import java.util.Scanner;
public class Main {

	

	public static void main(String[] args) {
		int [] queue = new int [1025];
		int front  = 0;
		int rear = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("n입력: ");
		int n = scan.nextInt();
		for(int i=0; i<n; i++) {
			String a = scan.next();
			if(a.equals("push")) { //문자열 객체 주소값이 다르기 떄문에 equals 써야됨. 
				int b = scan.nextInt();
				queue[rear] = b;
				rear = (rear+1)%1025;
			}
			if(a.equals("pop")) {
				if(front == rear) {
					System.out.println(-1);
				}
				else {
				System.out.println(queue[front]);
				front = (front+1)%1025;
				}
			}
			if(a.equals("size")) {
				System.out.println((rear-front + 1025)%1025);
			}
			if(a.equals("empty")) {
				if(front == rear) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
			}
			if(a.equals("front")) {
				System.out.println(queue[front]);
			}
			if(a.equals("back")) {
				System.out.println(queue[rear-1]);
			}
			
		}
	}

}
