import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(0, target, candidates, new LinkedList<>());
        return ans;
    }

    void backtracking(int i, int target, int[] candidates, LinkedList<Integer> path) {
        if (target == 0) {
            ans.add((List<Integer>) path.clone());
            return;
        }
        if (i == candidates.length || target < candidates[i])
            return;
        path.addLast(candidates[i]);
        backtracking(i + 1, target - candidates[i], candidates, path);
        path.removeLast();
        while(i < candidates.length - 1 && candidates[i] == candidates[i + 1])
            i++;
        backtracking(i + 1, target, candidates, path);
    }
}
