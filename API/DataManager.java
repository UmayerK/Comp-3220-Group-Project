package API;

class DataManager extends API {

  private int order_type;
  private String file_type;
  private int new_perms_level;

  public void sortDataset(String fileName, int order_type) {
    this.fileName = fileName;
    this.setOrder_type(order_type);

  }

  public int getOrder_type() {
    return order_type;
  }

  public void setOrder_type(int order_type) {
    this.order_type = order_type;
  }

  public String getFile_type() {
    return file_type;
  }

  public void setFile_type(String file_type) {
    this.file_type = file_type;
  }

  public void cleanDataset(String fileName, String file_type) {
    this.fileName = fileName;
    this.setFile_type(file_type);

  }

  public void setPermissions(String fileName, int new_perms_level) {
    this.fileName = fileName;
    this.setNew_perms_level(new_perms_level);

  }

  public int getNew_perms_level() {
    return new_perms_level;
  }

  public void setNew_perms_level(int new_perms_level) {
    this.new_perms_level = new_perms_level;
  }

}