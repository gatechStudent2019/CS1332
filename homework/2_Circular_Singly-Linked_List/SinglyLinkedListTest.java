import java.util.Arrays;

public class SinglyLinkedListTest {
    public static void main(String[] args) {
    System.out.println("Testing SinglyLinkedList.java . . .");

    SinglyLinkedList<Integer> a = new SinglyLinkedList<>();

    //Tests clear()
    System.out.printf("clear(): ");
    boolean clearResult = true;
    a.clear();
    if (!a.isEmpty()) { clearResult = false; };
    for (int i = 0; i < 100; i++) {
        a.addToBack(i);
    }
    if (a.isEmpty()) { clearResult = false; };
    a.clear();
    if (!a.isEmpty()) { clearResult = false; };
    System.out.println(clearResult ? "✔︎" : "✗");
    a.clear();

    //Tests isEmpty()
    System.out.printf("isEmpty(): ");
    boolean isEmptyResult = true;
    if (!a.isEmpty()) { isEmptyResult = false; }
    for (int i = 0; i < 100; i++) {
        a.addToBack(i);
    }
    if (a.isEmpty()) { isEmptyResult = false; }
    a.clear();
    if (!a.isEmpty()) { isEmptyResult = false; }
    System.out.println(isEmptyResult ? "✔︎" : "✗");
    a.clear();

    //Tests addToFront()
    System.out.printf("addToFront(): ");
    boolean addToFrontResult = true;
    a.addToFront(8);
    if (a.size() != 1 && a.get(0) != 8) { addToFrontResult = false; }
    a.clear();
    for (int i = 99; i >= 0; i--) {
        a.addToFront(i);
    }
    if (a.size() != 100) { addToFrontResult = false; }
    for (int i = 0; i < 100; i++) {
        if (a.get(i) != i) { addToFrontResult = false; }
    }
    a.addToFront(567);
    if (a.get(0) != 567) { addToFrontResult = false; }
    System.out.println(addToFrontResult ? "✔︎" : "✗");
    a.clear();

    //Tests addToBacK()
    System.out.printf("addToBack(): ");
    boolean addToBackResult = true;
    a.addToBack(8);
    if (a.get(0) != 8 && a.size() != 1) { addToBackResult = false; }
    a.clear();
    if (a.size() != 0) { addToBackResult = false; }
    for (int i = 0; i < 100; i++) {
        a.addToBack(i);
    }
    for (int i = 0; i < 100; i++) {
        if (a.get(i) != i) { addToBackResult = false; }
    }
    if (a.size() != 100) { addToBackResult = false; }
    System.out.println(addToBackResult ? "✔︎" : "✗");
    a.clear();

    //Tests addAtIndex()
    System.out.printf("addAtIndex(): ");
    boolean addAtIndexResult = true;
    a.addAtIndex(1, 0);
    if (a.get(0) != 1 && a.size() != 1) { addAtIndexResult = false; }
    a.clear();
    a.addAtIndex(1, a.size());
    if (!(a.get(0) == 1)) { addAtIndexResult = false; }
    a.clear();
    for (int i = 0; i < 100; i++) {
        a.addAtIndex(i, i);
    }
    if (a.size() != 100) { addToFrontResult = false; }
    for (int i = 0; i < 100; i++) {
        if (a.get(i) != i) { addToFrontResult = false; }
    }
    a.addAtIndex(888, 50);
    if (a.get(50) != 888) { addAtIndexResult = false; }
    a.addAtIndex(555, 0);
    if (a.get(0) != 555) { addAtIndexResult = false; }
    a.addAtIndex(222, a.size());
    if (a.get(a.size() - 1) != 222) { addAtIndexResult = false; }
    System.out.println(addAtIndexResult ? "✔︎" : "✗");
    a.clear();

    //Tests removeFromFront()
    System.out.printf("removeFromFront(): ");
    boolean removeFromFrontResult = true;
    if (a.removeFromFront() != null) { removeFromFrontResult = false; }
    if (a.size() != 0) { removeFromFrontResult = false; }
    a.addToBack(88);
    if (a.removeFromFront() != 88 && a.size() != 1) { removeFromFrontResult = false; }
    for (int i = 0; i < 100; i++) {
        a.addToBack(i);
    }
    for (int i = 0; i < 100; i++) {
        if (a.removeFromFront() != i) { removeFromFrontResult = false; }
    }
    if (a.size() != 0) { removeFromFrontResult = false; }
    System.out.println(removeFromFrontResult ? "✔︎" : "✗");
    a.clear();

    //Tests removeFromBack()
    System.out.printf("removeFromBack(): ");
    boolean removeFromBackResult = true;
    if (a.removeFromBack() != null) { removeFromBackResult = false; }
    if (a.size() != 0) { removeFromBackResult = false; }
    a.addToBack(98);
    if (a.removeFromBack() != 98 && a.size() != 1) { removeFromBackResult = false; }
    for (int i = 0; i < 100; i++) {
        a.addToBack(i);
    }
    for (int i = 99; i >= 0; i--) {
        if (a.removeFromBack() != i) { removeFromFrontResult = false; }
        if (a.size() != i) { removeFromFrontResult = false; }
    }

    System.out.println(removeFromBackResult ? "✔︎" : "✗");

    //Tests removeAtIndex()
    System.out.printf("removeAtIndex(): ");
    boolean removeAtIndexResult = true;
    a.addToFront(287);
    if (a.removeAtIndex(0) != 287 && a.size() != 0) { removeAtIndexResult = false; }
    for (int i = 1; i <= 100; i++) {
        a.addToBack(i);
    }
    if (a.removeAtIndex(7) != 7 && a.size() != 99) { removeAtIndexResult = false; }
    if (a.removeAtIndex(0) != 0 && a.size() != 98 && a.get(0) == 0) { removeAtIndexResult = false; }
    if (a.removeAtIndex(a.size() - 1) != 100 && a.size() != 97) { removeAtIndexResult = false; }

    for (int i = 0; i < 97; i++) {
        a.removeAtIndex(0);
    }

    if (a.size() != 0) { removeAtIndexResult = false;}
    System.out.println(removeAtIndexResult ? "✔︎" : "✗");

    // Tests removeLastOccurrence()
    System.out.printf("removeLastOccurrence(): ");
    boolean removeLastOccurrenceResult = true;
    if (a.removeLastOccurrence(52) != null) { removeLastOccurrenceResult = false; }
    a.addToFront(77);
    if (a.removeLastOccurrence(77) != 77 && a.size() != 0) { removeLastOccurrenceResult = false; }
    for (int i = 0; i < 100; i++) {
        a.addToBack(i);
    }
    a.addAtIndex(44, 80);
    a.addAtIndex(60, 50);
    if (a.removeLastOccurrence(44) != 44 && a.get(44) != 44) { removeLastOccurrenceResult = false; }
    if (a.removeLastOccurrence(60) != 44 && a.get(50) != 60) { removeLastOccurrenceResult = false; }
    a.clear();
    for (int i = 0; i < 10; i++) {
        a.addAtIndex(i, a.size());
    }
    a.addAtIndex(4, 6);
    a.addAtIndex(4, a.size());
    if (a.removeLastOccurrence(4) != 4 && a.get(4) != 4 && a.get(6) != 4) { removeLastOccurrenceResult = false; }
    if (a.removeLastOccurrence(4) != 4 && a.get(4) != 4) {removeLastOccurrenceResult = false; }
    if (a.removeLastOccurrence(4) != 4 && a.get(4) == 4) {removeLastOccurrenceResult = false; }
    for (int i = 0; i < 10; i++) {
        a.removeLastOccurrence(i);
    }
    if (a.size() != 0) { removeLastOccurrenceResult = false; }
    System.out.println(removeLastOccurrenceResult ? "✔︎" : "✗");

    //Tests get()
    System.out.printf("get(): ");
    boolean getResult = true;
    a.addToBack(0);
    a.addToFront(1);
    a.addAtIndex(3, 2);
    if (a.get(0) != 1) { getResult = false; }
    a.clear();
    for (int i = 0; i < 10; i++) {
        a.addToBack(i);
    }
    for (int i = 0; i < 10; i++) {
        if (a.get(i) != i) { getResult = false; }
    }
    System.out.println(getResult ? "✔︎" : "✗");
    a.clear();

    //Tests toArray()
    System.out.printf("toArray(): ");
    boolean toArrayResult = true;
    Object[] b = a.toArray();
    if (a.size() != b.length) { toArrayResult = false; }
    for (int i = 0; i < 999; i++) {
        a.addToBack(i);
    }
    b = a.toArray();
    if (a.size() != b.length) { toArrayResult = false; }
    for (int i = 0; i < 999; i++) {
        if (a.get(i) != b[i]) { toArrayResult = false; }
    }
    System.out.println(toArrayResult ? "✔︎" : "✗");

    //End Results
    System.out.println((clearResult && isEmptyResult && addToFrontResult
        && addToBackResult && addAtIndexResult && removeFromFrontResult
        && removeFromBackResult && removeAtIndexResult
        && removeLastOccurrenceResult && getResult && toArrayResult)
        ? "⭐ Good job ⭐" : "❌ No good ❌");
    }
}













