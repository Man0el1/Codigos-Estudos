#include <stdio.h>
int main(){
    int vetor[16], temp;
    for (int i = 0; i < 16; i++) {
        printf("Digite o valor %d: ", i);
        scanf(" %d", &vetor[i]);
    }
    for (int i = 0; i < 8; i++) {
        temp = vetor[i];
        vetor[i] = vetor[i + 8];
        vetor[i + 8] = temp;
    }
    printf("Vetor resultante: ");
    for (int i = 0; i < 16; i++) {
        printf("%d ", vetor[i]);
    }
    return 0;
}