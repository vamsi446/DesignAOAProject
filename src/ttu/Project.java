package ttu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Project {
	public static void main(String[] args) {
		int size =10000;
		int source1[] = new int[size];
		int source2[] = new int[size];
		int source3[] = new int[size];
		int source4[] = new int[size];
		int source5[] = new int[size];
		try {
			
			// read the input data from the given text files
			File s1File = new File("C:\\Users\\Vamsi\\Desktop\\Project1\\source1.txt");
			Scanner s1Reader = new Scanner(s1File);
			File s2File = new File("C:\\Users\\Vamsi\\Desktop\\Project1\\source2.txt");
			Scanner s2Reader = new Scanner(s2File);
			File s3File = new File("C:\\Users\\Vamsi\\Desktop\\Project1\\source3.txt");
			Scanner s3Reader = new Scanner(s3File);
			File s4File = new File("C:\\Users\\Vamsi\\Desktop\\Project1\\source4.txt");
			Scanner s4Reader = new Scanner(s4File);
			File s5File = new File("C:\\Users\\Vamsi\\Desktop\\Project1\\source5.txt");
			Scanner s5Reader = new Scanner(s5File);

			int i = 0;
			while (i < size) {
				source1[i] = Integer.parseInt(s1Reader.nextLine());
				source2[i] = Integer.parseInt(s2Reader.nextLine());
				source3[i] = Integer.parseInt(s3Reader.nextLine());
				source4[i] = Integer.parseInt(s4Reader.nextLine());
				source5[i] = Integer.parseInt(s5Reader.nextLine());
				i++;
			}
			s1Reader.close();
			s2Reader.close();
			s3Reader.close();
			s4Reader.close();
			s5Reader.close();
		} catch (FileNotFoundException exception) {
			System.out.println("Error Occurred: "+ exception.getMessage());
		} catch (NumberFormatException exception) {
			System.out.println("Error Occurred: "+ exception.getMessage());
		} catch (Exception exception) {
			System.out.println("Error Occurred: "+ exception.getMessage());
		}

		// Combined Rank is the summation of rank of each web page from all the sources
		int combinedRank[] = new int[10000];
		for (int i = 0; i < 10000; i++) {
			combinedRank[i] = source1[i] + source2[i] + source3[i] + source4[i] + source5[i];
		}
		int combinedRankIndex[] = new int[10000];
		List<IndexValuePair> combinedIndexValue = sortArrayWhileMemorizingIndex(combinedRank);
		int s1rearranged[] = new int[10000];
		int s2rearranged[] = new int[10000];
		int s3rearranged[] = new int[10000];
		int s4rearranged[] = new int[10000];
		int s5rearranged[] = new int[10000];
		int k=0;
		for(IndexValuePair obj:combinedIndexValue) {
			int index = obj.index;
			s1rearranged[k] = source1[index];
			s2rearranged[k] = source2[index];
			s3rearranged[k] = source3[index];
			s4rearranged[k] = source4[index];
			s5rearranged[k] = source5[index];
			k++;
		}
		
		System.out.println("--------------Merge Sort--------------------");
		MergeSort M1 = new MergeSort();				//Creates MergeSort object
		M1.sort(s1rearranged, 0, s1rearranged.length-1);	//Sorts array and counts inversions
		System.out.println(M1.getInversions());			//Displays # of inversions
		MergeSort M2 = new MergeSort();
		M2.sort(s2rearranged, 0, s2rearranged.length-1);
		System.out.println(M2.getInversions());
		MergeSort M3 = new MergeSort();
		M3.sort(s3rearranged, 0, s3rearranged.length-1);
		System.out.println(M3.getInversions());
		MergeSort M4 = new MergeSort();
		M4.sort(s4rearranged, 0, s4rearranged.length-1);
		System.out.println(M4.getInversions());
		MergeSort M5 = new MergeSort();
		M5.sort(s5rearranged, 0, s5rearranged.length-1);
		System.out.println(M5.getInversions());
		
		//Displays the rank of the source file based on its reliability
		Rank.sort(M1.getInversions(), M2.getInversions(), M3.getInversions(), M4.getInversions(), M5.getInversions());
		
		
		System.out.println("--------------Quick Sort--------------------");
		QuickSort Q1 = new QuickSort();
		Q1.sort(s1rearranged, 0, s1rearranged.length-1);
		System.out.println(Q1.getInversions());
		QuickSort Q2 = new QuickSort();
		Q2.sort(s2rearranged, 0, s2rearranged.length-1);
		System.out.println(Q2.getInversions());
		QuickSort Q3 = new QuickSort();
		Q3.sort(s3rearranged, 0, s3rearranged.length-1);
		System.out.println(Q3.getInversions());
		QuickSort Q4 = new QuickSort();
		Q4.sort(s4rearranged, 0, s4rearranged.length-1);
		System.out.println(Q4.getInversions());
		QuickSort Q5 = new QuickSort();
		Q5.sort(s5rearranged, 0, s5rearranged.length-1);
		System.out.println(Q5.getInversions());
		
		Rank.sort(Q1.getInversions(), Q2.getInversions(), Q3.getInversions(), Q4.getInversions(), Q5.getInversions());
		
		System.out.println("--------------Bubble Sort--------------------");
		BubbleSort B1 = new BubbleSort();
		B1.sort(s1rearranged, s1rearranged.length);
		System.out.println(B1.getInversions());
		BubbleSort B2 = new BubbleSort();
		B2.sort(s2rearranged, s2rearranged.length);
		System.out.println(B2.getInversions());
		BubbleSort B3 = new BubbleSort();
		B3.sort(s3rearranged, s3rearranged.length);
		System.out.println(B3.getInversions());
		BubbleSort B4 = new BubbleSort();
		B4.sort(s4rearranged, s4rearranged.length);
		System.out.println(B4.getInversions());
		BubbleSort B5 = new BubbleSort();
		B5.sort(s5rearranged, s5rearranged.length);
		System.out.println(B5.getInversions());
		
		Rank.sort(B1.getInversions(), B2.getInversions(), B3.getInversions(), B4.getInversions(), B5.getInversions());
		
	}
	
	//to store index value pair for the combined rank
	static class IndexValuePair {
        int index;
        int value;

        IndexValuePair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
	
	// To memorize the indices after sorting the combined rank array
	public static List<IndexValuePair> sortArrayWhileMemorizingIndex(int[] arr) {
        List<IndexValuePair> indexValuePairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            indexValuePairs.add(new IndexValuePair(i, arr[i]));
        }

        Collections.sort(indexValuePairs, new Comparator<IndexValuePair>() {
            @Override
            public int compare(IndexValuePair ivp1, IndexValuePair ivp2) {
                return Integer.compare(ivp1.value, ivp2.value);
            }
        });

        return indexValuePairs;
    }
	
	
}


