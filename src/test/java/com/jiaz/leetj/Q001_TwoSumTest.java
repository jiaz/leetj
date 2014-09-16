package com.jiaz.leetj;

import org.junit.Test;

import static com.jiaz.leetj.TestRunner.*;

public class Q001_TwoSumTest {

    @Test
    public void testTwoSum() throws Exception {
        Q001_TwoSum ts = new Q001_TwoSum();
        judge("Q001", input -> {
            String[] inputs = tokenizeInput(input);
            return serialize(ts.twoSum(toIntArray(inputs[0]), toInt(inputs[1])));
        });
    }

}