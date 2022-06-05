#include <memory.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>

#define STACK_BUFFER_SIZE 10

struct node {
	struct node *prev;
	int data;
	int in_use;
};

static unsigned int buf_ptr;
static struct node buf[STACK_BUFFER_SIZE];

void die(char *msg, ...) {
	va_list args;
	va_start(args, msg);
	fprintf(stderr, "ERROR: ");
	vfprintf(stderr, msg, args);
	fprintf(stderr, "\n");
	va_end(args);

	exit(EXIT_FAILURE);
}

void init() {
	buf_ptr = 0;
	memset(buf, 0, sizeof(buf) / sizeof(buf[0]));
}

struct node *push(struct node *sp, int data) {
	int old_value = buf_ptr;
	
	while (buf[buf_ptr].in_use) {
		buf_ptr = (buf_ptr + 1) % STACK_BUFFER_SIZE;

		if (old_value == buf_ptr) {
			die("Stack is full");
		}
	}

	buf[buf_ptr].data   = data;
	buf[buf_ptr].prev   = sp;
	buf[buf_ptr].in_use = 1;
	return &buf[buf_ptr];
}

int pop(struct node **sp) {
	struct node *n = *sp;
	int data = n->data;
	n->in_use = 0;
	*sp = n->prev;
	return data;	
}

int peek(struct node *sp) {
	return sp->data;
}

int
main(int argc, char **argv) {
	init();

	struct node *sp1 = NULL; // nums divisible by 1
	struct node *sp2 = NULL; // nums divisible by 2
	struct node *sp3 = NULL; // nums divisible by 3
	struct node *sp4 = NULL; // will be used to fill the stack

	for (int i = 0; i < STACK_BUFFER_SIZE / 2; i++) {
		sp1 = push(sp1, i);
		if (i % 2 == 0) { sp2 = push(sp2, i); }
		if (i % 3 == 0) { sp3 = push(sp3, i); }
	}

	// pop all items off the three stacks
	while (sp1) { fprintf(stdout, "%d ", pop(&sp1)); }
	fprintf(stdout, "\n");
	while (sp2) { fprintf(stdout, "%d ", pop(&sp2)); }
	fprintf(stdout, "\n");
	while (sp3) { fprintf(stdout, "%d ", pop(&sp3)); }
	fprintf(stdout, "\n");

	for (int i = 0; i < STACK_BUFFER_SIZE; i++) {
		sp4 = push(sp4, i);
	}

	while(sp4) { fprintf(stdout, "%d ", pop(&sp4)); }
	fprintf(stdout, "\n");

	return EXIT_SUCCESS;
}
