package ie.munnellg.interview;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PalindromeTest {

    @Test
    public void test1() {
        Node<Integer> list = Node.of(1, 2, 3, 2, 1);
        assertTrue(Palindrome.isPalindrome(list));
    }

    @Test
    public void test2() {
        Node<Integer> list = Node.of(1, 2, 3, 3, 2, 1);
        assertTrue(Palindrome.isPalindrome(list));
    }

    @Test
    public void test3() {
        Node<Integer> list = Node.of(1, 2, 3, 2, 1);
        assertTrue(Palindrome.destructiveIsPalindrome(list));
    }

    @Test
    public void test4() {
        Node<Integer> list = Node.of(1, 2, 3, 3, 2, 1);
        assertTrue(Palindrome.destructiveIsPalindrome(list));
    }
}
