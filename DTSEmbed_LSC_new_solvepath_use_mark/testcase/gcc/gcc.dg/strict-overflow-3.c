/* { dg-do compile } */
/* { dg-options "-fstrict-overflow -O2 -fdump-tree-final_cleanup" } */

/* Source: Ian Lance Taylor.  Dual of no-strict-overflow-3.c.  */

/* We can only simplify the conditional when using strict overflow
   semantics.  */

int
foo (int i, int j)
{
  return i + 100 < j + 1000;
}

/* { dg-final { scan-tree-dump-not "1000" "final_cleanup" } } */
/* { dg-final { cleanup-tree-dump "final_cleanup" } } */
