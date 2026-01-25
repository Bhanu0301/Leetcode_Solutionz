class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ans = 0;
        //|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
        //i<j => |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + (j-i)
        //=> +/-(arr1[i] - arr1[j]) + +/-(arr2[i] - arr2[j]) + (j-i)
        //=> +/-arr1[i] -/+arr1[j] +/-arr2[i] -/+ arr2[j] + j - i
        //=> (-/+arr1[j] -/+arr2[j] + j) - (-/+arr1[i] -/+arr2[i] + i)
        //=> f(j) - f(i) where f(i) = -/+(arr1[i]+arr2[i]+i)

        //we need to maximize the difference.
        //max(f(j)) - min(f(i))
        int[] P = {1,-1,1,-1};
        int[] Q = {1,1,-1,-1};
        for(int i = 0;i<4; i++){
            int p = P[i];
            int q = Q[i];
            int minF = Integer.MAX_VALUE;
            for(int j=0;j<arr1.length; j++){
                int f = p*arr1[j] + q*arr2[j] + j;
                minF = Math.min(minF, f);
                ans = Math.max(ans, f-minF);
            }
        }
        return ans;
        //f(i) = p*arr1[i] + q*arr2[i] + i, where p,q={+/-1}
        
    }
}