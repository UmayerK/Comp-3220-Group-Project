package Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class createHeatmap extends JPanel {

  private int[][] data;
  private String[] rowLabels;
  private String[] colLabels;
  private Color[] colors;

  public createHeatmap(int[][] data, String[] rowLabels, String[] colLabels, Color[] colors) {
    this.data = data;
    this.rowLabels = rowLabels;
    this.colLabels = colLabels;
    this.colors = colors;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    int cellWidth = 40;
    int cellHeight = 40;
    int startX = 50;
    int startY = 50;

    // Draw row labels
    for (int i = 0; i < rowLabels.length; i++) {
      g2d.drawString(rowLabels[i], 20, startY + cellHeight * i + cellHeight / 2);
    }

    // Draw column labels
    for (int i = 0; i < colLabels.length; i++) {
      g2d.drawString(colLabels[i], startX + cellWidth * i + cellWidth / 2, 40);
    }

    // Draw heatmap cells
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        int value = data[i][j];
        Color color = getColor(value);
        g2d.setColor(color);
        g2d.fill(new Rectangle2D.Double(startX + cellWidth * j, startY + cellHeight * i, cellWidth, cellHeight));
      }
    }
  }

  private Color getColor(int value) {
    double ratio = (double) value / getMaxValue();
    int r = (int) (255 * ratio);
    int b = 255 - r;
    return new Color(r, 0, b);
  }

  private int getMaxValue() {
    int max = Integer.MIN_VALUE;
    for (int[] row : data) {
      for (int value : row) {
        if (value > max) {
          max = value;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] data = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };
    String[] rowLabels = { "Row 1", "Row 2", "Row 3" };
    String[] colLabels = { "Col 1", "Col 2", "Col 3" };
    Color[] colors = new Color[0]; // Not used in this example

    JFrame frame = new JFrame("Basic Heatmap");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    createHeatmap heatmap = new createHeatmap(data, rowLabels, colLabels, colors);
    frame.add(heatmap);

    frame.setVisible(true);
  }
}
