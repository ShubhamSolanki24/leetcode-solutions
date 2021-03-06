class Solution {
    public int findUnsortedSubarray(int[] nums) {
        /*Approach 1 Tc(ologn) sc- o(n)
        int[] arr= new int[nums.length];
        for(int i =0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int start =0; int end = nums.length-1;
        for(;start<nums.length;start++){
            if(nums[start] != arr[start])break;
        }
        if(start>=nums.length -1)return 0;
        for(;end>=0;end--){
            if(nums[end] !=arr[end])break;
        }
        return end-start +1;
        */
        //Approach 2 TC- O(N) sc-O(1)       
        int min =Integer.MAX_VALUE,max= Integer.MIN_VALUE;
        int n = nums.length;
        for(int i =1;i<n;i++){ 
            //decreasing value
            if(nums[i] <nums[i-1]){
                min= Math.min(min,nums[i]);
            }
        }
        for(int i =n-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                max= Math.max(max,nums[i]);
            }
        }
        if(min == Integer.MAX_VALUE && max==Integer.MIN_VALUE)return 0;
        int start =0,end= n-1; 
        for(;start<n;start++){
            if(nums[start]>min) break; 
        }
        for(;end>=0 ;end--){
            if(nums[end]<max) break;
        }
        return end-start+1;
    
    }
}