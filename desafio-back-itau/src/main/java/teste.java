import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class teste {

    public static void main(String[] args) {

        List<Double> valores = new ArrayList<>();

        DoubleSummaryStatistics stats = valores.stream().mapToDouble(v -> v).summaryStatistics();

        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
        System.out.println(stats.getMax());


    }
}
