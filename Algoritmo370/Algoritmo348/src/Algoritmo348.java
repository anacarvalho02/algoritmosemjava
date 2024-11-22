import java.util.Scanner;

public class Algoritmo348 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Aluno[] alunos = new Aluno[5];


        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Digite o nome do " + (i + 1) + "º aluno:");
            String nome = scanner.nextLine();

            System.out.println("Digite a 1ª nota do aluno:");
            double nota1 = scanner.nextDouble();

            System.out.println("Digite a 2ª nota do aluno:");
            double nota2 = scanner.nextDouble();


            scanner.nextLine();


            alunos[i] = new Aluno(nome, nota1, nota2);
        }


        System.out.println("\n\t\t\tRELACAO FINAL");
        for (int i = 0; i < alunos.length; i++) {
            System.out.println((i + 1) + " - " + alunos[i].getNome());
            System.out.println("Notas: " + alunos[i].getNota1() + ", " + alunos[i].getNota2());
            System.out.println("Média: " + alunos[i].calcularMedia());
        }

        scanner.close();
    }
}


class Aluno {
    private String nome;
    private double nota1;
    private double nota2;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }


    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }


    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }
}
