import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MinMax {

	public static void main(String[] args) throws IOException {
		
		File f=new File("D:\\Algorithm time Complexity analysis\\min_max_comp_analysis.txt");
		BufferedWriter bw=new BufferedWriter(new FileWriter(f,false),2);
		
		//50000,75000,100000,125000,150000,175000,200000
		List<Integer> TestCase=Arrays.asList(50000,75000,100000,125000,150000,175000,200000);
		int[] arr;

		
		int k=0;
		bw.write("Number_of_Input\t\t\tNumber_of_comparisions\n");
		
		while(k < TestCase.size()) {
			
			int arrSize=TestCase.get(k);
			arr=new int[arrSize];
			
			Random rand=new Random();    // To Generate Random Numbers...
			
			for(int i=0;i<arrSize;i++) {
				arr[i]=rand.nextInt(arrSize*10);			//Filling Numbers in the range of (0, arrSize*10-1) in array of size arrSize
			}
			
			
			CountComparisons=0;
			//Avg case.....
			Pair minmax=minMax(arr,0,arr.length-1);
			bw.write(String.format("%d\t\t\t%d\n",arrSize,CountComparisons));
			
//			System.out.println(minmax.min+" "+minmax.max+" "+CountComparisons);
			
			k++;
			System.out.println("Success");
		}
		bw.close();

	}
	
	static int CountComparisons;
	
	static class Pair{
		int min;
		int max;
		
		Pair(int min,int max){
			this.min=min;
			this.max=max;
		}
	}
	
	// By Tournament Method
	private static Pair minMax(int[] arr, int l,int h) {
		if(l==h) {
			return new Pair(arr[l],arr[h]);
		}
		else if(l==h-1) {
			CountComparisons++;
			if(arr[l]>arr[h]) {
				return new Pair(arr[h],arr[l]);
			}else {
				return new Pair(arr[l],arr[h]);
			}
		}
		int mid=l+(h-l)/2;
		Pair minmaxl=minMax(arr,l,mid);
		Pair minmaxr=minMax(arr,mid+1,h);
		int localmin,localmax;
		
		CountComparisons+=2;
		
		if(minmaxl.min < minmaxr.min) {
			localmin=minmaxl.min;
		}else {
			localmin=minmaxr.min;
		}
		
		if(minmaxl.max > minmaxr.max) {
			localmax=minmaxl.max;
		}else {
			localmax=minmaxr.max;
		}
		
		return new Pair(localmin,localmax);
	}


}
