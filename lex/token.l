%{

%}

%%
#.*>	{printf("%s : header \n",yytext);}
[A-Za-z]+.*\)		{printf("%s : function \n",yytext);}
float|int	{printf("%s : Data type \n",yytext);}
[a-zA-Z]+ {printf("%s : variable \n",yytext);}
= 	{printf("%s : assignment \n",yytext);}
[0-9]+	{printf("%s : value \n",yytext);}
;|\{|\}	{}
%%

void main()
{
	yyin=fopen("input.c","r");
	yylex();
	
	
	
}

int yywrap()
{
	return 1;
}
