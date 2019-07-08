package StreamTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Employee> employees=EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        Stream<Employee> employeeStream = employees.parallelStream();
        int[] arr={1,4,3,6,2};
        IntStream stream1 = Arrays.stream(arr);

    }
}
