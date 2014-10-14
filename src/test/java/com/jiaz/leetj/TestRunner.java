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

    private static String trimSides(String s) {
        if (s.length() < 2) return s;
        return s.substring(1, s.length() - 1);
    }

    public static int[] toIntArray(String input) {
        if (input.equals("[]")) return new int[0];

        return ArrayUtils.toPrimitive(Arrays.stream(trimSides(input).split(","))
                .map(Integer::valueOf)
                .toArray(Integer[]::new));
    }

    public static ListNode toList(String input) {
        ListNode placeHolder = new ListNode(0);
        Arrays.stream(trimSides(input).split(","))
            .map(Integer::valueOf)
            .map(x -> new ListNode(x))
            .reduce(placeHolder, (x, y) -> x.next = y);
        return placeHolder.next;
    }

    public static int toInt(String input) {
        return Integer.valueOf(input);
    }

    public static String toStr(String input) {
        return trimSides(input);
    }

    public static String serialize(ListNode list) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        while(list != null) {
            if (!first) sb.append(",");
            first = false;
            sb.append(list.val);
            list = list.next;
        }
        sb.append("}");
        return sb.toString();
    }

    public static String serialize(int i) {
        return String.valueOf(i);
    }

    public static String serialize(double d) {
        return String.format("%.5f", d);
    }

    public static String serialize(String s) {
        return "\"" + s + "\"";
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
                //.parallel()
                .forEach(pair -> {
                    System.out.println("Running case: " + pair.left);
                    String result = solution.apply(pair.left);
                    if (pair.getRight().equals(result)) {
                        System.out.println("[Passed]");
                    } else {
                        Assert.assertEquals("Case failed: " + pair.left, pair.getRight(), result);
                    }
                });
    }
}
