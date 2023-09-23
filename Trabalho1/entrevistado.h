#include <iostream>
using namespace std;

class entrevistado{
    string genero;
    string idade;
    string escolaridade;
    string regiao;
    string tech;
    string area;

    public:
    entrevistado(string genero, string idade, string escolaridade, string regiao, string tech, string area);
    string getGenero();
    string getIdade();
    string getEscolaridade();
    string getRegiao();
    string getTech();
    string getArea();
    void setGenero(char genero);
    void setIdade(int idade);
    void setEscolaridade(string escolaridade);
    void setRegiao(string regiao);
    void setTech(string tech);
    void setArea(string area);
};