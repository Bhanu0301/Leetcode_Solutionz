class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);//g->children greeed content 
        Arrays.sort(s);//s->cookie size

        //Moto is to assign the least content cookie to the child
        int i=0,j=0;
        int count = 0;
        while(i<g.length && j<s.length){
            if(g[i]<=s[j]){
                count++;
                i++;
            }
            //else
            j++; //increase cookie size
        }
        return count;
    }
}