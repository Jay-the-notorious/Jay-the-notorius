import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack(); 	//���� ������ ������ ���� ����
		ArrayList giho = new ArrayList(); // ��ȣ�� ������ ����Ʈ
		int index = 0; 				// �Է¹��� ���ü����� ��ġ�� ����ų �ε���
		int max =0; // ���ÿ� ���� �ִ밪�� �����(�߰��� pop�� �� ���� ������ �־��ֱ� ����)
		int jul = sc.nextInt(); 	// ���ٷ� ���ü����� ������ 
		int[] su = new int[jul];	// �Է¹��� ���ü���
		for(int i=0; i<jul; i++) { su[i] = sc.nextInt();} 	//���ü����� �Է¹޴´�.
		int count = 0; // ���ǹ����� �ݺ� �����Ű�� ���� ī��Ʈ 
		while(count < jul) {
		if(stack.empty() == true) { //�ƹ��͵� ������� �ʾ� ������ ������� ��
				for(int i = 1; i<=jul; i++) {
					stack.add(i); giho.add('+'); //���ü��� ù ���ڸ�ŭ ���ÿ� ����ְ� +
					if((int)stack.peek() == su[index]) { //���ÿ� ���� ���� �ִٰ� ���� ���������� ������ ���� �ε��� �� ���� ���Դ��� Ȯ��
						index++; //���� ���ü��� ���� ����Ŵ
						max = (int)stack.peek(); //���� ���� ���Դ� ���� üũ�ؼ� ������ ���� ���ÿ� ä���ֱ� ��
						stack.pop();
						giho.add('-');
						count++;
					}
				}
		}
		else if(stack.empty() == false && stack.contains(su[index]) == true ) { //������ ������� ���� ��(���þȿ��� ���� �̾ƾ� �� ��)
			int temp = (int)stack.peek()-su[index]; // ���ÿ� ������ ���̶� ���ü����� ���� ���̰� 1�� �ƴҶ� �ٸ� ���ڸ� �̾ƾ� �ؼ� ���ü����� ��������� ����
			if(temp != 1) { // ���� �� �ִ� ���� ž�� ���� ������ 
				System.out.println("no");
				break;
			}
			else if(temp == 1){ 
				index++; 
				stack.pop(); //������ ���� pop
				giho.add('-'); //��ȣ�� �����ص� ���� - ��ȣ �ֱ�
				count++;
			}
			
		}
			else if(stack.empty() == false && stack.contains(su[index]) == false) { //������ ������� ���� ��(���ü����� ���� �߰��ϰ� ã�ƾ� �� ��)
				for(int i= max; i <= su[index]; i++) {
					stack.add(i); giho.add('+');
					if((int)stack.peek() == su[index]) {
						index++;
						max = (int)stack.peek(); // �߰��� ���� �� ���� ���ÿ� �־��ֱ� ���� 
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
