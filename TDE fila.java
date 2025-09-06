import java.util.Scanner;

class Node {
    int valor;
    Node proximo;

    Node(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Fila {
    private Node inicio;
    private Node fim;

    Fila() {
        inicio = null;
        fim = null;
    }

   
    public void insere(int valor) {
        Node novo = new Node(valor);
        if (fim == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    
    public int remove() {
        if (inicio == null) return -1;
        int removido = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) fim = null; 
        return removido;
    }

    
    public void imprime() {
        Node atual = inicio;
        if (atual == null) {
            System.out.println("Fila vazia");
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
        Fila fila = new Fila();
        String entrada;

        System.out.println("Digite números para inserir na fila");

        while (true) {
            System.out.print("Digite valor ou comando: ");
            entrada = sc.next();

            if (entrada.equals("s")) break;
            else if (entrada.equals("r")) {
                fila.remove();
                fila.imprime();
            } else {
                int valor = Integer.parseInt(entrada);
                fila.insere(valor);
                fila.imprime();
            }
        }

        sc.close();
    }
}
