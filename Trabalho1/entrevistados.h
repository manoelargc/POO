#include <iostream>
using namespace std;
#include  "Arquivo.h"

class entrevistados{
    vector<entrevistado> listEntrevistados;

    public:
    entrevistados();
    entrevistados(vector<entrevistado> list);
    string getEntrevistado(int op);
    int totalEntrevistados();
    int estatisticaGenero(string op);
    int estatisticaIdade(string op);
    int estatisticaEscolaridade(string op);
    int estatisticaRegiao(string op);
    int estatisticaTech(string op);
    int estatisticaArea(string op);
    float Porcentagem(int f);
    int idadeTech(string tech, string idade);
    int areaIdade(string idade, string area);
};