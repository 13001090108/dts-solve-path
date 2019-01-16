# 1 "E:\\TESTCASE\\\345\215\225\345\205\203\345\206\205\\test\\5.c"
# 1 "<built-in>"
# 1 "<command line>"





# 1 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt" 1
# 35 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt"
 typedef char * va_list;
# 7 "<command line>" 2
# 1 "E:\\TESTCASE\\\345\215\225\345\205\203\345\206\205\\test\\5.c"
int a = 1;

void f1() {
 int c = a;
 scanf("%d", &c);
 f2(c);
}


void f2(int a) {
 int m = a + 1;
 int c = 1;
 int n = m + a;
 int h = f5();
 f3(n ,10 );
 f4();
}

void f3(int m ,int n) {
  a = 1000;
  a ++;
  for(int i = 1 ; i < 10 ; i ++) {
   m = m + i;
  }
  int num[] = {1 , 2};
  m = m + num[1];
  int c = m + 10;
  f4(c);
}
void f4(int a){

 a += 3;

 int *q = a;
 int h = 1;

 a = a + 1;
 a = *q;
 a += 2;
 int p = a;
 p = p + 1;
 p ++;
 int n = 12 + p;
 int m = n;

 int c = m + f5(h);
}


int f5(a){
 a += 3;
 int c = 23;
 int b = c + 1;
 a -= a;
 a += b;
 return a;
}
