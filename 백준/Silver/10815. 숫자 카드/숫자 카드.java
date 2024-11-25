import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


//이중 for문을 사용하여 시간을 비교하면 O(n^2)시간이 소요된다
//이분/이진 탐색을 사용하면 O(logN)시간이 소요되므로 상대적으로 빠른 탐색이 가능하다
//이분/이진 탐색 : 정렬이 되어있는 배열에서 중간값과 찾는값을 비교하여 값을 찾을때 까지 반복

public class Main {
	
	static int N,M;
	static int[] NArray;
	
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		
		N = Integer.parseInt(br.readLine());
		NArray = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i < N; i++)
			NArray[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(NArray); //이진 탐색을 위해 정렬되어있어야함
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			bw.write(BinarySearch(num)+" ");
		}
		
		bw.flush();
		br.close();		
		bw.close();
	}				
	
	public static int BinarySearch(int num)
	{
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int middle = (left + right) / 2;
			int middleValue = NArray[middle];
			
			if(num > middleValue) {
				left = middle + 1;
			}else if(num < middleValue) {
				right = middle - 1;
			}else {
				return 1;
			}
		}
		
		return 0;
	}
}
