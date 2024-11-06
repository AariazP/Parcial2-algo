package dinamica;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

public class MaximunSubArray {

    public static void main(String[] args) {
        MaximunSubArray msb = new MaximunSubArray();
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(msb.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add nums[i] to the current subarray or start a new subarray at nums[i]
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // Update the overall maximum if needed
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }


}
