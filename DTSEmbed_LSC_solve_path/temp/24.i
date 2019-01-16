# 1 "E:\\TESTCASE\\\345\215\225\345\205\203\345\206\205\\2.c"
# 1 "<built-in>"
# 1 "<command line>"





# 1 "E:\\lib\\Workspace\\DTSEmbed_SRY\\cpp\\defines.txt" 1
# 35 "E:\\lib\\Workspace\\DTSEmbed_SRY\\cpp\\defines.txt"
 typedef char * va_list;
# 7 "<command line>" 2
# 1 "E:\\TESTCASE\\\345\215\225\345\205\203\345\206\205\\2.c"
void f1(){
 int a;
 scanf("%d", &a);
 int b = 1;
 int m = a + b + 10;
 int n = 100;
 f2(m , n);
}

void f2(int m , int n){
 int x = 1;
 int y = n + x + 10;
 int h = m + 10;
 f3(m);
}


void f3(int n){
 int b = 10;
 int a;
 a = n + 1;
 f4(a);
}


void f4(int m){
 int x = 1;
 int y = 10;
 int a = m + x + y;
 f6(a , f5());
}

int f5(int a) {
    int m = 10 ;
    m = m + a;
    switch(m) {
    case 1 : m = m + 1; break;
    case 2 : m ++ ; break;
    case 3 :m += 10; break;
    default : m = 1000;
    }
    return m;
}

void f6(int a , int b) {
 int m = a + 10;
 int n = a - 10;
 int c = m + n;
}
