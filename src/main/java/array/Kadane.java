
class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        int me = 0;
        int ms = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            me+=arr[i];
            if(ms < me){
                ms = me;
            }
            if(me < 0){
                me =0;
            }
        }
        return ms;
    }
}
