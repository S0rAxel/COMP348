#include <stdio.h>
#include "AGGREGATE.h"

float minf(float* arr, int size)
{
	if (!arr || size <= 0)
	{
		printf("FATAL ERROR in line %d where %s", __LINE__, __FILE__);
		return 0;
	}

	float min = arr[0];

	for (int i = 0; i < size; i++)
	{
		if (arr[i] < min)
		{
			min = arr[i];
		}
	}

	return min;
}

float maxf(float* arr, int size)
{
	if (!arr || size <= 0)
	{
		printf("FATAL ERROR in line %d where %s", __LINE__, __FILE__);
		return 0;
	}

	float max = arr[0];

	for (int i = 0; i < size; i++)
	{
		if (arr[i] > max)
		{
			max = arr[i];
		}
	}

	return max;
}

float sumf(float* arr, int size)
{
	if (!arr || size <= 0)
	{
		printf("FATAL ERROR in line %d where %s", __LINE__, __FILE__);
		return 0;
	}

	float sum = 0;

	for (int i = 0; i < size; i++)
	{
		sum += arr[i];
	}

	return sum;
}

float avgf(float* arr, int size)
{
	if (!arr || size <= 0)
	{
		printf("FATAL ERROR in line %d where %s", __LINE__, __FILE__);
		return 0;
	}

	float avg = sumf(arr, size);

	return avg / size;
}

float pseudo_avg(float* arr, int size)
{
	return (minf(arr, size) + maxf(arr, size)) / 2;
}