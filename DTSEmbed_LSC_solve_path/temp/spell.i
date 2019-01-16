# 1 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c"
# 1 "<built-in>"
# 1 "<command line>"





# 1 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt" 1
# 35 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt"
 typedef char * va_list;
# 7 "<command line>" 2
# 1 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c"
# 27 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c"
# 1 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/getopt.h" 1
# 32 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/getopt.h"
  extern char *optarg;
# 46 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/getopt.h"
  extern int optind;




  extern int opterr;



  extern int optopt;
# 78 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/getopt.h"
  struct option
    {

      const char *name;





      int has_arg;
      int *flag;
      int val;
    };
# 105 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/getopt.h"
  extern int getopt ();

  extern int getopt_long (int argc, char *const *argv, const char *shortopts,
     const struct option *longopts, int *longind);
  extern int getopt_long_only (int argc, char *const *argv,
          const char *shortopts,
          const struct option *longopts, int *longind);


  extern int _getopt_internal (int argc, char *const *argv,
          const char *shortopts,
          const struct option *longopts, int *longind,
          int long_only);
# 28 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2
# 1 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/str.h" 1
# 22 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/str.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h" 1
# 29 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/_ansi.h" 1
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/_ansi.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/newlib.h" 1
# 16 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/_ansi.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/config.h" 1



# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/ieeefp.h" 1
# 5 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/config.h" 2
# 186 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/config.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/config.h" 1
# 187 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/config.h" 2
# 17 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/_ansi.h" 2
# 30 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h" 2




# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 1 3 4
# 213 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 3 4
typedef unsigned int unsigned int;
# 35 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h" 2


# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stdarg.h" 1 3 4
# 44 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stdarg.h" 3 4
typedef char* __gnuc_va_list;
# 38 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h" 2







# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h" 1
# 13 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/_ansi.h" 1
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_types.h" 1
# 12 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_types.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_types.h" 1






# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_default_types.h" 1
# 26 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_default_types.h"
typedef signed char __int8_t ;
typedef unsigned char __uint8_t ;
# 36 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_default_types.h"
typedef signed short __int16_t;
typedef unsigned short __uint16_t;
# 46 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_default_types.h"
typedef __int16_t __int_least16_t;
typedef __uint16_t __uint_least16_t;
# 58 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_default_types.h"
typedef signed int __int32_t;
typedef unsigned int __uint32_t;
# 76 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_default_types.h"
typedef __int32_t __int_least32_t;
typedef __uint32_t __uint_least32_t;
# 99 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_default_types.h"
typedef signed long long __int64_t;
typedef unsigned long long __uint64_t;
# 8 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/_types.h" 2
# 13 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_types.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/lock.h" 1
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/lock.h"
typedef void *_LOCK_T;
# 44 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/lock.h"
void __cygwin_lock_init(_LOCK_T *);
void __cygwin_lock_init_recursive(_LOCK_T *);
void __cygwin_lock_fini(_LOCK_T *);
void __cygwin_lock_lock(_LOCK_T *);
int __cygwin_lock_trylock(_LOCK_T *);
void __cygwin_lock_unlock(_LOCK_T *);
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_types.h" 2


typedef long _off_t;







typedef short __dev_t;




typedef unsigned short __uid_t;


typedef unsigned short __gid_t;



__extension__ typedef long long _off64_t;







typedef long _fpos_t;





typedef _off64_t _fpos64_t;





typedef int _ssize_t;






# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 1 3 4
# 354 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 3 4
typedef unsigned int wint_t;
# 64 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_types.h" 2



typedef struct
{
  int __count;
  union
  {
    wint_t __wch;
    unsigned char __wchb[4];
  } __value;
} _mbstate_t;



typedef _LOCK_T _flock_t;




typedef void *_iconv_t;
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h" 2






typedef unsigned long __ULong;
# 37 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
struct _reent;






struct _Bigint
{
  struct _Bigint *_next;
  int _k, _maxwds, _sign, _wds;
  __ULong _x[1];
};


struct __tm
{
  int __tm_sec;
  int __tm_min;
  int __tm_hour;
  int __tm_mday;
  int __tm_mon;
  int __tm_year;
  int __tm_wday;
  int __tm_yday;
  int __tm_isdst;
};







struct _on_exit_args {
 void * _fnargs[32];
 void * _dso_handle[32];

 __ULong _fntypes;


 __ULong _is_cxa;
};
# 89 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
struct _atexit {
 struct _atexit *_next;
 int _ind;

 void (*_fns[32])(void);
        struct _on_exit_args _on_exit_args;
};
# 105 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
struct __sbuf {
 unsigned char *_base;
 int _size;
};
# 169 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
struct __sFILE {
  unsigned char *_p;
  int _r;
  int _w;
  short _flags;
  short _file;
  struct __sbuf _bf;
  int _lbfsize;






  void * _cookie;

  _ssize_t __attribute__((__cdecl__)) (*_read) (struct _reent *, void *, char *, int);

  _ssize_t __attribute__((__cdecl__)) (*_write) (struct _reent *, void *, const char *, int);

  _fpos_t __attribute__((__cdecl__)) (*_seek) (struct _reent *, void *, _fpos_t, int);
  int __attribute__((__cdecl__)) (*_close) (struct _reent *, void *);


  struct __sbuf _ub;
  unsigned char *_up;
  int _ur;


  unsigned char _ubuf[3];
  unsigned char _nbuf[1];


  struct __sbuf _lb;


  int _blksize;
  int _offset;


  struct _reent *_data;



  _flock_t _lock;

  _mbstate_t _mbstate;
  int _flags2;
};
# 226 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
struct __sFILE64 {
  unsigned char *_p;
  int _r;
  int _w;
  short _flags;
  short _file;
  struct __sbuf _bf;
  int _lbfsize;

  struct _reent *_data;


  void * _cookie;

  _ssize_t __attribute__((__cdecl__)) (*_read) (struct _reent *, void *, char *, int);

  _ssize_t __attribute__((__cdecl__)) (*_write) (struct _reent *, void *, const char *, int);

  _fpos_t __attribute__((__cdecl__)) (*_seek) (struct _reent *, void *, _fpos_t, int);
  int __attribute__((__cdecl__)) (*_close) (struct _reent *, void *);


  struct __sbuf _ub;
  unsigned char *_up;
  int _ur;


  unsigned char _ubuf[3];
  unsigned char _nbuf[1];


  struct __sbuf _lb;


  int _blksize;
  int _flags2;

  _off64_t _offset;
  _fpos64_t __attribute__((__cdecl__)) (*_seek64) (struct _reent *, void *, _fpos64_t, int);


  _flock_t _lock;

  _mbstate_t _mbstate;
};
typedef struct __sFILE64 __FILE;





struct _glue
{
  struct _glue *_next;
  int _niobs;
  __FILE *_iobs;
};
# 305 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
struct _rand48 {
  unsigned short _seed[3];
  unsigned short _mult[3];
  unsigned short _add;




};
# 579 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
struct _reent
{
  int _errno;




  __FILE *_stdin, *_stdout, *_stderr;

  int _inc;
  char _emergency[25];

  int _current_category;
  const char *_current_locale;

  int __sdidinit;

  void __attribute__((__cdecl__)) (*__cleanup) (struct _reent *);


  struct _Bigint *_result;
  int _result_k;
  struct _Bigint *_p5s;
  struct _Bigint **_freelist;


  int _cvtlen;
  char *_cvtbuf;

  union
    {
      struct
        {
          unsigned int _unused_rand;
          char * _strtok_last;
          char _asctime_buf[26];
          struct __tm _localtime_buf;
          int _gamma_signgam;
          __extension__ unsigned long long _rand_next;
          struct _rand48 _r48;
          _mbstate_t _mblen_state;
          _mbstate_t _mbtowc_state;
          _mbstate_t _wctomb_state;
          char _l64a_buf[8];
          char _signal_buf[24];
          int _getdate_err;
          _mbstate_t _mbrlen_state;
          _mbstate_t _mbrtowc_state;
          _mbstate_t _mbsrtowcs_state;
          _mbstate_t _wcrtomb_state;
          _mbstate_t _wcsrtombs_state;
   int _h_errno;
        } _reent;



      struct
        {

          unsigned char * _nextf[30];
          unsigned int _nmalloc[30];
        } _unused;
    } _new;


  struct _atexit *_atexit;
  struct _atexit _atexit0;


  void (**(_sig_func))(int);




  struct _glue __sglue;
  __FILE __sf[3];
};
# 817 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/reent.h"
extern struct _reent *_impure_ptr ;
extern struct _reent *const _global_impure_ptr ;

void _reclaim_reent (struct _reent *);







  struct _reent * __attribute__((__cdecl__)) __getreent (void);
# 46 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h" 1
# 69 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h"
# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 1 3 4
# 151 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 3 4
typedef int ptrdiff_t;
# 325 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 3 4
typedef short unsigned int wchar_t;
# 70 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/types.h" 1
# 19 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/types.h"
typedef long int __off_t;
typedef int __pid_t;

__extension__ typedef long long int __loff_t;
# 71 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h" 2
# 92 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h"
typedef unsigned char unsigned char;
typedef unsigned short u_short;
typedef unsigned int u_int;
typedef unsigned long u_long;



typedef unsigned short ushort;
typedef unsigned int uint;



typedef unsigned long clock_t;




typedef long time_t;




struct timespec {
  time_t tv_sec;
  long tv_nsec;
};

struct itimerspec {
  struct timespec it_interval;
  struct timespec it_value;
};


typedef long daddr_t;
typedef char * caddr_t;
# 171 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h"
typedef int pid_t;





typedef _ssize_t ssize_t;
# 196 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h"
typedef unsigned short nlink_t;
# 218 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h"
typedef long fd_mask;







typedef struct _types_fd_set {
 fd_mask fds_bits[(((64)+(((sizeof (fd_mask) * 8))-1))/((sizeof (fd_mask) * 8)))];
} _types_fd_set;
# 249 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h"
typedef unsigned long clockid_t;




typedef unsigned long timer_t;



typedef unsigned long useconds_t;
typedef long suseconds_t;

# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/features.h" 1
# 262 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h" 2
# 495 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/types.h" 1
# 20 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/types.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/sysmacros.h" 1
# 21 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/types.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdint.h" 1
# 18 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdint.h"
typedef signed char int;
typedef short int;
typedef int int;
typedef long long int;


typedef unsigned char unsigned int;
typedef unsigned short unsigned int;


typedef unsigned int unsigned int;

typedef unsigned long long unsigned int;



typedef signed char int_least8_t;
typedef short int_least16_t;
typedef int int_least32_t;
typedef long long int_least64_t;

typedef unsigned char uint_least8_t;
typedef unsigned short uint_least16_t;
typedef unsigned int uint_least32_t;
typedef unsigned long long uint_least64_t;



typedef signed char int_fast8_t;
typedef int int_fast16_t;
typedef int int_fast32_t;
typedef long long int_fast64_t;

typedef unsigned char uint_fast8_t;
typedef unsigned int uint_fast16_t;
typedef unsigned int uint_fast32_t;
typedef unsigned long long uint_fast64_t;





