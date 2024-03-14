package Dashboard;

import javax.swing.*;
import java.awt.*;

public class createPiegraph extends JPanel {

  private int[] data;
  private String[] labels;

  public createPiegraph(int[] data, String[] labels) {
    this.data = data;
    this.labels = labels;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    int total = 0;
    for (int value : data) {
      total += value;
    }

    int startAngle = 0;
    int arcAngle;
    for (int i = 0; i < data.length; i++) {
      arcAngle = (int) Math.round((double) data[i] / total * 360);
      g2d.setColor(getRandomColor());
      g2d.fillArc(50, 50, 300, 300, startAngle, arcAngle);
      startAngle += arcAngle;
    }
  }

  private Color getRandomColor() {
    return new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
  }

  public static void main(String[] args) {
    int[] data = { 30, 40, 30 }; // Example data
    String[] labels = { "Slice 1", "Slice 2", "Slice 3" }; // Example labels

    JFrame frame = new JFrame("Basic Pie Chart");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);

    createPiegraph pieChart = new createPiegraph(data, labels);
    frame.add(pieChart);

    frame.setVisible(true);
  }
}
