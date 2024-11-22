import java.util.Scanner;

public class Algoritmo354 {


    public void executar() {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[15];


        for (int L = 0; L < 15; L++) {
            System.out.print((L + 1) + "º número: ");
            num[L] = scanner.nextInt();
        }


        System.out.println("\nRELACÃO DOS NÚMEROS");
        for (int L = 0; L < 15; L++) {
            System.out.print((L + 1) + " - " + num[L]);
            if (num[L] % 2 == 0) {
                System.out.println(" é PAR");
            } else {
                System.out.println(" é ÍMPAR");
            }
        }

        scanner.close();
    }


    public static void main(String[] args) {
        Algoritmo354 algoritmo = new Algoritmo354();
        algoritmo.executar();
    }
}