typedef int intptr_t;

typedef unsigned int uintptr_t;



typedef long long intmax_t;
typedef unsigned long long uintmax_t;
# 22 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/types.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/endian.h" 1
# 23 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/types.h" 2



typedef struct timespec timespec_t;




typedef struct timespec timestruc_t;





typedef _off64_t off_t;





typedef __loff_t loff_t;



typedef short __dev16_t;
typedef unsigned long __dev32_t;

typedef __dev32_t dev_t;







typedef long blksize_t;




typedef long __blkcnt32_t;
typedef long long __blkcnt64_t;

typedef __blkcnt64_t blkcnt_t;







typedef unsigned long fsblkcnt_t;




typedef unsigned long fsfilcnt_t;




typedef unsigned short __uid16_t;
typedef unsigned long int;

typedef int uid_t;







typedef unsigned short __gid16_t;
typedef unsigned long int;

typedef int gid_t;







typedef unsigned long __ino32_t;
typedef unsigned long long __ino64_t;

typedef __ino64_t ino_t;
# 118 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/types.h"
typedef unsigned long unsigned long;
# 140 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/types.h"
struct flock {
 short l_type;
 short l_whence;
 off_t l_start;
 off_t l_len;

 pid_t l_pid;




};



typedef long long key_t;







typedef unsigned long vm_offset_t;




typedef unsigned long vm_size_t;




typedef void *vm_object_t;




typedef unsigned char u_int8_t;



typedef __uint16_t u_int16_t;



typedef __uint32_t u_int32_t;



typedef __uint64_t u_int64_t;




typedef __int32_t register_t;




typedef char *addr_t;




typedef unsigned mode_t;





typedef struct __pthread_t {char __dummy;} *pthread_t;
typedef struct __pthread_mutex_t {char __dummy;} *pthread_mutex_t;

typedef struct __pthread_key_t {char __dummy;} *pthread_key_t;
typedef struct __pthread_attr_t {char __dummy;} *pthread_attr_t;
typedef struct __pthread_mutexattr_t {char __dummy;} *pthread_mutexattr_t;
typedef struct __pthread_condattr_t {char __dummy;} *pthread_condattr_t;
typedef struct __pthread_cond_t {char __dummy;} *pthread_cond_t;


typedef struct
{
  pthread_mutex_t mutex;
  int state;
}
pthread_once_t;
typedef struct __pthread_rwlock_t {char __dummy;} *pthread_rwlock_t;
typedef struct __pthread_rwlockattr_t {char __dummy;} *pthread_rwlockattr_t;
# 496 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/types.h" 2
# 47 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h" 2



typedef __FILE FILE;



typedef _fpos64_t fpos_t;
# 65 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stdio.h" 1
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stdio.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/cdefs.h" 1
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stdio.h" 2
# 35 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stdio.h"








# 66 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h" 2
# 175 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
FILE * __attribute__((__cdecl__)) tmpfile (void);
char * __attribute__((__cdecl__)) tmpnam (char *);
int __attribute__((__cdecl__)) fclose (FILE *);
int __attribute__((__cdecl__)) fflush (FILE *);
FILE * __attribute__((__cdecl__)) freopen (const char *, const char *, FILE *);
void __attribute__((__cdecl__)) setbuf (FILE *, char *);
int __attribute__((__cdecl__)) setvbuf (FILE *, char *, int, unsigned int);
int __attribute__((__cdecl__)) fprintf (FILE *, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));

int __attribute__((__cdecl__)) fscanf (FILE *, const char *, ...) __attribute__ ((__format__ (__scanf__, 2, 3)));

int __attribute__((__cdecl__)) printf (const char *, ...) __attribute__ ((__format__ (__printf__, 1, 2)));

int __attribute__((__cdecl__)) scanf (const char *, ...) __attribute__ ((__format__ (__scanf__, 1, 2)));

int __attribute__((__cdecl__)) sscanf (const char *, const char *, ...) __attribute__ ((__format__ (__scanf__, 2, 3)));

int __attribute__((__cdecl__)) vfprintf (FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) vprintf (const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 1, 0)));

int __attribute__((__cdecl__)) vsprintf (char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) fgetc (FILE *);
char * __attribute__((__cdecl__)) fgets (char *, int, FILE *);
int __attribute__((__cdecl__)) fputc (int, FILE *);
int __attribute__((__cdecl__)) fputs (const char *, FILE *);
int __attribute__((__cdecl__)) getc (FILE *);
int __attribute__((__cdecl__)) getchar (void);
char * __attribute__((__cdecl__)) gets (char *);
int __attribute__((__cdecl__)) putc (int, FILE *);
int __attribute__((__cdecl__)) putchar (int);
int __attribute__((__cdecl__)) puts (const char *);
int __attribute__((__cdecl__)) ungetc (int, FILE *);
unsigned int __attribute__((__cdecl__)) fread (void *, unsigned int _size, unsigned int _n, FILE *);
unsigned int __attribute__((__cdecl__)) fwrite (const void * , unsigned int _size, unsigned int _n, FILE *);



int __attribute__((__cdecl__)) fgetpos (FILE *, fpos_t *);

int __attribute__((__cdecl__)) fseek (FILE *, long, int);



int __attribute__((__cdecl__)) fsetpos (FILE *, const fpos_t *);

long __attribute__((__cdecl__)) ftell ( FILE *);
void __attribute__((__cdecl__)) rewind (FILE *);
void __attribute__((__cdecl__)) clearerr (FILE *);
int __attribute__((__cdecl__)) feof (FILE *);
int __attribute__((__cdecl__)) ferror (FILE *);
void __attribute__((__cdecl__)) perror (const char *);

FILE * __attribute__((__cdecl__)) fopen (const char *_name, const char *_type);
int __attribute__((__cdecl__)) sprintf (char *, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));

int __attribute__((__cdecl__)) remove (const char *);
int __attribute__((__cdecl__)) rename (const char *, const char *);






int __attribute__((__cdecl__)) fseeko (FILE *, off_t, int);
off_t __attribute__((__cdecl__)) ftello ( FILE *);




int __attribute__((__cdecl__)) asiprintf (char **, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));

char * __attribute__((__cdecl__)) asniprintf (char *, unsigned int *, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

char * __attribute__((__cdecl__)) asnprintf (char *, unsigned int *, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) asprintf (char **, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));


int __attribute__((__cdecl__)) diprintf (int, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));


int __attribute__((__cdecl__)) fcloseall (void);
int __attribute__((__cdecl__)) fiprintf (FILE *, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));

int __attribute__((__cdecl__)) fiscanf (FILE *, const char *, ...) __attribute__ ((__format__ (__scanf__, 2, 3)));

int __attribute__((__cdecl__)) iprintf (const char *, ...) __attribute__ ((__format__ (__printf__, 1, 2)));

int __attribute__((__cdecl__)) iscanf (const char *, ...) __attribute__ ((__format__ (__scanf__, 1, 2)));

int __attribute__((__cdecl__)) siprintf (char *, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));

int __attribute__((__cdecl__)) siscanf (const char *, const char *, ...) __attribute__ ((__format__ (__scanf__, 2, 3)));

int __attribute__((__cdecl__)) snprintf (char *, unsigned int, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) sniprintf (char *, unsigned int, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

char * __attribute__((__cdecl__)) tempnam (const char *, const char *);
int __attribute__((__cdecl__)) vasiprintf (char **, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

char * __attribute__((__cdecl__)) vasniprintf (char *, unsigned int *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

char * __attribute__((__cdecl__)) vasnprintf (char *, unsigned int *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) vasprintf (char **, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) vdiprintf (int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) vfiprintf (FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) vfiscanf (FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 2, 0)));

int __attribute__((__cdecl__)) vfscanf (FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 2, 0)));

int __attribute__((__cdecl__)) viprintf (const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 1, 0)));

int __attribute__((__cdecl__)) viscanf (const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 1, 0)));

int __attribute__((__cdecl__)) vscanf (const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 1, 0)));

int __attribute__((__cdecl__)) vsiprintf (char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) vsiscanf (const char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 2, 0)));

int __attribute__((__cdecl__)) vsniprintf (char *, unsigned int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) vsnprintf (char *, unsigned int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) vsscanf (const char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 2, 0)));
# 317 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
FILE * __attribute__((__cdecl__)) fdopen (int, const char *);

int __attribute__((__cdecl__)) fileno (FILE *);
int __attribute__((__cdecl__)) getw (FILE *);
int __attribute__((__cdecl__)) pclose (FILE *);
FILE * __attribute__((__cdecl__)) popen (const char *, const char *);
int __attribute__((__cdecl__)) putw (int, FILE *);
void __attribute__((__cdecl__)) setbuffer (FILE *, char *, int);
int __attribute__((__cdecl__)) setlinebuf (FILE *);
int __attribute__((__cdecl__)) getc_unlocked (FILE *);
int __attribute__((__cdecl__)) getchar_unlocked (void);
void __attribute__((__cdecl__)) flockfile (FILE *);
int __attribute__((__cdecl__)) ftrylockfile (FILE *);
void __attribute__((__cdecl__)) funlockfile (FILE *);
int __attribute__((__cdecl__)) putc_unlocked (int, FILE *);
int __attribute__((__cdecl__)) putchar_unlocked (int);
# 342 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
int __attribute__((__cdecl__)) dprintf (int, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));


FILE * __attribute__((__cdecl__)) fmemopen (void *, unsigned int, const char *);


FILE * __attribute__((__cdecl__)) open_memstream (char **, unsigned int *);

int __attribute__((__cdecl__)) renameat (int, const char *, int, const char *);
int __attribute__((__cdecl__)) symlinkat (const char *, int, const char *);

