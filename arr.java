
import java.util.*;


public class arr {
    public static void CountSort(int marks[]){
        //count largest
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<marks.length; i++){
            largest = Math.max(largest, marks[i]);
        }
        // put the numbers im the count index
        int count[] = new int[largest+1];
        for(int i=0;i<marks.length;i++){
            count[marks[i]]++;
        }
        //sort
        int j = 0;
        for(int i=0;i<count.length;i++){
            while(count[i] > 0){
                marks[j] = i;
                j++;
                count[i]--;
            }
        }

        PrintArray(marks);

    }
    public static void InsertionSort(int marks[]) {
        for(int i = 1; i< marks.length; i++){
            int curr = i;
            int prev = i-1;
            while(prev >=0 && marks[prev] > marks[curr]){ // try accending and decending
                marks[prev+1] = marks[prev];
                prev --;
            }
            marks[prev+1] = marks[curr];
        }
        PrintArray(marks);
    }
    public static void SelectionSort(int marks[]){
        for(int i=0; i<marks.length -1; i++){
            int minPos = i;
            for(int j=i+1; j< marks.length; j++){
                if(marks[minPos] > marks[j]){   // try accending and  decending
                    minPos = j;
                }
            }
            int temp = marks[minPos];
            marks[minPos] = marks[i];
            marks[i] = temp;
        }
        PrintArray(marks);
    }
    public static void BubbleSort(int marks[]){
        int swap = 0;
        for(int i = 0; i<marks.length -1; i++){
            for(int j = 0; j<marks.length -1-i; j++){
                if(marks[j] > marks[j+1]){     // > for accending   < for decending
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;

                    swap++;
                }
            }
        }
        if(swap==0){
            System.out.println("This is sorted array");
        }
        PrintArray(marks);
    }
    public static int BuyandSellStocks (int price[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i = 0; i<price.length; i++){
            if(buyPrice < price[i]){
                int profit = price[i] - buyPrice;
                maxprofit = Math.max(maxprofit, profit);
            }else{
                buyPrice = price[i];
            }
        }
        return maxprofit;
    }
    public static int TrapRainWater(int marks[]){
        // left max
        int LeftMax[] = new int[marks.length];
        LeftMax[0] = marks[0];
        for(int i = 1; i<marks.length; i++){
            LeftMax[i] = Math.max(LeftMax[i-1], marks[i]);
        }
        // right max
        int RightMax[] = new int[marks.length];
        RightMax[marks.length -1] = marks[marks.length -1];
        for(int j = marks.length -2; j>=0; j--){
            RightMax[j] = Math.max(RightMax[j+1], marks[j]);
        }

        //loop
        int trappedwater = 0;
        for(int i = 0; i<marks.length; i++){
            // water level = min(left max, right max)
            int waterlevel = Math.min(LeftMax[i], RightMax[i]);
            // area = water level -  height[i]
            trappedwater += waterlevel - marks[i];
        }
        return trappedwater;
    }
    public static void Kadans(int marks[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i=0; i<marks.length; i++){
            cs += marks[i];

            if(cs<0){
                cs = 0;
            }
            ms = Math.max(ms,cs);
        }
        System.out.println("max value by kadans algorithm : "+ms);
    }
    public static void MaxsubArraySumPrefix(int marks[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        int prefix[] = new int[marks.length];
        prefix[0] = marks[0];
        for(int i = 1; i<prefix.length; i++){
            prefix[i] = prefix[i-1]+ marks[i];
        }

        for(int i = 0;i<marks.length; i++){
            int start = i;
            for(int j = i; j<marks.length; j++){
                int end = j;

                cs = start == 0? prefix[end] : prefix[end] - prefix[start-1];

                if(ms<cs){
                    ms = cs;
                }
            }
        }
        System.out.println("Sum of all subarray by prefix sum is : "+ms);
    }

    public static void MaxsubArraySum(int marks[]){
        System.out.println("sum of all sub array ");
        int maxsum = Integer.MIN_VALUE;
        int currsum = 0;
        for (int i = 0; i < marks.length; i++) {
            int start = i;
            for (int j = i; j < marks.length; j++) {
                int end = j;
                currsum = 0;
                for(int k = start; k<=end; k++){
                    currsum += marks[k];
                }
                System.out.print(currsum);
                if(maxsum<currsum){
                    maxsum = currsum;
                }
                System.out.println();
                
            }
            System.out.println();
            
        }
        System.out.println("Maximun sum is : "+maxsum);
    }
    
    public static void SubArray(int marks[]){
        int totalsubarray = 0;
        for (int i = 0; i < marks.length; i++) {
            int start = i;
            for (int j = i; j < marks.length; j++) {
                int end = j;
                for(int k = start; k<=end; k++){
                    System.out.print(marks[k]+" ");
                }
                System.out.println();
            }
            System.out.println();
            totalsubarray++;
        }
        System.out.println("Total no of subarray is : "+totalsubarray);
    }

    public static void PairsArray(int marks[]){
        for(int i=0; i<marks.length;i++){
            for(int j=i+1; j<marks.length; j++){
                System.out.print("("+marks[i]+","+marks[j]+")");
            }
        }
    }

    public static void Reverse(int marks[]){
        
        //for(int i=0; i<marks.length; i++){
            int start = 0;
            int end = marks.length-1;
            for(int j=0; j<marks.length;j++){
                if(start <= end){
                int temp = marks[start];
                marks[start] = marks[end];
                marks[end] = temp;
                }
                start++;
                end--;
            }
        //}
        System.out.print("Reverse array is : ");
        PrintArray(marks);
    }

    public static int BinarySearch(int marks[], int key){
        int start = 0;
        int end = marks.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(marks[mid] ==key){
                return mid;
            }if(key>marks[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void MaxValue(int marks[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<marks.length; i++){
            if(marks[i] > max){
                max = marks[i];
            }
        }
        System.out.println("Maximum element of this is : "+max);
    }

    public static void MinValue(int marks[]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<marks.length; i++){
            if(marks[i] < min){
                min = marks[i];
            }
        }
        System.out.println("Minimum element of this is : "+min);
    }

    public static int LinearSearch(int marks[], int key){
        for(int i=0; i<marks.length; i++){
            if(marks[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static void UpdateArray(int marks[]){
        for(int i=0; i<marks.length; i++){
            marks[i] = marks[i] + 1;
        }
    }

    public static void PrintArray(int marks[]){
        for(int i=0; i<marks.length; i++){
           System.out.print(marks[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int marks[] = {3,5,10,5,6,4,9};

        // print main aray
        System.out.print("Main array is :");
        PrintArray(marks);
        
        // update and print new array
        // UpdateArray(marks);
        System.out.print("Update array is :");
        PrintArray(marks);

        // linearserach
        int keyforLinear = 5;
        int index = LinearSearch(marks,keyforLinear);
        if(index >= 0){
            System.out.println(keyforLinear+" found at index of : "+index);
        }else{
            System.out.println(keyforLinear + " not found in this array.");
        }

        // maximum value
        MaxValue(marks);
        // minimum value
        MinValue(marks);

        // Binary Search
        int keyforBinary = 10;
        int indexofBin = BinarySearch(marks,keyforBinary);
        if(indexofBin >= 0){
            System.out.println(keyforBinary+" found at index of : "+indexofBin);
        }else{
            System.out.println("binary search work only sorted array. so, "+keyforBinary + " not found in this array.");
        }

        // reverse array
        Reverse(marks);

        // Pairs of array
        System.out.print("Pairs of array is :" );
        PairsArray(marks);

        // SubArray
        System.out.println();
        SubArray(marks);

        // maximum subarray
        MaxsubArraySum(marks);

        // maximum sub array sum with prefix array
        MaxsubArraySumPrefix(marks);

        // kadans algorithms
        Kadans(marks);

        //trapping rain water
        System.out.println("Area of Ttrapped Rain Water is : "+TrapRainWater(marks));

        // Buy and Sell Stocks
        System.out.println("Maximum profit is : "+BuyandSellStocks(marks));



        // *******************sorting algorithm ********************

        // buuble sort
        System.out.println("After Bubble Sort The sorted array is : ");
        BubbleSort(marks);

        // selection sort
        System.out.println("After Selection sort the SORTED array is : ");
        SelectionSort(marks);

        // Insertion sort
        System.out.println("After Insertion sort the sorted array is : ");
        InsertionSort(marks);

        // inbuilt sort 
        Arrays.sort(marks);
        PrintArray(marks);


        // count sort
        System.out.println("After counting sort the sorted array is : ");
        CountSort(marks);
    }
}
