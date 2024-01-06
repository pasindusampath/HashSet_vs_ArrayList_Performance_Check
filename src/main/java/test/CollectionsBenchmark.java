package test;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
public class CollectionsBenchmark {

    @State(Scope.Thread)
    public static class MyState {
        private Set<Employee> employeeSet = new HashSet<>();
        private List<Employee> employeeList = new ArrayList<>();
        private long iterations = 1000;
        private Employee employee = new Employee(100L, "Harry");
        @Setup(Level.Trial)
        public void setUp() {
            for (long i = 0; i < iterations; i++) {
                employeeSet.add(new Employee(i, "John"));
                employeeList.add(new Employee(i, "John"));
            }
            employeeList.add(employee);
            employeeSet.add(employee);
        }
    }

    @Benchmark
    public boolean testArrayList(MyState state) {
        return state.employeeList.contains(state.employee);
    }

    @Benchmark
    public boolean testHashSet(MyState state) {
        return state.employeeSet.contains(state.employee);
    }

}