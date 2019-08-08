package collections.trees;

import java.util.Iterator;

public class TestTreeRunner {
    public static void main(String[] args) {

        TestTree<String> stringTestTree = new TestTree<>();
        stringTestTree.add("g");
        stringTestTree.add("b");
        stringTestTree.add("e");

        System.out.println(stringTestTree.size());

        System.out.println(stringTestTree.contains("i"));

//        stringTestTree.printTree();

        Iterator<String> iterator = stringTestTree.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
