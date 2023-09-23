#include "entrevistados.h"

#ifdef _WIN32
#define CLEARSCREEN "cls"
#else
#define CLEARSCREEN "clear"
#endif


int novaOperacao(){
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
            operacao = 8;
        }
        if(opcao > 2 || opcao < 1){
            system(CLEARSCREEN);
            cout << "opcao invalida!" << endl;
        }
    }while(opcao > 2 || opcao < 1);
    return operacao;
}

int main(){
    int op, op2;

    vector<entrevistado> Entrevistados;
    arquivo arq("Entrevistados.csv");
    Entrevistados = arq.lerquivo();

    entrevistados ent(Entrevistados);

    do{
        system(CLEARSCREEN);
        cout << "[1] total de entrevistados" << endl;
        cout << "[2] estatisticas de genero" << endl;
        cout << "[3] estatisticas de idade" << endl;
        cout << "[4] estatisticas de escolaridade" << endl;
        cout << "[5] estatisticas de regiao" << endl;
        cout << "[6] estatisticas de tecnologias computacionais" << endl;
        cout << "[7] estatisticas de area prioritária" << endl;
        cout << "[8] Sair" << endl;

        cout << "Digite a opcao desejada: ";
        cin >> op;
        cout << endl;
        fflush(stdin);
        system(CLEARSCREEN);
        //verifica opção invalida
        if(op > 8 || op < 0){
            cout << "Opcao invalida!" << endl;
            op = novaOperacao();
        }else{
            if(op == 1) cout << "total de entrevistados: " << ent.totalEntrevistados() << endl;

            if(op == 2){
                cout << "[1] Mulheres entrevistados" << endl;
                cout << "[2] Homens entrevistadas" << endl;
                cout << "[3] Outros entrevistados" << endl;
                cout << "Digite a opcao desejada: ";
                cin >> op2;
                cout << endl;
                system(CLEARSCREEN);
                ent.estatisticaGenero(op2);
            }

            if(op == 3){
                cout << "[1] Entrevistados até 15 anos" << endl;
                cout << "[2] Entrevistados de 16 a 29 anos" << endl;
                cout << "[3] Entrevistados de 30 a 59 anos" << endl;
                cout << "[4] Entrevistados Acima de 60 anos" << endl;
                cout << "Digite a opcao desejada: ";
                cin >> op2;
                cout << endl;
                system(CLEARSCREEN);
                ent.estatisticaIdade(op2);
            } 
        
            if(op == 4){
                cout << "[1] Entravistados com ensino fundamental incompleto" << endl;
                cout << "[2] Entravistados com ensino médio incompleto" << endl;
                cout << "[3] Entravistados com ensino superior incompleto" << endl;
                cout << "[4] Entravistados com ensino fundamental completo" << endl;
                cout << "[5] Entravistados com ensino médio completo" << endl;
                cout << "[6] Entravistados com ensino superior completo" << endl;
                cout << "Digite a opcao desejada: ";
                cin >> op2;
                cout << endl;
                system(CLEARSCREEN);
                ent.estatisticaEscolaridade(op2);
            }

            if(op == 5){
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
                ent.estatisticaRegiao(op2);
            }

            if(op == 6){
                cout << "[1] Entrevistados que utilizam Computador Pessoal" << endl;
                cout << "[2] Entrevistados que utilizam Smartphone" << endl;
                cout << "[3] Entrevistados que utilizam Notebook ou Netbook" << endl;
                cout << "[4] Entrevistados que utilizam Tablet" << endl;
                cout << "[5] Entrevistados que utilizam Nenhuma tecnologia computacional" << endl;
                cout << "Digite a opcao desejada: ";
                cin >> op2;
                cout << endl;
                system(CLEARSCREEN);
                ent.estatisticaTech(op2);
            }

            if(op == 7){
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
                ent.estatisticaArea(op2);
            }

            if(op != 8) op = novaOperacao();
        }
    }while(op != 8);
    system(CLEARSCREEN);
    
    return 0;
}