int __attribute__((__cdecl__)) vdprintf (int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));
# 362 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
int __attribute__((__cdecl__)) _asiprintf_r (struct _reent *, char **, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

char * __attribute__((__cdecl__)) _asniprintf_r (struct _reent *, char *, unsigned int *, const char *, ...) __attribute__ ((__format__ (__printf__, 4, 5)));

char * __attribute__((__cdecl__)) _asnprintf_r (struct _reent *, char *, unsigned int *, const char *, ...) __attribute__ ((__format__ (__printf__, 4, 5)));

int __attribute__((__cdecl__)) _asprintf_r (struct _reent *, char **, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) _diprintf_r (struct _reent *, int, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) _dprintf_r (struct _reent *, int, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) _fclose_r (struct _reent *, FILE *);
int __attribute__((__cdecl__)) _fcloseall_r (struct _reent *);
FILE * __attribute__((__cdecl__)) _fdopen_r (struct _reent *, int, const char *);
int __attribute__((__cdecl__)) _fflush_r (struct _reent *, FILE *);
int __attribute__((__cdecl__)) _fgetc_r (struct _reent *, FILE *);
char * __attribute__((__cdecl__)) _fgets_r (struct _reent *, char *, int, FILE *);




int __attribute__((__cdecl__)) _fgetpos_r (struct _reent *, FILE *, fpos_t *);
int __attribute__((__cdecl__)) _fsetpos_r (struct _reent *, FILE *, const fpos_t *);

int __attribute__((__cdecl__)) _fiprintf_r (struct _reent *, FILE *, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) _fiscanf_r (struct _reent *, FILE *, const char *, ...) __attribute__ ((__format__ (__scanf__, 3, 4)));

FILE * __attribute__((__cdecl__)) _fmemopen_r (struct _reent *, void *, unsigned int, const char *);
FILE * __attribute__((__cdecl__)) _fopen_r (struct _reent *, const char *, const char *);
FILE * __attribute__((__cdecl__)) _freopen_r (struct _reent *, const char *, const char *, FILE *);
int __attribute__((__cdecl__)) _fprintf_r (struct _reent *, FILE *, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) _fpurge_r (struct _reent *, FILE *);
int __attribute__((__cdecl__)) _fputc_r (struct _reent *, int, FILE *);
int __attribute__((__cdecl__)) _fputs_r (struct _reent *, const char *, FILE *);
unsigned int __attribute__((__cdecl__)) _fread_r (struct _reent *, void *, unsigned int _size, unsigned int _n, FILE *);
int __attribute__((__cdecl__)) _fscanf_r (struct _reent *, FILE *, const char *, ...) __attribute__ ((__format__ (__scanf__, 3, 4)));

int __attribute__((__cdecl__)) _fseek_r (struct _reent *, FILE *, long, int);
int __attribute__((__cdecl__)) _fseeko_r (struct _reent *, FILE *, _off_t, int);
long __attribute__((__cdecl__)) _ftell_r (struct _reent *, FILE *);
_off_t __attribute__((__cdecl__)) _ftello_r (struct _reent *, FILE *);
void __attribute__((__cdecl__)) _rewind_r (struct _reent *, FILE *);
unsigned int __attribute__((__cdecl__)) _fwrite_r (struct _reent *, const void * , unsigned int _size, unsigned int _n, FILE *);
int __attribute__((__cdecl__)) _getc_r (struct _reent *, FILE *);
int __attribute__((__cdecl__)) _getc_unlocked_r (struct _reent *, FILE *);
int __attribute__((__cdecl__)) _getchar_r (struct _reent *);
int __attribute__((__cdecl__)) _getchar_unlocked_r (struct _reent *);
char * __attribute__((__cdecl__)) _gets_r (struct _reent *, char *);
int __attribute__((__cdecl__)) _iprintf_r (struct _reent *, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));

int __attribute__((__cdecl__)) _iscanf_r (struct _reent *, const char *, ...) __attribute__ ((__format__ (__scanf__, 2, 3)));

FILE * __attribute__((__cdecl__)) _open_memstream_r (struct _reent *, char **, unsigned int *);
void __attribute__((__cdecl__)) _perror_r (struct _reent *, const char *);
int __attribute__((__cdecl__)) _printf_r (struct _reent *, const char *, ...) __attribute__ ((__format__ (__printf__, 2, 3)));

int __attribute__((__cdecl__)) _putc_r (struct _reent *, int, FILE *);
int __attribute__((__cdecl__)) _putc_unlocked_r (struct _reent *, int, FILE *);
int __attribute__((__cdecl__)) _putchar_unlocked_r (struct _reent *, int);
int __attribute__((__cdecl__)) _putchar_r (struct _reent *, int);
int __attribute__((__cdecl__)) _puts_r (struct _reent *, const char *);
int __attribute__((__cdecl__)) _remove_r (struct _reent *, const char *);
int __attribute__((__cdecl__)) _rename_r (struct _reent *, const char *_old, const char *_new);

int __attribute__((__cdecl__)) _scanf_r (struct _reent *, const char *, ...) __attribute__ ((__format__ (__scanf__, 2, 3)));

int __attribute__((__cdecl__)) _siprintf_r (struct _reent *, char *, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) _siscanf_r (struct _reent *, const char *, const char *, ...) __attribute__ ((__format__ (__scanf__, 3, 4)));

int __attribute__((__cdecl__)) _sniprintf_r (struct _reent *, char *, unsigned int, const char *, ...) __attribute__ ((__format__ (__printf__, 4, 5)));

int __attribute__((__cdecl__)) _snprintf_r (struct _reent *, char *, unsigned int, const char *, ...) __attribute__ ((__format__ (__printf__, 4, 5)));

int __attribute__((__cdecl__)) _sprintf_r (struct _reent *, char *, const char *, ...) __attribute__ ((__format__ (__printf__, 3, 4)));

int __attribute__((__cdecl__)) _sscanf_r (struct _reent *, const char *, const char *, ...) __attribute__ ((__format__ (__scanf__, 3, 4)));

char * __attribute__((__cdecl__)) _tempnam_r (struct _reent *, const char *, const char *);
FILE * __attribute__((__cdecl__)) _tmpfile_r (struct _reent *);
char * __attribute__((__cdecl__)) _tmpnam_r (struct _reent *, char *);
int __attribute__((__cdecl__)) _ungetc_r (struct _reent *, int, FILE *);
int __attribute__((__cdecl__)) _vasiprintf_r (struct _reent *, char **, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

char * __attribute__((__cdecl__)) _vasniprintf_r (struct _reent*, char *, unsigned int *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 4, 0)));

char * __attribute__((__cdecl__)) _vasnprintf_r (struct _reent*, char *, unsigned int *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 4, 0)));

int __attribute__((__cdecl__)) _vasprintf_r (struct _reent *, char **, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) _vdiprintf_r (struct _reent *, int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) _vdprintf_r (struct _reent *, int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) _vfiprintf_r (struct _reent *, FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) _vfiscanf_r (struct _reent *, FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 3, 0)));

int __attribute__((__cdecl__)) _vfprintf_r (struct _reent *, FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) _vfscanf_r (struct _reent *, FILE *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 3, 0)));

int __attribute__((__cdecl__)) _viprintf_r (struct _reent *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) _viscanf_r (struct _reent *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 2, 0)));

int __attribute__((__cdecl__)) _vprintf_r (struct _reent *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 2, 0)));

int __attribute__((__cdecl__)) _vscanf_r (struct _reent *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 2, 0)));

int __attribute__((__cdecl__)) _vsiprintf_r (struct _reent *, char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) _vsiscanf_r (struct _reent *, const char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 3, 0)));

int __attribute__((__cdecl__)) _vsniprintf_r (struct _reent *, char *, unsigned int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 4, 0)));

int __attribute__((__cdecl__)) _vsnprintf_r (struct _reent *, char *, unsigned int, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 4, 0)));

int __attribute__((__cdecl__)) _vsprintf_r (struct _reent *, char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__printf__, 3, 0)));

int __attribute__((__cdecl__)) _vsscanf_r (struct _reent *, const char *, const char *, __gnuc_va_list) __attribute__ ((__format__ (__scanf__, 3, 0)));




int __attribute__((__cdecl__)) fpurge (FILE *);
ssize_t __attribute__((__cdecl__)) __getdelim (char **, unsigned int *, int, FILE *);
ssize_t __attribute__((__cdecl__)) __getline (char **, unsigned int *, FILE *);
# 520 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
int __attribute__((__cdecl__)) __srget_r (struct _reent *, FILE *);
int __attribute__((__cdecl__)) __swbuf_r (struct _reent *, int, FILE *);







FILE *__attribute__((__cdecl__)) funopen (const void * __cookie, int (*__readfn)(void * __c, char *__buf, int __n), int (*__writefn)(void * __c, const char *__buf, int __n), _fpos64_t (*__seekfn)(void * __c, _fpos64_t __off, int __whence), int (*__closefn)(void * __c));




FILE *__attribute__((__cdecl__)) _funopen_r (struct _reent *, const void * __cookie, int (*__readfn)(void * __c, char *__buf, int __n), int (*__writefn)(void * __c, const char *__buf, int __n), _fpos64_t (*__seekfn)(void * __c, _fpos64_t __off, int __whence), int (*__closefn)(void * __c));
# 557 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
typedef ssize_t cookie_read_function_t(void *__cookie, char *__buf, unsigned int __n);
typedef ssize_t cookie_write_function_t(void *__cookie, const char *__buf,
     unsigned int __n);

typedef int cookie_seek_function_t(void *__cookie, _off64_t *__off,
       int __whence);



typedef int cookie_close_function_t(void *__cookie);
typedef struct
{


  cookie_read_function_t *read;
  cookie_write_function_t *write;
  cookie_seek_function_t *seek;
  cookie_close_function_t *close;
} cookie_io_functions_t;
FILE *__attribute__((__cdecl__)) fopencookie (void *__cookie, const char *__mode, cookie_io_functions_t __functions);

FILE *__attribute__((__cdecl__)) _fopencookie_r (struct _reent *, void *__cookie, const char *__mode, cookie_io_functions_t __functions);
# 600 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"
extern __inline__ __attribute__ ((__always_inline__)) int __sgetc_r(struct _reent *__ptr, FILE *__p);

extern __inline__ __attribute__ ((__always_inline__)) int __sgetc_r(struct _reent *__ptr, FILE *__p)
  {
    int __c = (--(__p)->_r < 0 ? __srget_r(__ptr, __p) : (int)(*(__p)->_p++));
    if ((__p->_flags & 0x4000) && (__c == '\r'))
      {
      int __c2 = (--(__p)->_r < 0 ? __srget_r(__ptr, __p) : (int)(*(__p)->_p++));
      if (__c2 == '\n')
        __c = __c2;
      else
        ungetc(__c2, __p);
      }
    return __c;
  }
# 688 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdio.h"

# 23 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/str.h" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h" 1
# 10 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/ieeefp.h" 1
# 11 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h" 2




# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 1 3 4
# 16 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h" 2


# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/stdlib.h" 1
# 17 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/stdlib.h"
char *mkdtemp (char *);
# 19 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h" 2

# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/alloca.h" 1
# 21 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h" 2



# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/stdlib.h" 1
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/stdlib.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/wait.h" 1
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/stdlib.h" 2






const char *getprogname (void);
void setprogname (const char *);


char *realpath (const char *, char *);
char *canonicalize_file_name (const char *);
int unsetenv (const char *);
char *initstate (unsigned seed, char *state, unsigned int size);
long random (void);
char *setstate (const char *state);
void srandom (unsigned);
char *ptsname (int);
int grantpt (int);
int unlockpt (int);


int posix_openpt (int);
int posix_memalign (void **, unsigned int, unsigned int);






extern void * memalign (unsigned int, unsigned int);
extern void * valloc (unsigned int);
# 25 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h" 2




typedef struct
{
  int quot;
  int rem;
} div_t;

typedef struct
{
  long quot;
  long rem;
} ldiv_t;


typedef struct
{
  long long int quot;
  long long int rem;
} lldiv_t;
# 58 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h"
extern __attribute__((dllimport)) int __mb_cur_max;



void __attribute__((__cdecl__)) abort (void) __attribute__ ((noreturn));
int __attribute__((__cdecl__)) abs (int);
int __attribute__((__cdecl__)) atexit (void (*__func)(void));
double __attribute__((__cdecl__)) atof (const char *__nptr);

float __attribute__((__cdecl__)) atoff (const char *__nptr);

