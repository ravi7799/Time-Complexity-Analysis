import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CountingSort {

	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\Algorithm time Complexity analysis\\counting_sort_analysis.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,false),2);
		
		//1000000, 3000000, 5000000, 7000000, 9000000
		List<Integer> TestCase=Arrays.asList(1000000, 3000000, 5000000, 7000000, 9000000);
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
				avg[i]=rand.nextInt(1001);			//Filling Numbers in the range of (0, ........, 1000) in array of size arrSize
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
	        
			best=counting_sort(best,arrSize);
	       
			long TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Best_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Worst case
			initialTime=System.nanoTime();
			
			worst=counting_sort(worst,arrSize);

			TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Worst_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Average case
			initialTime=System.nanoTime();

			avg=counting_sort(avg,arrSize);
			
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
		
			
			k++;
			System.out.println("Success");
		}
		bw.close();

	}

	private static int[] counting_sort(int[] arr, int n) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(arr[i] > max) {
				max=arr[i];
			}
		}
		
		int[] count=new int[max+1];
		Arrays.fill(count,0);
		
		for(int i=0;i<n;i++) {
			count[arr[i]]++;
		}

		
		for(int i=1;i<count.length;i++) {
			count[i]=count[i]+count[i-1];
		}

		
		int[] res=new int[n];
		
		for(int i=n-1;i>=0;i--) {
			res[count[arr[i]]-1]=arr[i];
			count[arr[i]]--;
		}

		return res;
	}

}
