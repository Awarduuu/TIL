package Day1;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = new int [6];
		
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));

		// Arrays fill(배열, 값) >> 해당 배열을 특정 값으로 채움
		Arrays.fill(arr, 100);
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		
		// 배열 재할당
		arr = new int [] {1, 2, 3, 4, 5};
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));

		Arrays.sort(arr);
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
		
		// 배열 복사
		int [] copyArr = Arrays.copyOfRange(arr, 1, 3);
				
		System.out.println(copyArr);
		System.out.println(Arrays.toString(copyArr));
		
		// 2차원 배열을 출력
		int [][] arr2d = {{1, 2}, {3, 4}, {5, 6}};
		System.out.println(arr2d);
		
		for(int i=0; i<3; i++) {
			System.out.println(Arrays.toString(arr2d[i]));
		}
		
		System.out.println(Arrays.deepToString(arr2d));


	}

}
