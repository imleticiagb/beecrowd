#include <iostream>

using namespace std;

int main() {
    int T;
    cin >> T;

    for (int i = 0; i < T; i++) {
        int B;
        cin >> B; 

        int AiDabriel, DiDabriel, LiDabriel;
        cin >> AiDabriel >> DiDabriel >> LiDabriel;

        int AiGuarte, DiGuarte, LiGuarte;
        cin >> AiGuarte >> DiGuarte >> LiGuarte;

        double valorGolpeDabriel = ((AiDabriel + DiDabriel) / 2.0) + (LiDabriel % 2 == 0 ? B : 0);
        double valorGolpeGuarte = ((AiGuarte + DiGuarte) / 2.0) + (LiGuarte % 2 == 0 ? B : 0);

        if (valorGolpeDabriel == valorGolpeGuarte) {
            cout << "Empate" << endl;
        } else if (valorGolpeDabriel > valorGolpeGuarte) {
            cout << "Dabriel" << endl;
        } else {
            cout << "Guarte" << endl;
        }
    }

    return 0;
}
