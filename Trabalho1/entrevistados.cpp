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

int entrevistados::estatisticaGenero(string gen){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getGenero() == gen) cont++;
    }
  return cont;
}

int entrevistados::estatisticaIdade(string idade){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getIdade() == idade) cont++;
    }
  return cont;
}

int entrevistados::estatisticaEscolaridade(string esc){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getEscolaridade() == esc) cont++;
    }
  return cont;
}

int entrevistados::estatisticaRegiao(string regiao){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getRegiao() == regiao) cont++;
    }
  return cont;
}

int entrevistados::estatisticaTech(string tech){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getTech() == tech) cont++;
    }
  return cont;
}

int entrevistados::estatisticaArea(string area){
    int cont = 0,i;
    for(i = 0; i < listEntrevistados.size(); i++){
        if(listEntrevistados[i].getArea() == area) cont++;
    }
  return cont;
}

float entrevistados::Porcentagem(int f){
  return (float)f/(listEntrevistados.size()/100);
}

int entrevistados::idadeTech(string tech, string idade){
  int cont =0, i;
  for(i = 0; i < listEntrevistados.size(); i++){
      if(listEntrevistados[i].getTech() == tech && listEntrevistados[i].getIdade() == idade){
        cont++;
      }
  }

  return cont;
}

int entrevistados::areaIdade(string idade, string area){
  int cont = 0, i;
  for(i = 0; i < listEntrevistados.size(); i++){
      if(listEntrevistados[i].getIdade() == idade && listEntrevistados[i].getArea() == area){
        cont++;
      }
  }
  return cont;
}
