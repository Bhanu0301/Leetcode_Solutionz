class Solution {
    public int reversePairs(int[] arr) {
        int count = 0;
        count = mergeSort(arr,0,arr.length-1);
        return count;
    }
    int mergeSort(int arr[],int low, int high){
        int inv = 0;
        if(low<high){
            int mid = (low+high)/2;
            inv = inv + mergeSort(arr,low,mid);
            inv = inv + mergeSort(arr,mid+1,high);
            inv = inv + merge(arr,low,mid,high);
        }
        return inv;
    }
    static int merge(int[] nums, int l, int m, int r){
        int inv = 0;
        int n1 = m-l+1;
        int n2 = r-m;
        int left = l;
        int right = m+1;
        while(left<=m && right<=r){
          if(nums[left]> 2L*nums[right]){
               inv = inv + (m-left+1);
               right++;
          }
          else{
               left++;
          }
        }
        int[] L = new int[n1];
        int[] R = new int[n2];
        int k = 0;
        for(int i = l; i<=m;i++){
          L[k++] = nums[i];
        }
        k = 0;
        for(int i = m+1; i<=r; i++){
          R[k++] = nums[i];
        }
        int i = 0;
        int j = 0;
        k = 0;
        int[] temp = new int[r-l+1];
        while(i<L.length && j<R.length){
          //temp[k++] = L[i]<=R[j]? L[i++]:R[j++];
          if(L[i]<=R[j]){
            temp[k++] = L[i++];
          }
          else {
          //    inv = inv + (n1-i);
             temp[k++] = R[j++];
          }
        }
        while(i<L.length){
          temp[k++] = L[i++];
        }
        while(j<R.length){
          temp[k++] = R[j++];
        }
        for(int x = 0; x < temp.length; x++){
          nums[l + x] = temp[x];
        }

        return inv;
    }
}