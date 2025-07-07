class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        for (int i = 0; i < flowerbed.length; i++) {

            if (n == 0) break;

            int beforeNumber = (i <= 0) ? 0 : flowerbed[i - 1];
            int currentNumber = flowerbed[i];
            int nextNumber = (i >= flowerbed.length - 1) ? 0 : flowerbed[i + 1];

            if (beforeNumber == 0 && currentNumber == 0 && nextNumber == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return (n == 0);
    }
}

// https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75