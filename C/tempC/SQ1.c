#include <stdio.h>
int main(){
    int numeros[100 + 1];
    for(int i = 1; i <= 100; i++){
        if(i % 2 == 0){
            numeros[i] = 0;
        } else {
            numeros[i] = 1;
        }
    }
    for(int i = 1; i <= 100; i++){
        printf("numero %d: %d\n", i, numeros[i]);
    }
    return 0;
}