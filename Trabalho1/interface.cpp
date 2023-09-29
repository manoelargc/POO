#include "interface.h"

#ifdef _WIN32
#define CLEARSCREEN "cls"
#else
#define CLEARSCREEN "clear"
#endif

int interface::menu(){
    int op;
    system(CLEARSCREEN);
    cout << "[1] total de entrevistados" << endl;
    cout << "[2] estatisticas de genero" << endl;
    cout << "[3] estatisticas de idade" << endl;
    cout << "[4] estatisticas de escolaridade" << endl;
    cout << "[5] estatisticas de regiao" << endl;
    cout << "[6] estatisticas de tecnologias computacionais" << endl;
    cout << "[7] estatisticas de area prioritária" << endl;
    cout << "[8] estatisticas especificas" << endl;
    cout << "[9] Sair" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op;
    cout << endl;
    fflush(stdin);
    system(CLEARSCREEN);

    return op;
}

int interface::total_entrevistados(){
    int op;
    return op;
}

int interface::estatisticas_genero(){
    int resNum, op2;
    cout << "[1] Mulheres entrevistadas" << endl;
    cout << "[2] Homens entrevistados" << endl;
    cout << "[3] Outros entrevistados" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op2;
    cout << endl;
    system(CLEARSCREEN);
    
    return op2;
}

int interface::estatisticas_idade(){
    int resNum, op2;
    cout << "[1] Entrevistados até 15 anos" << endl;
    cout << "[2] Entrevistados de 16 a 29 anos" << endl;
    cout << "[3] Entrevistados de 30 a 59 anos" << endl;
    cout << "[4] Entrevistados acima de 60 anos" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op2;
    cout << endl;
    system(CLEARSCREEN);
    
    return op2;
}

int interface::estatisticas_escolaridade(){
    int resNum, op2;
    cout << "[1] Entrevistados com ensino fundamental incompleto" << endl;
    cout << "[2] Entrevistados com ensino médio incompleto" << endl;
    cout << "[3] Entrevistados com ensino superior incompleto" << endl;
    cout << "[4] Entrevistados com ensino fundamental completo" << endl;
    cout << "[5] Entrevistados com ensino médio completo" << endl;
    cout << "[6] Entrevistados com ensino superior completo" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op2;
    cout << endl;
    system(CLEARSCREEN);

    return op2;
}

int interface::estatisticas_regiao(){
    int resNum, op2;
    cout << "[1] Entrevistados na região Cidade Alta/Aguateiros" << endl;
    cout << "[2] Entrevistados na região Extremo Oeste" << endl;
    cout << "[3] Entrevistados na região Norte" << endl;
    cout << "[4] Entrevistados na região Sul" << endl;
    cout << "[5] Entrevistados na região Extremo Leste" << endl;
    cout << "[6] Entrevistados na região Leste/Ibirapuitã" << endl;
    cout << "[7] Entrevistados na região Oeste/Regalado" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op2;
    cout << endl;
    system(CLEARSCREEN);

    return op2;
}

int interface::estatisticas_tecnologia(){
    int resNum, op2;
    cout << "[1] Entrevistados que utilizam Computador Pessoal" << endl;
    cout << "[2] Entrevistados que utilizam Smartphone" << endl;
    cout << "[3] Entrevistados que utilizam Notebook ou Netbook" << endl;
    cout << "[4] Entrevistados que utilizam Tablet" << endl;
    cout << "[5] Entrevistados que utilizam Nenhuma tecnologia computacional" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op2;
    cout << endl;
    system(CLEARSCREEN);

    return op2;
}

int interface::estatisticas_area(){
    int resNum, op2;
    cout << "[1] Alimentação" << endl;
    cout << "[2] Educação" << endl;
    cout << "[3] Transporte" << endl;
    cout << "[4] Lazer" << endl;
    cout << "[5] Segurança" << endl;
    cout << "[6] Cultura" << endl;
    cout << "[7] Emprego" << endl;
    cout << "[8] Saúde" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op2;
    cout << endl;
    system(CLEARSCREEN);

    return op2;
}

int interface::estatisticas_especiais(){
    int resNum, op2;
    cout << "[1] Entrevistados com idade inferior a 30 anos" << endl;
    cout << "[2] Entrevistados residentes nas regiões Norte e Sul" << endl;
    cout << "[3] Entrevistados que possui ao menos o ensino médio completo" << endl;
    cout << "[4] Faixa etaria dos entrevistados que utilizam tablet" << endl;
    cout << "[5] Número de entrevistados com idade acima de 30 anos que utilizam Notebook ou Netbook" << endl;
    cout << "[6] Área prioritária das pessoas com idade acima de 60 anos" << endl;
    cout << "Digite a opcao desejada: ";
    cin >> op2;
    cout << endl;
    system(CLEARSCREEN);
    
    return op2;
}

int interface::nova_op(){
    int opcao, operacao;
    do{
        cout << "[1]Realizar outra operacao" << endl;
        cout << "[2]Sair" << endl;
        cout << "Digite a opcao desejada: ";
        fflush(stdin);
        cin >> opcao;
        cout << endl;
        if (opcao == 1){
            operacao = 0;
        }
        if (opcao == 2){
            operacao = 9;
        }
        if(opcao > 2 || opcao < 1){
            system(CLEARSCREEN);
            cout << "opcao invalida!" << endl;
        }
    }while(opcao > 2 || opcao < 1);
    return operacao;
}