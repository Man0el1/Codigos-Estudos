#include <stdio.h>
int main(){
    int soma = 0, vet[10 + 1];
    for (int i = 1; i <= 10; i++){
        printf("Valor para a posicao %d: ", i);
        scanf(" %d", &vet[i]);
        soma += vet[i];
    }
    printf("Soma dos elementos do vetor: %d", soma);
    return 0;
}