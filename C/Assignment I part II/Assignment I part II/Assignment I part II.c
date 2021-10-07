#include <stdio.h>
#include "AGGREGATE.h"

void iteration(float* arr, int size);

const char* funcnames[] = { "MINF", "MAXF", "SUMF", "AVGF", "SAVG" };
float (*aggregates[5])(float* arr, int size) = { minf, maxf, sumf, avgf, pseudo_avg };
Aggregate agg;

int main()
{
	for (int i = 0; i < 5; i++)
		agg.aggregates[i] = aggregates[i];

	float nums[5] = { 6, 4, 10, 22, 8 };
	float moreNums[10] = { 1, 38, 37, 17, 31, 5, 46, 26, 3, 40 };

	printf("\n- Array of 5 random numbers -\n");
	iteration(nums, 5);
	printf("\n- Array of 10 random numbers -\n");
	iteration(moreNums, 10);
}

void iteration(float* arr, int size)
{
	float  result = 0;
	for (int i = 0; i < 5; i++)
	{
		result = agg.aggregates[i](arr, size);
		printf("\t%s: %0.1f\n", funcnames[i], result);
	}
}