class MergeSort {
    private int inversions = 0;
    public int getInversions() {
    	return inversions;
    }
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            sort(arr, left, m);
            sort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }
    
    public void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
                inversions += n1 - i;
            }
        }
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

}


 class QuickSort {
    private int countInversions = 0;
    
    public int getInversions() {
    	return countInversions;
    }
    
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex - 1);
            sort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
                countInversions += j - i;
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class BubbleSort {
	//Getter for inversions
	public int getInversions() {
    		return inversions;
    }
	
	private int inversions = 0;
	
	//BubbleSort method
	void sort(int arr[], int n) {
		//Traverse through the array
		for (int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i -1;j++) {
				//If data at j is greater than data at j+1, swap
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					//Increments inversion for every swap
					inversions++;
				}
			}
		}
	}
}


class Rank {
		
	//This method adds all inverse counts to an array and rearranged them in ascending order
	public static void sort(int inv1, int inv2, int inv3, int inv4, int inv5) {
		//Create array with inverse counts
		int[] arr = new int[]{inv1, inv2, inv3, inv4, inv5};
		//Create array with source file numbers
		int[] sourceList = new int[] {1, 2, 3, 4, 5};
		
		//Selection sort to order inverse counts in ascending order
		for(int i = 0;i<arr.length;i++) {
			for(int j = i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
					//If an inverse count is reordered, so is the corresponding source file
					temp = sourceList[j];
					sourceList[j] = sourceList[i];
					sourceList[i] = temp;
				}
			}
		}
		//Prints the rank of the source files from most reliable to least reliable
		System.out.println("Ranked");
		for(int k=0;k<5;k++) {
			System.out.println("Source " + sourceList[k]);
		}
	}
}
