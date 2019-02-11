%{
int x;
int wc;
int sc;
int tc;
int nc;
int ch;
int sl;
int bl;
int d;
int y;
%}

%%
[a-z]+          { x=yyleng+x;}
[A-Z]+		{ y=yyleng+y;}
[\n]+		{ nc++; }
[ ]+		{ sc++; }
[\t]+		{ tc++; }
[0-9]+		{ d++; }

%%

void main()
{
	yyin=fopen("input.txt","r");
	yylex();
	printf("Word count: %d\n",nc+tc+sc);
	printf("No of new line: %d\n",nc);
	printf("No of tab spaces: %d\n",tc);
	printf("No of space count: %d\n",sc);
	printf("No of characters: %d\n",x+y);
	printf("No of digits: %d\n",d);
	printf("No of small letters: %d\n",x);
	printf("No of big letters: %d\n",y);
	
	
}

int yywrap()
{
	return 1;
}
