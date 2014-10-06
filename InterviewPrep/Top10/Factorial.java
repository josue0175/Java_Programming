public class Factorial {

    public static void main(String[] args){
        System.out.print(Factorial.factorial(5));
    }

    public static int factorial(int n){
        if(n == 0) return 1;

        return n * factorial(n - 1);
    }
}
