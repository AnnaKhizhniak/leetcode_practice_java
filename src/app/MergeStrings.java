package app;

public class MergeStrings {
    static void main(String[] args) {
        int firstWordLength = args[0].length();
        int secondWordLength = args[1].length();

        if (args[0].isEmpty() || args[1].length() > 100) {
            return;
        }

        int maxLength = Math.max(firstWordLength, secondWordLength);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < maxLength; i++) {
            if (i < firstWordLength) {
                result.append(args[0].charAt(i));
            } else {
                result.append(args[1].charAt(i));
                continue;
            }

            for (int j = i; j < i + 1 ; j++) {
                if (j < secondWordLength) {
                    result.append(args[1].charAt(j));
                } else {
                    break;
                }
            }
        }
        System.out.println("Result: " + result);
    }
}

/*
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.
Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d


Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */
