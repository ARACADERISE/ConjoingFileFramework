package setup_type.setup_type;

/*
  - This file will be the setup of the type of data
  - That will be written into the file
*/

import java.util.ArrayList;
import java.util.Collections;

public class setup_type {
  // These will be the setup types for what the .txt file will be
  public enum types {
    port,
    connect,
    reg
  }

  public ArrayList<String> type_data = new ArrayList<String>();

  // This will be initialized a value for this.final_ to work
  public String TYPE;
  // We want to check the value of this.TYPE through this.final_
  public String final_;
  // This will set the course for using the signal
  public boolean is_ready;

  public void getSetupType(String type_) {
    this.TYPE = type_;

    switch(this.TYPE) {
      case "port":
        types port = types.port;
        if (port.equals(types.port)) {
          this.final_ = this.TYPE;
          this.type_data.add(this.final_);
        }
        break;
      case "err":
        this.final_ = this.TYPE+"or";
        break;
    }

    if(this.final_.equals(this.TYPE)) {
      this.is_ready = true;
    } else if(!this.final_.equals(this.TYPE)) {
      this.is_ready = false;
      System.out.println(this.final_+": User did not choose a correct setup type");
    }
    while (this.is_ready) {
      Collections.sort(this.type_data);
      break;
    }
  }
}
