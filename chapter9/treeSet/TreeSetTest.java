package treeSet;

import java.util.*;

/**
 * This program sorts a set of item by comparing their descriptions
 * @version 9.3.1 2020-4-28
 * @author yefan_jiang
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 1992));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(
            Comparator.comparing(Item::getDescription)
        );

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}