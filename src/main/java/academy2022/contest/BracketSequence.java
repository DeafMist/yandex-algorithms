package academy2022.contest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BracketSequence {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        Scanner sc = new Scanner(inputFile);
        char[] symbols = sc.nextLine().toCharArray();

        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int currentIndex = 0;
        int index = -1;
        int removal = 0;

        for (char symbol : symbols) {
            currentIndex++;
            if (symbol == '(') {
                stack1.push(symbol);
                stack2.push(currentIndex);
            }

            if (symbol == ')') {
                if (!stack1.isEmpty()) {
                    char topStack = stack1.peek();

                    if (topStack == '(') {
                        stack1.pop();
                        stack2.pop();
                    }
                    else {
                        if (removal == 0) {
                            stack1.pop();
                            stack2.pop();
                            index = currentIndex;
                            removal++;

                            if (stack1.peek() == '(') {
                                stack1.pop();
                                stack2.pop();
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
                else {
                    stack1.push(symbol);
                    stack2.push(currentIndex);
                    break;
                }
            }
        }

        if (stack1.isEmpty()) {
            System.out.println(index);
        }
        else {
            if (removal == 0) {
                stack1.pop();

                if (stack1.isEmpty()) {
                    System.out.println(stack2.pop());
                }
                else {
                    System.out.println(-1);
                }
            }
        }

        sc.close();
    }
}
