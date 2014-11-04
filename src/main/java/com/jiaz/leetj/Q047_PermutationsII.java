package com.jiaz.leetj;

import java.util.*;
import java.util.stream.*;

// Given a collection of numbers that might contain duplicates,
// return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

public class Q047_PermutationsII {

    private void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

    private void recPermutate(int[] num, int pos, List<List<Integer>> result) {
        if (pos == num.length - 1) {
            List<Integer> list = IntStream.of(num).boxed().collect(Collectors.toList());
            result.add(list);
            return;
        }

        Set<Integer> seen = new HashSet<>();

        for (int i = pos; i < num.length; ++i) {
            if (!seen.contains(num[i])) {
                seen.add(num[i]);
                swap(num, i, pos);
                recPermutate(num, pos + 1, result);
                swap(num, i, pos);
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        recPermutate(num, 0, result);
        return result;
    }

}
