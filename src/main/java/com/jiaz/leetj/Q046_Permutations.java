package com.jiaz.leetj;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

// Given a collection of numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Q046_Permutations {

    private void swap(int[] num, int a, int b) {
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

    private void recPermute(int[] num, int pos, List<List<Integer>> res) {
        if (pos == num.length) {
            res.add(IntStream.of(num).boxed().collect(Collectors.toList()));
        } else {
            for (int i = pos; i < num.length; ++i) {
                swap(num, pos, i);
                recPermute(num, pos+1, res);
                swap(num, pos, i);
            }
        }
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        recPermute(num, 0, result);
        return result;
    }

}
