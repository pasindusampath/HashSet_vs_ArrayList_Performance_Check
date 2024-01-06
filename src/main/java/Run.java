import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import test.CollectionsBenchmark;

public class Run {
    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                .include(CollectionsBenchmark.class.getSimpleName())
                .forks(1).build();
        new Runner(options).run();
    }
}
