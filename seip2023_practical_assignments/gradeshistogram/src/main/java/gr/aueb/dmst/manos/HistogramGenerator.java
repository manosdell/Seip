package gr.aueb.dmst.manos;

import java.io.*;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * The HistogramGenerator class is responsible for reading the
 * grades from a txt file, given as a command line argument
 * and generating a histogram from them.
 * The grades are stored in an ArrayList<Float> and then
 * added to a dataset which is used to create the histogram.
 *
 * @author Emmanouil Dellatolas
 * @version 1.0
 * @since 2023-04-13
 */
public class HistogramGenerator {
     static ArrayList<Float> grades = new ArrayList<Float>();

    /**
     * The constructor of the HistogramGenerator class.
     *
     * @param filename The name of the file that contains the grades.
     */
    public static void readFile(String filename) {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));

            // read the file line by line
            String currentLine = reader.readLine();
            while (currentLine != null) {
                grades.add(Float.parseFloat(currentLine));
                currentLine = reader.readLine();

            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

    /**
     * The generateHistogram() method creates a dataset from the
     * grades and then creates a histogram from it.
     */
    public static void generateHistogram() {
        // create series of data points from the file
        XYSeries series = new XYSeries("Grades");
        for (int i = 0; i < grades.size(); i++) {
            series.add(i, grades.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        // create the XYLine chart
        JFreeChart chart = ChartFactory.createXYLineChart("Grades", "Students", "Grades", dataset,
                PlotOrientation.VERTICAL, true, true, false);
        ChartFrame frame = new ChartFrame("Grades", chart);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The main method of the application.
     */
    public static void main( String[] args )
    {
        readFile(args[0]);
        generateHistogram();
    }


}
