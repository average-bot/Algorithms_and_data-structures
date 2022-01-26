package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Task1 {
        Task1(String language, String filename) throws FileNotFoundException {
            if (language == "C"){
                String[] openingSymbols = {"/*", "/", "[", "{"};
                String[] closingSymbols = {"*/", "*", "]", "}"};
                checkSymbols(openingSymbols,closingSymbols, filename, language);
            }
            else if (language == "C++"){
                String[] openingSymbols = {"[", "{", "(", "/"};
                String[] closingSymbols = {"]", "}", ")"};
                checkSymbols(openingSymbols, closingSymbols, filename, language);
            }
        }


        public void checkSymbols(String []openingSymbols, String[]closingSymbols, String filename, String language) throws FileNotFoundException {
            Stack stack = new Stack();
            int line_nr = 0; // counter for the error messages


            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            Queue<Character> queue = new LinkedList<Character>();

            while (scanner.hasNext()) {
                String line = scanner.nextLine(); // go through every line by line
                line_nr += 1;
                //System.out.println(line_nr);

                boolean ignore = false; // used to ignore commented text
                String closingSymbol;
                stack.clear(); // empty the stack of previous loops

                char[] lineChars = line.toCharArray();
                for (char chars : lineChars) {
                    // create a queue of the characters in the line
                    queue.add(chars);
                }

                while (queue.size() > 0) {  // loop until there are no characters left
                    char character = queue.poll();  // get the first element in the queue
                    if (Arrays.asList(openingSymbols).contains(String.valueOf(character))) {  // if the character is one of the opening symbols
                        //System.out.println(character);
                        if (character == '/' && queue.size() > 0) {  // if the character is / we peek the queue to see the next element
                            char next = queue.peek();
                            //System.out.println("next one after  : "+next);
                            if (next == '*' && language =="C") {  // if the next element is * :pop the queue and add /* to the stack
                                queue.poll();
                                character = queue.poll();
                                stack.push("/*");
                                ignore = true;  // change the status to false since the next characters will be part of the comments
                            } else if (next == '/') {  // if the next element is also a / then we ignore rest of the line since it is a comment
                                queue.clear();
                                continue;
                            }
                        } else if (ignore == false) {  // if the char is not / just add it to the stack
                            stack.push(String.valueOf(character));
                        }
                    }
                    if (Arrays.asList(closingSymbols).contains(String.valueOf(character))) {  // if the character is one of the closing symbols
                        if (stack.size() != 0) {  // if the stack is not empty
                            if (character == '*' && queue.peek() == '/'&& language =="C") {  // if the character is * and next element is / its end of comment
                                queue.poll();  // remove the / from the queue
                                ignore = false;  // change the status to true since the next characters will be part of the code after */
                                closingSymbol = "*/";
                            } else if (character == '*' && queue.peek() != '/' && language =="C") { //FIX if there is a single *
                                continue;
                            } else { // using to store a value that is not a character but a string
                                closingSymbol = Character.toString(character);
                            }
                            if (Arrays.asList(openingSymbols).indexOf(stack.peek()) != Arrays.asList(closingSymbols).indexOf(closingSymbol)) {  // if the first element in the stack and the closing symbol do not have the same index then
                                System.out.println("There is closing symbol " + closingSymbol + " that does not correspond to the last opening symbol " + stack.peek() + ". Line nr: " + line_nr);
                            } else if (ignore == false) {
                                stack.pop();
                            }
                        } else if (stack.size() == 0 && character == '*' && queue.peek() != '/' && language =="C") { // if there is only one * and the stack is empty
                            continue;
                        } else if (stack.size() == 0) {  // if the stack with opening symbols is empty and a closing symbol is found
                            System.out.println("The stack with opening symbols is empty and there is a closing symbol " + character + ". Line nr: " + line_nr);
                        }

                    }
                }
                if (stack.size() != 0) {  // if there are still opening symbols in the stack report an error
                    System.out.println("There were more opening symbols left. Line nr: " + line_nr);
                }

            }
            scanner.close();
        }
}
