int foo_4_3(int i) {
	char p[5];
	if (i || p[0]) {
		p[0] = 'a';
	}
	return 0;
}

// Memory
int bar_4_3(int i) {
	char *p[5];
	if (i || !p[0]) {
		*p[0] = 'a';
	}
	return 0;
}
