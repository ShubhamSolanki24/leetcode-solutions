class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> result= new ArrayList<List<Integer>>();
        recurse(nums,0,result);
        return result;
    }
    
    private void recurse(int[] nums, int idx, List<List<Integer>>result){
        
        if(idx==nums.length-1){
            List<Integer> tmp = 
                Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(tmp);
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            
            // checking if already swapped nums[idx] with element at index i
            int j = i - 1;
            while (j >= idx && nums[j] != nums[i])  j--; // looping to check all numbers between [idx , i]
            if (j != idx - 1) continue; // if already swapped, loop will break before reaching idx-1 and hence we continue to next iteration
            
            swap(nums,idx,i);
            recurse(nums,idx+1,result);
            swap(nums,idx,i);
        }
    }
    
    private void swap(int[] arr, int i, int j){
        if(i==j)return;
        int tmp = arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;  
    }
}