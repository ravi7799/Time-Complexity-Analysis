import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort {
	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\java file handling\\quick_sort_analysis.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,false),2);
		
		//50000,75000,100000,125000,150000,175000,200000
		List<Integer> TestCase=Arrays.asList(5000,7500,10000,12500,15000,17500,21000);
		int[] best;
		int[] worst;
		int[] avg;
		
		
		int k=0;
		bw.write(" \tNumber_of_Input\tTime_Taken\n");
		String s="raveet";
		Character c='K';
		s=s+c;
		System.out.println(s);
		while(k < 0) {
			
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
	        
			quicksort(best,0,arrSize-1);
	       
			long TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Best_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Worst case
			initialTime=System.nanoTime();
			
			quicksort(worst,0,arrSize-1);

			TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Worst_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Average case
			initialTime=System.nanoTime();

			quicksort(avg,0,arrSize-1);
			
			TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Avg_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			
			//For TESTING only...
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

    static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1);  
        for (int j=low; j<high; j++) 
        {  
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  

        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  

    static void quicksort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            quicksort(arr, low, pi-1); 
            quicksort(arr, pi+1, high); 
        } 
    } 
}
