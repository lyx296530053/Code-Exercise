package cn.lyx.Day9_8;

import java.util.*;

public class Test6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string = scanner.nextLine();
        String string1=scanner.nextLine();
        int temp=scanner.nextInt();
        int[] split = Arrays.stream(string.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] split1 = Arrays.stream(string1.split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            map.put(split[i],split1[i]);
        }
        int size=1;
        Stack<Integer> stack=new Stack();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            if(value==temp){
                stack.push(entry.getKey());
                size++;
            }
        }
        while (!stack.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : entries) {
                Integer value = entry.getValue();
                Iterator<Integer> iterator = stack.iterator();
                while (iterator.hasNext()){
                    if(value==iterator.next()){
                        size++;
                        list.add(entry.getKey());
                    }
                }
            }
            while (!stack.isEmpty()){
                stack.pop();
            }
            for (int i = 0; i < list.size(); i++) {
                stack.push(list.get(i));
            }
        }
        System.out.println(size);
    }
}
