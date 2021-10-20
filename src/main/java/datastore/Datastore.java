package datastore;

import sorting.algorithms.SortingAlgorithm;
import util.Util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Datastore {
    /*
     * key: space removed string.
     * value: actual string.
     * */
    public Map<String, String> actualData;
    private SortingAlgorithm<String, LinkedList<String>> sortingAlgorithm;

    public Datastore(SortingAlgorithm<String, LinkedList<String>> sortingAlgorithm) {
        actualData = new HashMap<>();
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void insert(String data) {
        //validateStringArr(actualData.size() + 1);
        String removedString = Util.removeSpacesAndLowerCase(data);
        actualData.put(removedString, data);
    }

    public void bulkInsert(String[] data) {
        //validateStringArr(data.length);
        for (String word : data) {
            //  validateString(word);
            String removedString = Util.removeSpacesAndLowerCase(word);
            actualData.put(removedString, word);
        }
    }

    public void delete(String data) {
        for (Map.Entry<String, String> m : actualData.entrySet()) {
            if (m.getValue().equals(data)) {
                actualData.remove(m.getKey());
                break;
            }
        }
    }

    public String[] getActualDataKeyAsArray() {
        String[] result = new String[actualData.size()];
        int index = 0;
        for (Map.Entry<String, String> m : actualData.entrySet()) {
            result[index] = m.getKey();
            index++;
        }
        return result;
    }

    public String getValueFromKey(String key) {
        return actualData.get(key);
    }

    public LinkedList<String> sort(String[] arr) {
        return sortingAlgorithm.sort(arr);
    }
}
