package app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  static void main(String[] args) {
    List<String> stringList = new ArrayList<>();
    String resultString = "";

    findSubstringWithoutRepeatingCharacters("ab", resultString, stringList);
  }

  public static int findSubstringWithoutRepeatingCharacters(String string, String resultString, List<String> stringList) {
    if (string.isEmpty()) {
      return 0;
    }

    return loopString(resultString, stringList, string);
  }

  private static int loopString(String resultString, List<String> stringList, String string) {
    Set<Character> chars = new HashSet<>();
    int index = 0;
    int maxLength = 0;
    for (int i = 0; i < string.length(); i++) {
      while (chars.contains(string.charAt(i))) {
        chars.remove(string.charAt(index));
        index++;
      }
      chars.add(string.charAt(i));
      maxLength = maxLength < chars.size() ? chars.size() : maxLength;
    }
    System.out.println(maxLength);
    return maxLength;
  }
}

/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:
0 <= s.length <= 105
 */