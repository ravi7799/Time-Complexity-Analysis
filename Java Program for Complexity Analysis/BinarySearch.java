import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BinarySearch {

public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\java file handling\\binary_search_analysis.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,false),2);
		
		//50000,75000,100000,125000,150000,175000,200000
		List<Integer> TestCase=Arrays.asList(50000,75000,100000,125000,150000,175000,200000);
		int[] arr;

		
		int k=0;
		bw.write("Case\t\t\tNumber_of_Input\t\t\tNumber_of_comparisions\n");
		
		while(k < TestCase.size()) {
			
			int arrSize=TestCase.get(k);
			arr=new int[arrSize];
			
			Random rand=new Random();    // To Generate Random Numbers...
			
			for(int i=0;i<arrSize;i++) {
				arr[i]=rand.nextInt(arrSize*10);			//Filling Numbers in the range of (0, arrSize*10-1) in array of size arrSize
			}
			Arrays.sort(arr);					
			// For Best Case
		
			int comparisions=binary_search(arr,arr[(arrSize-1)/2]);
			bw.write(String.format("Best_case\t\t\t%d\t\t\t%d\n",arrSize,comparisions));
			
			//if element is not present in the array.. it will be the worst case
			comparisions=binary_search(arr,-1);
			bw.write(String.format("Worst_case\t\t\t%d\t\t\t%d\n",arrSize,comparisions));
			
			//Avg case..taking a number at some index in middle...
			comparisions=binary_search(arr,arr[(arrSize-1)/8-1 ]);
			bw.write(String.format("Avg_case\t\t\t%d\t\t\t%d\n",arrSize,comparisions));
			
//			//For TESTING only...
//			
//			if(k==0) {
//				for(int i=0;i<arrSize;i++) {
//					System.out.print(arr[i] +" ");
//				}
//				System.out.println();
//			}		
//			
			k++;
			System.out.println("Success");
		}
		bw.close();

	}

	private static int binary_search(int[] arr, int var) {
	int comp=0;
	int l=0,h=arr.length-1;
	int mid = l + (h - l) / 2; 
	
	while(l<=h) {
		mid = l + (h - l) / 2; 
		if(arr[mid]==var) {
			return comp+1;
		}else if(var > arr[mid]) {
			comp++;
			l=mid+1;
		}else {
			comp++;
			h=mid-1;
		}
	}
	return (int) (Math.log10(arr.length-1)/Math.log10(2));
}

}
