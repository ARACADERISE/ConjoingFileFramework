package use_type.use_type;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import use_type_setup.use_type_setup.use_type_setup;
import write.write.write;
import convert_to_json.convert_to_json.convert_to_json;

public class use_type extends use_type_setup {
  // Globabl variables
  private String type;
  private Scanner get_line = new Scanner(System.in);
  private ArrayList<String> return_data;
  private write w_f = new write();
  private convert_to_json json_it = new convert_to_json();
  // This will be used within the "connect" category
  private String s;

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
      json_it.GET_NAME_INFO(data.get(1));
      this.return_data = data;
    } else if(this.type.equals("connect")) {
      System.out.print("File Name: ");
      String file_dir = this.get_line.nextLine();
      File con_to_dir = new File(file_dir);
      data.add("connect_to_file::-->"+con_to_dir);
      json_it.GET_NAME_INFO(data.get(1));
      Scanner read_file = new Scanner(con_to_dir);
      do {
        this.s = read_file.next();
        return_data.add(this.s);
        json_it.GET_FILE_READ_INFO(file_dir,return_data,this.type);
      } while(read_file.hasNext());
      if(con_to_dir.canRead()) {
        System.out.println("\n\nConnection Made\nStatus 202");
      } else {
        throw new Exception("Error whilst connecting");
      }
      w_f.get_data(file_dir,this.s, con_to_dir.canRead());
      this.return_data = data;
    } else if(this.type.equals("reg")) {
      System.out.println(this.type);
    } else {
      throw new Exception("Type could not be confirmed");
    }
    if(!(this.type.equals("connect"))) {
      json_it.JSON_IT(this.type);
    }
  }
  @Override
  public String return_all_vals() {
    // Taking this.return_data from ArrayList to a simple string
    // So we can return String
    for(int i = 0; i < this.return_data.size()-1; i++) {
      String s = this.return_data.get(i)+", "+this.return_data.get(i+1);
      return s;
    }
    return this.type;
  }
}
