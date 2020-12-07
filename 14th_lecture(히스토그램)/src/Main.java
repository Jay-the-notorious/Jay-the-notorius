// Lecture 14
// 분할정복을 이용하여 히스토그램에서 가장 큰 넣ㅂ이의 직사각형 넓이 구하기
//	입력
//	처음에 히스토그램의 샘플 갯수 N이 입력됩니다.
//	다음에 각 샘플들의 도수들이 N개 입력됩니다.
//	예를 들어서{3, 2, 6 ,7 }의 도수를 가지는 4개의 샘플이 있는 히스토그램은
//	4 3 2 6 7
//	로 입력이 주어집니다.
//	이에 대한 답변은 직사각형의 넓이를 출력하면 됩니다.
//	12
import java.util.Scanner;
public class Main {
	//	분할정복을 위한 함수
	//	배열 v에서 범위 (a, b) 구간에서 최대 크기의 직사각형 넓이 반환
	static int histo(int[] v, int a, int b) {
		int temp = 0;
		int c = (b-a)/2;
		int leftmaxzic = v[a];	
		int rightmaxzic = v[c+1];
		int middlemaxzic= 0;
		int maxzic = 0;	//
//		System.out.println(c);

		for(int i=a; i<=c; i++) {	//반나눠서 left 계산
//			if(a>=c) return leftmaxzic;
			int minpick = v[i]; 
			for(int j=i+1; j<=c; j++) {
				if(minpick >v[j]) minpick=v[j];  
				temp=minpick*(j-i+1); // 현재 가장 작은 사각형 기준으로 제일 사각형 넓이 값
				if(temp>leftmaxzic) leftmaxzic= temp; //이전에 가장 큰 사각형 넓이 값이랑 비교후 바꿈.	
			}
		}
//		System.out.println(leftmaxzic);
		for(int i=c+1; i<=b; i++) {	//반 나눠서 right
//			if(c+1>=b) rightmaxzic;
			int minpick = v[i]; 
			for(int j=i+1; j<=b; j++) {
				if(minpick >v[j]) minpick=v[j];  
				temp=minpick*(j-i+1); // 현재 가장 작은 사각형 기준으로 제일 사각형 넓이 값
				if(temp>rightmaxzic) rightmaxzic= temp; //이전에 가장 큰 사각형 넓이 값이랑 비교후 바꿈.	
			}
		}
//		System.out.println(rightmaxzic);
		if (leftmaxzic >= rightmaxzic) maxzic = leftmaxzic;
		else	maxzic= rightmaxzic;
		int left = c;
		int right = c+1;
		int minpick1 =v[left];
		while(left >= a || right <= b) {	//가운데서 끝으로 나아가자
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
	//	히스토그램에서 최대의 직사각형 넓이를 계산해서 출력하는 함수
	//	v : 히스토그램의 샘플들의 도수들의 배열 (0 이상의 자연수)
	//	n : 샘플의 갯수
	static int histo(int [] v, int n) {
		//v[0...n-1] 구간의 넓이를 구해서 그 값을 반환합니다.
		int c = n/2;
//		for(int i=0; i<=n; i++) {
//			int left = c;
//			int right = c+1;//c가 홀 수일 경우 index 벗어나지 않기 위해, 오른쪽 부터 증가시킴
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
		//	샘플 갯수 N을 입력
		int n = scan.nextInt();
		// n개의 공간을 갖는 배열을 생성
		int[] v = new int[n];
		//	n개의 배열 공간에 입력된 값을 넣는다.
		for(int i =0; i<n; i++) {
			v[i] = scan.nextInt();
		}
		//	histo() 함수를 호출해서 그 결과 저장
		int r = histo(v, n);
		//	결과 출력
		System.out.println(r);
	}

}
