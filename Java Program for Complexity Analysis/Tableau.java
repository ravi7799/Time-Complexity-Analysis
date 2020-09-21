import java.util.*;

public class Tableau {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int[][] arr= {
				{2,5,8,9},{4,6,10,12},{6,7,13,Integer.MAX_VALUE},{8,11,Integer.MAX_VALUE,Integer.MAX_VALUE}
		};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.printf("%-10d ",arr[i][j]);
			}
			System.out.println();
		}
		
		int c=1;
		if(arr[arr.length-1][arr[0].length-1] != Integer.MAX_VALUE) {
			System.out.println("Already filed");
		}else {
			arr[arr.length-1][arr[0].length-1]=c;
			tableau(arr,arr.length-1,arr[0].length-1);
		}
		
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.printf("%-10d ",arr[i][j]);
			}
			System.out.println();
		}
		
		if(arr[0][0]==Integer.MAX_VALUE) {
			System.out.println("Tableu is empty");
		}else {
			arr[0][0]=Integer.MAX_VALUE;
			deleteMin(arr,0,0);
		}
		
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.printf("%-10d ",arr[i][j]);
			}
			System.out.println();
		}
		
		
	
	}

	private static void tableau(int[][] arr,int i,int j) {
		
		int largesti=i,largestj=j;

		if(  i-1>=0  && arr[i-1][j] > arr[largesti][largestj]) {
			 largesti=i-1;
			 largestj=j;
		 }
		
		if(  j-1>=0  && arr[i][j-1] > arr[largesti][largestj]) {
			 largesti=i;
			 largestj=j-1;
		 }
		
		
		if(largesti !=i || largestj !=j) {
			int temp=arr[i][j];
			arr[i][j]=arr[largesti][largestj];
			arr[largesti][largestj]=temp;
			
			tableau(arr,largesti,largestj);
		}else {
			return;
		}
	
	}
	
	private static void deleteMin(int[][] arr,int i,int j) {
		int m=arr[0].length;
		int n=arr.length;
		
		int smallesti=i,smallestj=j;

		if(  i+1< n  && arr[i+1][j] < arr[smallesti][smallestj]) {
			 smallesti=i+1;
			 smallestj=j;		 }
		
		if(  j+1< m  && arr[i][j+1] < arr[smallesti][smallestj]) {
			 smallesti=i;
			 smallestj=j+1;
		 }
		
		
		if(smallesti !=i || smallestj !=j) {
			int temp=arr[i][j];
			arr[i][j]=arr[smallesti][smallestj];
			arr[smallesti][smallestj]=temp;
			
			deleteMin(arr,smallesti,smallestj);
		}else {
			return;
		}
	}	
	
}
