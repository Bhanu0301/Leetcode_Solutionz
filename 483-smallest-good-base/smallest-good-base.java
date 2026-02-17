class Solution {
    private long sumPossible(long target, int terms, long base){
        long sum = 1;
        long curr = 1;
        for(int i = 1;i<=terms; i++){
            if(curr>target/base)return target+1;//overflow
            curr = curr * base;
            if(sum>target-curr)return target+1;//overflow
            sum = sum + curr;
        }
        return sum;
    }
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int maxTerms = (int)(Math.log(num) / Math.log(2));

        for(int i = maxTerms; i>=2; i--){//terms
            long left = 2;
            long right = (long) Math.pow(num, 1.0 / (i - 1)) + 5;

            while(left<=right){
                long mid = left + (right-left)/2;
                long sum = sumPossible(num, i, mid);
                if(sum==num)return String.valueOf(mid);
                else if(sum<num){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return String.valueOf(num-1);
    }
}