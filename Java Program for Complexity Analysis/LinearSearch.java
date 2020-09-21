import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LinearSearch {

public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\java file handling\\linear_search_analysis.txt");
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
			
			int comparisions=linear_search(arr,arr[0]);
			bw.write(String.format("Best_case\t\t\t%d\t\t\t%d\n",arrSize,comparisions));
			
			//if element is not present in the array.. it will be the worst case
			comparisions=linear_search(arr,-1);
			bw.write(String.format("Worst_case\t\t\t%d\t\t\t%d\n",arrSize,comparisions));
			
			//Avg case..taking a number at some index in middle...
			comparisions=linear_search(arr,arr[(arrSize-1)/3]);
			bw.write(String.format("Avg_case\t\t\t%d\t\t\t%d\n",arrSize,comparisions));
				
			k++;
			System.out.println("Success");
		}
		bw.close();

	}

	private static int linear_search(int[] arr, int var) {
		int comp=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==var) {
				return comp+1;
			}else {
				comp+=1;
			}
		}
		return arr.length-1;
	}

}
