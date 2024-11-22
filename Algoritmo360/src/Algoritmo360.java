import java.util.Scanner;

public class Algoritmo360 {
    private int[] ultdia = new int[12];
    private String[] signos = new String[12];

    // Método para preencher os signos e seus respectivos últimos dias
    public void preencherSignos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os signos e os últimos dias de cada mês:");
        for (int i = 0; i < 12; i++) {
            System.out.print("\nDigite o signo do mês " + (i + 1) + ": ");
            signos[i] = scanner.next();
            System.out.print("Digite o último dia do signo " + signos[i] + ": ");
            ultdia[i] = scanner.nextInt();
        }
    }

    // Método para processar e exibir o signo com base na data de nascimento
    public void identificarSignos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite a data no formato ddmm ou 9999 para terminar:");
        int data = scanner.nextInt();

        while (data != 9999) {
            int dia = data / 100;
            int mes = data % 100;
            mes--;

            if (dia > ultdia[mes]) {
                mes = (mes + 1) % 12;
            }

            System.out.println("\nSigno: " + signos[mes]);
            System.out.println("\nDigite a próxima data no formato ddmm ou 9999 para terminar:");
            data = scanner.nextInt();
        }

        System.out.println("\nPrograma encerrado.");
    }

    public static void main(String[] args) {
        Algoritmo360 algoritmo = new Algoritmo360();
        algoritmo.preencherSignos();
        algoritmo.identificarSignos();
    }
}

