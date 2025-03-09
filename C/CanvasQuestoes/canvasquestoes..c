#include <stdio.h>

int main() {
    int numeros[10];
    int i, maior, posicao;

    // Leitura dos números e armazenamento no vetor
    printf("Digite 10 números inteiros:\n");
    for (i = 0; i < 10; i++) {
        printf("Número %d: ", i + 1);
        scanf("%d", &numeros[i]);
    }

    // Inicialização do maior elemento como o primeiro elemento do vetor
    maior = numeros[0];
    posicao = 0;

    // Encontrando o maior elemento e sua posição
    for (i = 1; i < 10; i++) {
        if (numeros[i] > maior) {
            maior = numeros[i];
            posicao = i;
        }
    }

    // Imprimindo o vetor
    printf("Vetor: ");
    for (i = 0; i < 10; i++) {
        printf("%d ", numeros[i]);
    }
    printf("\n");

    // Imprimindo o maior elemento e sua posição
    printf("O maior elemento é: %d\n", maior);
    printf("Ele se encontra na posição: %d\n", posicao + 1);

    return 0;
}
