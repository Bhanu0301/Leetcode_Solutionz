class Solution {
    List<String> res = new ArrayList<>();
    private void generate(List<String> list, int open, int closed, int n){
        if(open == closed && open == n){
            StringBuilder sb = new StringBuilder();
            for(String s : list){
                sb.append(s);
            }
            res.add(sb.toString());
        }
        if(open<n){
            list.add("(");
            generate(list, open+1, closed, n);
            list.remove(list.size()-1);
        }
        if(closed<open){
            list.add(")");
            generate(list, open, closed+1, n);
            list.remove(list.size()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, 0, 0, n);
        return res;
    }
}