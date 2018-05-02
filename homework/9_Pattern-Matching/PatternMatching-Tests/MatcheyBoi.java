import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;

/**
 * Pattern Matching tests.
 *
 * Latest news:
 *      2.0: Added failure table checks for correctness and efficiency, also
 *      checks KMP for efficiency more rigorously.
 *      2.1: Added random seed
 *      2.2: Added debug
 *      2.3: Fixed random bug
 *      2.4: Improved string generation; guaranteed to have a random number of
 *      hits per string.
 *      2.5: Prints randomized seed, some comparison changes, a KMP killer test.
 *      2.6: Removed KMP test for now.
 *
 * @author jdierberger3
 * @version 2.6
 */
public class MatcheyBoi {

    private CharacterComparator comparator;

    public static final int TIMEOUT = 200;

    /**
     * Randomization seed.
     */
    public static final long RANDOM_SEED = new Random().nextLong();

    /**
     * If we should check the exception messages.
     */
    public static final boolean CHECK_EXCEPTION_MESSAGES = false;

    /**
     * Number of times to check random Strings for a given matcher's
     * correctness.
     */
    public static final int NUMBER_OF_CORRECTNESS_CHECKS = 64;

    /**
     * Max threshold (additive) for comparisons. Fails if:
     * abs(expected - actual) > thresh && actual > expected
     *
     * This doesn't check for overoptimization because you should be smart
     * enough to figure that out for yourself.
     */
    public static final int MAX_COMPARISON_ADDITIVE_THRESH = 3;

    /**
     * Max threshold (muliplicitve) for comparisons. Fails if:
     * actual > expected*thresh
     */
    public static final double MAX_COMPARISON_MULTIPLICATIVE_THRESH = 1;

    /**
     * Print debug messages?
     */
    public static final boolean DEBUG = false;

    private static boolean printedRandom = false;

