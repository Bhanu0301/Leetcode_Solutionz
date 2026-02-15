class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0;
        boolean sign = true; //negative sign?
        if((dividend>=0 && divisor>0) || (dividend<=0 && divisor<0))
            sign = false;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        while(a>=b){
            int power = 0;
            while(a>=((b<<(power+1)))){
                power++;
            }
            ans = ans + (1<<power);
            a = a - (b<<power);
        }
        if(sign && ans==(1<<31)){
            return Integer.MIN_VALUE;
        }
        if(!sign && ans==(1<<31)){
            return Integer.MAX_VALUE;
        }
        return sign?-1*ans : ans;
    }
}