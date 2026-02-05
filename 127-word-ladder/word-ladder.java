class Pair{
    String first;
    int second;
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.poll();
            if(word.equals(endWord)){
                return step;
            }
            int size = word.length();
            for(int i = 0;i<size; i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] charWord = word.toCharArray();
                    charWord[i] = ch;
                    String newWord = new String(charWord);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, step+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}