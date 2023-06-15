package codeanalyzer;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

/**
 * Facade class that contains the main method and calls the other
 * classes of the program.
 *
 * @author Emmanouil Dellatolas
 * @version 1.1
 * @since 14-6-2023
 */
public class CodeAnalyzerFacade {

    /**
     * The analyze method calls the other classes
     * of the program.
     *
     * @param sourceFilepath The path of the source file.
     * @param location The location of the source file.
     * @param analyzerType The type of the analyzer.
     * @param outputFilepath The path of the output file.
     * @param outputType The type of the output file.
     * @throws IOException If the file is not found.
     */
    public void analyze(String sourceFilepath, String location,
                        String analyzerType, String outputFilepath,
                        String outputType) throws IOException{

        SourceFileReaderFactory fileReaderFactory = new SourceFileReaderFactory();

        SourceFileReader fileReaderType = fileReaderFactory.createSourceFileReader(location);

        SourceCodeAnalyzerFactory analyzerFactory = new SourceCodeAnalyzerFactory();

        SourceCodeAnalyzer analyzer = analyzerFactory.createSourceCodeAnalyzer(analyzerType, fileReaderType);

        int loc = analyzer.calculateLOC(sourceFilepath);
        int nom = analyzer.calculateNOM(sourceFilepath);
        int noc = analyzer.calculateNOC(sourceFilepath);

        MetricsExporterFactory exporterFactory = new MetricsExporterFactory();

        Map<String, Integer> metrics = new HashMap<>();
        metrics.put("loc", loc);
        metrics.put("nom", nom);
        metrics.put("noc", noc);

        MetricsExporter exporter = exporterFactory.createMetricsExporter(outputType);
        exporter.writeFile(metrics, outputFilepath);
    }
}


