## Trabalho 1 - Programação Orientada a Objetos - Ciência da Computação - 23.2
- Manoela Resende (manoelacunha.aluno@unipampa.edu.br)
- Eduarda Sifuentes (eduardasifuentes.aluno@unipampa.edu.br)
- Nicolas Flores (nicolasfeijo.aluno@unipampa.edu.br)

Este trabalho é propriedade de Manoela Resende [manoelargc](https://github.com/manoelargc), Nicolas Flores [manoelargc](https://github.com/manoelargc)e Eduarda Sifuentes [manoelargc](https://github.com/manoelargc). Ele foi desenvolvido como parte do Trabalho Final da disciplina de Arquitetura e Organização de Computadores I do 3º Semestre de Ciência da Computação - 23.1.

# Instruções de Compilação e Execução do Projeto

Este projeto consiste em um programa C++ que lê dados de entrevistados a partir de um arquivo CSV, realiza várias estatísticas com base nos dados e exibe os resultados no console.

### Pré-requisitos

Certifique-se de ter um compilador C++ instalado em seu sistema. Você também deve ter os arquivos fonte do projeto (Arquivo.cpp, Arquivo.h, entrevistado.cpp, entrevistado.h, entrevistados.cpp, entrevistados.h e main.cpp) e o arquivo de dados "Entrevistados.csv" no mesmo diretório.

### Compilação

Para compilar o projeto, siga os passos abaixo:

1. Abra o terminal ou prompt de comando.
2. Navegue até o diretório onde estão os arquivos do projeto.
3. Use o seguinte comando para compilar os arquivos fonte:

```bash
g++ -o projeto Arquivo.cpp arquivo.h entrevistado.cpp entrevistado.h entrevistados.cpp entrevistados.h main.cpp
```

Isso irá gerar um executável chamado "projeto" no mesmo diretório.

### Execução

Para executar o projeto, siga os passos abaixo:

1. Certifique-se de que o executável "projeto" foi gerado após a compilação.
2. No terminal ou prompt de comando, digite o seguinte comando:

```bash
./projeto
```

Isso iniciará o programa, que exibirá um menu de opções no console.

### Utilizando o Programa

O programa apresenta um menu com várias opções para calcular estatísticas com base nos dados do arquivo "Entrevistados.csv". Para selecionar uma opção, digite o número correspondente e pressione Enter.

- As opções de 1 a 7 calculam estatísticas gerais, como o total de entrevistados e estatísticas por gênero, idade, escolaridade, região, tecnologia e área prioritária.

- A opção 8 permite calcular estatísticas específicas, como a idade média dos entrevistados que utilizam tablet.

- A opção 9 sai do programa.

Após cada cálculo, o programa exibirá os resultados no console.

### Saindo do Programa

Para sair do programa, escolha a opção 9 no menu. O programa encerrará e retornará ao prompt de comando.

Isso conclui as instruções de compilação e execução do projeto. Certifique-se de ter os arquivos fonte e de dados no mesmo diretório antes de executar o programa.