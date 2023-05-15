package kreis.aula;

import java.util.ArrayList;
import java.util.List;

public class HashTableReadequation {
    private List<List<Integer>> oldTable;
    private List<List<Integer>> newTable;

    public HashTableReadequation(List<List<Integer>> oldTable) {
        this.oldTable = oldTable;
        newTable = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            newTable.add(new ArrayList<>());
        }
    }

    public void readequate() {
        for (int i = 0; i < oldTable.size(); i++) {
            List<Integer> chain = oldTable.get(i);
            if (chain != null) {
                for (int j = 0; j < chain.size(); j++) {
                    int number = chain.get(j);
                    int newPosition = hash(i);
                    newTable.get(newPosition).add(number);
                }
            }
        }
    }

    private int hash(int position) {
        return position % 10;
    }

    public void printNewTable() {
        for (int i = 0; i < newTable.size(); i++) {
            System.out.print(i + "\t");
            List<Integer> chain = newTable.get(i);
            if (chain != null) {
                for (int j = 0; j < chain.size(); j++) {
                    System.out.print(chain.get(j) + "\t");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
      
        List<List<Integer>> oldTable = new ArrayList<>();
        oldTable.add(List.of(12, 647, 158, 136, 467));
        oldTable.add(List.of(156, 600, 551));
        oldTable.add(List.of(263, 414, 882, 945, 914, 953, 629));
        oldTable.add(List.of(884, 795, 194, 513));
        oldTable.add(List.of(591, 847, 66, 337, 979));
        oldTable.add(List.of(768, 53));
        oldTable.add(List.of(114, 803, 90, 339, 550));
        oldTable.add(List.of(574, 977, 216, 99, 617, 88));
        oldTable.add(List.of(142, 148, 227, 939, 585, 338, 206));
        oldTable.add(List.of(569, 708, 844));

        HashTableReadequation hashTable = new HashTableReadequation(oldTable);
        hashTable.readequate();
        hashTable.printNewTable();
    }
}
