package termproject_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.print("n입력: ");
		int n = scan.nextInt();
		int [] ranum = new int[n];
		for(int i=0; i<n; i++) { 	//n개의 랜덤숫자 중복빼고 생성
			ranum[i] = r.nextInt(n)+1;
			for( int j=0; j<i; j++) {
				if (ranum[i] == ranum[j]) {
					i--;
				}
			}
		}
		for(int i=0;i<n; i++) {		//n개의 랜덤숫자 출력
			System.out.println(ranum[i]);
		}
		System.out.print("k입력: ");
		int k = scan.nextInt();
		int count = 1;
		while (count <= k){
			System.out.print("구간 a,b 입력: ");
			int a = scan.nextInt(); int b = scan.nextInt();
			int size = b-a;
			int [] gugan = new int[size+1]; // a,b 구간 사이의 값들을 모아놓은 배열.
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
			System.out.println(" "+hap);
			count++;
			
		}

	}

}
