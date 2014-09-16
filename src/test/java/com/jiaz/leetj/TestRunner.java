package com.jiaz.leetj;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class TestRunner {
    public static Stream<ImmutablePair<String, String>> enumerate(String qName) throws Exception {
        // load cases
        InputStream is = TestRunner.class.getResourceAsStream("/CaseData/" + qName + "_Small.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF8"));
        InputStream isLarge = TestRunner.class.getResourceAsStream("/CaseData/" + qName + "_Large.txt");
        BufferedReader brLarge = new BufferedReader(new InputStreamReader(isLarge, "UTF8"));

        return Stream.concat(br.lines(), brLarge.lines())
                .map(x -> x.split("\t"))
                .map(x -> new ImmutablePair<>(x[0], x[1]));
    }

    public static String[] tokenizeInput(String s) {
        return s.split(", ");
    }

    public static int[] toIntArray(String input) {
        return ArrayUtils.toPrimitive(Arrays.stream(input.substring(1, input.length() - 1).split(","))
                .map(Integer::valueOf)
                .toArray(Integer[]::new));
    }

    public static int toInt(String input) {
        return Integer.valueOf(input);
    }

    public static String serialize(int[] arr) {
        if (arr == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0) sb.append(", ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void judge(String qName, Function<String, String> solution) throws Exception {
        enumerate(qName)
                .parallel()
                .forEach(pair -> {
                    String result = solution.apply(pair.left);
                    if (pair.getRight().equals(result)) {
                        System.out.println("Case passed: " + pair.left);
                    } else {
                        Assert.assertEquals("Case failed: " + pair.left, pair.getRight(), result);
                    }
                });
    }
}
