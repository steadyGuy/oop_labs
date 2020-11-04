#include "functions.h"

#include <stdio.h>
#include <math.h>
#include <stdlib.h>

void ReadPar(struct funcData *data)
{
  printf("Enter a: \n");
  scanf("%d", &data->a);

  printf("Enter b: \n");
  scanf("%d", &data->b);

  printf("Enter x1: \n");
  scanf("%lf", &data->x1);

  printf("Enter x2: \n");
  scanf("%lf", &data->x2);

  printf("Enter dx: \n");
  scanf("%f", &data->dx);
}

void CalcFunc(struct funcData *data)
{
  double x = data->x1;
  int counter = 0;

  while (x <= data->x2)
  {
    if (x <= 2)
    {
      data->funcValues[counter++] = data->a * pow(x, 2) - data->b * x;
    }
    else
    {
      data->funcValues[counter++] = (x - data->a) / (x - data->b);
    }
    x += data->dx;
  }

  data->size = counter;
}

void Tab(struct funcData *data)
{
  double x = data->x1;
  
  //заголовки x та f(x)
  printf("\n%-10lc%-8s%-8lc%-10s%-7lc\n", CHARACTER, "X", CHARACTER, "f(x)", CHARACTER);

  //вивід самої таблиці
  for (int i = 0; i < data->size; i++)
  {
    for (int i = 0; i < 37; i++)
    {
      printf("%lc", CHARACTER);
    }
    printf("\n");
    printf("%-7lc%-11.2f%-7lc%-11.2f%-7lc\n", CHARACTER, x, CHARACTER, data->funcValues[i], CHARACTER);

    x += data->dx;
  }

  printf("\n");
}

double FindS1(struct funcData *data)
{
  double s1 = 0;
  int s1Counter = 0;

  //знаходження парних за номером (не за індексом масиву) точок масиву функції 
  for (int i = 1; i <= data->size; i++)
  {
    if (i % 2 == 0)
    {
      s1 += data->funcValues[i - 1];
      s1Counter++;
    }
  }

  return (s1 / s1Counter); //знаходження s1
}

double FindS2(struct funcData *data)
{
  double s2 = 0;

  //сума квадратів значень функції f(x)
  for (int i = 0; i < data->size; i++)
  {
    s2 += pow(data->funcValues[i], 2);
  }

  return (s2 / data->size); //знаходження s2
}

double *GenerateRndArr(struct funcData *data, double s1, double s2)
{
  double beta = 0.15;
  double *rnd = (double *)malloc(data->size * sizeof(double));
  if (rnd == NULL) exit(EXIT_FAILURE);
  double sMin = s1;
  double sMax = s2;
  double sAvg = (sMax + sMin) / 2;
  double step = beta * sAvg;
  // міняємо місцем мінімальне і максимальне за необхідності (при min > max)
  if (sMin > sMax)
  {
    sMin = sMax + sMin;
    sMax = sMin - sMax;
    sMin = sMin - sMax;
  }

  rnd[0] = ((sMax - sMin) * ((double)rand() / RAND_MAX)) + sMin;
  for (int i = 1; i < data->size; i++)
  {
    double minRand = rnd[i - 1] - step;
    double maxRand = rnd[i - 1] + step;
    // генеруємо випадкове значення на проміжку
    double generatedValue = (rand() % 2 == 0) ? minRand : maxRand;
    if (generatedValue > sMax || generatedValue < sMin)
    { 
      // якщо значення виходить за межі з якогось боку, візьмемо протилежне
      rnd[i] = (generatedValue == minRand) ? maxRand : minRand;
    }
    else
    {
      rnd[i] = generatedValue;
    }
  }

  return rnd;
}

void TabRestData(int arrSize, double *arr, double s1, double s2)
{
  printf("S1: %3.5f\n", s1);
  printf("S2: %3.5f\n\n", s2);

  //заголовки N та rnd[i]
  printf("%-7lc%-7s%-7lc%-10s%-7lc\n", CHARACTER, "N", CHARACTER, "rnd[i]", CHARACTER);

  //вивід самої таблиці
  for (int i = 0; i < arrSize; i++)
  {
    for (int i = 0; i < 32; i++)
    {
      printf("%lc", CHARACTER);
    }
    printf("\n");
    printf("%-7lc%-7d%-7lc%-10.2f%-7lc\n", CHARACTER, i, CHARACTER, arr[i], CHARACTER);
  }

  printf("\n");
}

int *GenerateLinearArr(struct funcData *data)
{
  int *linear = (int *)malloc(data->size * sizeof(int));
  if (linear == NULL) exit(EXIT_FAILURE);

  double max = data->funcValues[0];
  double min = data->funcValues[0];
  double a = 0;
  double b = 70; //за умовою

  //знаходження max та min значень f(x)
  for (int i = 1; i < data->size; i++)
  {
    if (data->funcValues[i] > max)
    {
      max = data->funcValues[i];
    }
    else if (min > data->funcValues[i])
    {
      min = data->funcValues[i];
    }
  }

  for (int i = 0; i < data->size; i++)
  {
    // використаємо нормалізацію мінімум-максимум з довільним набором значень
    linear[i] = a + (data->funcValues[i] - min) * (b - a) / (max - min);
  }
  return linear;
}

void Print(struct funcData *data, int *arr) {
	
  printf("Graph of a linear function: \n");

	for (int i = data->size; i > 0; i--)
	{
		for (int j = 0; j < arr[i - 1] - 1; j++)
		{
			printf(" ");
		}
    printf("%lc\n", CHARACTER);
	}
}