#include <stdio.h>
#include "AGGREGATE.h"

int main() 
{
	void f(void);
	void f2(void);

	void (*farray[2])(void) = { &f, &f2 };

	return 0;
}