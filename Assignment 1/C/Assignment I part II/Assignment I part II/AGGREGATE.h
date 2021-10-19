#pragma once

typedef struct _Aggregate
{
	float (*aggregates[5])(float* arr, int size);
} Aggregate;

float minf(float* arr, int size);
float maxf(float* arr, int size);
float sumf(float* arr, int size);
float avgf(float* arr, int size);
float pseudo_avg(float* arr, int size);