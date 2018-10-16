import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombination {

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        letterCombination.letterCombinations("342");
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty())
            return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}
