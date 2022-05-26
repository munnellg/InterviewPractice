#include <memory.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct node {
	int data;
	struct node *l;
	struct node *r;
};

struct node*
new(int data) {
	struct node* node = malloc(sizeof(struct node));

	if (node) {
		memset(node, 0, sizeof(struct node));
		node->data = data;
	} else {
		fprintf(stderr, "malloc failed for node");
	}

	return node;
}

struct node*
insert(struct node* node, int data) {
	if (node == NULL) {
		return new(data);
	}

	if (data < node->data) {
		node->l = insert(node->l, data);
	} else {
		node->r = insert(node->r, data);
	}

	return node;
}

void
print(struct node* tree) {
	if (!tree)   { return; }
	if (tree->l) { print(tree->l); }

	fprintf(stdout, "%d\n", tree->data);
	
	if (tree->r) { print(tree->r); }
}

void
dealloc(struct node* tree) {
	if (tree) {
		dealloc(tree->l);
		dealloc(tree->r);
		free(tree);
	}
}

void swap(int *a, int *b) {
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

int
main() {
	struct node *root = NULL;
	srand(time(0));

	int data[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	size_t len = sizeof(data) / sizeof(data[0]);

	// shuffle array while inserting to mitigate worst case performance
	for (int i = len - 1; i >= 0; i--) {
		int r = rand() % (i + 1);
		swap(&data[i], &data[r]);
		root = insert(root, data[i]);
	}

	print(root);

	dealloc(root);

	return 0;
}