
//Algoritmo 398//

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static final int MAX_PRODUTOS = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] codigos = new int[MAX_PRODUTOS];
        int[] quantidades = new int[MAX_PRODUTOS];
        double[] precos = new double[MAX_PRODUTOS];
        int totalProdutos = 0;
        double totalVendas = 0.0;


        System.out.println("Digite o código do produto ou -1 para encerrar o cadastro:");
        int codigo = scanner.nextInt();

        while (codigo != -1 && totalProdutos < MAX_PRODUTOS) {
            codigos[totalProdutos] = codigo;
            System.out.print("Digite a quantidade disponível: ");
            quantidades[totalProdutos] = scanner.nextInt();
            System.out.print("Digite o preço do produto: ");
            precos[totalProdutos] = scanner.nextDouble();

            totalProdutos++;
            System.out.println("Digite o código do próximo produto ou -1 para encerrar o cadastro:");
            codigo = scanner.nextInt();
        }

        if (totalProdutos == MAX_PRODUTOS) {
            System.out.println("Cadastro completo. Não é possível adicionar mais produtos.");
        }


        System.out.println("\nDigite o código do produto para venda ou 0 para encerrar as vendas:");
        codigo = scanner.nextInt();

        while (codigo != 0) {
            int index = buscarProduto(codigos, totalProdutos, codigo);

            if (index == -1) {
                System.out.println("Produto Não-Cadastrado.");
            } else {
                System.out.print("Digite a quantidade requerida: ");
                int quantidadeRequerida = scanner.nextInt();

                if (quantidades[index] >= quantidadeRequerida) {
                    quantidades[index] -= quantidadeRequerida;
                    double venda = quantidadeRequerida * precos[index];
                    totalVendas += venda;
                    System.out.printf("Venda realizada! Total: R$ %.2f%n", venda);
                } else {
                    System.out.println("Estoque Insuficiente.");
                }
            }

            System.out.println("\nDigite o código do próximo produto para venda ou 0 para encerrar:");
            codigo = scanner.nextInt();
        }


        System.out.println("\nRelatório Final:");
        System.out.printf("Total vendido no dia: R$ %.2f%n", totalVendas);
        System.out.println("Produtos em estoque (em ordem decrescente de quantidade):");

        ordenarPorQuantidade(codigos, quantidades, precos, totalProdutos);

        for (int i = 0; i < totalProdutos; i++) {
            System.out.printf("Código: %d | Quantidade: %d | Preço: R$ %.2f%n",
                    codigos[i], quantidades[i], precos[i]);
        }

        scanner.close();
    }

    // Método para buscar o índice de um produto no vetor
    private static int buscarProduto(int[] codigos, int totalProdutos, int codigo) {
        for (int i = 0; i < totalProdutos; i++) {
            if (codigos[i] == codigo) {
                return i;
            }
        }
        return -1;
    }

    // Método para ordenar os produtos em ordem decrescente de quantidade
    private static void ordenarPorQuantidade(int[] codigos, int[] quantidades, double[] precos, int totalProdutos) {
        Integer[] indices = new Integer[totalProdutos];
        for (int i = 0; i < totalProdutos; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingInt((Integer i) -> quantidades[i]).reversed());

        int[] codTemp = new int[totalProdutos];
        int[] quantTemp = new int[totalProdutos];
        double[] precoTemp = new double[totalProdutos];

        for (int i = 0; i < totalProdutos; i++) {
            codTemp[i] = codigos[indices[i]];
            quantTemp[i] = quantidades[indices[i]];
            precoTemp[i] = precos[indices[i]];
        }

        System.arraycopy(codTemp, 0, codigos, 0, totalProdutos);
        System.arraycopy(quantTemp, 0, quantidades, 0, totalProdutos);
        System.arraycopy(precoTemp, 0, precos, 0, totalProdutos);
    }
}
