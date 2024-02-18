package game;

public class GameSolver {

    public static boolean canPlayer1Win(int[] nums) {
        return canWin(nums, 0, nums.length - 1, 1) >= 0;
    }

    private static int canWin(int[] nums, int start, int end, int player) {
        if (start == end) {
            return player * nums[start];
        }

        int scoreStart = player * nums[start] + canWin(nums, start + 1, end, -player);
        int scoreEnd = player * nums[end] + canWin(nums, start, end - 1, -player);

        return player * Math.max(player * scoreStart, player * scoreEnd);
    }

}