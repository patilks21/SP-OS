%{
#include<stdio.h>
#include"y.tab.h"
%}
%token NOUN PRONOUN VERB CONJ
%%
sent : sub obj CONJ sent	{printf("comp");}
sent : sub obj			{printf("simp");}
sub : NOUN | PRONOUN	{printf("sub");}
obj : VERB obj	{printf("objh1");}
obj : VERB	{printf("obj2");}
%%
void main()
{
	extern FILE *yyin;
	yyin=fopen("input.txt","r");
	yyparse();
}
int yyerror(char *s)
{
	return 1;
}
