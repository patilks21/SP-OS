%{
#include"y.tab.h"
%}
%%
and|or	{return CONJ;}
I|He|She|It	{return PRONOUN;}
is|are	{return VERB;}
[a-z]	{return VERB;}
%%
int yywrap()
{
	return 1;
}
