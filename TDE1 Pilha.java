import java.util.Scanner;

class Node {
    int valor;
    Node proximo;

    Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Pilha {
    private Node topo;

    Pilha() {
        topo = null;
    }

    public void insere(int valor) {
        Node novo = new Node(valor);
        novo.proximo = topo;
        topo = novo;
    }

    public int remove() {
        if (topo == null) return -1;
        int removido = topo.valor;
        topo = topo.proximo;
        return removido;
    }

    public void imprime() {
        Node atual = topo;
        if (atual == null) {
            System.out.println("Pilha vazia");
            return;
        }
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pilha pilha = new Pilha();
        String entrada;

        System.out.println("Digite números, r para remover");

        while (true) {
            System.out.print("Digite valor ");
            entrada = sc.next();

            if (entrada.equals("s")) break;
            else if (entrada.equals("r")) {
                pilha.remove();
                pilha.imprime();
            } else {
                int valor = Integer.parseInt(entrada);
                pilha.insere(valor);
                pilha.imprime();
            }
        }

        sc.close();
    }
}
