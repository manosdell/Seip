package codeanalyzer;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 *
 * @author Emmanouil Dellatolas
 * @version 1.1
 */
public interface MetricsExporter {

    void writeFile(Map<String, Integer> metrics, String filepath);

}
