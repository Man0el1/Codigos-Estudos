#include <stdio.h>
int vetor[16], temp;
void inversao(int num){
    temp = vetor[num];
    vetor[num] = vetor[num + 8];
    vetor[num + 8] = temp;
}
int main(){
    for (int i = 0; i < 16; i++) {
        printf("Digite o valor %d: ", i);
        scanf(" %d", &vetor[i]);
    }
    for (int i = 0; i < 8; i++) {
        inversao(i);
    }
    printf("Vetor resultante: ");
    for (int i = 0; i < 16; i++) {
        printf("%d ", vetor[i]);
    }
    return 0;
}