int __attribute__((__cdecl__)) atoi (const char *__nptr);
int __attribute__((__cdecl__)) _atoi_r (struct _reent *, const char *__nptr);
long __attribute__((__cdecl__)) atol (const char *__nptr);
long __attribute__((__cdecl__)) _atol_r (struct _reent *, const char *__nptr);
void * __attribute__((__cdecl__)) bsearch (const void * __key, const void * __base, unsigned int __nmemb, unsigned int __size, int (* __attribute__((__cdecl__)) _compar) (const void *, const void *));




void * __attribute__((__cdecl__)) calloc (unsigned int __nmemb, unsigned int __size) ;
div_t __attribute__((__cdecl__)) div (int __numer, int __denom);
void __attribute__((__cdecl__)) exit (int __status) __attribute__ ((noreturn));
void __attribute__((__cdecl__)) free (void *) ;
char * __attribute__((__cdecl__)) getenv (const char *__string);
char * __attribute__((__cdecl__)) _getenv_r (struct _reent *, const char *__string);
char * __attribute__((__cdecl__)) _findenv (const char *, int *);
char * __attribute__((__cdecl__)) _findenv_r (struct _reent *, const char *, int *);
long __attribute__((__cdecl__)) labs (long);
ldiv_t __attribute__((__cdecl__)) ldiv (long __numer, long __denom);
void * __attribute__((__cdecl__)) malloc (unsigned int __size) ;
int __attribute__((__cdecl__)) mblen (const char *, unsigned int);
int __attribute__((__cdecl__)) _mblen_r (struct _reent *, const char *, unsigned int, _mbstate_t *);
int __attribute__((__cdecl__)) mbtowc (wchar_t *, const char *, unsigned int);
int __attribute__((__cdecl__)) _mbtowc_r (struct _reent *, wchar_t *, const char *, unsigned int, _mbstate_t *);
int __attribute__((__cdecl__)) wctomb (char *, wchar_t);
int __attribute__((__cdecl__)) _wctomb_r (struct _reent *, char *, wchar_t, _mbstate_t *);
unsigned int __attribute__((__cdecl__)) mbstowcs (wchar_t *, const char *, unsigned int);
unsigned int __attribute__((__cdecl__)) _mbstowcs_r (struct _reent *, wchar_t *, const char *, unsigned int, _mbstate_t *);
unsigned int __attribute__((__cdecl__)) wcstombs (char *, const wchar_t *, unsigned int);
unsigned int __attribute__((__cdecl__)) _wcstombs_r (struct _reent *, char *, const wchar_t *, unsigned int, _mbstate_t *);


char * __attribute__((__cdecl__)) mkdtemp (char *);
int __attribute__((__cdecl__)) mkstemp (char *);
int __attribute__((__cdecl__)) mkstemps (char *, int);
char * __attribute__((__cdecl__)) mktemp (char *) __attribute__ ((warning ("the use of `mktemp' is dangerous; use `mkstemp' instead")));

char * __attribute__((__cdecl__)) _mkdtemp_r (struct _reent *, char *);
int __attribute__((__cdecl__)) _mkstemp_r (struct _reent *, char *);
int __attribute__((__cdecl__)) _mkstemps_r (struct _reent *, char *, int);
char * __attribute__((__cdecl__)) _mktemp_r (struct _reent *, char *) __attribute__ ((warning ("the use of `mktemp' is dangerous; use `mkstemp' instead")));

void __attribute__((__cdecl__)) qsort (void * __base, unsigned int __nmemb, unsigned int __size, int(*_compar)(const void *, const void *));
int __attribute__((__cdecl__)) rand (void);
void * __attribute__((__cdecl__)) realloc (void * __r, unsigned int __size) ;

void * __attribute__((__cdecl__)) reallocf (void * __r, unsigned int __size);

void __attribute__((__cdecl__)) srand (unsigned __seed);
double __attribute__((__cdecl__)) strtod (const char *__n, char **__end_PTR);
double __attribute__((__cdecl__)) _strtod_r (struct _reent *,const char *__n, char **__end_PTR);
float __attribute__((__cdecl__)) strtof (const char *__n, char **__end_PTR);






long __attribute__((__cdecl__)) strtol (const char *__n, char **__end_PTR, int __base);
long __attribute__((__cdecl__)) _strtol_r (struct _reent *,const char *__n, char **__end_PTR, int __base);
unsigned long __attribute__((__cdecl__)) strtoul (const char *__n, char **__end_PTR, int __base);
unsigned long __attribute__((__cdecl__)) _strtoul_r (struct _reent *,const char *__n, char **__end_PTR, int __base);

int __attribute__((__cdecl__)) system (const char *__string);


long __attribute__((__cdecl__)) a64l (const char *__input);
char * __attribute__((__cdecl__)) l64a (long __input);
char * __attribute__((__cdecl__)) _l64a_r (struct _reent *,long __input);
int __attribute__((__cdecl__)) on_exit (void (*__func)(int, void *),void * __arg);
void __attribute__((__cdecl__)) _Exit (int __status) __attribute__ ((noreturn));
int __attribute__((__cdecl__)) putenv (char *__string);
int __attribute__((__cdecl__)) _putenv_r (struct _reent *, char *__string);
void * __attribute__((__cdecl__)) _reallocf_r (struct _reent *, void *, unsigned int);
int __attribute__((__cdecl__)) setenv (const char *__string, const char *__value, int __overwrite);
int __attribute__((__cdecl__)) _setenv_r (struct _reent *, const char *__string, const char *__value, int __overwrite);

char * __attribute__((__cdecl__)) gcvt (double,int,char *);
char * __attribute__((__cdecl__)) gcvtf (float,int,char *);
char * __attribute__((__cdecl__)) fcvt (double,int,int *,int *);
char * __attribute__((__cdecl__)) fcvtf (float,int,int *,int *);
char * __attribute__((__cdecl__)) ecvt (double,int,int *,int *);
char * __attribute__((__cdecl__)) ecvtbuf (double, int, int*, int*, char *);
char * __attribute__((__cdecl__)) fcvtbuf (double, int, int*, int*, char *);
char * __attribute__((__cdecl__)) ecvtf (float,int,int *,int *);
char * __attribute__((__cdecl__)) dtoa (double, int, int, int *, int*, char**);
int __attribute__((__cdecl__)) rand_r (unsigned *__seed);

double __attribute__((__cdecl__)) drand48 (void);
double __attribute__((__cdecl__)) _drand48_r (struct _reent *);
double __attribute__((__cdecl__)) erand48 (unsigned short [3]);
double __attribute__((__cdecl__)) _erand48_r (struct _reent *, unsigned short [3]);
long __attribute__((__cdecl__)) jrand48 (unsigned short [3]);
long __attribute__((__cdecl__)) _jrand48_r (struct _reent *, unsigned short [3]);
void __attribute__((__cdecl__)) lcong48 (unsigned short [7]);
void __attribute__((__cdecl__)) _lcong48_r (struct _reent *, unsigned short [7]);
long __attribute__((__cdecl__)) lrand48 (void);
long __attribute__((__cdecl__)) _lrand48_r (struct _reent *);
long __attribute__((__cdecl__)) mrand48 (void);
long __attribute__((__cdecl__)) _mrand48_r (struct _reent *);
long __attribute__((__cdecl__)) nrand48 (unsigned short [3]);
long __attribute__((__cdecl__)) _nrand48_r (struct _reent *, unsigned short [3]);
unsigned short *
       __attribute__((__cdecl__)) seed48 (unsigned short [3]);
unsigned short *
       __attribute__((__cdecl__)) _seed48_r (struct _reent *, unsigned short [3]);
void __attribute__((__cdecl__)) srand48 (long);
void __attribute__((__cdecl__)) _srand48_r (struct _reent *, long);
long long __attribute__((__cdecl__)) atoll (const char *__nptr);
long long __attribute__((__cdecl__)) _atoll_r (struct _reent *, const char *__nptr);
long long __attribute__((__cdecl__)) llabs (long long);
lldiv_t __attribute__((__cdecl__)) lldiv (long long __numer, long long __denom);
long long __attribute__((__cdecl__)) strtoll (const char *__n, char **__end_PTR, int __base);
long long __attribute__((__cdecl__)) _strtoll_r (struct _reent *, const char *__n, char **__end_PTR, int __base);
unsigned long long __attribute__((__cdecl__)) strtoull (const char *__n, char **__end_PTR, int __base);
unsigned long long __attribute__((__cdecl__)) _strtoull_r (struct _reent *, const char *__n, char **__end_PTR, int __base);
# 198 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/stdlib.h"
char * __attribute__((__cdecl__)) _dtoa_r (struct _reent *, double, int, int, int *, int*, char**);







int __attribute__((__cdecl__)) _system_r (struct _reent *, const char *);

void __attribute__((__cdecl__)) __eprintf (const char *, const char *, unsigned int, const char *);








# 24 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\/str.h" 2





enum add_line_return
  {
    ADD_LINE_OK,
    ADD_LINE_ERR,
    ADD_LINE_EOF
  };

struct str
  {
    char *str;
    int len;
    unsigned int mem;
  };
typedef struct str str_t;

char *str_to_nstr (str_t * str);
int str_add_line (str_t *, FILE *);
int str_add_line_from_desc (str_t *, int);
str_t *int_to_str (int);
str_t *nstr_to_str (char *);
str_t *str_make (str_t *);
void str_add_char (str_t *, char);
void str_add_str (str_t *, str_t *);
# 29 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2




# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/ctype.h" 1







int __attribute__((__cdecl__)) isalnum (int __c);
int __attribute__((__cdecl__)) isalpha (int __c);
int __attribute__((__cdecl__)) iscntrl (int __c);
int __attribute__((__cdecl__)) isdigit (int __c);
int __attribute__((__cdecl__)) isgraph (int __c);
int __attribute__((__cdecl__)) islower (int __c);
int __attribute__((__cdecl__)) isprint (int __c);
int __attribute__((__cdecl__)) ispunct (int __c);
int __attribute__((__cdecl__)) isspace (int __c);
int __attribute__((__cdecl__)) isupper (int __c);
int __attribute__((__cdecl__)) isxdigit (int __c);
int __attribute__((__cdecl__)) tolower (int __c);
int __attribute__((__cdecl__)) toupper (int __c);


int __attribute__((__cdecl__)) isblank (int __c);



int __attribute__((__cdecl__)) isascii (int __c);
int __attribute__((__cdecl__)) toascii (int __c);
# 45 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/ctype.h"
extern __attribute__((dllimport)) char *__ctype_ptr__;
# 109 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/ctype.h"
extern __attribute__((dllimport)) const char _ctype_[];


# 34 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/errno.h" 1




typedef int error_t;



# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/errno.h" 1
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/errno.h"
extern int *__errno (void);




extern __attribute__((dllimport)) const char * const _sys_errlist[];
extern __attribute__((dllimport)) int _sys_nerr;

extern __attribute__((dllimport)) const char * const sys_errlist[];
extern __attribute__((dllimport)) int sys_nerr;
# 10 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/errno.h" 2
# 35 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/memory.h" 1
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/memory.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/string.h" 1
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/string.h"
# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 1 3 4
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/string.h" 2







