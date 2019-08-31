package cn.lyx.Day8_31;


import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        List<String> list1 = get(chars);
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            if (!hashMap.containsKey(list1.get(i))) {
                hashMap.put(list1.get(i), 1);
            } else {
                hashMap.replace(list1.get(i), hashMap.get(list1.get(i)), hashMap.get(list1.get(i)) + 1);
            }
        }
        int temp1 = Integer.MIN_VALUE;
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (value > temp1) {
                temp1 = value;
            }
        }
            System.out.println(temp1);
    }

    public static List<String> get(char[] arr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            int i1 = j;
            String aa = "";
            while (i1 < arr.length) {
                arrayList.add(aa += arr[i1]);
                i1++;
            }
        }
        return arrayList;
    }

}
