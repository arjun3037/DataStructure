package array;

import java.util.ArrayList;

class SubArraySum
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    
    {
        ArrayList<Integer> array = new ArrayList<>();
        
        if (s == 0){
            array.add(-1);
            return array;
        }
        // Your code here
        
        int currSum = arr[0];
        int j =0;
        for(int i = 1 ; i <= n ; i++){
            
            while(currSum > s && j < n-1){
                currSum =currSum - arr[j];
                j++;
            }
            
            if(currSum == s){
                array.add(j+1);
                array.add(i);
                break;
            }
            
            if(i < n){
                currSum =currSum + arr[i];    
            }    
            
            
        }
        
        if(array.isEmpty()){
            array.add(-1);
        }
        return array;
    }
}
