import game.GameSolver;
import input.InputHandler;

public class PredictTheWinner {

    public static void main(String[] args) {
        int[] nums = InputHandler.getValidArray(1, 20, 0, 10000000);

        boolean canWin = GameSolver.canPlayer1Win(nums);

        System.out.println("\nМожет ли Игрок 1 выиграть? " + (canWin ? "Да" : "Нет"));
    }

}