package setup_type.setup_type;

/*
  - This file will be the setup of the type of data
  - That will be written into the file
*/

import java.util.ArrayList;
import java.util.Collections;
import gather_type.gather_type.gather_type;

public class setup_type {
  // These will be the setup types for what the .txt file will be
  public enum types {
    port,
    connect,
    reg
  }

  private ArrayList<String> type_data = new ArrayList<String>();
  private gather_type type = new gather_type();
  

  // This will be initialized a value for this.final_ to work
  private String TYPE;
  // We want to check the value of this.TYPE through this.final_
  private String final_;
  // This will set the course for using the signal
  private boolean is_ready;
  // This will be bytes for official setup
  private int max = 0;
  // This will be the total amount of bytes for this.max
  private int total = 2;
  // Setup types for gather_type
  private static String[] SETUP_TYPES = {"port","connect","reg"};

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
      case "connect":
        types connect = types.connect;
        if(connect.equals(types.connect)) {
          this.final_ = this.TYPE;
          this.type_data.add(this.final_);
        }
        break;
      case "reg":
        types reg = types.reg;
        if(reg.equals(types.reg)) {
          this.final_ = this.TYPE;
          this.type_data.add(this.final_);
        }
        break;
      case "err":
        this.final_ = this.TYPE+"or";
        this.type_data.add("setup_type_"+this.final_);
        break;
    }

    if(this.final_.equals(this.TYPE)) {
      this.is_ready = true;
      type.setTheType(this.SETUP_TYPES,this.final_,this.type_data);
    } else if(!this.final_.equals(this.TYPE)) {
      this.is_ready = false;
      System.out.println(this.final_+": User did not choose a correct setup type with response of " + this.TYPE);
    }
    do {
      Collections.sort(this.type_data);
      this.max += 1;
      // We don't want to use all of this.total
      // Since the rest of the list will already be sorted we will save an extra byte since the last one will not need to be sorted
      if(this.max == this.type_data.size()-1) {
        this.total -= this.max;
        break;
      }
    } while (this.is_ready && this.max < this.total);
    //while (this.is_ready && this.max < this.total) {
    //  Collections.sort(this.type_data);
    //  this.max += 1;
    //  if(this.max == this.total) {
    //    break;
    //  }
    //}
  }
}
