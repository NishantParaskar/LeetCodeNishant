class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return KokoBananaProblem(piles, h);
    }

    private static int KokoBananaProblem(int[] nums, int h) {

        int max = Arrays.stream(nums).max().getAsInt(); // Find max

        int low = 1;
        int high = max;

        int ans = -1;
        while (low <= high) {

            int mid = (low + high) / 2;
            int completedInHour = EatingInhour(nums, mid);
            if (completedInHour <= h) {

                ans = mid; // it could be the answer still check for meaning ans ;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;
    }

    static int EatingInhour(int nums[], int mid) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.ceil((double) nums[i] / (double) (mid));

        }
        return ans; // check in left side
    }

}

































































// ref: https://www.youtube.com/watch?v=qyfekrNni90&t=474s
// https://takeuforward.org/binary-search/koko-eating-bananas/
// take you forward