//Time O(nlogn)

class Solution {
    class Pair{
        int data;
        char c;
        Pair left;
        Pair right;
        Pair(int data,char c){
            this.data=data;
            this.c=c;
        }
        Pair(Pair left,Pair right){
            this.c='-';
            this.left=left;
            this.right=right;
            this.data=left.data+right.data;
            
        }
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        ArrayList<String> ans=new ArrayList<String>();
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a,Pair b){
                return a.data==b.data?1:a.data-b.data;
                
            }
        });
        for(int i=0;i<N;i++){
            pq.add(new Pair(f[i],S.charAt(i)));
            
        }
        Pair root=null;
        
        while(pq.size()>1){
            Pair x=pq.poll();
            Pair y=pq.poll();
            Pair curr=new Pair(x,y);
            pq.add(curr);
            
            root=curr;
            
        }
        solve(root,"",ans);
        return ans;
    }
    void solve(Pair root,String s,ArrayList<String> ans){
        if(root.c!='-'){
            ans.add(s);
            return ;
        }
        solve(root.left,s+"0",ans);
        solve(root.right,s+"1",ans);
    }
}
