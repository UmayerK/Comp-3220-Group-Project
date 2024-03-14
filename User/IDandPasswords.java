
package User;

import java.util.HashMap;

public class IDandPasswords {

  HashMap<String, String> logininfo = new HashMap<String, String>();

  IDandPasswords() {

    logininfo.put("user1", "password");
    logininfo.put("user2", "PASSWORD");
    logininfo.put("user@gmail.com", "abc123");
  }

  public HashMap getLoginInfo() {
    return logininfo;
  }
}