package termproject_3; // ������ �ڵ带 ����� ����!

import java.util.Random;
import java.util.Scanner;
import java.util.Random;
public class Main {

	public static void main(String[] args) {
		long A = System.currentTimeMillis();
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		//System.out.print("n�Է�: ");
		//int n = scan.nextInt();
		int n = 10000;
		int [] ranum = new int[n];
		for(int i=0; i<n; i++) 	ranum[i] = r.nextInt(n)+1;
		for(int i=0;i<n; i++) {
			System.out.println(ranum[i]);
		}
		System.out.println();
		System.out.println();
		// ------------------------���� ���-------------------
		//System.out.print("K�Է�:  ");
		//int k = scan.nextInt();
		int k = 10000000;
		int count = 1;
		while(count <=k) {
			//System.out.print("���� a,b �Է�: ");
			//int a= scan.nextInt(); int b= scan.nextInt();
			int a=1; int b= 100;
			int min= ranum[a-1];
			int max= ranum[a-1];
			long sum = ranum[a-1];
			for(int i = a; i<b; i++) {
				if(min > ranum[i]) min =ranum[i];
				if(max < ranum[i]) max = ranum[i];
				sum += ranum[i];
			}
			System.out.println(min + "	"+ max + "	" + sum);
			count++;
		}
		long B =System.currentTimeMillis();
		System.out.println(B-A);
	}

}
