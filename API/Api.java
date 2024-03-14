package API;

class API {

  protected String fileName;
  private String criterion;
  private String id;
  private int Dataformats;
  private String user_name;
  private String passWord;

  public void queryData(String fileName, String criterion) {
    this.fileName = fileName;
    this.criterion = criterion;

  }

  public String getData_id() {
    return id;

  }

  public int getDataformats() {
    return Dataformats;

  }

  public String getDatasets() {
    return fileName;
  }

  public void authenticateUser(String user_name, String passWord) {
    this.user_name = user_name;
    this.passWord = passWord;
  }
}
