class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5=0;
        int count10=0;
        int count20=0;
        for(int price:bills){
            if(price==5){
                count5++;
            }
            else if(price==10){
                count10++;
                if(count5>=1)count5--;
                else return false;
            }
            else{
                count20++;
                if(count10>=1 && count5>=1){
                    count10--;
                    count5--;
                }
                else if(count5>=3)count5=count5-3;
                else return false;
            }
        }
        return true;
    }
}