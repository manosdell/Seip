package gr.aueb.dmst.manos;

import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * The HistogramGenerator class is responsible for reading the
 * grades from a txt file, given as a command line argument
 * and generating a histogram (Bar chart) from them.
 * The frequencies of the grades are stored in an array
 * where the first element is the grade and the
 * second element is the frequency of that grade.
 *
 * @author Emmanouil Dellatolas
 * @version 1.1
 * @since 2023-04-13
 */
public class HistogramGenerator {

    static int[][] frequency = new int[11][2];

    /**
     * The readFile() method reads the grades from the file
     * and stores them in an array.
     * The grades are stored in the first column of the array
     * and the frequencies are stored in the second column.
     *
     * @param filename The name of the file that contains the grades.
     */
    public static void readFile(String filename) {

        for (int i = 0; i < 11; i++) {
            frequency[i][0] = i;
            frequency[i][1] = 0;
        }

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));

            // read the file line by line
            String currentLine = reader.readLine();
            while (currentLine != null) {
                // add the grade to the ArrayList
                int grade = Integer.parseInt(currentLine);
                frequency[grade][1]++;

                // read the next line
                currentLine = reader.readLine();

            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }

    /**
     * The generateHistogram() method creates a bar chart
     * from the grades stored in the array. The grades are
     * the categories of the chart and the frequencies are
     * the values of the chart.
     */
    public static void generateHistogram() {
        // create series of data points from the file
        String series1 = "Grade";
        // create the dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 11; i++) {
            dataset.addValue(frequency[i][1], series1, String.valueOf(i));
        }

        // create the chart
        JFreeChart chart = ChartFactory.createBarChart("Grades Histogram", // chart title
                "Grade", // domain axis label
                "Frequency", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // URLs?
        );

        // display the chart
        ChartFrame frame = new ChartFrame("Grades Histogram", chart);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * The main method of the application.
     */
    public static void main(String[] args) {
        readFile(args[0]);
        generateHistogram();
    }

}
