import java.util.Scanner;
import setup_type.setup_type.setup_type;

public class Main {
  public static Scanner getInfo = new Scanner(System.in);

  // Getting type
  public static void TYPE() {
    System.out.print("SETUP TYPES:\n1. Port\n2. Connect\n3. Reg\n\nSetup Type: ");
    String get_type = getInfo.nextLine();
    // These should work well being hard coded
    if (get_type.equals("1")) {
      get_type = "port";
    } else if(get_type.equals("2")) {
      get_type = "connect";
    } else if(get_type.equals("3")) {
      get_type = "reg";
    } else if(!get_type.equals("1") || !get_type.equals("2") || !get_type.equals("3")) {
      // Nothing should change. I just didn't want this to be empty
      get_type = get_type;
    }
    setup_type set_t = new setup_type();
    try {
      set_t.getSetupType(get_type);
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    TYPE();
  }
}
