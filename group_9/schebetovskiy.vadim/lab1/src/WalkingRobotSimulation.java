import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class WalkingRobotSimulation {
    // Направление робота: 0 - север, 1 - восток, 2 - юг, 3 - запад
    // Массив смещений для каждого направления (север, восток, юг и запад соответственно)
    public static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int robotSim(int[] commands, int[][] obstacles) {

        int direction = 0;
        int curCoordX = 0;
        int curCoordY = 0;
        int maxDistance = 0;

        // Создаем Set препятствий для быстрого доступа
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if (command == -2) { // Поворот налево
                direction = (direction + 3) % 4;
            } else if (command == -1) { // Поворот направо
                direction = (direction + 1) % 4;
            } else { // Движение вперед
                int deltaX = DIRECTIONS[direction][0];
                int deltaY = DIRECTIONS[direction][1];

                for (int i = 0; i < command; i++) {
                    int nextCoordX = curCoordX + deltaX;
                    int nextCoordY = curCoordY + deltaY;

                    // Проверяем, не находится ли следующая позиция на препятствии
                    if (obstacleSet.contains(nextCoordX + "," + nextCoordY)) {
                        break;
                    }

                    curCoordX = nextCoordX;
                    curCoordY = nextCoordY;
                    maxDistance = Math.max(maxDistance, curCoordX * curCoordX + curCoordY * curCoordY);
                }
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {

        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2, 4}};
        int maxDistance = robotSim(commands, obstacles);

        System.out.println("Команды: " + Arrays.toString(commands));
        System.out.println("Препятствия:");
        for (int[] obstacle : obstacles)
            System.out.println(Arrays.toString(obstacle));
        System.out.println("Максимальная дистанция: " + maxDistance);

    }
}