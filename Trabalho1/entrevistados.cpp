#include "entrevistados.h"
#include <math.h>

entrevistados::entrevistados(){

}

entrevistados::entrevistados(vector<entrevistado> list){
    listEntrevistados = list;
}

string entrevistados::getEntrevistado(int i){
    return listEntrevistados[i].getGenero() + " | " + listEntrevistados[i].getIdade() + " | " + listEntrevistados[i].getEscolaridade() + " | " + listEntrevistados[i].getRegiao() + 
    " | " + listEntrevistados[i].getTech() + " | " + listEntrevistados[i].getArea();
}

int entrevistados::totalEntrevistados(){
    return listEntrevistados.size();
}

//(float)f/(listEntrevistados.size()/100)

int entrevistados::estatisticaIdade(string idade){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getIdade() == idade) cont++;
    }
  return cont;

}

void entrevistados::estatisticaGenero(int j){
    int m=0, f=0, o=0, i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getGenero() == "m") m++;
        if(listEntrevistados[i].getGenero() == "f") f++;
        if(listEntrevistados[i].getGenero() == "o") o++;
    }

        if(j == 1) cout << "numero de mulheres entrevistadas: " << f << " (" << (float)f/(listEntrevistados.size()/100) << "%)" <<endl;
        if(j == 2) cout << "numero de homens entrevistados: " << m << " (" << (float)m/(listEntrevistados.size()/100) << "%)" << endl;
        if(j == 3) cout << "outros: " << o << " (" << (float)o/(listEntrevistados.size()/100) << "%)" << endl;
        if(j > 3 || j < 0) cout << "Opcao invalida!" << endl;

}

void entrevistados::estatisticaIdade(int j){
    int op1=0, op2=0, op3=0, op4=0, i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getIdade() == "Até 15 anos") op1++;
        if(listEntrevistados[i].getIdade() == "De 16 a 29 anos") op2++;
        if(listEntrevistados[i].getIdade() == "De 30 a 59 anos") op3++;
        if(listEntrevistados[i].getIdade() == "Acima de 60 anos") op4++;
    }

    if(j == 1) cout << "Até 15 anos " << op1 << " (" << (float)op1/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 2) cout << "De 16 a 29 anos " << op2 << " (" << (float)op2/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 3) cout << "De 30 a 59 anos " << op3 << " (" << (float)op3/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 4) cout << "Acima de 60 anos " << op4 << " (" << (float)op4/(listEntrevistados.size()/100) << "%)" << endl;
    if(j > 4 || j < 0) cout << "Opcao invalida!" << endl;

}

void entrevistados::estatisticaIdade(string idade){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getIdade() == idade) cont++;
    }
  return cont;

}


void entrevistados::estatisticaEscolaridade(int j){
    int op1=0, op2=0, op3=0, op4=0, op5=0, op6=0, i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getEscolaridade() == "Ensino fundamental incompleto") op1++;
        if(listEntrevistados[i].getEscolaridade() == "Ensino médio incompleto") op2++;
        if(listEntrevistados[i].getEscolaridade() == "Ensino superior incompleto") op3++;
        if(listEntrevistados[i].getEscolaridade() == "Ensino fundamental completo") op4++;
        if(listEntrevistados[i].getEscolaridade() == "Ensino médio completo") op5++;
        if(listEntrevistados[i].getEscolaridade() == "Ensino superior completo") op6++;
    }

    if(j == 1) cout << "Ensino fundamental incompleto " << op1 << " (" << (float)op1/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 2) cout << "Ensino médio incompleto " << op2 << " (" << (float)op2/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 3) cout << "Ensino superior incompleto " << op3 << " (" << (float)op3/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 4) cout << "Ensino fundamental completo " << op4 << " (" << (float)op4/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 5) cout << "Ensino médio completo " << op5 << " (" << (float)op5/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 6) cout << "Ensino superior completo " << op6 << " (" << (float)op6/(listEntrevistados.size()/100) << "%)" << endl;
    if(j > 6 || j < 0) cout << "Opcao invalida!" << endl;

}

