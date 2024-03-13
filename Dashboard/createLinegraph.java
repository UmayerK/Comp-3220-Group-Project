package Dashboard;

import javax.swing.*;
import java.awt.*;

public class createLinegraph extends JPanel {

  private int[] data;
  private String[] labels;

  public createLinegraph(int[] data, String[] labels) {
    this.data = data;
    this.labels = labels;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    int maxDataValue = getMax(data);
    int minDataValue = getMin(data);
    int dataRange = maxDataValue - minDataValue;

    int xSpacing = (getWidth() - 100) / (data.length - 1);
    int ySpacing = (getHeight() - 100) / dataRange;

    // Draw X-axis
    g2d.drawLine(50, getHeight() - 50, getWidth() - 50, getHeight() - 50);

    // Draw Y-axis
    g2d.drawLine(50, getHeight() - 50, 50, 50);

    // Draw data points and connecting lines
    g2d.setColor(Color.RED);
    for (int i = 0; i < data.length; i++) {
      int x = 50 + i * xSpacing;
      int y = getHeight() - 50 - (data[i] - minDataValue) * ySpacing;
      g2d.fillOval(x - 2, y - 2, 4, 4);
      if (i > 0) {
        int prevX = 50 + (i - 1) * xSpacing;
        int prevY = getHeight() - 50 - (data[i - 1] - minDataValue) * ySpacing;
        g2d.drawLine(prevX, prevY, x, y);
      }
    }

    // Draw labels
    g2d.setColor(Color.BLACK);
    for (int i = 0; i < labels.length; i++) {
      int x = 50 + i * xSpacing;
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
    int[] data = { 50, 80, 30, 120 }; // Example data
    String[] labels = { "Label 1", "Label 2", "Label 3", "Label 4" }; // Example labels

    JFrame frame = new JFrame("Basic Line Graph");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    createLinegraph lineGraph = new createLinegraph(data, labels);
    frame.add(lineGraph);

    frame.setVisible(true);
  }
}
