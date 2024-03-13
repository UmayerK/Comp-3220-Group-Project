package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Data {
  private String data_type;
  private String format;
  private String data_source;
  private String perms;

  public Data(String data_type, String format, String data_source, String perms) {
    this.data_type = data_type;
    this.format = format;
    this.data_source = data_source;
    this.perms = perms;
  }

  // setters
  public void setData_type(String data_type) {
    this.data_type = data_type;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public void setData_source(String data_source) {
    this.data_source = data_source;
  }

  public void setPerms(String perms) {
    this.perms = perms;
  }

  // getter
  private String setData_Type() {
    return data_type;
  }

  private String setFormat() {
    return format;
  }

  private String setData_source() {
    return data_source;
  }

  private String setPerms() {
    return perms;
  }

  // methods

  // Create a new data set based on the file name
  /**
   * 
   * @param newName the new name of the file
   */
  public void createNewSet(String newName) {
    File newFile = new File(newName + "." + format);
    try {
      if (newFile.createNewFile()) {
        System.out.println("New data set created: " + newName);
      } else {
        System.out.println("Data set already exists: " + newName);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Read the data set from a file
  public void readDataSet(String fileName, int cursorVal) {
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      int lineNumber = 0;
      while ((line = br.readLine()) != null && lineNumber < cursorVal) {
        System.out.println(line);
        lineNumber++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Update the data set in a file
  public void updateDataSet(String fileName, int beginning_pos, int end_pos) {
    try (FileWriter writer = new FileWriter(fileName, true)) {
      writer.write("Updating the data set between positions " + beginning_pos + " and " + end_pos + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Delete the data set file
  public void deleteDataSet(String fileName) {
    File fileToDelete = new File(fileName + "." + format);
    if (fileToDelete.delete()) {
      System.out.println("Data set deleted: " + fileName);
    } else {
      System.out.println("Failed to delete data set: " + fileName);
    }
  }
}
