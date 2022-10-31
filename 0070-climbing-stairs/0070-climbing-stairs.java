class Solution {
    public int climbStairs(int n) {
             return climbStairsHelper(n,new HashMap<Integer,Integer>());

    }
    
        private int climbStairsHelper(int n , Map<Integer,Integer> map) {

        
        if (n==1)
            return 1;
        else if (n == 2) {
            return 2;
        }else {

            int stepsRemaining = n - 1;//stepsize 1 chosen
            Integer noOfWaysAfterstepChosenAs1 = map.get(stepsRemaining);
            if (noOfWaysAfterstepChosenAs1 == null){
                noOfWaysAfterstepChosenAs1 = climbStairsHelper(stepsRemaining, map);
                map.put(stepsRemaining,noOfWaysAfterstepChosenAs1);
            }

            stepsRemaining = n - 2;//stepsize 1 chosen
            Integer noOfWaysAfterstepChosenAs2 = map.get(stepsRemaining);
            if (noOfWaysAfterstepChosenAs2 == null){
                noOfWaysAfterstepChosenAs2 = climbStairsHelper(stepsRemaining, map);
                map.put(stepsRemaining,noOfWaysAfterstepChosenAs2);
            }
            return noOfWaysAfterstepChosenAs1+noOfWaysAfterstepChosenAs2;
        }
        
        }
    
}