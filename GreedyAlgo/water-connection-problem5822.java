https://practice.geeksforgeeks.org/problems/water-connection-problem5822/1
class Solution 
{ 
    class Pair{
        int home;
        int dia;
        Pair(int home,int dia){
            this.home=home;
            this.dia=dia;
        }
    }
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b ,ArrayList<Integer> d) 
    { 
         // code here
         HashMap<Integer,ArrayList<Pair>> mp=new HashMap<>();
         int parent[]=new int[21];
         Arrays.fill(parent,-1);
         boolean[] vis=new boolean[21];
         for(int i=0;i<p;i++){
             mp.putIfAbsent(a.get(i),new ArrayList<Pair>());
             mp.get(a.get(i)).add(new Pair(b.get(i),d.get(i)));
             int from=find(a.get(i),parent);
             if(from!=b.get(i)){
                parent[b.get(i)]=from;
                
             }else{
                 vis[from]=true;
             }
             
         }
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
         
         int t=0;
         for(int i=0;i<p;i++){
             if(!vis[a.get(i)]){
                 int from=find(a.get(i),parent);
                 if(!vis[from]){
                    dfs(n,p,mp,vis,ans,from,from,mp.get(from).get(0).dia);
                     
                 }
             }
             
             
         }
         Collections.sort(ans,(A,B)->{return A.get(0)-B.get(0);});
         return ans;
     }
     int find(int curr,int[] parent){
         if(parent[curr]==-1){
             return curr;
         }
         return parent[curr]=find(parent[curr],parent);
     }
     void dfs(int n,int p,HashMap<Integer,ArrayList<Pair>> mp,boolean[] vis,ArrayList<ArrayList<Integer>> ans,int from,int curr,int min){
         vis[curr]=true;
         ArrayList<Pair> x=mp.getOrDefault(curr,new ArrayList<>());
         for(Pair neighbour:x){
             if(!vis[neighbour.home]){
                dfs(n,p,mp,vis,ans,from,neighbour.home,Math.min(min,neighbour.dia)); 
                 
             }
             
         }
         if(x.size()==0){//means woh last house hai jissme outgoing pipe nhi hai
            
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(from);
                temp.add(curr);
                temp.add(min);
                ans.add(temp);
             
         }
            
     }
     
} 
