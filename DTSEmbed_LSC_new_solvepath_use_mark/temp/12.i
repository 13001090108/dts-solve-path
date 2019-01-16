# 1 "E:\\TESTCASE\\\350\276\223\345\205\245\345\237\237\\1.c"
# 1 "<built-in>"
# 1 "<command line>"





# 1 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt" 1
# 35 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt"
 typedef char * va_list;
# 7 "<command line>" 2
# 1 "E:\\TESTCASE\\\350\276\223\345\205\245\345\237\237\\1.c"

void f1(int* p) {
   int a=2,b=3;
   *p = a+b;
}

void f2() {
   int x=1;
   f1(&x);
   int y=x;
}


void f3(int* x) {
   int a=2,b=3;
   if (a>0) {
      *x = a+b;
   } else {
      *x = a-b;
   }
}

void f4() {
   int x=1;
   f3(&x);
   int y=x;
}



void f5(int a) {
   int b=a+1;
}
void f6() {

   f5(1);
}


int f7(int a) {
   return 1;
}
void f8() {
   int c=1;
   int b=f7(c);
}


int g;
void f9() {

   g=1;
   f10();
   g=2;
}
void f10() {
   int b=g;
}


void f11() {

   g=3;
}
void f12() {
   g=4;
   f11();
   int c=g;
}


void f13(int a) {
   int b=a;
}

void f14() {
   void (*f)(int);
   f=f13;
   int a=1;
   (*f)(a);
}

int f15(int a) {
   return a+1;
}

void f16(int x) {
   int y=x+1;
}
void f17() {
   int b=1;
   f16(f15(b));
}


int f18() {

   return f15();
}
void f19() {
   int a=f18();
}

void f20() {


   g=f15(1);
   f21();
}
void f21() {
   int b=g;
}


typedef struct
{
   int a;
   char b;
}A;

void f22() {
   A* a;
   a->b='1';
   a->a=1;
   f23(a);
}
void f23(A* aa) {
   int x=aa->a;
   char y=aa->b;
}


void f24() {
   int y;
   int x=1;
   switch(x)
   {
      case 1:y=1;break;
      case 2:y=2;break;
      default:y=3;break;
   }
   int z=y;
   int b = a;
   b ++;
   b = 2;
   int n = b;
}


void f25 (int a,int b,int c) {
   int d=0;
   int e=0;
   if (a>0) {
      e=1;
   }
   if (b>0) {
      e=2;
   }
   if (c>0) {
      e=3;
   }
   int x=d;
}

void f26() {
   int a=1;
   if (a>0)
      g=1;
   else
      g=2;

}
void f27() {
   f26();
   int b=g;
}

void f28() {
   int p=1;
   p++;
   p++;
   int q=p;

}


int f29() {
   int b=1;
   return b;
}

int f30(int x) {
   int a=1;
   if (a>0)
      return a;
   else
      return a+1;
}

void f31() {
   int a=f30(f29());
}

void f32() {
   int a=1;
   int b=2;
   if(a>0)
      if(b>0)
         f31();
}

void f33() {
   int x=0;
   if (x>0) {
      f32();
   }
}
