unsigned int exp_1(unsigned int * p_1)
{
	unsigned int x = *p_1;
	(*p_1) = x*x;
	return (x)  ;
}
unsigned int exp_2(unsigned int * p_1)
{
	unsigned int x = *p_1;
	(*p_1) = (x%2);
	return (x);
}
void static_p(void)
{
	unsigned int y=3u, x=0u;
	x=exp_1(&y)+exp_2(&y);
}
