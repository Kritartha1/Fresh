//BFS
//leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

//TreeList is taken bcoz a node of a tree can have max three nodes adjacent to it--> 1 parent node, 2 children nodes.

class Solution {
    class Pair{
        int val;
        int dist;
        Pair(int val,int dist){
            this.val=val;
            this.dist=dist;
        }
    }
    class TreeList{
        int node;
        int i;
        int[] l;
        TreeList(){
            
            this.l=new int[3];
            l[0]=-1;
            l[1]=-1;
            l[2]=-1;
            
        }
        void add(int to){
            
            l[this.i]=to;
            this.i=this.i+1;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    
        HashMap<Integer,TreeList> mp=buildGraph(root);
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(target.val,0));
        boolean[] vis=new boolean[501];
        List<Integer> ans=new LinkedList<>();
        
        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(curr.dist==k){
                ans.add(curr.val);
            }else if(curr.dist>k){
                return ans;
            }
            vis[curr.val]=true;
            int[] neighbours=mp.get(curr.val).l;
            for(int i=0;i<3&&neighbours[i]!=-1;i++){
                if(!vis[neighbours[i]]){
                    q.add(new Pair(neighbours[i],curr.dist+1));
                }
            }
        }
        return ans;
        
        
    }
    HashMap<Integer,TreeList> buildGraph(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        HashMap<Integer,TreeList> mp=new HashMap<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            mp.putIfAbsent(curr.val,new TreeList());
            if(curr.left!=null){
                
                mp.get(curr.val).add(curr.left.val);
                mp.putIfAbsent(curr.left.val,new TreeList());
                mp.get(curr.left.val).add(curr.val);
                q.add(curr.left);
            }
            
            if(curr.right!=null){
                
                mp.get(curr.val).add(curr.right.val);
                mp.putIfAbsent(curr.right.val,new TreeList());
                mp.get(curr.right.val).add(curr.val);
                q.add(curr.right);
            }
        }
        return mp;
    }
    
}
