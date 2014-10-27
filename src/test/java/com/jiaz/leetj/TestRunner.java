package com.jiaz.leetj;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TestRunner {

    public static final boolean isParallel;

    static {
        String isParallelSetting = System.getProperty("IsParallel");
        if (isParallelSetting.equals("true")) {
            isParallel = true;
        } else {
            isParallel = false;
        }
    }

    public static Stream<ImmutablePair<String, String>> enumerate(String qName) throws Exception {
        // load cases
        InputStream is = TestRunner.class.getResourceAsStream("/CaseData/" + qName + "_Small.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF8"));
        InputStream isLarge = TestRunner.class.getResourceAsStream("/CaseData/" + qName + "_Large.txt");
        BufferedReader brLarge = new BufferedReader(new InputStreamReader(isLarge, "UTF8"));

        Stream<String> lines = Stream.concat(br.lines(), brLarge.lines());
        if (isParallel) {
            lines = lines.parallel();
        }
        return lines.map(x -> x.split("\t"))
                    .map(x -> new ImmutablePair<>(x[0], x[1]));
    }

    public static String[] tokenizeInput(String s) {
        return s.split(", ");
    }

    private static String trimSides(String s) {
        if (s.length() == 0) return "";

        int begin = 0;
        int end = s.length();
        char c = s.charAt(0);
        switch (c) {
            case '[':
            case '(':
            case '{':
            case '\"':
                begin = 1;
                break;
        }
        c = s.charAt(s.length() - 1);
        switch (c) {
            case ']':
            case ')':
            case '}':
            case '\"':
                end = s.length() - 1;
                break;
        }
        if (begin >= end) return "";
        return s.substring(begin, end);
    }

    public static int[] toIntArray(String input) {
        if (input.equals("[]")) return new int[0];

        return ArrayUtils.toPrimitive(Arrays.stream(trimSides(input).split(","))
                .map(Integer::valueOf)
                .toArray(Integer[]::new));
    }

    public static int[][] toArrayOfIntArray(String input) {
        if (input.equals("[]")) return new int[0][];
        input = trimSides(input);
        String[] arrays = input.split("\\],\\[");
        int[][] res = new int[arrays.length][];
        for (int i = 0; i < arrays.length; ++i) {
            res[i] = toIntArray(arrays[i]);
        }
        return res;
    }

    public static List<List<Integer>> toListOfListOfInt(String input) {
        int[][] arr = toArrayOfIntArray(input);
        List<List<Integer>> list = new ArrayList<>();
        for (int[] row : arr) {
            list.add(IntStream.of(row).boxed().collect(Collectors.toList()));
        }
        return list;
    }

    public static String[] toStrArray(String input) {
        if (input.equals("[]")) return new String[0];

        return Arrays.stream(trimSides(input).split("\",\""))
                .map(x -> toStr(x))
                .toArray(String[]::new);
    }

    public static char[][] toCharMap(String input) {
        String[] str = toStrArray(input);
        char[][] result = new char[str.length][];
        for (int i = 0; i < str.length; ++i) {
            result[i] = str[i].toCharArray();
        }
        return result;
    }

    public static ListNode toList(String input) {
        input = trimSides(input);
        if (input.equals("")) return null;

        ListNode placeHolder = new ListNode(0);
        Arrays.stream(input.split(","))
            .map(Integer::valueOf)
            .map(x -> new ListNode(x))
            .reduce(placeHolder, (x, y) -> x.next = y);
        return placeHolder.next;
    }

    public static List<ListNode> toListOfListNode(String input) {
        List<ListNode> result = new ArrayList<>();
        if (input.equals("[]")) return result;

        return Arrays.stream(trimSides(input).split("\\},\\{"))
            .map(x -> toList(x))
            .collect(Collectors.toList());
    }

    public static Interval toInterval(String input) {
        int[] interval = toIntArray(input);
        Interval in = new Interval(interval[0], interval[1]);
        return in;
    }

    public static List<Interval> toIntervalList(String input) {
        int[][] intervals = toArrayOfIntArray(input);
        List<Interval> ins = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            ins.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        return ins;
    }

    public static int toInt(String input) {
        return Integer.valueOf(input);
    }

    public static String toStr(String input) {
        return trimSides(input);
    }

    public static TreeNode toTreeNode(String input) {
        if (input == null || input.equals("{}")) return null;

        input = trimSides(input);
        String[] tokens = input.split(",");
        TreeNode root = tokens[0].equals("#") ? null : new TreeNode(Integer.valueOf(tokens[0]));
        if (root == null) return root;

        int pos = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (pos < tokens.length) {
            TreeNode n = q.remove();
            String subs = tokens[pos];
            if (subs.equals("#")) {
                n.left = null;
            } else {
                n.left = new TreeNode(Integer.valueOf(subs));
                q.add(n.left);
            }
            pos++;
            if (pos >= tokens.length) break;
            subs = tokens[pos];
            if (subs.equals("#")) {
                n.right = null;
            } else {
                n.right = new TreeNode(Integer.valueOf(subs));
                q.add(n.right);
            }
            pos++;
        }
        return root;
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

    public static String serializeListOfListInt(List<List<Integer>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean first = true;
        for (List<Integer> x : list) {
            if (!first) {
                sb.append(",");
            } else {
                first = false;
            }
            sb.append(serializeList(x, IntegerSerializer.getInstance()));
        }
        sb.append(']');
        return sb.toString();
    }

    public static interface Serializer<T> {
        public String serialize(T obj);
    }

    public static class StringSerializer implements Serializer<String> {
        private static final StringSerializer _instance = new StringSerializer();

        public static Serializer<String> getInstance() {
            return _instance;
        }

        public String serialize(String obj) {
            return TestRunner.serialize(obj);
        }
    }

    public static class StringArraySerializer implements Serializer<String[]> {
        private static final StringArraySerializer _instance = new StringArraySerializer();

        public static Serializer<String[]> getInstance() {
            return _instance;
        }

        public String serialize(String[] obj) {
            return TestRunner.serialize(obj);
        }
    }

    public static class IntegerSerializer implements Serializer<Integer> {
        private static final IntegerSerializer _instance = new IntegerSerializer();

        public static Serializer<Integer> getInstance() {
            return _instance;
        }

        public String serialize(Integer obj) {
            return TestRunner.serialize(obj);
        }
    }

    public static class IntervalSerializer implements Serializer<Interval> {
        private static final IntervalSerializer _instance = new IntervalSerializer();

        public static Serializer<Interval> getInstance() {
            return _instance;
        }

        public String serialize(Interval obj) {
            return TestRunner.serialize(obj);
        }
    }

    public static <T> String serializeList(List<T> list, Serializer<T> serializer) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean first = true;
        for (T x : list) {
            if (!first) {
                sb.append(",");
            } else {
                first = false;
            }
            sb.append(serializer.serialize(x));
        }
        sb.append(']');
        return sb.toString();
    }

    public static String serialize(Interval in) {
        if (in == null) return "[]";

        return "[" + in.start + "," + in.end + "]";
    }

    public static String serialize(int i) {
        return String.valueOf(i);
    }

    public static String serialize(double d) {
        return String.format("%.5f", d);
    }

    public static String serialize(boolean b) {
        return b ? "true" : "false";
    }

    public static String serialize(String s) {
        if (s == null) return "null";
        return "\"" + s + "\"";
    }

    public static String serialize(TreeNode root) {
        if (root == null) return "{}";

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode nullNode = new TreeNode(0);
        queue.add(root);
        int noneNullCount = 1;
        while(noneNullCount > 0) {
            TreeNode n = queue.remove();
            if (n != nullNode) {
                noneNullCount--;
                sb.append(n.val + ",");
                if (n.left != null) {
                    queue.add(n.left);
                    noneNullCount++;
                } else {
                    queue.add(nullNode);
                }
                if (n.right != null) {
                    queue.add(n.right);
                    noneNullCount++;
                } else {
                    queue.add(nullNode);
                }
            } else {
                sb.append("#,");
            }
        }
        return sb.substring(0, sb.length() - 1) + "}";
    }

    public static String serializeInformal(int[] arr) {
        if (arr == null) return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0) sb.append(", ");
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static String serialize(int[] arr) {
        if (arr == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0) sb.append(",");
            sb.append(arr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public static String serialize(String[] arr) {
        if (arr == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; ++i) {
            if (i > 0) sb.append(",");
            sb.append(serialize(arr[i]));
        }
        sb.append(']');
        return sb.toString();
    }

    public static void judge(String qName, Function<String, String> solution) throws Exception {
        Stream<ImmutablePair<String, String>> testCases = enumerate(qName);
        if (isParallel) {
            testCases = testCases.parallel();
        }
        testCases.forEach(pair -> {
            if (!isParallel) {
                System.out.println("Running case: " + pair.left);
            }
            long startTimeMs = System.currentTimeMillis();
            String result = solution.apply(pair.left);
            long endTimeMs = System.currentTimeMillis();
            if (pair.getRight().equals(result)) {
                if (!isParallel) {
                    System.out.println("[Passed] " + (endTimeMs - startTimeMs) + "ms");
                }
            } else {
                Assert.assertEquals("Case failed: " + pair.left, pair.getRight(), result);
                //System.out.println("[Failed] " + (endTimeMs - startTimeMs) + "ms");
            }
        });
    }
}
