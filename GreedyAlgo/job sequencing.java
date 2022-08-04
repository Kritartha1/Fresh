O(n^2)


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int[] ans=new int[2];
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        boolean[] job=new boolean[n];
        for(int i=0;i<n;i++){
            
            for(int j=Math.min(n-1,arr[i].deadline-1);j>=0;--j){
                if(!job[j]){
                    job[j]=true;
                    ans[1]+=arr[i].profit;
                    ans[0]++;
                    break;
                }
            }
            //System.out.println("i:"+i+"ans:"+ans[1]);
        }
        
        return ans;
    }
}





class Solution


{
    //O(nlogn)
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int[] ans=new int[2];
        Arrays.sort(arr,(a,b)->a.deadline-b.deadline);
        PriorityQueue<Job> maxH=new PriorityQueue<Job>((a,b)->{
            return b.profit-a.profit;
        });
        for(int i=n-1;i>=0;--i){
            int timeSlot;
            if(i==0){
                timeSlot=arr[i].deadline;
            }else{
                timeSlot=arr[i].deadline-arr[i-1].deadline;
            }
            maxH.add(arr[i]);
            while(timeSlot>0&&!maxH.isEmpty()){
                Job res=maxH.remove();//added to ans
                ans[1]+=res.profit;
                ans[0]++;
                timeSlot--;
            }
        }
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/


