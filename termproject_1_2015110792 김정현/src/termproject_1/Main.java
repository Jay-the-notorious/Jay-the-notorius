package termproject_1;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.print("n�Է�: ");
		int n = scan.nextInt();
		int [] ranum = new int[n];
		System.out.print("���� a,b �Է�: ");
		int a = scan.nextInt(); int b = scan.nextInt();
		for(int i=0; i<n; i++) { 	//n���� �������� �ߺ����� ����
			ranum[i] = r.nextInt(n)+1;
			for( int j=0; j<i; j++) {
				if (ranum[i] == ranum[j]) {
					i--;
				}
			}
		}
		for(int i=0;i<n; i++) {		//n���� �������� ���
			System.out.println(ranum[i]);
		}
		System.out.println();
		int size = b-a;
		int [] gugan = new int[size+1]; // a,b ���� ������ ������ ��Ƴ��� �迭.
		for(int i=0; i<size+1; i++) {
			gugan[i] = ranum[i+a-1];
		}
		int [] temp = new  int [1024];
		temp = gugan;
		Arrays.sort(gugan);
		System.out.print(gugan[0]+" "+gugan[size]);
		int hap =0;
		for(int i=0; i< temp.length; i++ ) {
			hap += temp[i];
		}
		System.out.print(" "+hap);
		
	}
	
}
