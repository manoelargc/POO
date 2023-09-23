#include "entrevistado.h"

entrevistado::entrevistado (string gen, string i, string esc, string reg, string t, string a){
    genero = gen;
    idade = i;
    escolaridade = esc;
    regiao = reg;
    tech = t;
    area = a;
}

string entrevistado::getGenero(){
    return genero;
}

string entrevistado::getIdade(){
    return idade;
}

string entrevistado::getEscolaridade(){
    return escolaridade;
}

string entrevistado::getRegiao(){
    return regiao;
}

string entrevistado::getTech(){
    return tech;
}

string entrevistado::getArea(){
    return area;
}

void entrevistado::setGenero(char gen){
    genero = gen;
}

void entrevistado::setIdade(int i){
    idade = i;
}

void entrevistado::setEscolaridade(string esc){
    escolaridade = esc;
}

void entrevistado::setRegiao(string reg){
    regiao = reg;
}

void entrevistado::setTech(string t){
    tech = t;
}

void entrevistado::setArea(string a){
    area = a;
}
