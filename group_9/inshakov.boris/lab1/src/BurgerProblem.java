import java.util.ArrayList;
import java.util.List;

public class BurgerProblem {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        
        int bigTasty = (tomatoSlices - 2 * cheeseSlices) / 2;
        int junior = cheeseSlices - bigTasty;
        
        // Проверяем, чтобы все ингредиенты были использованы и количество бургеров было неотрицательно
        if (4 * bigTasty + 2 * junior == tomatoSlices && bigTasty + junior == cheeseSlices && bigTasty >= 0 && junior >= 0) {
            result.add(bigTasty);
            result.add(junior);
    }
    
        return result;
    }
    
    public static void main(String[] args) {
        BurgerProblem burgerProblem = new BurgerProblem();
        System.out.println(burgerProblem.numOfBurgers(16, 7)); // [1,6]
        System.out.println(burgerProblem.numOfBurgers(17, 4)); // []
        System.out.println(burgerProblem.numOfBurgers(4, 17)); // []
    }
    }