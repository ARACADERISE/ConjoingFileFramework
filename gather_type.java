package gather_type.gather_type;

import java.util.Arrays;
import java.util.ArrayList;
import write.write.write;
import use_type.use_type.use_type;

public class gather_type {
  // Global variables that will be used throughout gather_type
  private String type_chosen;
  private String types;
  private boolean is_ready = false;
  private int max = 0;
  private write write_to_file = new write();
  private use_type u_t = new use_type();

  public void setTheType(String[] types,String type_is, ArrayList<String> add_to_data) {
    this.type_chosen = type_is;
    this.types = Arrays.toString(types);

    // This will iterate through this.types and find the index of this.type_chosen
    for(int i = 0; i < this.types.length(); i++) {
      if(this.type_chosen.equals(types[i])) {
        this.type_chosen = this.type_chosen;
        add_to_data.add(this.type_chosen);
        add_to_data.remove(0);
        this.is_ready = true;
        break;
      }
    }

    do {
      this.write_to_file.write_data(add_to_data,add_to_data,this.is_ready);
      System.out.println(this.type_chosen);
      u_t.get_type_to_return(this.type_chosen);
      try {
        u_t.use_type_(add_to_data);
      } catch(Exception e) {
        System.out.println(e);
      }
      u_t.return_all_vals();
      break;
    } while(this.is_ready);
  }
}
