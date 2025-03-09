#include <stdio.h>
float vet1[20], vet2[20], resultado[20];
float calculo(int i){
    vet1[i] = i + 1;
    vet2[i] = 20 - i;
    return vet1[i] * vet2[i];
}
int main(){
    for (int i = 0; i < 20; i++) {
        resultado[i] = calculo(i);
    }
    printf("Resultado da multiplicação:\n");
    for (int i = 0; i < 20; i++) {
        printf("Numero %d: %.2f\n", i, resultado[i]);
    }
    return 0;
}