void * __attribute__((__cdecl__)) memchr (const void *, int, unsigned int);
int __attribute__((__cdecl__)) memcmp (const void *, const void *, unsigned int);
void * __attribute__((__cdecl__)) memcpy (void *, const void *, unsigned int);
void * __attribute__((__cdecl__)) memmove (void *, const void *, unsigned int);
void * __attribute__((__cdecl__)) memset (void *, int, unsigned int);
char *__attribute__((__cdecl__)) strcat (char *, const char *);
char *__attribute__((__cdecl__)) strchr (const char *, int);
int __attribute__((__cdecl__)) strcmp (const char *, const char *);
int __attribute__((__cdecl__)) strcoll (const char *, const char *);
char *__attribute__((__cdecl__)) strcpy (char *, const char *);
unsigned int __attribute__((__cdecl__)) strcspn (const char *, const char *);
char *__attribute__((__cdecl__)) strerror (int);
unsigned int __attribute__((__cdecl__)) strlen (const char *);
char *__attribute__((__cdecl__)) strncat (char *, const char *, unsigned int);
int __attribute__((__cdecl__)) strncmp (const char *, const char *, unsigned int);
char *__attribute__((__cdecl__)) strncpy (char *, const char *, unsigned int);
char *__attribute__((__cdecl__)) strpbrk (const char *, const char *);
char *__attribute__((__cdecl__)) strrchr (const char *, int);
unsigned int __attribute__((__cdecl__)) strspn (const char *, const char *);
char *__attribute__((__cdecl__)) strstr (const char *, const char *);


char *__attribute__((__cdecl__)) strtok (char *, const char *);


unsigned int __attribute__((__cdecl__)) strxfrm (char *, const char *, unsigned int);


char *__attribute__((__cdecl__)) strtok_r (char *, const char *, char **);

int __attribute__((__cdecl__)) bcmp (const void *, const void *, unsigned int);
void __attribute__((__cdecl__)) bcopy (const void *, void *, unsigned int);
void __attribute__((__cdecl__)) bzero (void *, unsigned int);
int __attribute__((__cdecl__)) ffs (int);
char *__attribute__((__cdecl__)) index (const char *, int);
void * __attribute__((__cdecl__)) memccpy (void *, const void *, int, unsigned int);
void * __attribute__((__cdecl__)) mempcpy (void *, const void *, unsigned int);
void * __attribute__((__cdecl__)) memmem (const void *, unsigned int, const void *, unsigned int);
char *__attribute__((__cdecl__)) rindex (const char *, int);
char *__attribute__((__cdecl__)) stpcpy (char *, const char *);
char *__attribute__((__cdecl__)) stpncpy (char *, const char *, unsigned int);
int __attribute__((__cdecl__)) strcasecmp (const char *, const char *);
char *__attribute__((__cdecl__)) strcasestr (const char *, const char *);
char *__attribute__((__cdecl__)) strdup (const char *);
char *__attribute__((__cdecl__)) _strdup_r (struct _reent *, const char *);
char *__attribute__((__cdecl__)) strndup (const char *, unsigned int);
char *__attribute__((__cdecl__)) _strndup_r (struct _reent *, const char *, unsigned int);
char *__attribute__((__cdecl__)) strerror_r (int, char *, unsigned int);
unsigned int __attribute__((__cdecl__)) strlcat (char *, const char *, unsigned int);
unsigned int __attribute__((__cdecl__)) strlcpy (char *, const char *, unsigned int);
int __attribute__((__cdecl__)) strncasecmp (const char *, const char *, unsigned int);
unsigned int __attribute__((__cdecl__)) strnlen (const char *, unsigned int);
char *__attribute__((__cdecl__)) strsep (char **, const char *);
char *__attribute__((__cdecl__)) strlwr (char *);
char *__attribute__((__cdecl__)) strupr (char *);


char *__attribute__((__cdecl__)) strsignal (int __signo);

int __attribute__((__cdecl__)) strtosigno (const char *__name);
# 100 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/string.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/string.h" 1
# 101 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/string.h" 2


# 16 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/memory.h" 2
# 36 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/pwd.h" 1
# 50 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/pwd.h"
struct passwd {
 char *pw_name;
 char *pw_passwd;
 uid_t pw_uid;
 gid_t pw_gid;
 char *pw_comment;
 char *pw_gecos;
 char *pw_dir;
 char *pw_shell;
};


struct passwd *getpwuid (uid_t);
struct passwd *getpwnam (const char *);
int getpwnam_r (const char *, struct passwd *,
   char *, unsigned int , struct passwd **);
int getpwuid_r (uid_t, struct passwd *, char *,
   unsigned int, struct passwd **);

struct passwd *getpwent (void);
void setpwent (void);
void endpwent (void);
# 37 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/signal.h" 1




# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/signal.h" 1
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/signal.h"
typedef unsigned long int;
# 104 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/signal.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/signal.h" 1
# 17 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/signal.h"
struct _fpstate
{
  unsigned long cw;
  unsigned long sw;
  unsigned long tag;
  unsigned long ipoff;
  unsigned long cssel;
  unsigned long dataoff;
  unsigned long datasel;
  unsigned char _st[80];
  unsigned long nxst;
};

struct ucontext
{
  unsigned long cr2;
  unsigned long dr0;
  unsigned long dr1;
  unsigned long dr2;
  unsigned long dr3;
  unsigned long dr6;
  unsigned long dr7;
  struct _fpstate fpstate;
  unsigned long gs;
  unsigned long fs;
  unsigned long es;
  unsigned long ds;
  unsigned long edi;
  unsigned long esi;
  unsigned long ebx;
  unsigned long edx;
  unsigned long ecx;
  unsigned long eax;
  unsigned long ebp;
  unsigned long eip;
  unsigned long cs;
  unsigned long eflags;
  unsigned long esp;
  unsigned long ss;
  unsigned char _internal;
  unsigned long oldmask;
};



typedef union sigval
{
  int sival_int;
  void *sival_ptr;
} sigval_t;

typedef struct sigevent
{
  sigval_t sigev_value;
  int sigev_signo;
  int sigev_notify;
  void (*sigev_notify_function) (sigval_t);
  pthread_attr_t *sigev_notify_attributes;
} sigevent_t;

#pragma pack(push,4)
struct _sigcommune
{
  __uint32_t _si_code;
  void *_si_read_handle;
  void *_si_write_handle;
  void *_si_process_handle;
  __extension__ union
  {
    int _si_fd;
    void *_si_pipe_fhandler;
    char *_si_str;
  };
};

typedef struct
{
  int si_signo;
  int si_code;
  pid_t si_pid;
  uid_t si_uid;
  int si_errno;

  __extension__ union
  {
    __uint32_t __pad[32];
    struct _sigcommune _si_commune;
    __extension__ union
    {

      struct
      {
 union
 {
   struct
   {
     timer_t si_tid;
     unsigned int si_overrun;
   };
   sigval_t si_sigval;
   sigval_t si_value;
 };
      };
    };


    __extension__ struct
    {
      int si_status;
      clock_t si_utime;
      clock_t si_stime;
    };


    void *si_addr;
  };
} siginfo_t;
#pragma pack(pop)

enum
{
  SI_USER = 0,
  SI_ASYNCIO = 2,

  SI_MESGQ,

  SI_TIMER,
  SI_QUEUE,

  SI_KERNEL,

  ILL_ILLOPC,
  ILL_ILLOPN,
  ILL_ILLADR,
  ILL_ILLTRP,
  ILL_PRVOPC,
  ILL_PRVREG,
  ILL_COPROC,
  ILL_BADSTK,

  FPE_INTDIV,
  FPE_INTOVF,
  FPE_FLTDIV,
  FPE_FLTOVF,
  FPE_FLTUND,
  FPE_FLTRES,
  FPE_FLTINV,
  FPE_FLTSUB,

  SEGV_MAPERR,
  SEGV_ACCERR,

  BUS_ADRALN,
  BUS_ADRERR,
  BUS_OBJERR,

  CLD_EXITED,
  CLD_KILLED,
  CLD_DUMPED,
  CLD_TRAPPED,
  CLD_STOPPED,
  CLD_CONTINUED
};

enum
{
  SIGEV_SIGNAL = 0,


  SIGEV_NONE,


  SIGEV_THREAD

};

typedef void (*_sig_func_ptr)(int);

struct sigaction
{
  __extension__ union
  {
    _sig_func_ptr sa_handler;
    void (*sa_sigaction) ( int, siginfo_t *, void * );
  };
  int sa_mask;
  int sa_flags;
};
# 263 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/signal.h"
int sigwait (const int *, int *);
int sigwaitinfo (const int *, siginfo_t *);
int sighold (int);
int sigignore (int);
int sigrelse (int);
_sig_func_ptr sigset (int, _sig_func_ptr);

int sigqueue(pid_t, int, const union sigval);
int siginterrupt (int, int);



extern const char __attribute__((dllimport)) *sys_sigabbrev[];
# 105 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/signal.h" 2
# 131 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/signal.h"
int __attribute__((__cdecl__)) sigprocmask (int how, const int *set, int *oset);


int __attribute__((__cdecl__)) pthread_sigmask (int how, const int *set, int *oset);
# 145 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/signal.h"
int __attribute__((__cdecl__)) kill (pid_t, int);
int __attribute__((__cdecl__)) killpg (pid_t, int);
int __attribute__((__cdecl__)) sigaction (int, const struct sigaction *, struct sigaction *);
int __attribute__((__cdecl__)) sigaddset (int *, const int);
int __attribute__((__cdecl__)) sigdelset (int *, const int);
int __attribute__((__cdecl__)) sigismember (const int *, int);
int __attribute__((__cdecl__)) sigfillset (int *);
int __attribute__((__cdecl__)) sigemptyset (int *);
int __attribute__((__cdecl__)) sigpending (int *);
int __attribute__((__cdecl__)) sigsuspend (const int *);
int __attribute__((__cdecl__)) sigpause (int);







int __attribute__((__cdecl__)) pthread_kill (pthread_t thread, int sig);







int __attribute__((__cdecl__)) sigwaitinfo (const int *set, siginfo_t *info);
int __attribute__((__cdecl__)) sigtimedwait (const int *set, siginfo_t *info, const struct timespec *timeout);


int __attribute__((__cdecl__)) sigwait (const int *set, int *sig);


int __attribute__((__cdecl__)) sigqueue (pid_t pid, int signo, const union sigval value);
# 6 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/signal.h" 2



typedef int sig_atomic_t;





struct _reent;

_sig_func_ptr __attribute__((__cdecl__)) _signal_r (struct _reent *, int, _sig_func_ptr);
int __attribute__((__cdecl__)) _raise_r (struct _reent *, int);


_sig_func_ptr __attribute__((__cdecl__)) signal (int, _sig_func_ptr);
int __attribute__((__cdecl__)) raise (int);



# 38 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2
# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stdarg.h" 1 3 4
# 106 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stdarg.h" 3 4
typedef __gnuc_va_list va_list;
# 39 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2


# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/file.h" 1
# 27 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/file.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/fcntl.h" 1
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/fcntl.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/fcntl.h" 1


# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_default_fcntl.h" 1
# 161 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_default_fcntl.h"
struct eflock {
 short l_type;
 short l_whence;
 long l_start;
 long l_len;
 short l_pid;
 short l_xxx;
 long l_rpid;
 long l_rsys;
};




# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stat.h" 1
# 9 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stat.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h" 1
# 18 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/machine/time.h" 1
# 19 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h" 2
# 27 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h"
# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 1 3 4
# 28 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h" 2





struct tm
{
  int tm_sec;
  int tm_min;
  int tm_hour;
  int tm_mday;
  int tm_mon;
  int tm_year;
  int tm_wday;
  int tm_yday;
  int tm_isdst;
};

clock_t __attribute__((__cdecl__)) clock (void);
double __attribute__((__cdecl__)) difftime (time_t _time2, time_t _time1);
time_t __attribute__((__cdecl__)) mktime (struct tm *_timeptr);
time_t __attribute__((__cdecl__)) time (time_t *_timer);

char *__attribute__((__cdecl__)) asctime (const struct tm *_tblock);
char *__attribute__((__cdecl__)) ctime (const time_t *_time);
struct tm *__attribute__((__cdecl__)) gmtime (const time_t *_timer);
struct tm *__attribute__((__cdecl__)) localtime (const time_t *_timer);

unsigned int __attribute__((__cdecl__)) strftime (char *_s, unsigned int _maxsize, const char *_fmt, const struct tm *_t);

char *__attribute__((__cdecl__)) asctime_r (const struct tm *, char *);
char *__attribute__((__cdecl__)) ctime_r (const time_t *, char *);
struct tm *__attribute__((__cdecl__)) gmtime_r (const time_t *, struct tm *);
struct tm *__attribute__((__cdecl__)) localtime_r (const time_t *, struct tm *);








char *__attribute__((__cdecl__)) strptime (const char *, const char *, struct tm *);
void __attribute__((__cdecl__)) tzset (void);
void __attribute__((__cdecl__)) _tzset_r (struct _reent *);

typedef struct __tzrule_struct
{
  char ch;
  int m;
  int n;
  int d;
  int s;
  time_t change;
  long offset;
} __tzrule_type;

typedef struct __tzinfo_struct
{
  int __tznorth;
  int __tzyear;
  __tzrule_type __tzrule[2];
} __tzinfo_type;

__tzinfo_type *__attribute__((__cdecl__)) __gettzinfo (void);
# 118 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h"
extern __attribute__((dllimport)) long _timezone;
extern __attribute__((dllimport)) int _daylight;
extern __attribute__((dllimport)) char *_tzname[2];
# 135 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/time.h" 1
# 19 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/time.h"
int __attribute__((__cdecl__)) clock_setres (clockid_t, struct timespec *);


time_t __attribute__((__cdecl__)) timelocal (struct tm *);
time_t __attribute__((__cdecl__)) timegm (struct tm *);





extern int daylight __asm__ ("__daylight");


extern long timezone __asm__ ("__timezone");
# 136 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h" 2
# 148 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/time.h"
int __attribute__((__cdecl__)) clock_settime (clockid_t clock_id, const struct timespec *tp);
int __attribute__((__cdecl__)) clock_gettime (clockid_t clock_id, struct timespec *tp);
int __attribute__((__cdecl__)) clock_getres (clockid_t clock_id, struct timespec *res);



int __attribute__((__cdecl__)) timer_create (clockid_t clock_id, struct sigevent *evp, timer_t *timerid);




int __attribute__((__cdecl__)) timer_delete (timer_t timerid);



int __attribute__((__cdecl__)) timer_settime (timer_t timerid, int flags, const struct itimerspec *value, struct itimerspec *ovalue);


int __attribute__((__cdecl__)) timer_gettime (timer_t timerid, struct itimerspec *value);
int __attribute__((__cdecl__)) timer_getoverrun (timer_t timerid);



int __attribute__((__cdecl__)) nanosleep (const struct timespec *rqtp, struct timespec *rmtp);
# 10 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stat.h" 2
# 20 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stat.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/stat.h" 1
# 62 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/stat.h"
struct stat
{
  dev_t st_dev;
  ino_t st_ino;
  mode_t st_mode;
  nlink_t st_nlink;
  uid_t st_uid;
  gid_t st_gid;
  dev_t st_rdev;
  off_t st_size;
  timestruc_t st_atim;
  timestruc_t st_mtim;
  timestruc_t st_ctim;
  blksize_t st_blksize;
  blkcnt_t st_blocks;

  timestruc_t st_birthtim;



};
# 21 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stat.h" 2
# 124 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/stat.h"
int __attribute__((__cdecl__)) chmod ( const char *__path, mode_t __mode );
int __attribute__((__cdecl__)) fchmod (int __fd, mode_t __mode);
int __attribute__((__cdecl__)) fstat ( int __fd, struct stat *__sbuf );
int __attribute__((__cdecl__)) mkdir ( const char *_path, mode_t __mode );
int __attribute__((__cdecl__)) mkfifo ( const char *__path, mode_t __mode );
int __attribute__((__cdecl__)) stat ( const char *__path, struct stat *__sbuf );
mode_t __attribute__((__cdecl__)) umask ( mode_t __mask );


int __attribute__((__cdecl__)) lstat ( const char *__path, struct stat *__buf );
int __attribute__((__cdecl__)) mknod ( const char *__path, mode_t __mode, dev_t __dev );



int __attribute__((__cdecl__)) fchmodat (int, const char *, mode_t, int);
int __attribute__((__cdecl__)) fstatat (int, const char *, struct stat *, int);
int __attribute__((__cdecl__)) mkdirat (int, const char *, mode_t);
int __attribute__((__cdecl__)) mkfifoat (int, const char *, mode_t);
int __attribute__((__cdecl__)) mknodat (int, const char *, mode_t, dev_t);
int __attribute__((__cdecl__)) utimensat (int, const char *, const struct timespec *, int);
int __attribute__((__cdecl__)) futimens (int, const struct timespec *);
# 176 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_default_fcntl.h" 2

extern int open (const char *, int, ...);
extern int creat (const char *, mode_t);
extern int fcntl (int, int, ...);

# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/time.h" 1
# 17 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/time.h"
struct timeval {
  time_t tv_sec;
  suseconds_t tv_usec;
};

struct timezone {
  int tz_minuteswest;
  int tz_dsttime;
};


# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/sys_time.h" 1
# 13 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/sys_time.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/select.h" 1
# 23 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/select.h"
# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/time.h" 1
# 24 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/select.h" 2







int select (int __n, _types_fd_set *__readfds, _types_fd_set *__writefds, _types_fd_set *__exceptfds, struct timeval *__timeout);

int pselect (int __n, _types_fd_set *__readfds, _types_fd_set *__writefds, _types_fd_set *__exceptfds, const struct timespec *__timeout, const int *__set);




# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/cygwin/sys_time.h" 2






int futimes (int, const struct timeval *);
int lutimes (const char *, const struct timeval *);
# 29 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/time.h" 2
# 37 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/time.h"
struct itimerval {
  struct timeval it_interval;
  struct timeval it_value;
};
# 74 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/time.h"
int __attribute__((__cdecl__)) gettimeofday (struct timeval *__p, void *__tz);
int __attribute__((__cdecl__)) settimeofday (const struct timeval *, const struct timezone *);
int __attribute__((__cdecl__)) utimes (const char *__path, const struct timeval *__tvp);
int __attribute__((__cdecl__)) getitimer (int __which, struct itimerval *__value);
int __attribute__((__cdecl__)) setitimer (int __which, const struct itimerval *__value, struct itimerval *__ovalue);
# 182 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/_default_fcntl.h" 2
extern int futimesat (int, const char *, const struct timeval *);
extern int openat (int, const char *, int, ...);
extern int unlinkat (int, const char *, int);
# 4 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/fcntl.h" 2
# 15 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/fcntl.h" 2
# 41 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/fcntl.h"
extern int posix_fadvise (int, off_t, off_t, int);
extern int posix_fallocate (int, off_t, off_t);
# 28 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/file.h" 2
# 48 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/file.h"


int __attribute__((__cdecl__)) flock (int, int);


# 42 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2


# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/unistd.h" 1



# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/unistd.h" 1
# 13 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/unistd.h"
# 1 "/usr/lib/gcc/i686-pc-cygwin/3.4.4/include/stddef.h" 1 3 4
# 14 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/unistd.h" 2

extern char **environ;

void __attribute__((__cdecl__)) _exit (int __status ) __attribute__ ((noreturn));

int __attribute__((__cdecl__)) access (const char *__path, int __amode );
unsigned __attribute__((__cdecl__)) alarm (unsigned __secs );
int __attribute__((__cdecl__)) chdir (const char *__path );
int __attribute__((__cdecl__)) chmod (const char *__path, mode_t __mode );

int __attribute__((__cdecl__)) chown (const char *__path, uid_t __owner, gid_t __group );


int __attribute__((__cdecl__)) chroot (const char *__path );

int __attribute__((__cdecl__)) close (int __fildes );

unsigned int __attribute__((__cdecl__)) confstr (int __name, char *__buf, unsigned int __len);

char __attribute__((__cdecl__)) *ctermid (char *__s );
char __attribute__((__cdecl__)) *cuserid (char *__s );

int __attribute__((__cdecl__)) daemon (int nochdir, int noclose);

int __attribute__((__cdecl__)) dup (int __fildes );
int __attribute__((__cdecl__)) dup2 (int __fildes, int __fildes2 );

int __attribute__((__cdecl__)) eaccess (const char *__path, int __mode);
void __attribute__((__cdecl__)) endusershell (void);
int __attribute__((__cdecl__)) euidaccess (const char *__path, int __mode);

int __attribute__((__cdecl__)) execl (const char *__path, const char *, ... );
int __attribute__((__cdecl__)) execle (const char *__path, const char *, ... );
int __attribute__((__cdecl__)) execlp (const char *__file, const char *, ... );
int __attribute__((__cdecl__)) execv (const char *__path, char * const __argv[] );
int __attribute__((__cdecl__)) execve (const char *__path, char * const __argv[], char * const __envp[] );
int __attribute__((__cdecl__)) execvp (const char *__file, char * const __argv[] );

int __attribute__((__cdecl__)) execvpe (const char *__file, char * const __argv[], char * const __envp[] );
int __attribute__((__cdecl__)) faccessat (int __dirfd, const char *__path, int __mode, int __flags);


int __attribute__((__cdecl__)) fchdir (int __fildes);

int __attribute__((__cdecl__)) fchmod (int __fildes, mode_t __mode );

int __attribute__((__cdecl__)) fchown (int __fildes, uid_t __owner, gid_t __group );


int __attribute__((__cdecl__)) fchownat (int __dirfd, const char *__path, uid_t __owner, gid_t __group, int __flags);
int __attribute__((__cdecl__)) fexecve (int __fd, char * const __argv[], char * const __envp[] );

pid_t __attribute__((__cdecl__)) fork (void );
long __attribute__((__cdecl__)) fpathconf (int __fd, int __name );
int __attribute__((__cdecl__)) fsync (int __fd);
int __attribute__((__cdecl__)) fdatasync (int __fd);
char __attribute__((__cdecl__)) *getcwd (char *__buf, unsigned int __size );

int __attribute__((__cdecl__)) getdomainname (char *__name, unsigned int __len);


gid_t __attribute__((__cdecl__)) getegid (void );
uid_t __attribute__((__cdecl__)) geteuid (void );
gid_t __attribute__((__cdecl__)) getgid (void );

int __attribute__((__cdecl__)) getgroups (int __gidsetsize, gid_t __grouplist[] );

long __attribute__((__cdecl__)) gethostid (void);

char __attribute__((__cdecl__)) *getlogin (void );

int __attribute__((__cdecl__)) getlogin_r (char *name, unsigned int namesize);

char __attribute__((__cdecl__)) *getpass (const char *__prompt);
int __attribute__((__cdecl__)) getpagesize (void);

int __attribute__((__cdecl__)) getpeereid (int, uid_t *, gid_t *);

pid_t __attribute__((__cdecl__)) getpgid (pid_t);
pid_t __attribute__((__cdecl__)) getpgrp (void );
pid_t __attribute__((__cdecl__)) getpid (void );
pid_t __attribute__((__cdecl__)) getppid (void );

pid_t __attribute__((__cdecl__)) getsid (pid_t);


uid_t __attribute__((__cdecl__)) getuid (void );


char * __attribute__((__cdecl__)) getusershell (void);
char __attribute__((__cdecl__)) *getwd (char *__buf );
int __attribute__((__cdecl__)) iruserok (unsigned long raddr, int superuser, const char *ruser, const char *luser);

int __attribute__((__cdecl__)) isatty (int __fildes );

int __attribute__((__cdecl__)) lchown (const char *__path, uid_t __owner, gid_t __group );

int __attribute__((__cdecl__)) link (const char *__path1, const char *__path2 );

int __attribute__((__cdecl__)) linkat (int __dirfd1, const char *__path1, int __dirfd2, const char *__path2, int __flags );

int __attribute__((__cdecl__)) nice (int __nice_value );

off_t __attribute__((__cdecl__)) lseek (int __fildes, off_t __offset, int __whence );






int __attribute__((__cdecl__)) lockf (int __fd, int __cmd, off_t __len);

long __attribute__((__cdecl__)) pathconf (const char *__path, int __name );
int __attribute__((__cdecl__)) pause (void );

int __attribute__((__cdecl__)) pthread_atfork (void (*)(void), void (*)(void), void (*)(void));

int __attribute__((__cdecl__)) pipe (int __fildes[2] );
ssize_t __attribute__((__cdecl__)) pread (int __fd, void *__buf, unsigned int __nbytes, off_t __offset);
ssize_t __attribute__((__cdecl__)) pwrite (int __fd, const void *__buf, unsigned int __nbytes, off_t __offset);
_ssize_t __attribute__((__cdecl__)) read (int __fd, void *__buf, unsigned int __nbyte );

int __attribute__((__cdecl__)) rresvport (int *__alport);
int __attribute__((__cdecl__)) revoke (char *__path);

int __attribute__((__cdecl__)) rmdir (const char *__path );

int __attribute__((__cdecl__)) ruserok (const char *rhost, int superuser, const char *ruser, const char *luser);

void * __attribute__((__cdecl__)) sbrk (ptrdiff_t __incr);


int __attribute__((__cdecl__)) setegid (gid_t __gid );
int __attribute__((__cdecl__)) seteuid (uid_t __uid );

int __attribute__((__cdecl__)) setgid (gid_t __gid );


int __attribute__((__cdecl__)) setgroups (int ngroups, const gid_t *grouplist );

int __attribute__((__cdecl__)) setpgid (pid_t __pid, pid_t __pgid );
int __attribute__((__cdecl__)) setpgrp (void );

int __attribute__((__cdecl__)) setregid (gid_t __rgid, gid_t __egid);
int __attribute__((__cdecl__)) setreuid (uid_t __ruid, uid_t __euid);

pid_t __attribute__((__cdecl__)) setsid (void );

int __attribute__((__cdecl__)) setuid (uid_t __uid );


void __attribute__((__cdecl__)) setusershell (void);

unsigned __attribute__((__cdecl__)) sleep (unsigned int __seconds );
void __attribute__((__cdecl__)) swab (const void *, void *, ssize_t);
long __attribute__((__cdecl__)) sysconf (int __name );
pid_t __attribute__((__cdecl__)) tcgetpgrp (int __fildes );
int __attribute__((__cdecl__)) tcsetpgrp (int __fildes, pid_t __pgrp_id );
char __attribute__((__cdecl__)) *ttyname (int __fildes );

int __attribute__((__cdecl__)) ttyname_r (int, char *, unsigned int);

int __attribute__((__cdecl__)) unlink (const char *__path );
int __attribute__((__cdecl__)) usleep (useconds_t __useconds);
int __attribute__((__cdecl__)) vhangup (void );
_ssize_t __attribute__((__cdecl__)) write (int __fd, const void *__buf, unsigned int __nbyte );



# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/getopt.h" 1
# 45 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/getopt.h"
extern int __attribute__((dllimport)) opterr;
extern int __attribute__((dllimport)) optind;
extern int __attribute__((dllimport)) optopt;
extern int __attribute__((dllimport)) optreset;
extern char __attribute__((dllimport)) *optarg;


int getopt (int, char * const *, const char *);
# 184 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/unistd.h" 2
# 193 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/unistd.h"
pid_t __attribute__((__cdecl__)) vfork (void );

extern char *suboptarg;
int getsubopt(char **, char * const *, char **);
# 220 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/sys/unistd.h"
int __attribute__((__cdecl__)) ftruncate (int __fd, off_t __length);
int __attribute__((__cdecl__)) truncate (const char *, off_t __length);




int __attribute__((__cdecl__)) getdtablesize (void);
int __attribute__((__cdecl__)) setdtablesize (int);
useconds_t __attribute__((__cdecl__)) ualarm (useconds_t __useconds, useconds_t __interval);


 int __attribute__((__cdecl__)) gethostname (char *__name, unsigned int __len);

char * __attribute__((__cdecl__)) mktemp (char *);



void __attribute__((__cdecl__)) sync (void);


ssize_t __attribute__((__cdecl__)) readlink (const char *__path, char *__buf, unsigned int __buflen);

ssize_t __attribute__((__cdecl__)) readlinkat (int __dirfd1, const char *__path, char *__buf, unsigned int __buflen);

int __attribute__((__cdecl__)) symlink (const char *__name1, const char *__name2);
# 5 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/unistd.h" 2
# 45 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2




# 1 "C:/Program Files (x86)/DTS/DTS/DTSGCC/include/strings.h" 1
# 50 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c" 2
# 71 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c"
struct pipe
  {

    int pin;
    int pout;
    int perr;


    int cin;
    int cout;
    int cerr;

    _types_fd_set error_set;

  };
typedef struct pipe pipe_t;


static char *strerror (int);


char *find_ispell ();
static char *xstrdup (const char *);
static void *xmalloc (unsigned int);
static void *xrealloc (void *, unsigned int);
static void error (int status, int errnum, const char *message,...);
static void sig_chld (int);
static void sig_pipe (int);
void new_pipe (pipe_t *);
void parent (pipe_t *, int, char **);
void read_file (pipe_t *, FILE *, char *);
void read_ispell (pipe_t *, char *, int);
void read_ispell_errors (pipe_t *);
void run_ispell_in_child (pipe_t *);


const char version[] = "version " ;


const struct option long_options[] =
{
  {"all-chains", 0, ((void *)0), 'l'},
  {"british", 0, ((void *)0), 'b'},
  {"dictionary", 1, ((void *)0), 'd'},
  {"help", 0, ((void *)0), 'h'},
  {"ispell", 1, ((void *)0), 'i'},
  {"ispell-version", 0, ((void *)0), 'I'},
  {"number", 0, ((void *)0), 'n'},
  {"print-file-name", 0, ((void *)0), 'o'},
  {"print-stems", 0, ((void *)0), 'x'},
  {"stop-list", 1, ((void *)0), 's'},
  {"verbose", 0, ((void *)0), 'v'},
  {"version", 0, ((void *)0), 'V'},
  {((void *)0), 0, ((void *)0), 0}
};


char *program_name = ((void *)0);


char *ispell_prog = ((void *)0);


char *dictionary = ((void *)0);


int show_ispell_version = 0;


int read_stdin = 0;


int british = 0;



int verbose = 0;


int number_lines = 0;



int print_file_names = 0;


int interactive = 0;

int
main (int argc, char **argv)
{
  char opt = 0;
  int opt_error = 0;
  int show_help = 0;
  int show_version = 0;
  pid_t pid = 0;
  pipe_t ispell_pipe;

  program_name = argv[0];


  while (1)
    {
      opt = getopt_long (argc, argv, "IVbdhilnosvx", long_options,
    (int *) 0);

      if (opt == (-1))
 break;

      switch (opt)
 {
 case 'I':
   show_ispell_version = 1;
   break;
 case 'V':
   show_version = 1;
   break;
 case 'b':
   british = 1;
   break;
 case 'd':
   if (optarg != ((void *)0))
     dictionary = xstrdup (optarg);
   else
     error (0, 0, "option argument not given");
   break;
 case 'h':
   show_help = 1;
   break;
 case 'i':
   if (optarg != ((void *)0))
     ispell_prog = xstrdup (optarg);
   else
     error (0, 0, "option argument not given");
   break;
 case 'l':
   break;
 case 'n':
   number_lines = 1;
   break;
 case 'o':
   print_file_names = 1;
   break;
 case 's':
   break;
 case 'v':
   verbose = 1;
   break;
 case 'x':
   break;
 default:
   opt_error = 1;
   break;
 }
    }

  if (opt_error)
    {
      printf ("Try `%s --help' for more information.\n", program_name);
      exit (1);
    }

  if (show_version)
    {
      error (0, 0, version);

      if (!show_help)
 exit (0);
    }

  if (show_help)
    {
      printf ("Usage: %s [OPTION]... [FILE]...\n", program_name);
      fputs ("This is GNU Spell, a Unix spell emulator.\n\n"
      "  -I, --ispell-version\t\tPrint Ispell's version.\n"
      "  -V, --version\t\t\tPrint the version number.\n"
      "  -b, --british\t\t\tUse the British dictionary.\n"
      "  -d, --dictionary=FILE\t\tUse FILE to look up words.\n"
      "  -h, --help\t\t\tPrint a summary of the options.\n"
      "  -i, --ispell=PROGRAM\t\tCalls PROGRAM as Ispell.\n"
      "  -l, --all-chains\t\tIgnored; for compatibility.\n"
      "  -n, --number\t\t\tPrint line numbers before lines.\n"
      "  -o, --print-file-name\t\tPrint file names before lines.\n"
      "  -s, --stop-list=FILE\t\tIgnored; for compatibility.\n"
      "  -v, --verbose\t\t\tPrint words not literally found.\n"
      "  -x, --print-stems\t\tIgnored; for compatibility.\n\n"
      "Please use Info to read more (type `info spell').\n", ((__getreent())->_stderr));
      exit (0);
    }

  if (!ispell_prog)
    ispell_prog = find_ispell ();

  new_pipe (&ispell_pipe);

  pid = fork ();

  if (pid < 0)
    error (1, (*__errno()), "error forking to run Ispell");
  else if (pid > 0)
    parent (&ispell_pipe, argc, argv);
  else
    run_ispell_in_child (&ispell_pipe);

  exit (0);
}





