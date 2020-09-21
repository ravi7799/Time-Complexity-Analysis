import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\java file handling\\merge_sort_analysis.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,false),2);
		
		//50000,75000,100000,125000,150000,175000,200000
		List<Integer> TestCase=Arrays.asList(50000,75000,100000,125000,150000,175000,200000);
		int[] best;
		int[] worst;
		int[] avg;
		
		
		int k=0;
		bw.write(" \tNumber_of_Input\tTime_Taken\n");
		
		while(k < TestCase.size()) {
			
			int arrSize=TestCase.get(k);
			best=new int[arrSize];
			worst=new int[arrSize];
			avg=new int[arrSize];
			
			Random rand=new Random();    // To Generate Random Numbers...
			
			for(int i=0;i<arrSize;i++) {
				avg[i]=rand.nextInt(arrSize*10);			//Filling Numbers in the range of (0, arrSize*10-1) in array of size arrSize
			}
			
			for(int i=0;i<arrSize;i++) {
				best[i]=avg[i];
			}
			Arrays.sort(best);					// To make a sorted array... which we will use for best case..

			for(int i=0;i<arrSize;i++) {
				worst[i]=best[arrSize-1-i];		// To make reverse order of the Best case ... to Check worst case..
			}
			
			// For Best Case
			long initialTime=System.nanoTime();			
	        
			merge_sort(best,0,arrSize-1);
	       
			long TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Best_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Worst case
			initialTime=System.nanoTime();
			
			merge_sort(worst,0,arrSize-1);

			TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Worst_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Average case
			initialTime=System.nanoTime();

			merge_sort(avg,0,arrSize-1);
			
			TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Avg_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			
//			//For TESTING only...
//			
//			if(k==0) {
//				for(int i=0;i<arrSize;i++) {
//					System.out.print(best[i] +" ");
//				}
//				System.out.println();
//				
//				for(int i=0;i<arrSize;i++) {
//					System.out.print(worst[i] +" ");
//				}
//				System.out.println();
//				
//				for(int i=0;i<arrSize;i++) {
//					System.out.print(avg[i] +" ");
//				}
//				System.out.println();
//			}
//		
//			
			k++;
			System.out.println("Success");
		}
		bw.close();

	}

	private static void merge_sort(int[] arr, int i, int j) {
		if(i<j) {
			int mid=(i+j)/2;
			merge_sort(arr,i,mid);
			merge_sort(arr,mid+1,j);
			merge(arr,i,mid,j);
		}
		
	}

	private static void merge(int[] arr, int l, int m, int r) {
	       int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        int L[] = new int[n1]; 
	        int R[] = new int[n2]; 

	        for (int i = 0; i < n1; ++i) 
	            L[i] = arr[l + i]; 
	        
	        for (int j = 0; j < n2; ++j) 
	            R[j] = arr[m + 1 + j]; 
	  
	        int i = 0, j = 0; 
	  

	        int k = l; 
	        
	        while (i < n1 && j < n2) { 
	        	
	            if (L[i] <= R[j]) { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  

	        while (i < n1) { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	        
	        while (j < n2) { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	}
	
}
