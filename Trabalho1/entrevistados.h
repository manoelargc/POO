#include <iostream>
using namespace std;
#include  "Arquivo.h"

class entrevistados{
    vector<entrevistado> listEntrevistados;

    public:
    entrevistados();
    entrevistados(vector<entrevistado> list);
    string getEntrevistado(int i);
    int totalEntrevistados();
    int estatisticaGenero(int i);
    int estatisticaIdade(int i);
    int estatisticaEscolaridade(int i);
    int estatisticaRegiao(int i);
    int estatisticaTech(int i);
    int estatisticaArea(int i);
    int estatisticaEspecifica(int i);
    float PorcentagemGenero(int i);
    float PorcentagemIdade(int i);
    float PorcentagemEscolaridade(int i);
    float PorcentagemRegiao(int i);
    float PorcentagemTech(int i);
    float PorcentagemArea(int i);
    float PorcentagemEspecifica(int i);
};