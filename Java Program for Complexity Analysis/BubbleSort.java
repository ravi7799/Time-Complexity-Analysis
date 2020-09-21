import java.util.*;
import java.io.*;

public class BubbleSort {

	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\java file handling\\bubblesort_analysis.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,false),2);
		//10000,30000,75000,100000,137000,175000
		List<Integer> TestCase=Arrays.asList(10000,30000,75000,100000,137000,175000);
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
	        
			bubble_sort(best);
			
			long TimeTaken=System.nanoTime()-initialTime;
			
			bw.write(String.format("Best_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Worst Case
			
			initialTime=System.nanoTime();
			
			bubble_sort(worst);
			
			TimeTaken=System.nanoTime()-initialTime;
			
			bw.write(String.format("Worst_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Average Case
			
			initialTime=System.nanoTime();

			bubble_sort(avg);
			
			TimeTaken=System.nanoTime()-initialTime;
			
			bw.write(String.format("Avg_Case\t%d\t%d\n",arrSize,TimeTaken));
				
			// For Testing Only..
//			if(k==0) {
//				for(int i=0;i<arrSize;i++) {
//					System.out.print(best[i] +" ");
//				}
//				System.out.println();
//				for(int i=0;i<arrSize;i++) {
//					System.out.print(worst[i] +" ");
//				}
//				System.out.println();
//				for(int i=0;i<arrSize;i++) {
//					System.out.print(avg[i] +" ");
//				}
//				System.out.println();
//			}
//				
			k++;
			System.out.println("Success");
		}
		bw.close();

	}
	
	static void bubble_sort(int[] arr) {
		
		int temp;
		for (int i = 0; i < arr.length-1; i++) { 
            for (int j = 0; j < arr.length-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                }
		}

	}

}