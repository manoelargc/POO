#include "entrevistados.h"
#include "interface.h"

#ifdef _WIN32
#define CLEARSCREEN "cls"
#else
#define CLEARSCREEN "clear"
#endif

int main(){
    int op, op2, resNum;
    string resString;

    vector<entrevistado> Entrevistados;
    arquivo arq("Entrevistados.csv");
    Entrevistados = arq.lerquivo();

    entrevistados ent(Entrevistados);
    interface intr;

    do{
        op = intr.menu();

        //verifica opção invalida
        if(op > 9 || op < 0){
            cout << "Opcao invalida!" << endl;
            op = intr.nova_op();
        }else{

            switch (op){
            
            //total de entrevistados
            case 1:
                cout << "total de entrevistados: " << ent.totalEntrevistados() << endl;
                break;
            
            //estatisticas de genero
            case 2:
                op2 = intr.estatisticas_genero();

                switch (op2){
                    case 1:
                        resNum = ent.estatisticaGenero("f");
                        cout << "Total de mulheres entrevistadas: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 2:
                        resNum = ent.estatisticaGenero("m");
                        cout << "Total de homens entrevistados: " << resNum << " " << ent.Porcentagem(resNum) << "%" <<endl;
                        break;

                    case 3:
                        resNum = ent.estatisticaGenero("o");
                        cout << "Outros: " << resNum << " " << ent.Porcentagem(resNum) << "%" <<endl;
                        break;
                    
                    default:
                        cout << "Opcao invalida!" << endl;
                        break;
                }
                break;
            
            //estatisticas de idade
            case 3:
                op2 = intr.estatisticas_idade();

                switch(op2){
                    case 1:
                        resNum = ent.estatisticaIdade("Até 15 anos");
                        cout << "Total de entrevistados até 15 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 2:
                        resNum = ent.estatisticaIdade("De 16 a 29 anos");
                        cout << "Total de entrevistados de 16 a 29 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 3:
                        resNum = ent.estatisticaIdade("De 30 a 59 anos");
                        cout << "Total de entrevistados de 30 a 59 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;   
                        break;

                    case 4:
                        resNum = ent.estatisticaIdade("Acima de 60 anos");
                        cout << "Total de entrevistados acima de 60 anos: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    default:
                        cout << "Opcao invalida!" << endl;
                        break;
                }
                break;
            

            //estatisticas de escolaridade
            case 4:
                op2 = intr.estatisticas_escolaridade();

                switch(op2){
                case 1:
                    resNum = ent.estatisticaEscolaridade("Ensino fundamental incompleto");
                    cout << "Total de entrevistados com ensino fundamental incompleto: " << resNum << " " << ent.Porcentagem(resNum) << "%" << endl;
                    break;

                case 2:
                    resNum = ent.estatisticaEscolaridade("Ensino médio incompleto");
                    cout << "Total de entrevistados com ensino médio incompleto: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                    break;

                case 3:
                    resNum = ent.estatisticaEscolaridade("Ensino superior incompleto");
                    cout << "Total de entrevistados com ensino superior incompleto: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                    break;

                case 4:
                    resNum = ent.estatisticaEscolaridade("Ensino fundamental completo");
                    cout << "Total de entrevistados com ensino fundamental completo: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                    break;

                case 5:
                    resNum = ent.estatisticaEscolaridade("Ensino médio completo");
                    cout << "Total de entrevistados com ensino médio completo: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                    break;

                case 6:
                    resNum = ent.estatisticaEscolaridade("Ensino superior completo");
                    cout << "Total de entrevistados com ensino superior completo: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                    break;

                default:
                    cout << "Opcao invalida!" << endl;
                    break;
                }
                break;

            //estatisticas de região
            case 5:
                op2 = intr.estatisticas_regiao();

                switch(op2){
                    case 1:
                        resNum = ent.estatisticaRegiao("Região Cidade Alta/Aguateiros");
                        cout << "Total de entrevistados na região Cidade Alta/Aguateiros: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 2:
                        resNum = ent.estatisticaRegiao("Região Extremo Oeste");
                        cout << "Total de entrevistados na região Extremo Oeste: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 3:
                        resNum = ent.estatisticaRegiao("Região Norte");
                        cout << "Total de entrevistados na região Norte: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 4:
                        resNum = ent.estatisticaRegiao("Região Sul");
                        cout << "Total de entrevistados na região Sul: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 5:
                        resNum = ent.estatisticaRegiao("Região Extremo Leste");
                        cout << "Total de entrevistados na região Extremo Leste: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 6:
                        resNum = ent.estatisticaRegiao("Região Leste/Ibirapuitã");
                        cout << "Total de entrevistados na região Leste/Ibirapuitã: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 7:
                        resNum = ent.estatisticaRegiao("Região Oeste/Regalado");
                        cout << "Total de entrevistados na região Oeste/Regalado: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    default:
                        cout << "Opcao invalida!" << endl;
                        break;
                }
                break;

            //estatisticas de tecnologia
            case 6:
                op2 = intr.estatisticas_tecnologia();

                switch(op2){
                    case 1:
                        resNum = ent.estatisticaTech("Computador Pessoal");
                        cout << "Total de entrevistados que utilizam computador Pessoal: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 2:
                        resNum = ent.estatisticaTech("Smartphone");
                        cout << "Total de entrevistados que utilizam smartphone: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 3:
                        resNum = ent.estatisticaTech("Notebook ou Netbook");
                        cout << "Total de entrevistados que utilizam notebook ou netbook: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 4:
                        resNum = ent.estatisticaTech("Tablet");
                        cout << "Total de entrevistados que utilizam tablet: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 5:
                        resNum = ent.estatisticaTech("Nenhuma");
                        cout << "Total de entrevistados que não utilizam nenhuma tecnologia computacional: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    default:
                        cout << "Opcao invalida!" << endl;
                        break;
                }
                break;

            //estatisticas de area
            case 7:
                op2 = intr.estatisticas_area();

                switch(op2){
                    case 1:
                        resNum = ent.estatisticaArea("Alimentação");
                        cout << "Total de entrevistados com area prioritária em alimentação: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 2:
                        resNum = ent.estatisticaArea("Educação");
                        cout << "Total de entrevistados com area prioritária em educação: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 3:
                        resNum = ent.estatisticaArea("Tranosporte");
                        cout << "Total de entrevistados com area prioritária em transporte: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 4:
                        resNum = ent.estatisticaArea("Lazer");
                        cout << "Total de entrevistados com area prioritária em lazer: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 5:
                        resNum = ent.estatisticaArea("Segurança");
                        cout << "Total de entrevistados com area prioritária em segurança: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 6:
                        resNum = ent.estatisticaArea("Cultura");
                        cout << "Total de entrevistados com area prioritária em cultura: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 7:
                        resNum = ent.estatisticaArea("Emprego");
                        cout << "Total de entrevistados com area prioritária em emprego: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    case 8:
                        resNum = ent.estatisticaArea("Saúde");
                        cout << "Total de entrevistados com area prioritária em saúde: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    default:
                        cout << "Opcao invalida!" << endl;
                        break;
                }
                break;

            //estatisticas especiais
            case 8:
                op2 = intr.estatisticas_especiais();
                
                switch(op2){
                    //idade inferior a 30
                    case 1:
                        resNum = ent.estatisticaIdade("Até 15 anos") + ent.estatisticaIdade("De 16 a 29 anos");
                        cout << "Total de entrevistados com idade inferior a 30 anos " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    //residentes nas regiões norte e sul
                    case 2:
                        resNum = ent.estatisticaRegiao("Região Norte") + ent.estatisticaRegiao("Região Sul");
                        cout << "Total de entrevistados residentes nas regiões Norte e Sul: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    //ao menos ensino superior completo
                    case 3:
                        resNum = ent.estatisticaEscolaridade("Ensino superior completo") + ent.estatisticaEscolaridade("Ensino médio completo") + ent.estatisticaEscolaridade("Ensino superior incompleto");
                        cout << "Total de entrevistados que possui ao menos o ensino médio completo " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    //idade média dos entrevistados que utilizam tablet
                    case 4:
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

                        cout << "Faixa etaria que mais utiliza tablet é:  " << resString << endl;
                        break;

                    //número de entrevistados acima de 30 que usam notbook
                    case 5:
                        resNum = ent.idadeTech("Notebook ou Netbook","De 30 a 59 anos") + ent.idadeTech("Notebook ou Netbook","Acima de 60 anos");
                        cout << "Total de entrevistados com idade acima de 30 anos que utilizam Notebook ou Netbook: " << resNum << " " << ent.Porcentagem(resNum) <<"%" << endl;
                        break;

                    //area prioritária dos entrevistados acima de 60 anos
                    case 6:
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
                        break;

                    default:
                        cout << "Opcao invalida!" << endl;
                        break;
                }
                break;
            
            default:
                break;
            }

            if(op != 9) op = intr.nova_op();
        }
    }while(op != 9);
    system(CLEARSCREEN);
    
    return 0;
}