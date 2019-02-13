%{
#include "stdio.h"
#include "y.tab.h"
%}
%token DTYPE ID SEMI COM
%%
Decl : DTYPE IDlist SEMI	{printf("valid2\n");}	
IDlist : ID COM IDlist		{printf("valid3\n");}
IDlist : ID			{printf("valid4\n");}
%%

void main()
{
	extern FILE * yyin; 
	yyin=fopen("input.java","r");
	yyparse();
	
	
	
}

int yyerror(char * s)
{
	printf("\n%s",s);
}
