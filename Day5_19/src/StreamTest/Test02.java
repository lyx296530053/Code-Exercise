package StreamTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test02 {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        System.out.println(stream.allMatch(e->e.getAge()>18));
        Stream<Employee> stream01 = employees.stream();
        System.out.println(stream01.anyMatch(e->e.getAge()>18));
        Stream<Employee> stream02 = employees.stream();
        System.out.println(stream02.noneMatch(e->e.getAge()>18));
        Stream<Employee> stream03 = employees.parallelStream();
        System.out.println(stream03.findAny());
        Stream<Employee> stream04= employees.parallelStream();
        List<Employee> collect = stream04.filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
      collect.forEach(System.out::println);
    }
}
