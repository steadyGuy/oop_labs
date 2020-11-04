#include "functions.h"
#include <stdlib.h>
#include <time.h>
//#include <locale.h>

int main(void)
{
  //setlocale(LC_ALL, "");
  struct funcData values;
  double s1, s2;
  double *rnd;
  int *linear;

  srand(time(0));
  ReadPar(&values);
  CalcFunc(&values);
  Tab(&values);

  s1 = FindS1(&values);
  s2 = FindS2(&values);
  
  rnd = GenerateRndArr(&values, s1, s2);
  TabRestData(values.size, rnd, s1, s2);
  linear = GenerateLinearArr(&values);
  Print(&values, linear);

  free(rnd);
  free(linear);
  return 0;
}