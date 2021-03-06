#include "linkedList.h"
#include <stdio.h>
#include <stdlib.h>

const element NIL = { .type = LIST, .l = NULL };

element aasel(atom a)
{
	element r = { .type = ATOM, .a = a };
	return r;
}

element lasel(list l)
{
	element r = { .type = LIST, .l = &l };
	return r;
}

element car(element e)
{
	if (e.l == LIST)
	{
		return e.l->el;
	}
	else
	{
		return NIL;
	}
}

list cdr(element e)
{
	if (e.l->next == NULL)
	{
		return e.l;
	}
	else if (e.l->el.type == ATOM)
	{
		return e.l->el.l;
	}

	return e.l->next->el.l;
}

list cddr(element e)
{
	return cdr(cdr(e)->el);
}

list cons(element e, list l)
{
	list r = malloc(sizeof(list));
	r->el = car(e);
	r->el.l = cdr(l->el);
	return r;
}

list append(list l1, list l2)
{
	list r = NULL;
	r->next = l1;
	r->next->next = l2;

	return r;
}

void lfreer(list l)
{
	free(l);
}

void print(element e)
{
	if (e.l == NULL)
	{
		printf("NIL");
	}

	if (e.type == ATOM)
	{
		printf("%c", e.a);
	}
	else if (e.type == LIST)
	{
		if (e.l == NULL)
		{
			atom a = e.a;
			printf("(");
			do {
				printf("%c ", e.a);
				if (e.l->next->el.a)
					a = e.l->next->el.a;
			} while (e.l->next != NULL);
		}
		printf(")");
	}
}
