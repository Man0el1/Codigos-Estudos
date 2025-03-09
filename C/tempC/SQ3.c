#include <stdio.h>
int main(){
    float vet1[20], vet2[20], resultado[20];;
    for (int i = 0; i < 20; i++) {
        vet1[i] = i + 1;
        vet2[i] = 20 - i;
        resultado[i] = vet1[i] * vet2[i];
    }
    printf("Resultado da multiplicação:\n");
    for (int i = 0; i < 20; i++) {
        printf("Numero %d: %.2f\n", i, resultado[i]);
    }
    return 0;
}