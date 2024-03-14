package Dashboard;

import javax.swing.*;
import java.awt.*;

public class createScatterplot extends JPanel {

  private int[] xData;
  private int[] yData;
  private String[] labels;

  public createScatterplot(int[] xData, int[] yData, String[] labels) {
    this.xData = xData;
    this.yData = yData;
    this.labels = labels;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    int maxDataValueX = getMax(xData);
    int minDataValueX = getMin(xData);
    int dataRangeX = maxDataValueX - minDataValueX;

    int maxDataValueY = getMax(yData);
    int minDataValueY = getMin(yData);
    int dataRangeY = maxDataValueY - minDataValueY;

    int xSpacing = (getWidth() - 100) / dataRangeX;
    int ySpacing = (getHeight() - 100) / dataRangeY;

    // Draw X-axis
    g2d.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50);

    // Draw Y-axis
    g2d.drawLine(50, getHeight() - 50, 50, 50);

    // Draw data points
    g2d.setColor(Color.BLUE);
    for (int i = 0; i < xData.length; i++) {
      int x = 50 + (xData[i] - minDataValueX) * xSpacing;
      int y = getHeight() - 50 - (yData[i] - minDataValueY) * ySpacing;
      g2d.fillOval(x - 2, y - 2, 4, 4);
    }

    // Draw labels
    g2d.setColor(Color.BLACK);
    for (int i = 0; i < labels.length; i++) {
      int x = 50 + (xData[i] - minDataValueX) * xSpacing;
      int y = getHeight() - 30;
      g2d.drawString(labels[i], x, y);
    }
  }

  private int getMax(int[] data) {
    int max = Integer.MIN_VALUE;
    for (int value : data) {
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

  private int getMin(int[] data) {
    int min = Integer.MAX_VALUE;
    for (int value : data) {
      if (value < min) {
        min = value;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    int[] xData = { 1, 2, 3, 4, 5 }; // Example x data
    int[] yData = { 30, 40, 50, 60, 70 }; // Example y data
    String[] labels = { "Point 1", "Point 2", "Point 3", "Point 4", "Point 5" }; // Example labels

    JFrame frame = new JFrame("Basic Scatter Plot");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    createScatterplot scatterPlot = new createScatterplot(xData, yData, labels);
    frame.add(scatterPlot);

    frame.setVisible(true);
  }
}
