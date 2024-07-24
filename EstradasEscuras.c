#include <stdio.h>
#include <stdlib.h>

#define MAX_NODES 200000
#define MAX_EDGES 200000

struct Aresta {
    int u, v, w;
};

int cmp(const void *a, const void *b) {
    return ((struct Aresta *)a)->w - ((struct Aresta *)b)->w;
}

int find(int parent[], int i) {
    if (parent[i] == i)
        return i;
    return parent[i] = find(parent, parent[i]);
}

void unionSet(int parent[], int rank[], int x, int y) {
    int rootX = find(parent, x);
    int rootY = find(parent, y);
    
    if (rootX != rootY) {
        if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

int solve(int m, int n, struct Aresta arestas[]) {
    qsort(arestas, n, sizeof(struct Aresta), cmp);

    int parent[MAX_NODES];
    int rank[MAX_NODES];
    
    for (int i = 0; i < m; i++) {
        parent[i] = i;
        rank[i] = 0;
    }

    int custoMST = 0;
    int arestasUtilizadas = 0;

    for (int i = 0; i < n; i++) {
        int u = arestas[i].u;
        int v = arestas[i].v;
        int w = arestas[i].w;

        if (find(parent, u) != find(parent, v)) {
            unionSet(parent, rank, u, v);
            custoMST += w;
            arestasUtilizadas++;
        }

        if (arestasUtilizadas == m - 1)
            break;
    }

    return custoMST;
}

int main() {
    int m, n;
    struct Aresta arestas[MAX_EDGES];

    while (scanf("%d %d", &m, &n) == 2 && (m != 0 || n != 0)) {
        int custoTotal = 0;

        for (int i = 0; i < n; i++) {
            scanf("%d %d %d", &arestas[i].u, &arestas[i].v, &arestas[i].w);
            custoTotal += arestas[i].w;
        }

        int custoMinimo = solve(m, n, arestas);
        int economiaMaxima = custoTotal - custoMinimo;

        printf("%d\n", economiaMaxima);
    }

    return 0;
}
