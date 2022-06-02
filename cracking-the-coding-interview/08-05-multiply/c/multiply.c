#include <stdio.h>
#include <stdlib.h>

int mult(int a, int b) {
	if (b == 0) { return 0; }
	if (b == 1) { return a; }
	return mult(a << 1, b >> 1) + ((b & 1)? a : 0);
}

int
main() {
	fprintf(stdout, "%d\n", mult(3,3));
	return EXIT_SUCCESS;
}
