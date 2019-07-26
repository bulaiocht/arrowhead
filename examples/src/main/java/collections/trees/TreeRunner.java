package collections;

import collections.trees.SimpleTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TreeRunner {

    public static void main(String[] args) throws IOException {

        SimpleTree<String> simpleTree = new SimpleTree<>();
        Files.lines(Paths.get("examples/src/main/resources/song.txt"))
                .forEach(simpleTree::add);

        System.out.printf("There are %d lines in song\n", simpleTree.getSize());
//        System.out.println(simpleTree.contains("!"));

        simpleTree.traverseTree();

    }
}