    @SuppressWarnings("unused")
    @Before
    public void setUp() {
        comparator = new CharacterComparator();
        if (!printedRandom && DEBUG) {
            System.out.println("[DEBUG] Random seed: " + RANDOM_SEED);
            printedRandom = true;
        }
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForceException() {
        testException(PatternMatching::bruteForce);
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForceCorrectness() {
        if (DEBUG) {
            System.out.println("[DEBUG] Testing brute force");
        }
        testCorrectness(PatternMatching::bruteForce);
    }

    @Test(timeout = TIMEOUT)
    public void testBruteForceComparisons() {
        if (DEBUG) {
            System.out.println("[DEBUG] Testing brute force");
        }
        testComparisons(PatternMatching::bruteForce, false);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreExceptions() {
        testException(PatternMatching::boyerMoore);
    }

    @SuppressWarnings("unused")
    @Test(timeout = TIMEOUT)
    public void testLastOccurenceTableExceptions() {
        try {
            PatternMatching.buildLastTable(null);
            fail("Expected IllegalArgumentException, got nothing.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().toLowerCase().contains("null")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message doesn't contain "
                        + "\"null\"; that info is probably useful.");
            }
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, got "
                    + e.getClass().getName());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testBuildLastOccurrenceTable() {
        if (DEBUG) {
            System.out.println("[DEBUG] Testing last occurrence table");
        }
        for (int i = 0; i < 16; i++) {
            Random r = new Random(RANDOM_SEED);
            int len = r.nextInt(128) + 128;
            String str = "";
            HashSet<Character> charsUsed = new HashSet<Character>();
            for (int j = 0; j < len; j++) {
                char c = (char) (r.nextInt('[' - 'A') + 'A');
                str += c;
                charsUsed.add(c);
            }
            Map<Character, Integer> table = PatternMatching.buildLastTable(str);
            if (DEBUG) {
                System.out.println("[DEBUG] Got " + charsUsed + " v/s "
                    + table.keySet() + "(text: " + str + ")");
            }
            assertEquals(charsUsed, table.keySet());
            for (Character c : table.keySet()) {
                assertEquals(Integer.valueOf(str.lastIndexOf(c)), table.get(c));
            }
        }
    }

    @Test(timeout = TIMEOUT)
    public void testBooyerMooreCorrectness() {
        if (DEBUG) {
            System.out.println("[DEBUG] Testing Boyer-Moore");
        }
        testCorrectness(PatternMatching::boyerMoore);
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreComparisons() {
        if (DEBUG) {
            System.out.println("[DEBUG] Testing Boyer-Moore");
        }
        testComparisons(PatternMatching::boyerMoore, false);
    }

    @Test(timeout = TIMEOUT)
    public void testKMPExceptions() {
        testException(PatternMatching::kmp);
    }

    @SuppressWarnings("unused")
    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableExecptions() {
        // Check null pattern
        try {
            PatternMatching.buildFailureTable(null, comparator);
            fail("Expected IllegalArgumentException with null pattern, "
                    + "got nothing.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().toLowerCase().contains("null")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null pattern doesn't contain "
                        + "\"null\"; that info is probably useful.");
            }
            if (!e.getMessage().toLowerCase().contains("pattern")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null pattern doesn't contain "
                    + "\"pattern\"; knowing which param is null is useful.");
            }
        } catch (Exception e) {
            fail("Expected IllegalArgumentException with null pattern, got "
                    + e.getClass().getName());
        }

        // Check null comparator
        try {
            PatternMatching.buildFailureTable("a", null);
            fail("Expected IllegalArgumentException with null character "
                    + "comparator, got nothing.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().toLowerCase().contains("null")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null text doesn't contain "
                        + "\"null\"; that info is probably useful.");
            }
            if (!e.getMessage().toLowerCase().contains("comparator")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null text doesn't contain "
                    + "\"comparator\"; knowing which param is null is useful.");
            }
        } catch (Exception e) {
            fail("Expected IllegalArgumentException with null character "
                    + "comparator, got " + e.getClass().getName());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableFixed() {
        int[] f1 = PatternMatching.buildFailureTable("abcdabd", comparator);
        //                 a  b  c  d  a  b  d
        int[] expected1 = {0, 0, 0, 0, 1, 2, 0};
        assertArrayEquals(expected1, f1);
        if (comparator.getCount() > expected1.length) {
            fail("Comparison count exceeds bound: expected <= "
                + expected1.length + " but got " + comparator.getCount());
        }

        setUp();
        int[] f2 = PatternMatching.buildFailureTable("revararev", comparator);
        //                 r  e  v  a  r  a  r  e  v
        int[] expected2 = {0, 0, 0, 0, 1, 0, 1, 2, 3};
        assertArrayEquals(expected2, f2);
        if (comparator.getCount() > expected2.length) {
            fail("Comparison count exceeds bound: expected <= "
                + expected2.length + " but got " + comparator.getCount());
        }

        setUp();
        int[] f3 = PatternMatching.buildFailureTable("abacadaba", comparator);
        //                 a  b  a  c  a  d  a  b  a
        int[] expected3 = {0, 0, 1, 0, 1, 0, 1, 2, 3};
        assertArrayEquals(expected3, f3);
        // This one requires one more comparison, checked by hand.
        if (comparator.getCount() > (expected3.length + 1)) {
            fail("Comparison count exceeds bound: expected <= "
                + (expected3.length + 1) + " but got " + comparator.getCount());
        }

        setUp();
        int[] f4 = PatternMatching.buildFailureTable("abab_baba", comparator);
        //                 a  b  a  b  _  b  a  b  a
        int[] expected4 = {0, 0, 1, 2, 0, 0, 1, 2, 3};
        assertArrayEquals(expected4, f4);
        if (comparator.getCount() > expected4.length) {
            fail("Comparison count exceeds bound: expected <= "
                + expected4.length + " but got " + comparator.getCount());
        }

        setUp();
        int[] f5 = PatternMatching.buildFailureTable("abaababac", comparator);
        //                 a  b  a  a  b  a  b  a  c
        int[] expected5 = {0, 0, 1, 1, 2, 3, 2, 3, 0};
        assertArrayEquals(expected5, f5);
        if (comparator.getCount() > expected5.length + 3) {
            fail("Comparison count exceeds bound: expected <= "
                + expected4.length + " but got " + comparator.getCount());
        }
    }

    @Test(timeout = TIMEOUT)
    public void testBuildFailureTableRandomized() {
        if (DEBUG) {
            System.out.println("[DEBUG] Testing failure table");
        }
        Random r = new Random(RANDOM_SEED);
        for (int i = 0; i < NUMBER_OF_CORRECTNESS_CHECKS; i++) {
            int textLen = r.nextInt(16) + 16;
            String text = "";
            for (int j = 0; j < textLen; j++) {
                char c = (char) (r.nextInt('[' - 'A') + 'A');
                text += c;
            }
            comparator = new CharacterComparator();
            int expectedComparisons = (int) (text.length());
            PatternMatching.buildFailureTable(text, comparator);
            if (DEBUG) {
                System.out.println("[DEBUG] Got " + comparator.getCount()
                    + " v/s " + expectedComparisons + "(text: " + text
                    + ")");
            }
            if (Math.abs(comparator.getCount() - expectedComparisons)
                    > MAX_COMPARISON_ADDITIVE_THRESH
                    && comparator.getCount() > expectedComparisons) {
                fail("Expected <= " + expectedComparisons + " +/- "
                    + MAX_COMPARISON_ADDITIVE_THRESH + " comparisons, got "
                    + comparator.getCount() + " on pattern " + text);
            }
            if (comparator.getCount() == 0) {
                fail("Got 0 comparisons generating table, expected around "
                    + expectedComparisons);
            }
        }
    }

    @Test(timeout = TIMEOUT)
    public void testKMPCorrectness() {
        if (DEBUG) {
            System.out.println("[DEBUG] Testing Knuth-Morris-Pratt");
        }
        testCorrectness(PatternMatching::kmp);
    }

    /**
     * Test a given matcher function for Exceptions.
     * @param matcher The matcher to test.
     */
    @SuppressWarnings("unused")
    private void testException(MatcherFunction matcher) {
        // Check null pattern
        try {
            matcher.function(null, "", comparator);
            fail("Expected IllegalArgumentException with null pattern, "
                    + "got nothing.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().toLowerCase().contains("null")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null pattern doesn't contain "
                        + "\"null\"; that info is probably useful.");
            }
            if (!e.getMessage().toLowerCase().contains("pattern")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null pattern doesn't contain "
                    + "\"pattern\"; knowing which param is null is useful.");
            }
        } catch (Exception e) {
            fail("Expected IllegalArgumentException with null pattern, got "
                    + e.getClass().getName());
        }

        // Check 0 len pattern
        try {
            matcher.function("", "", comparator);
            fail("Expected IllegalArgumentException with 0 length pattern,"
                    + " got nothing.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().toLowerCase().contains("empty")
                    && !e.getMessage().toLowerCase().contains("0")
                    && !e.getMessage().toLowerCase().contains("length")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for 0 length pattern doesn't contain "
                    + "\"empty\", \"0\", or \"length\"; that info is probably"
                    + " useful.");
            }
        } catch (Exception e) {
            fail("Expected IllegalArgumentException with null pattern, got "
                    + e.getClass().getName());
        }

