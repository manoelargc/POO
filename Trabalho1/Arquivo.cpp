#include "Arquivo.h"

arquivo::arquivo (string n){
    nome = n;
}

vector<entrevistado> arquivo::lerquivo(){
    ifstream arq;
    string gen;
    string i;
    string esc;
    string reg;
    string t;
    string a;
    vector<entrevistado> Entrevistados;

    arq.open(nome);
    while(arq.peek() != EOF){
        getline(arq,gen,';');
        getline(arq,i,';');
        getline(arq,esc,';');
        getline(arq,reg,';');
        getline(arq,t,';');
        getline(arq,a,'\n');
        entrevistado ent(gen,i,esc,reg,t,a);
        Entrevistados.push_back(ent);
    }
    arq.close();
    
    return Entrevistados;
}