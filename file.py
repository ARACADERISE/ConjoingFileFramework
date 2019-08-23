"""
  The MIT License
  Copyright (c) 2019 ARACADERISE (GetStuffDone)
  
  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
  documentation files (the "Software"), to deal in the Software without restriction, including without limitation the 
  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit 
  persons to whom the Software is furnished to do so, subject to the following conditions:
  
  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
  
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES 
  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE 
  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR 
  IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
"""

import os
import sys
from comm.set_file_port import *

# *NOTE: This is basically overriden at conjoin_path
path = str(sys.path[0])

# This application will compile for linux
if sys.platform == 'linux':
  # Overriding path. adds additional /
  conjoin_path = os.path.join(path, "")
  path_set_up = True
else:
  raise Exception('Error: ConjoiningFileFramework cannot function on a device OTHER THAN a linux supported platform platform')

# This will be where the application runs
while path_set_up:
  have_to_connect = input('Do you have a json file you would like to connect to cff_db.json[y/n] >> ')
  if have_to_connect == 'y' or have_to_connect == 'Y':
    get_file = input('\n.json File Name >> ')
    if not '.json' in get_file:
      get_file += '.json'
    get_abs_path = os.path.abspath(get_file)
    if os.path.exists(conjoin_path+get_file):
      connect_to(get_abs_path)
  break
