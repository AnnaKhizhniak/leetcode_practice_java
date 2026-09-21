package app;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private final static int MAX_STRING_LENGTH = (int) Math.pow(10, 5);

  static void main(String[] args) {
    List<String> stringList = new ArrayList<>();
    String resultString = "";

    findSubstringWithoutRepeatingCharacters("bbbbb", resultString, stringList);
    getMaxStringLength(stringList);
  }

  public static void findSubstringWithoutRepeatingCharacters(String string, String resultString, List<String> stringList) {
    if (string.length() > MAX_STRING_LENGTH) {
      return;
    }

    int key = 0;

    while (key < string.length()) {
      key = loopString(key, resultString, stringList, string);
    }
  }

  private static int loopString(int index, String resultString, List<String> stringList, String string) {
    for (int i = index; i < string.length(); i++) {
      if (!resultString.contains(string.substring(i, i + 1))) {
        resultString += string.substring(i, i + 1);
      } else {
        if (!stringList.contains(resultString)) {
          stringList.add(resultString);
          resultString = "";
        }

        return index + 1;
      }
    }
    return string.length();
  }

  public static int getMaxStringLength(List<String> stringList) {
    int maxStringLength = 1;

    for (String s : stringList) {
      int stringLength = s.length();
      if (maxStringLength < stringLength) {
        maxStringLength = stringLength;
      }
    }
    System.out.println(maxStringLength);
    return maxStringLength;
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