char *
find_ispell ()
{
  char *ispell = ((void *)0);
  char *path = ((void *)0);
  int path_len = 0;
  int pos = 0;
  str_t *file = str_make (0);
  struct stat stat_buf;

  path = xstrdup (getenv ("PATH"));
  path_len = strlen (path);

  while (1)
    {
      file = str_make (file);

      if (!pos && path[pos] == ':')


 str_add_char (file, '.');
      else
 for (; pos < path_len && path[pos] != ':'; pos++)
   str_add_char (file, path[pos]);

      if (file->str[file->len - 1] != '/')
 str_add_char (file, '/');
      str_add_str (file, nstr_to_str ("ispell"));

      if (stat (str_to_nstr (file), &stat_buf) != -1)
 return xstrdup (str_to_nstr (file));

      if (pos >= path_len)
 error (1, 0, "unable to locate Ispell");
      pos++;
    }


  abort ();
}




void
read_file (pipe_t * the_pipe, FILE * stream, char *file)
{
  str_t *str = str_make (0);
  enum add_line_return add_line_ret = 0;
  int line = 0;

  while (1)
    {
      str = str_make (str);

      str_add_char (str, '^');
      add_line_ret = str_add_line (str, stream);
      line++;

      if (add_line_ret == ADD_LINE_ERR)
 error (1, (*__errno()), "%s: error reading line", file);
      if (add_line_ret == ADD_LINE_EOF && !str->len)
 return;


      if (str->str[str->len - 1] != '\n')
 str_add_char (str, '\n');

      if (write (the_pipe->pout, str_to_nstr (str), str->len) != str->len)
 error (1, (*__errno()), "error writing to Ispell");

      read_ispell_errors (the_pipe);
      read_ispell (the_pipe, file, line);
      read_ispell_errors (the_pipe);

      if (add_line_ret == ADD_LINE_EOF)
 return;
    }

  if (fclose (stream) == (-1))
    error (0, (*__errno()), "%s: close error", file);
}







void
read_ispell (pipe_t * ispell_pipe, char *file, int line)
{
  str_t *str = str_make (0);

  while (1)
    {
      str = str_make (str);

      if (str_add_line_from_desc (str, ispell_pipe->pin) == ADD_LINE_EOF)
 exit (0);



      if (str->len == 1 && str->str[0] == '\n')
 return;


      if (str->str[0] == '*' || str->str[0] == '+'
   || str->str[0] == '-')
 continue;


      if (str->str[0] == '&' || str->str[0] == '#'
   || (str->str[0] == '?' && verbose))
 {
   int pos;

   if (print_file_names)
     {
       printf ("%s:", file);
       if (!number_lines)
  putc(' ', ((__getreent())->_stdout));
     }
   if (number_lines)
     printf ("%d: ", line);

   for (pos = 2; str->str[pos] != ' '; pos++)
     putc(str->str[pos], ((__getreent())->_stdout));
   putc('\n', ((__getreent())->_stdout));

   continue;
 }

      if (str->str[0] == '?' && !verbose)
 continue;

      error (0, 0, "unrecognized Ispell line `%s'", str_to_nstr (str));
    }
}






void
read_ispell_errors (pipe_t * the_pipe)
{
  struct timeval time_out;
  str_t *str = str_make (0);

  time_out.tv_sec = time_out.tv_usec = 0;

  while (select (64, &(the_pipe->error_set), ((void *)0), ((void *)0),
   &time_out) == 1)
    {
      str = str_make (str);

      if (str_add_line_from_desc (str, the_pipe->perr) == ADD_LINE_EOF)

 error (1, 0, "premature EOF from Ispell's stderr");


      str->len -= 2;
      str->str[str->len - 1] = 0;

      if (!memcmp (str->str, "Can't open ", strlen ("Can't open ")))
 error (1, 0, "%s: cannot open",
        str->str + strlen ("Can't open "));

      fprintf (((__getreent())->_stderr), "%s: %s\n", ispell_prog, str->str);
    }
}




void
new_pipe (pipe_t * the_pipe)
{
  int ifd[2];
  int ofd[2];
  int efd[2];

  if (signal (13, sig_pipe) == ((_sig_func_ptr)-1))
    error (1, (*__errno()), "error creating SIGPIPE handler");
  if (signal (20, sig_chld) == ((_sig_func_ptr)-1))
    error (1, (*__errno()), "error creating SIGCHLD handler");

  if (pipe (ifd) < 0)
    error (1, (*__errno()), "error creating pipe to Ispell");
  the_pipe->pin = ifd[0];
  the_pipe->cout = ifd[1];

  if (pipe (ofd) < 0)
    error (1, (*__errno()), "error creating pipe to Ispell");
  the_pipe->cin = ofd[0];
  the_pipe->pout = ofd[1];

  if (pipe (efd) < 0)
    error (1, (*__errno()), "error creating pipe to Ispell");
  the_pipe->perr = efd[0];
  the_pipe->cerr = efd[1];

  (__extension__ (void)({ unsigned int __i; char *__tmp = (char *)&(the_pipe->error_set); for (__i = 0; __i < sizeof (*(&(the_pipe->error_set))); ++__i) *__tmp++ = 0; }));
  ((&(the_pipe->error_set))->fds_bits[(the_pipe->perr)/(sizeof (fd_mask) * 8)] |= (1L << ((the_pipe->perr) % (sizeof (fd_mask) * 8))));
}



static void
sig_pipe (int signo)
{
  error (1, 0, "broken pipe");
}



static void
sig_chld (int signo)
{
  error (1, 0, "Ispell died");
}







void
parent (pipe_t * the_pipe, int argc, char **argv)
{
  FILE *stream;
  char *file = ((void *)0);
  int arg_error = 0;
  int arg_index = optind;



  close (the_pipe->cin);
  close (the_pipe->cout);
  close (the_pipe->cerr);

  read_ispell_errors (the_pipe);






  {
    int pos = 0;
    str_t *ispell_version = str_make (0);
    str_t *str = str_make (0);

    if (str_add_line_from_desc (str, the_pipe->pin) == ADD_LINE_EOF)
      error (1, 0, "premature EOF from Ispell's stdout");

    for (; !(((__ctype_ptr__+sizeof(""[str->str[pos]]))[(int)(str->str[pos])])&04) && pos <= str->len; pos++);
    for (; str->str[pos] != ' ' && pos <= str->len; pos++)
      str_add_char (ispell_version, str->str[pos]);

    if (show_ispell_version)
      {
 printf ("%s: Ispell version %s\n", program_name,
  str_to_nstr (ispell_version));
 exit (0);
      }
  }

  file = xstrdup ("-");

  if (argc == 1)
    read_file (the_pipe, ((__getreent())->_stdin), "-");

  while (arg_index < argc)
    {
      arg_error = 0;

      file = argv[arg_index];

      if (file[0] == '-' && file[1] == 0)
 {
   if (!read_stdin)
     {
       read_stdin = 1;
       stream = ((__getreent())->_stdin);
     }
 }
      else
 {
   struct stat stat_buf;

   if (stat (file, &stat_buf) == -1)
     {
       error (0, (*__errno()), "%s: stat error", file);
       arg_index++;
       continue;
     }
   if ((((stat_buf.st_mode)&0170000) == 0040000))
     {
       error (0, 0, "%s: is a directory", file);
       arg_index++;
       continue;
     }

   stream = fopen (file, "r");
   if (!stream)
     {
       error (0, (*__errno()), "%s: open error", file);
       arg_error = 1;
     }
 }

      if (!arg_error)
 read_file (the_pipe, stream, file);

      arg_index++;
    }
}





void
run_ispell_in_child (pipe_t * the_pipe)
{

  close (the_pipe->pin);
  close (the_pipe->pout);
  close (the_pipe->perr);

  if (the_pipe->cin != 0)
    if (dup2 (the_pipe->cin, 0) != 0)
      error (1, (*__errno()), "error duping to stdin");

  if (the_pipe->cout != 1)
    if (dup2 (the_pipe->cout, 1) != 1)
      error (1, (*__errno()), "error duping to stdout");

  if (the_pipe->cerr != 2)
    if (dup2 (the_pipe->cerr, 2) != 2)
      error (1, (*__errno()), "error duping to stderr");

  if (dictionary != ((void *)0))
    if (execl (ispell_prog, "ispell", "-a", "-p", dictionary, ((void *)0))
 < 0)
      error (1, (*__errno()), "error executing %s", ispell_prog);

  if (british)
    if (execl (ispell_prog, "ispell", "-a", "-d", "british", ((void *)0))
 < 0)
      error (1, (*__errno()), "error executing %s", ispell_prog);

  if (execl (ispell_prog, "ispell", "-a", ((void *)0)) < 0)
    error (1, (*__errno()), "error executing %s", ispell_prog);
}





static char *
strerror (int errnum)
{
  extern char *sys_errlist[];
  extern int sys_nerr;

  if (errnum > 0 && errnum <= sys_nerr)
    return sys_errlist[errnum];
  return "Unknown system error";
}
# 664 "C:\\Users\\lsc\\Desktop\\testcase\\spell-1.0(1)\\spell-1.0\\spell.c"
static void
error (int status, int errnum, const char *message,...)
{
  va_list args;

  fflush (((__getreent())->_stdout));
  fprintf (((__getreent())->_stderr), "%s: ", program_name);

  ( args = (va_list)&message + ( (sizeof(message) + sizeof(int) - 1) & ~(sizeof(int) - 1) ) );
  vfprintf (((__getreent())->_stderr), message, args);
  ( args = (va_list)0 );

  if (errnum)
    fprintf (((__getreent())->_stderr), ": %s", strerror (errnum));
  putc ('\n', ((__getreent())->_stderr));
  fflush (((__getreent())->_stderr));
  if (status)
    exit (status);
}




static void *
xmalloc (unsigned int size)
{
  void *ptr = malloc (size);

  if (!ptr)
    error (1, 0, "virtual memory exhausted");
  return ptr;
}





static void *
xrealloc (void *ptr, unsigned int size)
{
  if (!ptr)
    return xmalloc (size);
  ptr = realloc (ptr, size);
  if (!ptr)
    error (1, 0, "virtual memory exhausted");
  return ptr;
}





static char *
xstrdup (const char *str)
{
  unsigned int len = strlen (str) + 1;
  void *new = xmalloc (len);

  memcpy (new, (void *) str, len);

  return (char *) new;
}
