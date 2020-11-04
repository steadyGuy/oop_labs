#ifndef FUNCTIONS_H_INCLUDED
#define FUNCTIONS_H_INCLUDED

#define ARR_BOUND 100
/* 
oxB2 не виводився (використання %lc та setlocale не допомогло, потік виводу автоматично закривався, або
виводився не той символ, тому взяв інший символ зі знаенням від 0 до 127 як було вказано в методичних вказівках
*/
#define CHARACTER 0x7C

struct funcData
{
  int a;
  int b;
  float dx;
  double x1;
  double x2;
  int size;
  double funcValues[ARR_BOUND];
};

void ReadPar(struct funcData *data);
void CalcFunc(struct funcData *data);
void Tab(struct funcData *data);
double *GenerateRndArr(struct funcData *data, double s1, double s2);
double FindS1(struct funcData *data);
double FindS2(struct funcData *data);
void TabRestData(int arrSize, double *arr, double s1, double s2);
int *GenerateLinearArr(struct funcData *data);
void Print(struct funcData *data, int *arr);

#endif