// Lecture 14
// ���������� �̿��Ͽ� ������׷����� ���� ū �֤����� ���簢�� ���� ���ϱ�
//	�Է�
//	ó���� ������׷��� ���� ���� N�� �Էµ˴ϴ�.
//	������ �� ���õ��� �������� N�� �Էµ˴ϴ�.
//	���� ��{3, 2, 6 ,7 }�� ������ ������ 4���� ������ �ִ� ������׷���
//	4 3 2 6 7
//	�� �Է��� �־����ϴ�.
//	�̿� ���� �亯�� ���簢���� ���̸� ����ϸ� �˴ϴ�.
//	12
import java.util.Scanner;
public class Main {
	//	���������� ���� �Լ�
	//	�迭 v���� ���� (a, b) �������� �ִ� ũ���� ���簢�� ���� ��ȯ
	static int histo(int[] v, int a, int b) {
		int temp = 0;
		int c = (b-a)/2;
		int leftmaxzic = v[a];	
		int rightmaxzic = v[c+1];
		int middlemaxzic= 0;
		int maxzic = 0;	//
//		System.out.println(c);

		for(int i=a; i<=c; i++) {	//�ݳ����� left ���
//			if(a>=c) return leftmaxzic;
			int minpick = v[i]; 
			for(int j=i+1; j<=c; j++) {
				if(minpick >v[j]) minpick=v[j];  
				temp=minpick*(j-i+1); // ���� ���� ���� �簢�� �������� ���� �簢�� ���� ��
				if(temp>leftmaxzic) leftmaxzic= temp; //������ ���� ū �簢�� ���� ���̶� ���� �ٲ�.	
			}
		}
//		System.out.println(leftmaxzic);
		for(int i=c+1; i<=b; i++) {	//�� ������ right
//			if(c+1>=b) rightmaxzic;
			int minpick = v[i]; 
			for(int j=i+1; j<=b; j++) {
				if(minpick >v[j]) minpick=v[j];  
				temp=minpick*(j-i+1); // ���� ���� ���� �簢�� �������� ���� �簢�� ���� ��
				if(temp>rightmaxzic) rightmaxzic= temp; //������ ���� ū �簢�� ���� ���̶� ���� �ٲ�.	
			}
		}
//		System.out.println(rightmaxzic);
		if (leftmaxzic >= rightmaxzic) maxzic = leftmaxzic;
		else	maxzic= rightmaxzic;
		int left = c;
		int right = c+1;
		int minpick1 =v[left];
		while(left >= a || right <= b) {	//����� ������ ���ư���
			if(minpick1>v[right]) minpick1= v[right]; 
			if(minpick1>v[left]) minpick1= v[left];	
			middlemaxzic = minpick1 * (right-left+1);
			left--;
			right++;
		}
//		System.out.println(middlemaxzic);
		if (middlemaxzic >= maxzic) maxzic = middlemaxzic;
		return maxzic;
	}
	//	������׷����� �ִ��� ���簢�� ���̸� ����ؼ� ����ϴ� �Լ�
	//	v : ������׷��� ���õ��� �������� �迭 (0 �̻��� �ڿ���)
	//	n : ������ ����
	static int histo(int [] v, int n) {
		//v[0...n-1] ������ ���̸� ���ؼ� �� ���� ��ȯ�մϴ�.
		int c = n/2;
//		for(int i=0; i<=n; i++) {
//			int left = c;
//			int right = c+1;//c�� Ȧ ���� ��� index ����� �ʱ� ����, ������ ���� ������Ŵ
//			if 
//			if (v[left]>=v[right]) {
//				min = v[right++];
//			}
//			else {
//				min = v[left];
//				if(left >= 1) 	
//			}
//		}

		return histo(v, 0, n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		//	���� ���� N�� �Է�
		int n = scan.nextInt();
		// n���� ������ ���� �迭�� ����
		int[] v = new int[n];
		//	n���� �迭 ������ �Էµ� ���� �ִ´�.
		for(int i =0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		//	histo() �Լ��� ȣ���ؼ� �� ��� ����
		int r = histo(v, n);
		//	��� ���
		System.out.println(r);
	}

}
