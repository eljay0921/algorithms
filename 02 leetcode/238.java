class Solution {
    public int[] productExceptSelf(int[] nums) {


        // v1 : time complexity O(n)

        // int[] leftProducts = new int[nums.length];
        // int[] rightProducts = new int[nums.length];

        // leftProducts[0] = 1;                    // 1, , ,  
        // rightProducts[nums.length - 1] = 1;     //  , , , 1

        // for (int i = 1; i < nums.length; i++) {

        //     // 1 -->> 1 * [0] -->> (1 * [0]) * [1] -->> ((1 * [0]) * [1]) * [2]
        //     leftProducts[i] = leftProducts[i - 1] * nums[i - 1];

        //     // [1] * ([2] * ([3] * 1)) <<-- [2] * ([3] * 1) <<-- [3] * 1 <<-- 1 
        //     rightProducts[(nums.length - i) - 1] = nums[nums.length - i] * rightProducts[nums.length - i];  
        // }
        
        // int[] results = new int[nums.length];
        // for (int i = 0; i < leftProducts.length; i++) {
        //     results[i] = leftProducts[i] * rightProducts[i];
        // }

        // return results;



        // v2 : follow up (space complexity O(1))

        int size = nums.length;
        int[] results = new int[size];
        results[0] = 1;
        for (int i = 1; i < size; i++) {

            // v1에서 한 것처럼 left 값을 먼저 담고
            results[i] = results[i - 1] * nums[i - 1];
        }

        // 같은 배열 활용해서 right 값 곱하기
        int rights = 1;
        for (int i = size - 1; i >= 0; i--) {
            results[i] = results[i] * rights;
            rights = nums[i] * rights;
        }

        return results;
    }
}