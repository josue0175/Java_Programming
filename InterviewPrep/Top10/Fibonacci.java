public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("Starting fibonacci...");
        for(int i = 1; i<=10; i++){
            System.out.print(Fibonacci.calc(i) + " ");
        }

    } 

    public static int calc(int n) {
        int result = 1;
        int seed1 = 1;
        int seed2 = 1;
        if((n == 1 || n == 2)) return 1;

        for(int i=3; i<=n; i++){
            result = seed1 + seed2;
            seed1 = seed2;
            seed2 = result;

        }        
        return result;
    } 
}



        
