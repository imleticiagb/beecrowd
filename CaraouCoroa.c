#include <stdio.h>

int main(){
    int N, R, mary, john;

    while(scanf("%d", &N)){
        if(!N)  break;

        mary = 0, john = 0;

        for(int i = 0; i < N; ++i){
            scanf("%d", &R);

            if(R)   ++john;
            else    ++mary;
        }

        printf("Mary won %d times and John won %d times\n", mary, john);
    }

    return 0;
}