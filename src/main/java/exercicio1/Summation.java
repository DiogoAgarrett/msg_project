package exercicio1;

import java.util.function.Function;


public class Summation {
    public static int sum(Function<Integer, Integer> f, int inf, int sup) {
        int result = 0;
        for (int i = inf; i <= sup; i++) {
            result += f.apply(i);
        }
        return result;
    }
}
