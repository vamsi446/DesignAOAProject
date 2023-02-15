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
		int s1[] = new int[10000];
		int s2[] = new int[10000];
		int s3[] = new int[10000];
		int s4[] = new int[10000];
		int s5[] = new int[10000];
		try {
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
			while (i < 10000 && s1Reader.hasNextLine()) {
				s1[i] = Integer.parseInt(s1Reader.nextLine());
				s2[i] = Integer.parseInt(s2Reader.nextLine());
				s3[i] = Integer.parseInt(s3Reader.nextLine());
				s4[i] = Integer.parseInt(s4Reader.nextLine());
				s5[i] = Integer.parseInt(s5Reader.nextLine());
				i++;
			}
			s1Reader.close();
			s2Reader.close();
			s3Reader.close();
			s4Reader.close();
			s5Reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} catch (NumberFormatException a) {
			System.out.println("An error occurred.");
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		int combined[] = new int[10000];
		for (int i = 0; i < 10000; i++) {
			combined[i] = s1[i] + s2[i] + s3[i] + s4[i] + s5[i];
		}
		int combinedIndex[] = new int[10000];
		List<IndexValuePair> combinedIndexValue = sortArrayWhileMaintainingIndex(combined);
		int s1rearranged[] = new int[10000];
		int s2rearranged[] = new int[10000];
		int s3rearranged[] = new int[10000];
		int s4rearranged[] = new int[10000];
		int s5rearranged[] = new int[10000];
		int k=0;
		for(IndexValuePair obj:combinedIndexValue) {
			int index = obj.index;
			s1rearranged[k] = s1[index];
			s2rearranged[k] = s2[index];
			s3rearranged[k] = s3[index];
			s4rearranged[k] = s4[index];
			s5rearranged[k] = s5[index];
			k++;
		}
		
		
		
		
		MergeSort M1 = new MergeSort();
		M1.sort(s1rearranged, 0, s1rearranged.length-1);
		System.out.println(M1.getInversions());
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
		
	}
	
	static class IndexValuePair {
        int index;
        int value;

        IndexValuePair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
	
	public static List<IndexValuePair> sortArrayWhileMaintainingIndex(int[] arr) {
        List<IndexValuePair> indexValuePairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            indexValuePairs.add(new IndexValuePair(i, arr[i]));
        }

        Collections.sort(indexValuePairs, new Comparator<IndexValuePair>() {
            @Override
            public int compare(IndexValuePair o1, IndexValuePair o2) {
                return Integer.compare(o1.value, o2.value);
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
    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    
    public void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
                inversions += n1 - i;
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