void entrevistados::estatisticaRegiao(int j){
    int op1=0, op2=0, op3=0, op4=0, op5=0, op6=0, op7=0, i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getRegiao() == "Região Cidade Alta/Aguateiros") op1++;
        if(listEntrevistados[i].getRegiao() == "Região Extremo Oeste") op2++;
        if(listEntrevistados[i].getRegiao() == "Região Norte") op3++;
        if(listEntrevistados[i].getRegiao() == "Região Sul") op4++;
        if(listEntrevistados[i].getRegiao() == "Região Extremo Leste") op5++;
        if(listEntrevistados[i].getRegiao() == "Região Leste/Ibirapuitã") op6++;
        if(listEntrevistados[i].getRegiao() == "Região Oeste/Regalado") op7++;
    }

    if(j == 1) cout << "Região Cidade Alta/Aguateiros " << op1 << " (" << (float)op1/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 2) cout << "Região Extremo Oeste " << op2 << " (" << (float)op2/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 3) cout << "Região Norte " << op3 << " (" << (float)op3/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 4) cout << "Região Sul " << op4 << " (" << (float)op4/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 5) cout << "Região Extremo Leste " << op5 << " (" << (float)op5/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 6) cout << "Região Leste/Ibirapuitã " << op6 << " (" << (float)op6/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 7) cout << "Região Oeste/Regalado " << op7 << " (" << (float)op7/(listEntrevistados.size()/100) << "%)" << endl;
    if(j > 7 || j < 0) cout << "Opcao invalida!" << endl;
}

void entrevistados::estatisticaTech(int j){
    int op1=0, op2=0, op3=0, op4=0, op5=0, i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getTech() == "Computador Pessoal") op1++;
        if(listEntrevistados[i].getTech() == "Smartphone") op2++;
        if(listEntrevistados[i].getTech() == "Notebook ou Netbook") op3++;
        if(listEntrevistados[i].getTech() == "Tablet") op4++;
        if(listEntrevistados[i].getTech() == "Nenhuma") op5++;
    }

    if(j == 1) cout << "Computador Pessoal " << op1 << " (" << (float)op1/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 2) cout << "Smartphone " << op2 << " (" << (float)op2/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 3) cout << "Notebook ou Netbook " << op3 << " (" << (float)op3/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 4) cout << "Tablet " << op4 << " (" << (float)op4/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 5) cout << "Nenhuma " << op5 << " (" << (float)op5/(listEntrevistados.size()/100) << "%)" << endl;
    if(j > 5 || j < 0) cout << "Opcao invalida!" << endl;
}

void entrevistados::estatisticaArea(int j){
    int op1=0, op2=0, op3=0, op4=0, op5=0, op6=0, op7=0, op8=0, i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getArea() == "Alimentação") op1++;
        if(listEntrevistados[i].getArea() == "Educação") op2++;
        if(listEntrevistados[i].getArea() == "Transporte") op3++;
        if(listEntrevistados[i].getArea() == "Lazer") op4++;
        if(listEntrevistados[i].getArea() == "Segurança") op5++;
        if(listEntrevistados[i].getArea() == "Cultura") op6++;
        if(listEntrevistados[i].getArea() == "Emprego") op7++;
        if(listEntrevistados[i].getArea() == "Saúde") op8++;
    }

    if(j == 1) cout << "Alimentação " << op1 << " (" << (float)op1/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 2) cout << "Educação " << op2 << " (" << (float)op2/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 3) cout << "Transporte " << op3 << " (" << (float)op3/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 4) cout << "Lazer " << op4 << " (" << (float)op4/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 5) cout << "Segurança " << op5 << " (" << (float)op5/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 6) cout << "Cultura " << op6 << " (" << (float)op6/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 7) cout << "Emprego " << op7 << " (" << (float)op7/(listEntrevistados.size()/100) << "%)" << endl;
    if(j == 8) cout << "Saúde " << op8 << " (" << (float)op8/(listEntrevistados.size()/100) << "%)" << endl;
    if(j > 8 || j < 0) cout << "Opcao invalida!" << endl;
}

void entrevistados::estatisticaEspecifica(int j){
        int op=0, i;
        if(op == 1){
            for(i = 0; i < listEntrevistados.size(); i++){
                if(listEntrevistados[i].getRegiao() == "Região Norte") op++;
                if(listEntrevistados[i].getRegiao() == "Região Sul") op++;
            }
            cout << "Entrevistados residentes nas areas norte e sul " << op << " (" << (float)op/(listEntrevistados.size()/100) << "%)" << endl;
        }
        
}
