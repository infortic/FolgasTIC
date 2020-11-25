# Sistema para Gestão de Folgas Oline 

## Pré-requisitos
* Banco de Dados MySql
* Java 8
* Java EE (JSF)
* PrimeFaces 


### Em que consiste este sistema ? 

Projeto para gestão de folgas de colaboradores com 2 perfis de usuário, sendo o primeiro “Gestor” o qual consegue lançar folgas sem passar pelas regras de negócio e realizar cadastro de colaboradores. O segundo perfil é o “COLABORADOR” este recebe usuário e senha do gestor para realizar cadastro de folgas passado pelas validações do sistema, que são: 2 folgas por mês sendo uma por semana, não é permitido mais de 2 colaboradores folgado na mesma semana. 
