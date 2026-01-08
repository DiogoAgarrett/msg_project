package exercicio1;

public class Cliente {
    public static void main(String[] args) {

        // Σ (4 + sin(i)) from i=1 to i=10
        int result = Summation.sum(
                i -> 4 + (int) Math.sin(i),
                1,
                10
        );
        System.out.println(result);
    }
}

