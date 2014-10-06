public class FibonacciRecursion {

    public static void main(String[] args) {
        System.out.println("Starting fibonacci...");
        for(int i = 1; i<=10; i++){
            System.out.print(Fibonacci.calc(i) + " ");
        }

    } 

    public static int calc(int n) {
        if((n == 1 || n == 2)) return 1;

        return calc(n - 1) + calc(n-2);
    } 
}



        
