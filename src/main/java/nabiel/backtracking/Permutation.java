package nabiel.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>() {
            {
                add('A');
                add('B');
                add('C');
            }
        };

        List<List<Character>> result = permutate(list);
        System.out.println(result.toString());
    }

    public static <T> List<List<T>> permutate(List<T> list) {
        List<List<T>> result = new ArrayList<>();
        permutateBacktrack(result, new ArrayList<>(), list);
        return result;
    }

    // permutations without backtracking
    public static <T> void permutate(List<List<T>> result, List<T> res, List<T> rem) {
        if (rem.isEmpty()) {
            result.add(res);
            return;
        }

        for (int i = 0; i < rem.size(); i++) {
            List<T> remClone = new ArrayList<>(rem);
            T temp = remClone.remove(i);
            List<T> clone = new ArrayList<>(res);
            clone.add(temp);
            permutate(result, clone, remClone);
        }
    }

    // permutations with backtracking
    public static <T> void permutateBacktrack(List<List<T>> result, List<T> res, List<T> rem) {
        if (rem.isEmpty()) {
            List<T> copy = new ArrayList<>(res);
            result.add(copy);
            return;
        }

        for (int i = 0; i < rem.size(); i++) {
            // mark here
            T temp = rem.remove(i);
            res.add(temp);
            permutate(result, res, rem);
            // unmark here
            res.remove(res.size() - 1);
            rem.add(i, temp);
        }
    }
}
