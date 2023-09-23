#include <iostream>
#include <fstream>
#include <string>
#include <vector>
using namespace std;
#include "entrevistado.h"

class arquivo{
    string nome;

    public:
    arquivo(string nome);
    vector<entrevistado> lerquivo();
};
