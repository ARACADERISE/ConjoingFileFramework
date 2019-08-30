package gather_type.gather_type;

import java.util.Arrays;
import java.util.ArrayList;
import write.write.write;

public class gather_type {
  // Global variables that will be used throughout gather_type
  public String type_chosen;
  public String types;
  public boolean is_ready = false;
  public int max = 0;
  public write write_to_file = new write();

  public void setTheType(String[] types,String type_is, ArrayList<String> add_to_data) {
    this.type_chosen = type_is;
    this.types = Arrays.toString(types);

    // This will iterate through this.types and find the index of this.type_chosen
    for(int i = 0; i < this.types.length(); i++) {
      if(this.type_chosen.equals(types[i])) {
        this.type_chosen = "type: "+this.type_chosen;
        add_to_data.add(this.type_chosen);
        add_to_data.remove(0);
        this.is_ready = true;
        break;
      }
    }

    do {
      this.write_to_file.write_data(add_to_data,add_to_data,this.is_ready);
      break;
    } while(this.is_ready);
  }
}
