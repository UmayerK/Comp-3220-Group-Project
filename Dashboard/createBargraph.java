package Dashboard;

import javax.swing.*;
import java.awt.*;

public class createBargraph extends JPanel {

  private int[] data;
  private String[] labels;

  public createBargraph(int[] data, String[] labels) {
    this.data = data;
    this.labels = labels;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    int maxDataValue = getMax(data);
    int barWidth = 50;
    int spacing = 20;
    int startX = 50;

    for (int i = 0; i < data.length; i++) {
      int barHeight = (int) ((double) data[i] / maxDataValue * getHeight());
      int x = startX + i * (barWidth + spacing);
      int y = getHeight() - barHeight;
      g2d.setColor(Color.BLUE);
      g2d.fillRect(x, y, barWidth, barHeight);

      // Display label for each bar
      g2d.setColor(Color.BLACK);
      g2d.drawString(labels[i], x + barWidth / 2 - 10, getHeight() - 5);
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

  public static void main(String[] args) {
    int[] data = { 50, 80, 30, 120 }; // Example data
    String[] labels = { "Label 1", "Label 2", "Label 3", "Label 4" }; // Example labels

    JFrame frame = new JFrame("Basic Bar Graph");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    createBargraph barGraph = new createBargraph(data, labels);
    frame.add(barGraph);

    frame.setVisible(true);
  }
}
