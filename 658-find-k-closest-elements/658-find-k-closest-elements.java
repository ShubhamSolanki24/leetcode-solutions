class Solution {
   // TC -nlogk 
  /*    public static class Pair implements Comparable <Pair>{
       int val;
       int gap;
       Pair(){

       }
       Pair(int val,int gap){
           this.val= val;
           this.gap =gap;
       }

     public int compareTo(Pair o){
         if(this.gap == o.gap){
          return this.val -o.val;
         }else {
         return this.gap -o.gap; 
         }
     }

   }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         ArrayList<Integer> list = new ArrayList<>();
       PriorityQueue<Pair> pq =  new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(new Pair(arr[i],Math.abs(arr[i] - x)));
            }
            else {
                if(pq.peek().gap > Math.abs(arr[i]-x)){
                    pq.remove();
                    pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
                }
            }
        }
        while(pq.size()>0){
            Pair rem = pq.remove();
            list.add(rem.val);
        }
        Collections.sort(list);

        return list;
     */
    
    
    //Optimised Approach
      public List<Integer> findClosestElements(int[] arr, int k, int x) {
          int l = 0;
        int r = arr.length - k;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                l = mid + 1;
            else 
                r = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
        return res;
}
}
    