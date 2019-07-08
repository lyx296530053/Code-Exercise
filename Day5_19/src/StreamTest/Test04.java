package StreamTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test04 {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        stream.filter(employee -> employee.getSalary() > 2000).forEach(System.out::println);//筛选
        System.out.println("********************");
        Stream<Employee> stream1 = employees.stream();
        stream1.distinct().forEach(System.out::println);//去重
        System.out.println("********************");
        Stream<Employee> stream2 = employees.stream();
        stream2.skip(3).forEach(System.out::println);//跳过
        System.out.println("********************");
        Stream<Employee> stream3 = employees.stream();
        stream3.limit(3).forEach(System.out::println);//截取
        System.out.println("********************");
        Stream<Employee> stream4 = employees.stream();
        Stream<Double> doubleStream = stream4.map(employee -> employee.getSalary());
        doubleStream.map(a -> a * 1.5).forEach(System.out::println);
        System.out.println("********************");
        Stream<Employee> stream5 = employees.stream();
        stream5.sorted((o1, o2) -> {
            int compare = Integer.compare(o1.getAge(), o2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                int compare1 = Integer.compare(o1.getId(), o2.getId());
                return -compare1;
            }
        }).forEach(System.out::println);
        System.out.println("********************");
        Stream<Employee> stream6 = employees.stream();
        System.out.println(stream6.allMatch(o -> o.getAge() > 18));
        System.out.println("********************");
        Stream<Employee> stream7 = employees.stream();
        System.out.println(stream7.anyMatch(o -> o.getAge() > 18));
        System.out.println("********************");
        Stream<Employee> stream8 = employees.stream();
        System.out.println(stream8.noneMatch(o -> o.getAge() > 18));
        System.out.println("********************");
        Stream<Employee> stream9 = employees.stream();
        System.out.println(stream9.count());
        System.out.println("********************");
        Stream<Employee> stream10 = employees.stream();
        Optional<Employee> max = stream10.min((o1, o2) -> {
            int compare = Integer.compare(o1.getAge(), o2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                int compare1 = Integer.compare(o1.getId(), o2.getId());
                return -compare1;
            }
        });
        System.out.println(max);
        System.out.println("********************");
        Stream<Employee> stream11 = employees.stream();
        stream11.forEach(System.out::println);
        System.out.println("********************");
        Stream<Employee> stream12= employees.stream();
        System.out.println(stream12.map(e->e.getAge()).reduce(10,Integer::sum));
    }
}
