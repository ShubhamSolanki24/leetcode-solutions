class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(1,k,n,new LinkedList(),result);
        return result; 
    }
    private void combination(int start,int k,int n,LinkedList ll, List<List<Integer>> result){
       if(k<0|| n<0){
           return ;
       } 
        if(k==0 && n==0){
            result.add(new ArrayList(ll));
        }
        for(int i =start ;i<=9;i++){
            ll.add(i);
            combination(i+1,k-1,n-i,ll,result);
            ll.removeLast();
        }

    }
    
    
    
}