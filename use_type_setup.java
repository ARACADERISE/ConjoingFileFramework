package use_type_setup.use_type_setup;

import java.util.ArrayList;

// We just want to use an abstract class cause why not :)
public abstract class use_type_setup {
  // This will set up the use_type() function
  abstract public String get_type_to_return(String type_to_return);
  // This will give the type being used a use
  abstract public void use_type_(ArrayList<String> data) throws Exception;
  // This will return all values and or data
  abstract public String return_all_vals();
}
