import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Tester for GaTech CS 1332 HW9
 *
 * Created from a generator
 * Doesn't pass checkstyle
 *
 * @author sergeys
 * @version 1.0
 */
public class SS1332HW9Tests {
    public static final long TIMEOUT = 200L;

    @Test(timeout = TIMEOUT)
    public void testBruteForce0() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(4);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cb", "acbbcbcabcabaccbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                25, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore0() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(4);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cb", "acbbcbcabcabaccbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                18, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP0() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(4);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cb", "acbbcbcabcabaccbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                23, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable0() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable0() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce1() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("acc", "bccbbbbacbcacacccaccaccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore1() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("acc", "bccbbbbacbcacacccaccaccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                24, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP1() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("acc", "bccbbbbacbcacacccaccaccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                27, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable1() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("acc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable1() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("acc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce2() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        expected.add(4);
        expected.add(19);
        expected.add(20);
        expected.add(21);
        expected.add(22);
        expected.add(29);
        expected.add(35);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cc", "ccacccbbcbbacbbbacacccccabcbbccbcbaccabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                58, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore2() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        expected.add(4);
        expected.add(19);
        expected.add(20);
        expected.add(21);
        expected.add(22);
        expected.add(29);
        expected.add(35);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cc", "ccacccbbcbbacbbbacacccccabcbbccbcbaccabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                41, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP2() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        expected.add(4);
        expected.add(19);
        expected.add(20);
        expected.add(21);
        expected.add(22);
        expected.add(29);
        expected.add(35);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cc", "ccacccbbcbbacbbbacacccccabcbbccbcbaccabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                50, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable2() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable2() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce3() {
        List<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(16);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bbca", "ccbccbbcbbcacabbbbcaabbaaababbcaaccccbacabcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                67, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore3() {
        List<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(16);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bbca", "ccbccbbcbbcacabbbbcaabbaaababbcaaccccbacabcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                50, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP3() {
        List<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(16);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bbca", "ccbccbbcbbcacabbbbcaabbaaababbcaaccccbacabcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                53, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable3() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bbca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable3() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bbca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce4() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ac", "ccacbaacaaccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                19, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore4() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ac", "ccacbaacaaccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP4() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ac", "ccacbaacaaccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable4() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable4() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce5() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aaba", "caabaabcccccbcbaccaababaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                40, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore5() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aaba", "caabaabcccccbcbaccaababaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP5() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aaba", "caabaabcccccbcbaccaababaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable5() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aaba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable5() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aaba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce6() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("acc", "bbcccaaaabcaccbababacbcca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore6() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("acc", "bbcccaaaabcaccbababacbcca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                18, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP6() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("acc", "bbcccaaaabcaccbababacbcca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable6() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("acc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable6() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("acc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce7() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("accc", "cbbaaaccccbabbccaaacaabaacccabbccbbacabccbccba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                63, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore7() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("accc", "cbbaaaccccbabbccaaacaabaacccabbccbbacabccbccba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP7() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("accc", "cbbaaaccccbabbccaaacaabaacccabbccbbacabccbccba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                58, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable7() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("accc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable7() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("accc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce8() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "abcbbbaaacbcaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                20, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore8() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "abcbbbaaacbcaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP8() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "abcbbbaaacbcaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                19, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable8() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable8() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce9() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cca", "cccacabaabcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                16, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore9() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cca", "cccacabaabcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                10, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP9() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cca", "cccacabaabcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable9() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable9() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce10() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aabc", "bbaaaabccabaccbcbbbba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore10() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aabc", "bbaaaabccabaccbcbbbba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                21, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP10() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aabc", "bbaaaabccabaccbcbbbba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable10() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aabc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable10() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aabc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce11() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(15);
        expected.add(25);
        expected.add(39);
        expected.add(43);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abb", "babbbaccccacaccabbabccbababbabccbaacbbbabbbabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                66, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore11() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(15);
        expected.add(25);
        expected.add(39);
        expected.add(43);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abb", "babbbaccccacaccabbabccbababbabccbaacbbbabbbabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                44, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP11() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(15);
        expected.add(25);
        expected.add(39);
        expected.add(43);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abb", "babbbaccccacaccabbabccbababbabccbaacbbbabbbabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                56, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable11() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable11() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce12() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bac", "bbcbacaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                12, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore12() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bac", "bbcbacaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                13, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP12() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bac", "bbcbacaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                12, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable12() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 0);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable12() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce13() {
        List<Integer> expected = new ArrayList<>();
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ca", "aaababcbbbbcbcccaabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore13() {
        List<Integer> expected = new ArrayList<>();
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ca", "aaababcbbbbcbcccaabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                21, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP13() {
        List<Integer> expected = new ArrayList<>();
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ca", "aaababcbbbbcbcccaabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable13() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable13() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce14() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bcb", "babbbacabbbbab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                20, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore14() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bcb", "babbbacabbbbab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                12, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP14() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bcb", "babbbacabbbbab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                22, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable14() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bcb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable14() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bcb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce15() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(13);
        expected.add(14);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "bccbcacbbabaabbbbcabaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore15() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(13);
        expected.add(14);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "bccbcacbbabaabbbbcabaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                22, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP15() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(13);
        expected.add(14);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "bccbcacbbabaabbbbcabaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                29, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable15() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable15() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce16() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(13);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cab", "cbcabccbcaaaacabacbbcabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                34, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore16() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(13);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cab", "cbcabccbcaaaacabacbbcabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                25, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP16() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(13);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cab", "cbcabccbcaaaacabacbbcabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                30, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable16() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cab");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable16() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cab", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce17() {
        List<Integer> expected = new ArrayList<>();
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("babb", "aacaaacbbbacbcbabbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore17() {
        List<Integer> expected = new ArrayList<>();
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("babb", "aacaaacbbbacbcbabbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                13, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP17() {
        List<Integer> expected = new ArrayList<>();
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("babb", "aacaaacbbbacbcbabbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                27, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable17() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("babb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable17() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("babb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce18() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(22);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ca", "cbcccaaaaccbabcbabbaaccaabaabbaaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                45, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore18() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(22);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ca", "cbcccaaaaccbabcbabbaaccaabaabbaaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                38, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP18() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(22);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ca", "cbcccaaaaccbabcbabbaaccaabaabbaaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                44, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable18() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable18() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce19() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("acba", "baabbaccaaacbaacaccbaacbacabaaacababccbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                64, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore19() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("acba", "baabbaccaaacbaacaccbaacbacabaaacababccbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                51, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP19() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("acba", "baabbaccaaacbaacaccbaacbacabaaacababccbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                56, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable19() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("acba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable19() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("acba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce20() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(11);
        expected.add(14);
        expected.add(15);
        expected.add(20);
        expected.add(21);
        expected.add(22);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "acabccabccbbbcbbbababbbbcccbbaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                46, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore20() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(11);
        expected.add(14);
        expected.add(15);
        expected.add(20);
        expected.add(21);
        expected.add(22);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "acabccabccbbbcbbbababbbbcccbbaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP20() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(11);
        expected.add(14);
        expected.add(15);
        expected.add(20);
        expected.add(21);
        expected.add(22);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "acabccabccbbbcbbbababbbbcccbbaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                39, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable20() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable20() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce21() {
        List<Integer> expected = new ArrayList<>();
        expected.add(19);
        expected.add(26);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cc", "cbbcabbacbabcbbbcabccbbacacccaacabcaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                50, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore21() {
        List<Integer> expected = new ArrayList<>();
        expected.add(19);
        expected.add(26);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cc", "cbbcabbacbabcbbbcabccbbacacccaacabcaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                31, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP21() {
        List<Integer> expected = new ArrayList<>();
        expected.add(19);
        expected.add(26);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cc", "cbbcabbacbabcbbbcabccbbacacccaacabcaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                48, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable21() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable21() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce22() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bccc", "bccbcccabacac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore22() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bccc", "bccbcccabacac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                7, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP22() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bccc", "bccbcccabacac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable22() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 0);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bccc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable22() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bccc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce23() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bcc", "caabcbcccbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore23() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bcc", "caabcbcccbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                10, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP23() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bcc", "caabcbcccbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable23() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 0);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bcc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable23() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bcc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce24() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(9);
        expected.add(18);
        expected.add(22);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cac", "bccaccccbcacaacaaccacbcacabbbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                49, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore24() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(9);
        expected.add(18);
        expected.add(22);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cac", "bccaccccbcacaacaaccacbcacabbbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                39, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP24() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(9);
        expected.add(18);
        expected.add(22);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cac", "bccaccccbcacaacaaccacbcacabbbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                40, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable24() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable24() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce25() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("babc", "bbbcabbacbbccbabccbbabaaaacbaabbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                52, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore25() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("babc", "bbbcabbacbbccbabccbbabaaaacbaabbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP25() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("babc", "bbbcabbacbbccbabccbbabaaaacbaabbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                47, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable25() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("babc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable25() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("babc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce26() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(16);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ccc", "ababcbacccacbbbbcccacbaccaabcaccbbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                54, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore26() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(16);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ccc", "ababcbacccacbbbbcccacbaccaabcaccbbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP26() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(16);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ccc", "ababcbacccacbbbbcccacbaccaabcaccbbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                48, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable26() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ccc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable26() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ccc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce27() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(8);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cbba", "cbbaabbacbbacccabcbbabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore27() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(8);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cbba", "cbbaabbacbbacccabcbbabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP27() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(8);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cbba", "cbbaabbacbbacccabcbbabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                27, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable27() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cbba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable27() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cbba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce28() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(14);
        expected.add(15);
        expected.add(16);
        expected.add(17);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bbbb", "abbbbbacccabbabbbbbbbbccacbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                64, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore28() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(14);
        expected.add(15);
        expected.add(16);
        expected.add(17);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bbbb", "abbbbbacccabbabbbbbbbbccacbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                41, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP28() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(14);
        expected.add(15);
        expected.add(16);
        expected.add(17);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bbbb", "abbbbbacccabbabbbbbbbbccacbcab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                39, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable28() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bbbb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable28() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 3;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bbbb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce29() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abcb", "cccbaccacccabaacccccaccacaaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                35, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore29() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abcb", "cccbaccacccabaacccccaccacaaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                14, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP29() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abcb", "cccbaccacccabaacccccaccacaaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable29() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('b', 3);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abcb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable29() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abcb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce30() {
        List<Integer> expected = new ArrayList<>();
        expected.add(12);
        expected.add(25);
        expected.add(26);
        expected.add(27);
        expected.add(38);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "aabcacacbaaabbcacaacabcacbbbbaccccccccbbacccccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                57, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore30() {
        List<Integer> expected = new ArrayList<>();
        expected.add(12);
        expected.add(25);
        expected.add(26);
        expected.add(27);
        expected.add(38);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "aabcacacbaaabbcacaacabcacbbbbaccccccccbbacccccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP30() {
        List<Integer> expected = new ArrayList<>();
        expected.add(12);
        expected.add(25);
        expected.add(26);
        expected.add(27);
        expected.add(38);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "aabcacacbaaabbcacaacabcacbbbbaccccccccbbacccccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                53, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable30() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable30() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce31() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(15);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abcc", "aaabccabcccabbcabccacacaacbabccaabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                53, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore31() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(15);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abcc", "aaabccabcccabbcabccacacaacbabccaabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP31() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);
        expected.add(15);
        expected.add(27);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abcc", "aaabccabcccabbcabccacacaacbabccaabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable31() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('b', 1);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abcc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable31() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abcc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce32() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(11);
        expected.add(13);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ac", "bcccabacbabacacaaacaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                29, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore32() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(11);
        expected.add(13);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ac", "bcccabacbabacacaaacaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                24, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP32() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(11);
        expected.add(13);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ac", "bcccabacbabacacaaacaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable32() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable32() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce33() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(2);
        expected.add(12);
        expected.add(23);
        expected.add(31);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("acac", "acacaccbabcaacacbaaacbaacacbbbaacacabcbccacaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                79, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore33() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(2);
        expected.add(12);
        expected.add(23);
        expected.add(31);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("acac", "acacaccbabcaacacbaaacbaacacbbbaacacabcbccacaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                54, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP33() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(2);
        expected.add(12);
        expected.add(23);
        expected.add(31);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("acac", "acacaccbabcaacacbaaacbaacacbbbaacacabcbccacaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                60, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable33() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("acac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable33() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;
        expected[3] = 2;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("acac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce34() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(12);
        expected.add(15);
        expected.add(23);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aab", "acbbbabaababaabaabcccccaabbcaabac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                49, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore34() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(12);
        expected.add(15);
        expected.add(23);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aab", "acbbbabaababaabaabcccccaabbcaabac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                41, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP34() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(12);
        expected.add(15);
        expected.add(23);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aab", "acbbbabaababaabaabcccccaabbcaabac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable34() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aab");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable34() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aab", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce35() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aacc", "caaacaaccccabaaabaaaccacbcbbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                49, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore35() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aacc", "caaacaaccccabaaabaaaccacbcbbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP35() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aacc", "caaacaaccccabaaabaaaccacbcbbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                38, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable35() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aacc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable35() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aacc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce36() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(12);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bc", "abcbababbbacbccbcccc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                27, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore36() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(12);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bc", "abcbababbbacbccbcccc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                23, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP36() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(12);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bc", "abcbababbbacbccbcccc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                25, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable36() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable36() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce37() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cbaa", "caaccbaaabacbcbcbaaccbcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore37() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cbaa", "caaccbaaabacbcbcbaaccbcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                20, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP37() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cbaa", "caaccbaaabacbcbcbaaccbcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                31, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable37() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 1);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cbaa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable37() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cbaa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce38() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);
        expected.add(10);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cbb", "acbbabacbbcbbacbbcaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore38() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);
        expected.add(10);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cbb", "acbbabacbbcbbacbbcaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                21, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP38() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);
        expected.add(10);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cbb", "acbbabacbbcbbacbbcaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                22, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable38() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 2);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cbb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable38() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cbb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce39() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abcc", "caaabcccabcbbbcaabbbccabbabcbcabbbaacabcabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                66, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore39() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abcc", "caaabcccabcbbbcaabbbccabbabcbcabbbaacabcabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP39() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abcc", "caaabcccabcbbbcaabbbccabbabcbcabbbaacabcabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                57, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable39() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('b', 1);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abcc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable39() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abcc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce40() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bca", "bcaaabcaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                12, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore40() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bca", "bcaaabcaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP40() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bca", "bcaaabcaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                10, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable40() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable40() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce41() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(12);
        expected.add(19);
        expected.add(23);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bba", "bacbbacaacccbbaaabbbbaabbaccbcacccbbabaabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                65, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore41() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(12);
        expected.add(19);
        expected.add(23);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bba", "bacbbacaacccbbaaabbbbaabbaccbcacccbbabaabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                50, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP41() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(12);
        expected.add(19);
        expected.add(23);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bba", "bacbbacaacccbbaaabbbbaabbaccbcacccbbabaabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                51, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable41() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable41() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce42() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(22);
        expected.add(26);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ba", "cbaacacaaabbcaccabbbcbbacbba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore42() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(22);
        expected.add(26);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ba", "cbaacacaaabbcaccabbbcbbacbba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP42() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(22);
        expected.add(26);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ba", "cbaacacaaabbcaccabbbcbbacbba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                36, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable42() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable42() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce43() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("baaa", "cbcbbaacaccbcbcacbbacbbbcbacbaacbcaaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                54, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore43() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("baaa", "cbcbbaacaccbcbcacbbacbbbcbacbaacbcaaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP43() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("baaa", "cbcbbaacaccbcbcacbbacbbbcbacbaacbcaaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                51, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable43() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("baaa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable43() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("baaa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce44() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cbc", "caabccbccccabcabacaabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                30, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore44() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cbc", "caabccbccccabcabacaabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                18, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP44() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cbc", "caabccbccccabcabacaabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                30, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable44() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cbc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable44() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cbc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce45() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(7);
        expected.add(12);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aab", "cbaaabaaabcaaabcabaabacba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore45() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(7);
        expected.add(12);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aab", "cbaaabaaabcaaabcabaabacba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                25, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP45() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(7);
        expected.add(12);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aab", "cbaaabaaabcaaabcabaabacba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                31, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable45() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aab");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable45() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aab", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce46() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(19);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aac", "cbcaaccbbbaccbbbaccaacbbbbbacaaacabaccbaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                55, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore46() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(19);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aac", "cbcaaccbbbaccbbbaccaacbbbbbacaaacabaccbaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP46() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(19);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aac", "cbcaaccbbbaccbbbaccaacbbbbbacaaacabaccbaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                48, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable46() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable46() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce47() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);
        expected.add(27);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bba", "cbcacababababbbaabbaaaaccbcbbabbabcbabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                58, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore47() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);
        expected.add(27);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bba", "cbcacababababbbaabbaaaaccbcbbabbabcbabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                47, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP47() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);
        expected.add(27);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bba", "cbcacababababbbaabbaaaaccbcbbabbabcbabb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                48, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable47() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable47() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce48() {
        List<Integer> expected = new ArrayList<>();
        expected.add(16);
        expected.add(17);
        expected.add(27);
        expected.add(32);
        expected.add(36);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aa", "ccacabacacbbbabbaaabccbaccbaabccaabcaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                53, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore48() {
        List<Integer> expected = new ArrayList<>();
        expected.add(16);
        expected.add(17);
        expected.add(27);
        expected.add(32);
        expected.add(36);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aa", "ccacabacacbbbabbaaabccbaccbaabccaabcaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP48() {
        List<Integer> expected = new ArrayList<>();
        expected.add(16);
        expected.add(17);
        expected.add(27);
        expected.add(32);
        expected.add(36);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aa", "ccacabacacbbbabbaaabccbaccbaabccaabcaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                49, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable48() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable48() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce49() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(7);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aba", "cbabacaabaacccacbcbccaaaabaaaacaabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                55, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore49() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(7);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aba", "cbabacaabaacccacbcbccaaaabaaaacaabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                38, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP49() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(7);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aba", "cbabacaabaacccacbcbccaaaabaaaacaabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                50, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable49() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable49() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce50() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bbcb", "bbbcbabbbcbcacacb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore50() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bbcb", "bbbcbabbbcbcacacb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                16, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP50() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(7);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bbcb", "bbbcbabbbcbcacacb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                22, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable50() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 3);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bbcb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable50() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bbcb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce51() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aa", "abaaabcaccbbbcacbbbca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore51() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aa", "abaaabcaccbbbcacbbbca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                16, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP51() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aa", "abaaabcaccbbbcacbbbca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                25, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable51() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable51() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce52() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ccba", "aabccccbaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                16, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore52() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ccba", "aabccccbaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                11, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP52() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ccba", "aabccccbaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable52() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ccba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable52() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ccba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce53() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(8);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aa", "cbaaccccaaacabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                20, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore53() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(8);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aa", "cbaaccccaaacabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                13, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP53() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(8);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aa", "cbaaccccaaacabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                18, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable53() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable53() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce54() {
        List<Integer> expected = new ArrayList<>();
        expected.add(16);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abc", "bbcbbacacbcbabababcbabccbbaacbcaaccbaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                50, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore54() {
        List<Integer> expected = new ArrayList<>();
        expected.add(16);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abc", "bbcbbacacbcbabababcbabccbbaacbcaaccbaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                41, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP54() {
        List<Integer> expected = new ArrayList<>();
        expected.add(16);
        expected.add(20);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abc", "bbcbbacacbcbabababcbabccbbaacbcaaccbaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                46, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable54() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('b', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable54() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce55() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(12);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bcac", "caaabcaccacbbcaccaabaabaacbcbbccccbbcbacbbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                60, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore55() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(12);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bcac", "caaabcaccacbbcaccaabaabaacbcbbccccbbcbacbbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                39, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP55() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(12);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bcac", "caaabcaccacbbcaccaabaabaacbcbbccccbbcbacbbcc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                54, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable55() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 0);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bcac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable55() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bcac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce56() {
        List<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(13);
        expected.add(22);
        expected.add(29);
        expected.add(35);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cb", "aaccaccccbbbacbbcacccccbcaacccbbbbccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                55, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore56() {
        List<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(13);
        expected.add(22);
        expected.add(29);
        expected.add(35);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cb", "aaccaccccbbbacbbcacccccbcaacccbbbbccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                42, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP56() {
        List<Integer> expected = new ArrayList<>();
        expected.add(8);
        expected.add(13);
        expected.add(22);
        expected.add(29);
        expected.add(35);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cb", "aaccaccccbbbacbbcacccccbcaacccbbbbccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                52, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable56() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable56() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce57() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bac", "abbbccbaabcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore57() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bac", "abbbccbaabcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                9, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP57() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bac", "abbbccbaabcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                18, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable57() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 0);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable57() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce58() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bc", "ccaabcacaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                11, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore58() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bc", "ccaabcacaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                9, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP58() {
        List<Integer> expected = new ArrayList<>();
        expected.add(4);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bc", "ccaabcacaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                11, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable58() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable58() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce59() {
        List<Integer> expected = new ArrayList<>();
        expected.add(28);
        expected.add(40);
        expected.add(41);
        expected.add(42);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aa", "cccbacabbccccbbbabcabcacbcbbaabacacbccccaaaacac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                60, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore59() {
        List<Integer> expected = new ArrayList<>();
        expected.add(28);
        expected.add(40);
        expected.add(41);
        expected.add(42);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aa", "cccbacabbccccbbbabcabcacbcbbaabacacbccccaaaacac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                34, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP59() {
        List<Integer> expected = new ArrayList<>();
        expected.add(28);
        expected.add(40);
        expected.add(41);
        expected.add(42);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aa", "cccbacabbccccbbbabcabcacbcbbaabacacbccccaaaacac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                57, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable59() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable59() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce60() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ccc", "cccccbbcac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                18, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore60() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ccc", "cccccbbcac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                11, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP60() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ccc", "cccccbbcac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                13, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable60() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ccc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable60() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ccc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce61() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bbcb", "cbbaabcbbcbbaaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                24, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore61() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bbcb", "cbbaabcbbcbbaaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP61() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bbcb", "cbbaabcbbcbbaaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                22, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable61() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 3);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bbcb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable61() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bbcb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce62() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aaca", "bcabcccbacaccaacabaacabcbaccccbaabbacbbbabcaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                66, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore62() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aaca", "bcabcccbacaccaacabaacabcbaccccbaabbacbbbabcaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP62() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(18);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aaca", "bcabcccbacaccaacabaacabcbaccccbaabbacbbbabcaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                61, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable62() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aaca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable62() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aaca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce63() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(25);
        expected.add(26);
        expected.add(29);
        expected.add(39);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cc", "abaabcabaaccabacabaaaaabbcccbccbacbcbbaccacaaacbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                63, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore63() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(25);
        expected.add(26);
        expected.add(29);
        expected.add(39);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cc", "abaabcabaaccabacabaaaaabbcccbccbacbcbbaccacaaacbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                36, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP63() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(25);
        expected.add(26);
        expected.add(29);
        expected.add(39);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cc", "abaabcabaaccabacabaaaaabbcccbccbacbcbbaccacaaacbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                59, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable63() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable63() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce64() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("acc", "cbbbbaaccccabaacccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                24, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore64() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("acc", "cbbbbaaccccabaacccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                24, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP64() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("acc", "cbbbbaaccccabaacccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                22, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable64() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("acc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable64() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("acc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce65() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cccb", "cbbbabbbbcabbcccbbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                25, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore65() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cccb", "cbbbabbbbcabbcccbbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                19, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP65() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cccb", "cbbbabbbbcabbcccbbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                24, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable65() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 3);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cccb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable65() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cccb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                5, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce66() {
        List<Integer> expected = new ArrayList<>();
        expected.add(12);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("baaa", "bcaabbaabcacbaaaabcaaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                30, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore66() {
        List<Integer> expected = new ArrayList<>();
        expected.add(12);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("baaa", "bcaabbaabcacbaaaabcaaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                20, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP66() {
        List<Integer> expected = new ArrayList<>();
        expected.add(12);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("baaa", "bcaabbaabcacbaaaabcaaba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable66() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("baaa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable66() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("baaa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce67() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("acca", "bbbcabbcabbacaccaaccaabbabacbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                44, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore67() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("acca", "bbbcabbcabbacaccaaccaabbabacbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                27, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP67() {
        List<Integer> expected = new ArrayList<>();
        expected.add(13);
        expected.add(17);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("acca", "bbbcabbcabbacaccaaccaabbabacbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                39, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable67() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("acca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable67() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("acca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce68() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(8);
        expected.add(24);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "cacacaabbbaaccbaaaabcaacbbbcabaccbca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                45, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore68() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(8);
        expected.add(24);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "cacacaabbbaaccbaaaabcaacbbbcabaccbca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                31, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP68() {
        List<Integer> expected = new ArrayList<>();
        expected.add(7);
        expected.add(8);
        expected.add(24);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "cacacaabbbaaccbaaaabcaacbbbcabaccbca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                42, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable68() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable68() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce69() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bcb", "baacccccbbabbbcccbabcabbcabcacabcabccbaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                60, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore69() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bcb", "baacccccbbabbbcccbabcabbcabcacabcabccbaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP69() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bcb", "baacccccbbabbbcccbabcabbcabcacabcabccbaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                56, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable69() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bcb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable69() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bcb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce70() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(10);
        expected.add(28);
        expected.add(31);
        expected.add(32);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "bbbbcbcaaabbcacacccbcabcaaccbbabbbabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                53, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore70() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(10);
        expected.add(28);
        expected.add(31);
        expected.add(32);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "bbbbcbcaaabbcacacccbcabcaaccbbabbbabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP70() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(10);
        expected.add(28);
        expected.add(31);
        expected.add(32);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "bbbbcbcaaabbcacacccbcabcaaccbbabbbabaaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                47, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable70() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable70() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce71() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        expected.add(5);
        expected.add(15);
        expected.add(17);
        expected.add(19);
        expected.add(21);
        expected.add(23);
        expected.add(26);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ac", "acaacacbcbbcbaaacacacacaccaccaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                46, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore71() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        expected.add(5);
        expected.add(15);
        expected.add(17);
        expected.add(19);
        expected.add(21);
        expected.add(23);
        expected.add(26);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ac", "acaacacbcbbcbaaacacacacaccaccaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP71() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);
        expected.add(5);
        expected.add(15);
        expected.add(17);
        expected.add(19);
        expected.add(21);
        expected.add(23);
        expected.add(26);
        expected.add(30);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ac", "acaacacbcbbcbaaacacacacaccaccaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable71() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable71() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce72() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);
        expected.add(23);
        expected.add(26);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ba", "acccaaaccccbabbcacbbcaabaababaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                40, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore72() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);
        expected.add(23);
        expected.add(26);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ba", "acccaaaccccbabbcacbbcaabaababaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP72() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);
        expected.add(23);
        expected.add(26);
        expected.add(28);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ba", "acccaaaccccbabbcacbbcaabaababaccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable72() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable72() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce73() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(21);
        expected.add(29);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bab", "bbababbabcbaacaaccabbbabcbbaababbaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                59, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore73() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(21);
        expected.add(29);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bab", "bbababbabcbaacaaccabbbabcbbaababbaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                47, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP73() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(21);
        expected.add(29);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bab", "bbababbabcbaacaaccabbbabcbbaababbaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                48, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable73() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bab");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable73() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bab", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce74() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(12);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bcc", "ccbaabbcccbabccbccccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore74() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(12);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bcc", "ccbaabbcccbabccbccccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP74() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);
        expected.add(12);
        expected.add(15);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bcc", "ccbaabbcccbabccbccccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                24, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable74() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 0);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bcc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable74() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bcc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce75() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(7);
        expected.add(8);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cc", "bcccaabccccbbbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                21, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore75() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(7);
        expected.add(8);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cc", "bcccaabccccbbbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                16, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP75() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(7);
        expected.add(8);
        expected.add(9);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cc", "bcccaabccccbbbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable75() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable75() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce76() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cbc", "cbacbacbabccaaaabbacaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                30, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore76() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cbc", "cbacbacbabccaaaabbacaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                10, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP76() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cbc", "cbacbacbabccaaaabbacaca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                29, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable76() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cbc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable76() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cbc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce77() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aacc", "abbabbaaccbacaccbbbabcbabccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                35, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore77() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aacc", "abbabbaaccbacaccbbbabcbabccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                16, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP77() {
        List<Integer> expected = new ArrayList<>();
        expected.add(6);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aacc", "abbabbaaccbacaccbbbabcbabccb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                35, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable77() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aacc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable77() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aacc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce78() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("caa", "cbcbabababcaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore78() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("caa", "cbcbabababcaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                12, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP78() {
        List<Integer> expected = new ArrayList<>();
        expected.add(10);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("caa", "cbcbabababcaacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable78() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("caa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable78() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("caa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce79() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abcc", "ccabccabccccaaccaaaccaccbbababaacbaacaabbbcbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                65, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore79() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abcc", "ccabccabccccaaccaaaccaccbbababaacbaacaabbbcbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                34, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP79() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(6);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abcc", "ccabccabccccaaccaaaccaccbbababaacbaacaabbbcbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                59, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable79() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 0);
        expected.put('b', 1);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abcc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable79() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abcc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce80() {
        List<Integer> expected = new ArrayList<>();
        expected.add(25);
        expected.add(28);
        expected.add(29);
        expected.add(38);
        expected.add(39);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aa", "bbbbbccacbaccbbacacbaccabaacaaababbbccaaaccacccba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                64, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore80() {
        List<Integer> expected = new ArrayList<>();
        expected.add(25);
        expected.add(28);
        expected.add(29);
        expected.add(38);
        expected.add(39);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aa", "bbbbbccacbaccbbacacbaccabaacaaababbbccaaaccacccba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                42, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP80() {
        List<Integer> expected = new ArrayList<>();
        expected.add(25);
        expected.add(28);
        expected.add(29);
        expected.add(38);
        expected.add(39);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aa", "bbbbbccacbaccbbacacbaccabaacaaababbbccaaaccacccba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                60, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable80() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable80() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce81() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bbb", "ccabbbbbbbbcaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                27, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore81() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bbb", "ccabbbbbbbbcaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                20, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP81() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bbb", "ccabbbbbbbbcaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                16, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable81() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bbb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable81() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bbb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce82() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(12);
        expected.add(13);
        expected.add(18);
        expected.add(19);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aa", "acbaaaababcbaaacacaaabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                36, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore82() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(12);
        expected.add(13);
        expected.add(18);
        expected.add(19);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aa", "acbaaaababcbaaacacaaabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                25, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP82() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(12);
        expected.add(13);
        expected.add(18);
        expected.add(19);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aa", "acbaaaababcbaaacacaaabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                30, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable82() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable82() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce83() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abac", "baabaccbccacaaabacbacacabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore83() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abac", "baabaccbccacaaabacbacacabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP83() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(14);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abac", "baabaccbccacaaabacbacacabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                33, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable83() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 1);
        expected.put('c', 3);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable83() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce84() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        expected.add(9);
        expected.add(21);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "aabbabbaabbaacabaccbcbbcbbccbaccaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                47, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore84() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        expected.add(9);
        expected.add(21);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "aabbabbaabbaacabaccbcbbcbbccbaccaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                29, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP84() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        expected.add(9);
        expected.add(21);
        expected.add(24);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "aabbabbaabbaacabaccbcbbcbbccbaccaab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable84() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable84() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce85() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bb", "abbbbbbabca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore85() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bb", "abbbbbbabca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                14, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP85() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bb", "abbbbbbabca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                13, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable85() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable85() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce86() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(11);
        expected.add(18);
        expected.add(25);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bc", "aaabcaaaabbbcaabbabcaaaacbcbbbacaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                47, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore86() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(11);
        expected.add(18);
        expected.add(25);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bc", "aaabcaaaabbbcaabbabcaaaacbcbbbacaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP86() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(11);
        expected.add(18);
        expected.add(25);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bc", "aaabcaaaabbbcaabbabcaaaacbcbbbacaabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                44, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable86() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable86() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce87() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cac", "cccacbbccabcbcbbabaaacacbacaaacbcbccbbcbbabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                62, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore87() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cac", "cccacbbccabcbcbbabaaacacbacaaacbcbccbbcbbabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP87() {
        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cac", "cccacbbccabcbcbbabaaacacbacaaacbcbccbbcbbabc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                58, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable87() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cac");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable87() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cac", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce88() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ca", "acaaaabbaaabacaccbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                22, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore88() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ca", "acaaaabbaaabacaccbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                23, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP88() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(13);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ca", "acaaaabbaaabacaccbc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                21, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable88() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable88() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce89() {
        List<Integer> expected = new ArrayList<>();
        expected.add(17);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("caba", "cbacacbcacbcbcaaacabaabcccabaaacaaabcbbabbbbcabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                70, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore89() {
        List<Integer> expected = new ArrayList<>();
        expected.add(17);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("caba", "cbacacbcacbcbcaaacabaabcccabaaacaaabcbbabbbbcabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP89() {
        List<Integer> expected = new ArrayList<>();
        expected.add(17);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("caba", "cbacacbcacbcbcaaacabaabcccabaaacaaabcbbabbbbcabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                62, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable89() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("caba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable89() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("caba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce90() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aaba", "cbbaababbaaabcbacaabbcbbbaabacacccbaaabccacbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                72, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore90() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aaba", "cbbaababbaaabcbacaabbcbbbaabacacccbaaabccacbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP90() {
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(25);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aaba", "cbbaababbaaabcbacaabbcbbbaabacacccbaaabccacbcb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                57, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable90() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aaba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable90() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aaba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce91() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("abca", "abcabcabacbac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                19, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore91() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("abca", "abcabcabacbac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                13, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP91() {
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(3);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("abca", "abcabcabacbac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable91() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 1);
        expected.put('c', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("abca");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable91() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("abca", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce92() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("aaa", "bccaccaacbcbbababcbccacabcbccacabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                43, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore92() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("aaa", "bccaccaacbcbbababcbccacabcbccacabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                14, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP92() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("aaa", "bccaccaacbcbbababcbccacabcbccacabba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                44, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable92() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("aaa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable92() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 2;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("aaa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce93() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("ccba", "ccbcccacbbbcbabbcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                27, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore93() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("ccba", "ccbcccacbbbcbabbcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP93() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("ccba", "ccbcccacbbbcbabbcba", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable93() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("ccba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable93() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 1;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("ccba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                4, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce94() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(11);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bcaa", "bbcaacaacaabcaabaaaaabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                29, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore94() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(11);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bcaa", "bbcaacaacaabcaabaaaaabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                32, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP94() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(11);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bcaa", "bbcaacaacaabcaabaaaaabbb", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                26, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable94() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 0);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bcaa");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable94() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bcaa", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce95() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bcb", "cbaabacbabacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                15, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore95() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bcb", "cbaabacbabacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                5, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP95() {
        List<Integer> expected = new ArrayList<>();

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bcb", "cbaabacbabacc", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                17, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable95() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bcb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable95() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bcb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce96() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(6);
        expected.add(10);
        expected.add(12);
        expected.add(17);
        expected.add(32);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cb", "bcbaaccbcacbcbacccbbccacabaabcaccbcbacca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                57, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore96() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(6);
        expected.add(10);
        expected.add(12);
        expected.add(17);
        expected.add(32);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cb", "bcbaaccbcacbcbacccbbccacabaabcaccbcbacca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                40, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP96() {
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(6);
        expected.add(10);
        expected.add(12);
        expected.add(17);
        expected.add(32);
        expected.add(34);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cb", "bcbaaccbcacbcbacccbbccacabaabcaccbcbacca", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                51, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable96() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);
        expected.put('c', 0);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cb");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable96() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 0;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cb", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce97() {
        List<Integer> expected = new ArrayList<>();
        expected.add(14);
        expected.add(16);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("bab", "aaaccbccaccbccbababaacbbcccac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                37, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore97() {
        List<Integer> expected = new ArrayList<>();
        expected.add(14);
        expected.add(16);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("bab", "aaaccbccaccbccbababaacbbcccac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                19, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP97() {
        List<Integer> expected = new ArrayList<>();
        expected.add(14);
        expected.add(16);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("bab", "aaaccbccaccbccbababaacbbcccac", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                34, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable97() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 1);
        expected.put('b', 2);

        Map<Character, Integer> table = PatternMatching.buildLastTable("bab");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable97() {
        int[] expected = new int[3];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("bab", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                2, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce98() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(15);
        expected.add(18);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("acba", "caccbacbaccabbcacbacbacbaabcbbabbbbcbcabbbbab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                63, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore98() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(15);
        expected.add(18);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("acba", "caccbacbaccabbcacbacbacbaabcbbabbbbcbcabbbbab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                53, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP98() {
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(15);
        expected.add(18);
        expected.add(21);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("acba", "caccbacbaccabbcacbacbacbaabcbbabbbbcbcabbbbab", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                52, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable98() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 3);
        expected.put('b', 2);
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("acba");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable98() {
        int[] expected = new int[4];
        expected[0] = 0;
        expected[1] = 0;
        expected[2] = 0;
        expected[3] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("acba", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                3, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForce99() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);
        expected.add(12);
        expected.add(16);
        expected.add(19);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.bruteForce("cc", "ababacbacaacccbaccbccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                31, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMoore99() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);
        expected.add(12);
        expected.add(16);
        expected.add(19);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore("cc", "ababacbacaacccbaccbccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                23, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testKMP99() {
        List<Integer> expected = new ArrayList<>();
        expected.add(11);
        expected.add(12);
        expected.add(16);
        expected.add(19);

        CharacterComparator comp = new CharacterComparator();
        List<Integer> matches = PatternMatching.kmp("cc", "ababacbacaacccbaccbccaa", comp);
        Assert.assertEquals(expected, matches);
        Assert.assertEquals("Comparison count incorrect",
                28, comp.getCount());
    }

    @Test(timeout = TIMEOUT)
    public void testLastTable99() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('c', 1);

        Map<Character, Integer> table = PatternMatching.buildLastTable("cc");
        Assert.assertEquals(expected, table);
    }

    @Test(timeout = TIMEOUT)
    public void testFailureTable99() {
        int[] expected = new int[2];
        expected[0] = 0;
        expected[1] = 1;

        CharacterComparator comp = new CharacterComparator();
        int[] table = PatternMatching.buildFailureTable("cc", comp);
        Assert.assertArrayEquals(expected, table);
        Assert.assertEquals("Comparison count incorrect",
                1, comp.getCount());
    }

}