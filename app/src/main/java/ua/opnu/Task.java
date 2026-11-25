package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() <= list.get(i + 1).length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            list.add(i + 1, list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            stack.push(value);
            queue.add(value);
        }

        boolean result = true;

        for (int i = 0; i < size; i++) {
            int value = queue.remove();

            if (value != stack.pop()) {
                result = false;
            }

            queue.add(value);
        }

        return result;
    }

    public void reorder(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int negativeCount = 0;

        for (int i = 0; i < size; i++) {
            int value = queue.remove();

            if (value < 0) {
                stack.push(value);
                negativeCount++;
            } else {
                queue.add(value);
            }
        }

        for (int i = 0; i < negativeCount; i++) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < size - negativeCount; i++) {
            queue.add(queue.remove());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int evenCount = 0;

        for (int i = 0; i < size; i++) {
            int value = queue.remove();

            if (value % 2 == 0) {
                stack.push(value);
                evenCount++;
            } else {
                queue.add(value);
            }
        }

        int oddCount = size - evenCount;

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < oddCount; i++) {
            queue.add(queue.remove());
        }

        for (int i = 0; i < evenCount; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < oddCount; i++) {
            queue.add(queue.remove());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;

        for (String str : set) {
            if (str.length() > max) {
                max = str.length();
            }
        }

        return max;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String str = iterator.next();

            if (str.length() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<>(list1);
        int count = 0;

        for (int num : list2) {
            if (set.contains(num)) {
                count++;
                set.remove(num);
            }
        }

        return count;
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();

        for (String value : map.values()) {
            if (!values.add(value)) {
                return false;
            }
        }

        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key) &&
                    map1.get(key).equals(map2.get(key))) {
                result.put(key, map1.get(key));
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int value : map.values()) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        int rarest = 0;
        int minCount = Integer.MAX_VALUE;

        for (int value : counts.keySet()) {
            int count = counts.get(value);

            if (count < minCount || (count == minCount && value < rarest)) {
                minCount = count;
                rarest = value;
            }
        }

        return rarest;
    }

    public int maxOccurrences(List<Integer> list) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = 0;

        for (int num : list) {
            int count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);

            if (count > max) {
                max = count;
            }
        }

        return max;
    }

}
