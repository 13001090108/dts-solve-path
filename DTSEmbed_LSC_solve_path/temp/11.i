# 1 "E:\\TESTCASE\\newThink\\1.c"
# 1 "<built-in>"
# 1 "<command line>"





# 1 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt" 1
# 35 "E:\\lib\\Workspace\\DTSEmbed_LSC\\cpp\\defines.txt"
 typedef char * va_list;
# 7 "<command line>" 2
# 1 "E:\\TESTCASE\\newThink\\1.c"

int f(int k){
    int i;
 if (k>0)
    i=10;
 else
    i=1;
 int m = i;
 return i;
}

int
_getopt_internal (argc, argv, optstring, longopts, longind, long_only)
     int argc;
     char *const *argv;
     const char *optstring;
     const struct option *longopts;
     int *longind;
     int long_only;
{
  int option_index;

  optarg = 0;






  if (optind == 0)
    {
      first_nonopt = last_nonopt = optind = 1;

      nextchar = NULL;



      if (optstring[0] == '-')
 {
   ordering = RETURN_IN_ORDER;
   ++optstring;
 }
      else if (optstring[0] == '+')
 {
   ordering = REQUIRE_ORDER;
   ++optstring;
 }

      else
 ordering = PERMUTE;
    }

  if (nextchar == NULL || *nextchar == '\0')
    {
      if (ordering == PERMUTE)
 {



   if (first_nonopt != last_nonopt && last_nonopt != optind)
     exchange ((char **) argv);
   else if (last_nonopt != optind)
     first_nonopt = optind;




   while (optind < argc
   && (argv[optind][0] != '-' || argv[optind][1] == '\0')




     )
     optind++;
   last_nonopt = optind;
 }






      if (optind != argc && !strcmp (argv[optind], "--"))
 {
   optind++;

   if (first_nonopt != last_nonopt && last_nonopt != optind)
     exchange ((char **) argv);
   else if (first_nonopt == last_nonopt)
     first_nonopt = optind;
   last_nonopt = argc;

   optind = argc;
 }




      if (optind == argc)
 {


   if (first_nonopt != last_nonopt)
     optind = first_nonopt;
   return EOF;
 }




      if ((argv[optind][0] != '-' || argv[optind][1] == '\0')




 )
 {
   if (ordering == REQUIRE_ORDER)
     return EOF;
   optarg = argv[optind++];
   return 1;
 }




      nextchar = (argv[optind] + 1
    + (longopts != NULL && argv[optind][1] == '-'));
    }

  if (longopts != NULL
      && ((argv[optind][0] == '-'
    && (argv[optind][1] == '-' || long_only))



      ))
    {
      const struct option *p;
      char *s = nextchar;
      int exact = 0;
      int ambig = 0;
      const struct option *pfound = NULL;
      int indfound;

      while (*s && *s != '=')
 s++;


      for (p = longopts, option_index = 0; p->name;
    p++, option_index++)
 if (!strncmp (p->name, nextchar, s - nextchar))
   {
     if (s - nextchar == strlen (p->name))
       {

  pfound = p;
  indfound = option_index;
  exact = 1;
  break;
       }
     else if (pfound == NULL)
       {

  pfound = p;
  indfound = option_index;
       }
     else

       ambig = 1;
   }

      if (ambig && !exact)
 {
   if (opterr)
     fprintf (stderr, "%s: option `%s' is ambiguous\n",
       argv[0], argv[optind]);
   nextchar += strlen (nextchar);
   optind++;
   return '?';
 }

      if (pfound != NULL)
 {
   option_index = indfound;
   optind++;
   if (*s)
     {


       if (pfound->has_arg)
  optarg = s + 1;
       else
  {
    if (opterr)
      {
        if (argv[optind - 1][1] == '-')

   fprintf (stderr,
       "%s: option `--%s' doesn't allow an argument\n",
     argv[0], pfound->name);
        else

   fprintf (stderr,
       "%s: option `%c%s' doesn't allow an argument\n",
     argv[0], argv[optind - 1][0], pfound->name);
      }
    nextchar += strlen (nextchar);
    return '?';
  }
     }
   else if (pfound->has_arg == 1)
     {
       if (optind < argc)
  optarg = argv[optind++];
       else
  {
    if (opterr)
      fprintf (stderr, "%s: option `%s' requires an argument\n",
        argv[0], argv[optind - 1]);
    nextchar += strlen (nextchar);
    return optstring[0] == ':' ? ':' : '?';
  }
     }
   nextchar += strlen (nextchar);
   if (longind != NULL)
     *longind = option_index;
   if (pfound->flag)
     {
       *(pfound->flag) = pfound->val;
       return 0;
     }
   return pfound->val;
 }




      if (!long_only || argv[optind][1] == '-'



 )
 {
   if (opterr)
     {
       if (argv[optind][1] == '-')

  fprintf (stderr, "%s: unrecognized option `--%s'\n",
    argv[0], nextchar);
       else

  fprintf (stderr, "%s: unrecognized option `%c%s'\n",
    argv[0], argv[optind][0], nextchar);
     }
   nextchar = (char *) "";
   optind++;
   return '?';
 }
    }



  {
    char c = *nextchar++;
    char *temp = null;


    if (*nextchar == '\0')
      ++optind;

    if (temp == NULL || c == ':')
      {
 if (opterr)
   {
# 285 "E:\\TESTCASE\\newThink\\1.c"
     fprintf (stderr, "%s: illegal option -- %c\n", argv[0], c);

   }
 optopt = c;
 return '?';
      }
    if (temp[1] == ':')
      {
 if (temp[2] == ':')
   {

     if (*nextchar != '\0')
       {
  optarg = nextchar;
  optind++;
       }
     else
       optarg = 0;
     nextchar = NULL;
   }
 else
   {

     if (*nextchar != '\0')
       {
  optarg = nextchar;


  optind++;
       }
     else if (optind == argc)
       {
  if (opterr)
    {





      fprintf (stderr, "%s: option requires an argument -- %c\n",
        argv[0], c);

    }
  optopt = c;
  if (optstring[0] == ':')
    c = ':';
  else
    c = '?';
       }
     else


       optarg = argv[optind++];
     nextchar = NULL;
   }
      }
    return c;
  }
}
