package use_type.use_type;

import use_type_setup.use_type_setup.use_type_setup;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class use_type extends use_type_setup {
  // Globabl variables
  private String type;
  private Scanner get_line = new Scanner(System.in);
  private ArrayList<String> return_data;

  // Overriding the function, or calls
  @Override
  public String get_type_to_return(String type_to_return) {
    this.type = type_to_return;
    return this.type;
  }
  @Override
  public void use_type_(ArrayList<String> data) throws Exception {
    ArrayList<String> return_data = new ArrayList<String>();
    if(this.type.equals("port")) {
      System.out.print("Port Name: ");
      String get_port_type = this.get_line.nextLine();
      data.add("port_name::-->"+get_port_type);
      this.return_data = data;
    } else if(this.type.equals("connection")) {
      System.out.println(this.type);
    } else if(this.type.equals("reg")) {
      System.out.println(this.type);
    } else {
      throw new Exception("Type could not be confirmed");
    }
  }
  @Override
  public String return_all_vals() {
    // Taking this.return_data from ArrayList to a simple string
    // So we can return it
    for(int i = 0; i < this.return_data.size()-1; i++) {
      String s = this.return_data.get(i)+", "+this.return_data.get(i+1);
      return s;
    }
    return this.type;
  }
}
