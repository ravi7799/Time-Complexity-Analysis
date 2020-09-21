import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RadixSort {

	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\Algorithm time Complexity analysis\\Radix_sort_analysis.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,false),2);
		
		//1000000, 3000000, 5000000, 7000000, 9000000
		List<Integer> TestCase=Arrays.asList(1000000, 3000000, 5000000, 7000000, 9000000);
		String[] best;
		String[] worst;
		String[] avg;
		
		
		int k=0;
		bw.write(" \tNumber_of_Input\tTime_Taken\n");
		
		while(k < TestCase.size()) {
			
			int arrSize=TestCase.get(k);
			best=new String[arrSize];
			worst=new String[arrSize];
			avg=new String[arrSize];
			
			Random rand=new Random();    // To Generate Random Numbers...
			
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			
			for(int i=0;i<arrSize;i++) {
				StringBuilder sb = new StringBuilder(20);

				for (int j = 0; j < 20; j++) {
				    char c = chars[rand.nextInt(chars.length)];
				    sb.append(c);
				}
				String output = sb.toString();				
				avg[i]=output;			//Filling Numbers in the range of (0, arrSize*10-1) in array of size arrSize
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
	        
			radix_sort(best,arrSize);
	       
			long TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Best_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Worst case
			initialTime=System.nanoTime();
			
			radix_sort(worst,arrSize);

			TimeTaken=System.nanoTime()-initialTime;
			bw.write(String.format("Worst_Case\t%d\t%d\n",arrSize,TimeTaken));
			
			// For Average case
			initialTime=System.nanoTime();

			radix_sort(avg,arrSize);
			
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

	private static void radix_sort(String[] arr, int n) {
		int maxLen=getMaxLen(arr);
		
		for(int pos=maxLen;pos >= 1;pos--) {
			countingSort(arr,pos);
		}
	}

	private static void countingSort(String[] arr, int pos) {
		String[] res=new String[arr.length];
		int n=arr.length;
		int[] count=new int[26];
		
		for(int i=0;i<n;i++) {
			count[(int)(arr[i].charAt(pos-1)-97)]++;
		}
		
		for(int i=1;i<26;i++) {
			count[i]=count[i]+count[i-1];
		}
		
		for(int i=n-1;i>=0;i--) {
			res[--count[(int)(arr[i].charAt(pos-1)-97)]]=arr[i];
		}
		
		for(int i=0;i<n;i++) {
			arr[i]=res[i];
		}
	}

	private static int getMaxLen(String[] arr) {
		int max=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].length() > max) {
				max=arr[i].length();
			}
		}
		return max;
	}

}
