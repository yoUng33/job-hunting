#14. Longest Common Prefix
<https://leetcode.com/problems/longest-common-prefix/>

Easy

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"
Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.

Related Topics: String

##Solution:
对strs排序。因为是共有最长prefix，所以只要对比第一和最后一个。用StringBuilder来添加每个相同的字符。

```java
class Solution{
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        StringBuilder result = new StringBuilder();
        for(int i=0; i<first.length(); i++){
            if(i<last.length() && first.charAt(i) == last.charAt(i)){
                result.append(first.charAt(i));
            }else{
                break;
            }
        }
        return result.toString();
    }
}
```