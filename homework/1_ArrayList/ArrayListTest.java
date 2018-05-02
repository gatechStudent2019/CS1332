//Unfinished and not that helpful
public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList();

        int maxInt = 2147483647;
        int minInt = -2147483647;

        //Checks addToFront()
        System.out.print("Checking addToFront(): ");
        for(int i = 0; i < 100; i++) {
            a.addToFront(i);
        }
        System.out.printf((a.size() == 100 && a.get(0) == 99
            && a.get(a.size() - 1) == 0) ? "\t✔︎\n" : "\t✗\n");
        a.clear();

        //Checks addToBack()
        System.out.print("Checking addToBack(): ");
        for(int i = 0; i < 100; i++) {
            a.addToBack(i);
        }
        System.out.printf((a.size() == 100 && a.get(0) == 0
            && a.get(a.size() - 1) == 99) ? "\t✔\n︎" : "\t✗\n");
        a.clear();

        //Checks addAtIndex()
        System.out.printf("Checking addAtIndex(): \n");
        //Check 1
        a.addToBack(1); a.addAtIndex(0, 1);
        System.out.printf("\tCheck 1: " + (a.get(0) == 1 && a.size() == 2
            ? "✔︎\n" : "✗\n"));
        a.clear();
        //Check 2
        int ind = 50;
        for(int i = 0; i < 100; i++) {
            a.addToFront(i);
        }
        System.out.printf("\tCheck 2: " + (a.get(ind) == 49
            && a.size() == 100 ? "✔︎\n" : "✗\n"));

        a.clear();

        //Checks removeFromFront()
        System.out.printf("Checking removeFromFront(): \n");
        //Check 1
        a.addToFront(0);
        System.out.println("\tCheck 1: " + (a.removeFromFront() == 0
            && a.size() == 0 ? "✔︎\n" : "✗\n"));
        a.clear();
        //Check 2

        // System.out.println((a.size() == 100 && a.get(0) == 0
        //     && a.get(a.size() - 1) == 99) ? "good" : "bad");

    }
}