        // Check null text
        try {
            matcher.function("a", null, comparator);
            fail("Expected IllegalArgumentException with null text, got "
                    + "nothing.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().toLowerCase().contains("null")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null text doesn't contain "
                        + "\"null\"; that info is probably useful.");
            }
            if (!e.getMessage().toLowerCase().contains("text")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null text doesn't contain "
                        + "\"text\"; knowing which param is null is useful.");
            }
        } catch (Exception e) {
            fail("Expected IllegalArgumentException with null text, got "
                    + e.getClass().getName());
        }

        // Check null comparator
        try {
            matcher.function("a", "a", null);
            fail("Expected IllegalArgumentException with null character "
                    + "comparator, got nothing.");
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().toLowerCase().contains("null")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null text doesn't contain "
                        + "\"null\"; that info is probably useful.");
            }
            if (!e.getMessage().toLowerCase().contains("comparator")
                    && CHECK_EXCEPTION_MESSAGES) {
                fail("Exception message for null text doesn't contain "
                    + "\"comparator\"; knowing which param is null is useful.");
            }
        } catch (Exception e) {
            fail("Expected IllegalArgumentException with null character "
                    + "comparator, got " + e.getClass().getName());
        }
    }

    /**
     * Helper function for testing correctness to prevent copypastes.
     * @param matcher The matcher to check.
     */
    private void testCorrectness(MatcherFunction matcher) {
        if (DEBUG) {
            System.out.println("[DEBUG] Running correctness check");
        }
        Random r = new Random(RANDOM_SEED);
        for (int i = 0; i < NUMBER_OF_CORRECTNESS_CHECKS;) {
            int patternLen = r.nextInt(10) + 1;
            String pattern = "";
            for (int j = 0; j < patternLen; j++) {
                char c = (char) (r.nextInt('[' - 'A') + 'A');
                pattern += c;
            }

            String text = "";
            int patternOccurrences = r.nextInt(6);
            if (patternOccurrences == 0) {
                for (int k = 0; k < patternLen * 3; k++) {
                    char c = (char) (r.nextInt('[' - 'A') + 'A');
                    text += c;
                }
            } else {
                int padLen = r.nextInt((int) Math.ceil(1.0 * patternLen
                        / patternOccurrences)) + ((patternLen
                        + patternOccurrences) / 2);
                String pad = "";
                for (int j = 0; j < patternOccurrences;) {
                    for (int k = 0; k < padLen; k++) {
                        char c = (char) (r.nextInt('[' - 'A') + 'A');
                        pad += c;
                    }
                    if (r.nextDouble() < 0.75) {
                        text += pattern;
                        j++;
                    }
                    text += pad;
                }
            }

            if (text.contains(pattern)) {
                i++;
            } else if (DEBUG) {
                System.out.println("[DEBUG] Got a miss; running again");
            }
            List<Integer> list = matcher.function(pattern, text, comparator);
            // indices are unique and I am lazy
            ArrayList<Integer> correct
                = new ArrayList<Integer>(text.length() / 8);
            for (int j = 0; j < text.length(); j++) {
                j = text.indexOf(pattern, j);
                if (j == -1) {
                    break;
                }
                correct.add(j);
            }
            if (DEBUG) {
                System.out.println("[DEBUG] Got " + list + " v/s " + correct
                        + " (text: " + text + "; pattern: " + pattern + ")");
            }
            assertEquals("With text " + text + " and pattern "
                    + pattern + ": ", correct, list);
        }
        setUp();
        if (DEBUG) {
            System.out.println(
                    matcher.function("ababc", "abababcdef", comparator));
        }
        assertEquals("With text abababcdef and pattern ababc: ",
                Collections.singletonList(2),
                matcher.function("ababc", "abababcdef", comparator));
    }

    /**
     * Helper function for testing the number of comparisons.
     * @param matcher The matcher to check.
     * @param sum If the big O is the sum (true) or product (false) of the
     * length of the text and length of the pattern.
     */
    private void testComparisons(MatcherFunction matcher, boolean sum) {
        if (DEBUG) {
            System.out.println("[DEBUG] Running comparison check");
        }
        Random r = new Random(RANDOM_SEED);
        for (int i = 0; i < NUMBER_OF_CORRECTNESS_CHECKS;) {
            int patternLen = r.nextInt(8) + 4;
            String pattern = "";
            for (int j = 0; j < patternLen; j++) {
                char c = (char) (r.nextInt('[' - 'A') + 'A');
                pattern += c;
            }

            String text = "";
            int patternOccurrences = r.nextInt(6);
            if (patternOccurrences == 0) {
                for (int k = 0; k < patternLen * 3; k++) {
                    char c = (char) (r.nextInt('[' - 'A') + 'A');
                    text += c;
                }
            } else {
                int padLen = r.nextInt((int) Math.ceil(1.0 * patternLen
                        / patternOccurrences)) + ((patternLen
                        + patternOccurrences) / 2);
                String pad = "";
                for (int j = 0; j < patternOccurrences;) {
                    for (int k = 0; k < padLen; k++) {
                        char c = (char) (r.nextInt('[' - 'A') + 'A');
                        pad += c;
                    }
                    if (r.nextDouble() < 0.75) {
                        text += pattern;
                        j++;
                    }
                    text += pad;
                }
            }

            if (text.contains(pattern)) {
                i++;
            } else if (DEBUG) {
                System.out.println("[DEBUG] Got a miss; running again");
            }
            comparator = new CharacterComparator();
            matcher.function(pattern, text, comparator);
            int expectedComparisons = -1;
            if (!sum) {
                expectedComparisons = pattern.length() * text.length();
            } else {
                expectedComparisons = pattern.length() + text.length();
            }
            boolean boundComp = true;
            boolean justFailTable = false;
            if (sum) {
                boundComp = (Math.abs(comparator.getCount()
                        - expectedComparisons) > MAX_COMPARISON_ADDITIVE_THRESH
                        && comparator.getCount() > expectedComparisons)
                        /*
                         * Also make sure we aren't just checking the failure
                         * table generation.
                         */
                        || Math.abs(comparator.getCount() - pattern.length())
                            < MAX_COMPARISON_ADDITIVE_THRESH;
                justFailTable = Math.abs(comparator.getCount()
                        - pattern.length()) < MAX_COMPARISON_ADDITIVE_THRESH;
            } else {
                boundComp = comparator.getCount() > expectedComparisons
                        * MAX_COMPARISON_MULTIPLICATIVE_THRESH;
            }
            if (DEBUG) {
                System.out.println("[DEBUG] Got " + comparator.getCount()
                        + " comparisons v/s " + expectedComparisons + "(sum: "
                        + sum + "; text: " + text + "; pattern: " + pattern
                        + "; patternOccurences: " + patternOccurrences + ")");
            }
            if (boundComp) {
                fail("Expected <= " + expectedComparisons
                        + " comparisons, got " + comparator.getCount()
                        + " on text " + text + " and pattern " + pattern
                        + ((justFailTable)
                        ? " (likely only doing failure table generation)"
                        : ""));
            }
            if (text.contains(pattern) && comparator.getCount() == 0) {
                fail("Text contains pattern but got 0 comparisons.");
            }
        }
    }

    /**
     * This interface specifies the function header of a pattern matching
     * function to be used with the testing methods provided.
     * @author jdierberger3
     */
    public static interface MatcherFunction {
        /**
         * Templated matcher function.
         * @param pattern Pattern to look for.
         * @param text Text to search.
         * @param comp Comparator.
         * @return A list of indicies of the pattern in the text.
         */
        List<Integer> function(CharSequence pattern,
                CharSequence text, CharacterComparator comp);
    }
}