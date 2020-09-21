import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HeapSort {

	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\java file handling\\heap_sort_analysis.txt");
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
	        
			heap_sort(best);
	       
			long TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Best_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Worst case
			initialTime=System.nanoTime();
			
			heap_sort(worst);

			TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Worst_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Average case
			initialTime=System.nanoTime();

			heap_sort(avg);
			
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
			
			k++;
			System.out.println("Success");
		}
		bw.close();

	}
	
	
    public static void heap_sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        for (int i=n-1; i>0; i--) 
        { 
            int temp = arr[0];     
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            heapify(arr, i, 0); 
        } 
    } 
	
	
    static void heapify(int arr[], int n, int i) 
    { 
        int max= i;
        int l = 2*i + 1; 
        int r = 2*i + 2; 
  
        if (l < n && arr[l] > arr[max]) 
            max = l; 
  
        if (r < n && arr[r] > arr[max]) 
            max = r; 
  

        if (max != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[max]; 
            arr[max] = swap; 
  
            heapify(arr, n, max); 
        } 
    } 
}
