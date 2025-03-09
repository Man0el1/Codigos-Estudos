#include <stdio.h>
int soma = 0, vet[10 + 1];
void definir(int i){
    printf("Valor para a posicao %d: ", i);
    scanf(" %d", &vet[i]);
    soma += vet[i];
}
int main(){
    for (int i = 1; i <= 10; i++){
        definir(i);
    }
    printf("Soma dos elementos do vetor: %d", soma);
    return 0;
}