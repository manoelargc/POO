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
    int op, op2, resNum;
    string resString;

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
        cout << "[8] estatisticas especificas" << endl;
        cout << "[9] Sair" << endl;

        cout << "Digite a opcao desejada: ";
        cin >> op;
        cout << endl;
        fflush(stdin);
        system(CLEARSCREEN);
        //verifica opção invalida
        if(op > 9 || op < 0){
            cout << "Opcao invalida!" << endl;
            op = novaOperacao();
        }else{

            //total de entrevistados
            if(op == 1) cout << "total de entrevistados: " << ent.totalEntrevistados() << endl;

            //estatisticas de genero
            if(op == 2){
                cout << "[1] Mulheres entrevistados" << endl;
                cout << "[2] Homens entrevistadas" << endl;
                cout << "[3] Outros entrevistados" << endl;
                cout << "Digite a opcao desejada: ";
                cin >> op2;
                cout << endl;
                system(CLEARSCREEN);
                if(op2 == 1){
                    resNum = ent.estatisticaGenero("f");
                    cout << "Total de mulheres entrevistadas: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 2){
                    resNum = ent.estatisticaGenero("m");
                    cout << "Total de homens entrevistados: " << resNum << " " << ent.Porcentagem(resNum) << "%" <<endl;
                }
                if(op2 == 3){
                    resNum = ent.estatisticaGenero("o");
                    cout << "Outros: " << resNum << " " << ent.Porcentagem(resNum) << "%" <<endl;
                }
                if(op2 > 3 || op2 < 0) cout << "Opcao invalida!" << endl;
            }

            //estatisticas de idade
            if(op == 3){
                cout << "[1] Entrevistados até 15 anos" << endl;
                cout << "[2] Entrevistados de 16 a 29 anos" << endl;
                cout << "[3] Entrevistados de 30 a 59 anos" << endl;
                cout << "[4] Entrevistados acima de 60 anos" << endl;
                cout << "Digite a opcao desejada: ";
                cin >> op2;
                cout << endl;
                system(CLEARSCREEN);
                if(op2 == 1){
                    resNum = ent.estatisticaIdade("Até 15 anos");
                    cout << "Total de entrevistados até 15 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 2){
                    resNum = ent.estatisticaIdade("De 16 a 29 anos");
                    cout << "Total de entrevistados de 16 a 29 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 3){
                    resNum = ent.estatisticaIdade("De 30 a 59 anos");
                    cout << "Total de entrevistados de 30 a 59 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;   
                }
                if(op2 == 4){
                    resNum = ent.estatisticaIdade("Acima de 60 anos");
                    cout << "Total de entrevistados acima de 60 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 > 4 || op2 < 0) cout << "Opcao invalida!" << endl;
            } 

            //estatisticas de escolaridade
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
                if(op2 == 1){
                    resNum = ent.estatisticaEscolaridade("Ensino fundamental incompleto");
                    cout << "Total de entrevistados com ensino fundamental incompleto: " << resNum << " " << ent.Porcentagem(resNum) << "%" << endl;
                }
                if(op2 == 2){
                    resNum = ent.estatisticaEscolaridade("Ensino médio incompleto");
                    cout << "Total de entrevistados com ensino médio incompleto: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 3){
                    resNum = ent.estatisticaEscolaridade("Ensino superior incompleto");
                    cout << "Total de entrevistados com ensino superior incompleto: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 4){
                    resNum = ent.estatisticaEscolaridade("Ensino fundamental completo");
                    cout << "Total de entrevistados com ensino fundamental completo: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 5){
                    resNum = ent.estatisticaEscolaridade("Ensino médio completo");
                    cout << "Total de entrevistados com ensino médio completo: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 6){
                    resNum = ent.estatisticaEscolaridade("Ensino superior completo");
                    cout << "Total de entrevistados com ensino superior completo: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 > 6 || op2 < 0) cout << "Opcao invalida!" << endl;
                
            }

            //estatisticas de região
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
                if(op2 == 1){
                    resNum = ent.estatisticaRegiao("Região Cidade Alta/Aguateiros");
                    cout << "Total de entrevistados na região Cidade Alta/Aguateiros: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 2){
                    resNum = ent.estatisticaRegiao("Região Extremo Oeste");
                    cout << "Total de entrevistados na região Extremo Oeste: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 3){
                    resNum = ent.estatisticaRegiao("Região Norte");
                    cout << "Total de entrevistados na região Norte: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 4){
                    resNum = ent.estatisticaRegiao("Região Sul");
                    cout << "Total de entrevistados na região Sul: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 5){
                    resNum = ent.estatisticaRegiao("Região Extremo Leste");
                    cout << "Total de entrevistados na região Extremo Leste: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 6){
                    resNum = ent.estatisticaRegiao("Região Leste/Ibirapuitã");
                    cout << "Total de entrevistados na região Leste/Ibirapuitã: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 7){
                    resNum = ent.estatisticaRegiao("Região Oeste/Regalado");
                    cout << "Total de entrevistados na região Oeste/Regalado: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 > 7 || op2 < 0) cout << "Opcao invalida!" << endl;
            }

            //estatisticas de tecnologia
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
                if(op2 == 1){
                    resNum = ent.estatisticaTech("Computador Pessoal");
                    cout << "Total de entrevistados que utilizam computador Pessoal: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 2){
                    resNum = ent.estatisticaTech("Smartphone");
                    cout << "Total de entrevistados que utilizam smartphone: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 3){
                    resNum = ent.estatisticaTech("Notebook ou Netbook");
                    cout << "Total de entrevistados que utilizam notebook ou netbook: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 4){
                    resNum = ent.estatisticaTech("Tablet");
                    cout << "Total de entrevistados que utilizam tablet: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 5){
                    resNum = ent.estatisticaTech("Nenhuma");
                    cout << "Total de entrevistados que não utilizam nenhuma tecnologia computacional: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 > 5 || op2 < 0) cout << "Opcao invalida!" << endl;
                
            }

            //estatisticas de area
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
                if(op2 == 1){
                    resNum = ent.estatisticaArea("Alimentação");
                    cout << "Total de entrevistados com area prioritária em alimentação: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 2){
                    resNum = ent.estatisticaArea("Educação");
                    cout << "Total de entrevistados com area prioritária em educação: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 3){
                    resNum = ent.estatisticaArea("Tranosporte");
                    cout << "Total de entrevistados com area prioritária em transporte: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 4){
                    resNum = ent.estatisticaArea("Lazer");
                    cout << "Total de entrevistados com area prioritária em lazer: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 5){
                    resNum = ent.estatisticaArea("Segurança");
                    cout << "Total de entrevistados com area prioritária em segurança: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 6){
                    resNum = ent.estatisticaArea("Cultura");
                    cout << "Total de entrevistados com area prioritária em cultura: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 7){
                    resNum = ent.estatisticaArea("Emprego");
                    cout << "Total de entrevistados com area prioritária em emprego: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 == 8){
                    resNum = ent.estatisticaArea("Saúde");
                    cout << "Total de entrevistados com area prioritária em saúde: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }
                if(op2 > 8 || op2 < 0) cout << "Opcao invalida!" << endl;
            }

            //estatisticas especiais
            if(op == 8) {
                cout << "[1] Entrevistados com idade inferior a 30 anos" << endl;
                cout << "[2] Entrevistados residentes nas regiões Norte e Sul" << endl;
                cout << "[3] Entrevistados que possui ao menos o ensino médio completo" << endl;
                cout << "[4] Idade média dos entrevistados que utilizam tablet" << endl;
                cout << "[5] Número de entrevistados com idade acima de 30 anos que utilizam Notebook ou Netbook" << endl;
                cout << "[6] Área prioritária das pessoas com idade acima de 60 anos" << endl;
                cout << "Digite a opcao desejada: ";
                cin >> op2;
                cout << endl;
                system(CLEARSCREEN);
                
                //idade inferior a 30
                if(op2 == 1){
                    resNum = ent.estatisticaIdade("Até 15 anos") + ent.estatisticaIdade("De 16 a 29 anos");
                    cout << "Total de entrevistados com area prioritária em alimentação: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }

                //residentes nas regiões norte e sul
                if(op2 == 2){
                    resNum = ent.estatisticaRegiao("Região Norte") + ent.estatisticaRegiao("Região Sul");
                    cout << "Total de entrevistados com area prioritária em educação: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }

                //ao menos ensino superior completo
                if(op2 == 3){
                    resNum = ent.estatisticaEscolaridade("Ensino superior completo") + ent.estatisticaEscolaridade("Ensino médio completo") + ent.estatisticaEscolaridade("Ensino superior incompleto");
                    cout << "Total de entrevistados com area prioritária em transporte: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }

                //idade média dos entrevistados que utilizam tablet
                if(op2 == 4){
                    resNum = ent.idadeTech("Tablet","Até 15 anos");
                    resString = "Até 15 anos";
                    
                    if(ent.idadeTech("Tablet","De 16 a 29 anos") > resNum){
                        resNum = ent.idadeTech("Tablet","De 16 a 29 anos");
                        resString = "De 16 a 29 anos";
                    }

                    if(ent.idadeTech("Tablet","De 30 a 59 anos") > resNum){
                        resNum = ent.idadeTech("Tablet","De 30 a 59 anos");
                        resString = "De 30 a 59 anos";
                    }

                    if(ent.idadeTech("Tablet","Acima de 60 anos") > resNum){
                        resNum = ent.idadeTech("Tablet","Acima de 60 anos");
                        resString = "Acima de 60 anos";
                    }

                    cout << "A idade média dos entrevistados que utilizam tablet é:  " << resString << endl;
                }

                //número de entrevistados acima de 30 que usam notbook
                if(op2 == 5){
                    resNum = ent.idadeTech("Notebook ou Netbook","De 30 a 59 anos") + ent.idadeTech("Notebook ou Netbook","Acima de 60 anos");
                    cout << "Total de entrevistados com idade acima de 30 anos que utilizam Notebook ou Netbook: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                }

                //area prioritária dos entrevistados acima de 60 anos
                if(op2 == 6){
                    resNum = ent.areaIdade("Acima de 60 anos","Alimentação");;
                    resString = "Alimentação";
                    
                    if(ent.areaIdade("Acima de 60 anos","Educação") > resNum){
                        resNum = ent.areaIdade("Acima de 60 anos","Educação");
                        resString = "Educação";
                    }

                    if(ent.areaIdade("Acima de 60 anos","Tranosporte") > resNum){
                        resNum = ent.areaIdade("Acima de 60 anos","Tranosporte");
                        resString = "Tranosporte";
                    }

                    if(ent.areaIdade("Acima de 60 anos","Lazer") > resNum){
                        resNum = ent.areaIdade("Acima de 60 anos","Lazer");
                        resString = "Lazer";
                    }

                    if(ent.areaIdade("Acima de 60 anos","Segurança") > resNum){
                        resNum = ent.areaIdade("Acima de 60 anos","Segurança");
                        resString = "Segurança";
                    }

                    if(ent.areaIdade("Acima de 60 anos","Cultura") > resNum){
                        resNum = ent.areaIdade("Acima de 60 anos","Cultura");
                        resString = "Cultura";
                    }

                    if(ent.areaIdade("Acima de 60 anos","Emprego") > resNum){
                        resNum = ent.areaIdade("Acima de 60 anos","Emprego");
                        resString = "Emprego";
                    }

                    if(ent.areaIdade("Acima de 60 anos","Saúde") > resNum){
                        resNum = ent.areaIdade("Acima de 60 anos","Saúde");
                        resString = "Saúde";
                    }

                    cout << "A área prioritária das pessoas com idade acima de 60 anos é:  " << resString << endl;
                }
                if(op2 > 6 || op2 < 0) cout << "Opcao invalida!" << endl;
            }

            if(op != 9) op = novaOperacao();
        }
    }while(op != 8);
    system(CLEARSCREEN);
    
    return 0;
}