package Day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B10807_개수세기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer token = new StringTokenizer(bf.readLine(), " ");
		
		int [] arr = new int [n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		int v = Integer.parseInt(bf.readLine());
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			if(v == arr[i]) ans++;
		}
		
		System.out.println(ans);
		
		
//			Scanner sc = new Scanner(System.in);
//			
//			int res = 0;
//			
//			int n = sc.nextInt();
//			
//			int [] arr = new int [n];
//			
//			for(int i=0; i<n; i++) {
//				arr[i] = sc.nextInt();
//			}
//			
//			int find = sc.nextInt();
//			
//			for(int i : arr) {
//				if(i == find) {
//					res++;
//				}
//			}
//			
//			System.out.println(res);
	}

}
