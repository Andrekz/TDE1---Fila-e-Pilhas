public class Merge {

    // Versão com o vetor
    public static void mergeVetor(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] c = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        System.out.print("Merge com vetor: ");
        for (int x = 0; x < c.length; x++) {
            System.out.print(c[x] + " ");
        }
        System.out.println();
    }

    // Lista encadeada
    static class Node {
        int dado;
        Node prox;
        
        Node(int dado) {
            this.dado = dado;
            this.prox = null;
        }
    }

    static class FilaEncadeada {
        Node inicio;
        Node fim;

        FilaEncadeada() {
            inicio = null;
            fim = null;
        }

        boolean vazia() {
            return inicio == null;
        }

        void insere(int valor) {
            Node novo = new Node(valor);
            if (vazia()) {
                inicio = novo;
            } else {
                fim.prox = novo;
            }
            fim = novo;
        }

        int remove() {
            if (vazia()) {
                return -1;
            }
            int valor = inicio.dado;
            inicio = inicio.prox;
            if (inicio == null) {
                fim = null;
            }
            return valor;
        }

        int primeiro() {
            if (vazia()) {
                return -1;
            }
            return inicio.dado;
        }

        void imprime() {
            Node atual = inicio;
            System.out.print("Fila: ");
            while (atual != null) {
                System.out.print(atual.dado + " ");
                atual = atual.prox;
            }
            System.out.println();
        }
    }

    public static FilaEncadeada mergeLista(FilaEncadeada A, FilaEncadeada B) {
        FilaEncadeada C = new FilaEncadeada();

        while (!A.vazia() && !B.vazia()) {
            if (A.primeiro() < B.primeiro()) {
                C.insere(A.remove());
            } else {
                C.insere(B.remove());
            }
        }

        while (!A.vazia()) {
            C.insere(A.remove());
        }

        while (!B.vazia()) {
            C.insere(B.remove());
        }

        return C;
    }

    
    public static void main(String[] args) {
        int[] a = {12, 35, 52, 64};
        int[] b = {5, 15, 23, 55, 75};
        mergeVetor(a, b);

        FilaEncadeada A = new FilaEncadeada();
        FilaEncadeada B = new FilaEncadeada();

        A.insere(12); A.insere(35); A.insere(52); A.insere(64);
        B.insere(5); B.insere(15); B.insere(23); B.insere(55); B.insere(75);

        FilaEncadeada C = mergeLista(A, B);
        System.out.print("Merge com lista encadeada: ");
        C.imprime();
    }
}