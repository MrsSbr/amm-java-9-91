public class Main
{
    public static boolean isMagicSquare(int[][] arr, int row, int col)
    {
        int[] is_uniq = new int[9];
        for (int i = row; i < row + 3; i++)
        {
            for (int j = col; j < col + 3; j++)
            {
                if (arr[i][j] < 1 || arr[i][j] > 9)
                    return false;
                is_uniq[arr[i][j] - 1]++;
            }
        }

        for (int i = 0; i < 9; i++)
        {
            if(is_uniq[i] > 1)
                return false;
        }

        int sum = arr[row][col] + arr[row + 1][col] + arr[row + 2][col];

        for (int i = row; i < row + 3; i++)
        {
            if (arr[i][col] + arr[i][col + 1] + arr[i][col + 2] != sum)
                return false;
        }

        for (int j = col; j < col + 3; j++)
        {
            if (arr[row][j] + arr[row + 1][j] + arr[row + 2][j] != sum)
                return false;
        }

        if (arr[row][col] + arr[row + 1][col + 1] + arr[row + 2][col + 2] != sum)
            return false;

        if (arr[row][col + 2] + arr[row + 1][col + 1] + arr[row + 2][col] != sum)
            return false;

        return true;
    }
    public static int numMagisSquares(int[][] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++)
        {
            for (int j = 0; j < arr[0].length - 2; j++)
            {
                if (isMagicSquare(arr, i, j))
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        int[][] array = {{2, 9, 4, 2}, {7, 5, 3, 7}, {6, 1, 8, 6}};

        System.out.println("Массив:");

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[0].length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }

        int count = numMagisSquares(array);
        System.out.println("Количество магических квадратов: " + count);
    }
}