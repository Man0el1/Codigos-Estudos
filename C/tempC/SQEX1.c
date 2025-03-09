#include <stdio.h>
int numeros[100 + 1];
int parOuImpar(int i){
    if(i % 2 == 0){
        return 0;
    } else {
        return 1;
    }
}
int main(){
    for(int i = 1; i <= 100; i++){
        numeros[i] = parOuImpar(i);
    }
    for(int i = 1; i <= 100; i++){
        printf("numero %d: %d\n", i, numeros[i]);
    }
    return 0;
}