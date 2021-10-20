package sorting.algorithms;

import util.Util;

import java.util.LinkedList;

public class Radix implements SortingAlgorithm<String, LinkedList<String>> {

    @Override
    public LinkedList<String> sort(String[] arr) {
        LinkedList<String>[] bucket = new LinkedList[25];
        for (String s : arr) {
            if (bucket[Util.alphabet.get(s.charAt(0))] == null) {
                bucket[Util.alphabet.get(s.charAt(0))] = new LinkedList<>();
            }
            bucket[Util.alphabet.get(s.charAt(0))].add(Util.removeSpacesAndLowerCase(s));
        }
        for (int j = 0; j < bucket.length; j++) {
            bucket[j] = recursive(bucket[j], 1);
        }
        LinkedList<String> result = new LinkedList<>();
        for (LinkedList<String> strings : bucket) {
            if (strings != null) {
                result.addAll(strings);
            }
        }
        return result;
    }

    public LinkedList<String> recursive(LinkedList<String> subArr, int index) {
        LinkedList<String> result = new LinkedList();
        if (subArr != null) {
            LinkedList<String>[] bucket = new LinkedList[25];
            for (String s : subArr) {
                if (index + 1 > s.length()) {
                    result.add(s);
                } else {
                    if (bucket[Util.alphabet.get(s.charAt(index))] == null) {
                        bucket[Util.alphabet.get(s.charAt(index))] = new LinkedList<>();
                    }
                    bucket[Util.alphabet.get(s.charAt(index))].add(s);
                }
            }
            for (int j = 0; j < bucket.length; j++) {
                if (bucket[j] != null) {
                    if (bucket[j].size() > 1) {
                        bucket[j] = recursive(bucket[j], index + 1);
                    }
                    result.addAll(bucket[j]);
                }
            }
            return result;
        }
        return null;
    }
}
