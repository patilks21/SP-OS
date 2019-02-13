%{
#include "y.tab.h"
%}

%%
float|int	{return DTYPE;}
[a-zA-Z]+ {return ID;}
;	{return SEMI;}
,	{return COM;}	

%%



int yywrap()
{
	return 1;
}
