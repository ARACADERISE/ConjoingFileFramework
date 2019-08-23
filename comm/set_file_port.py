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

"""
  *NOTE: If you have a json file, make sure you having a "connection_with_cff": true in it with "PORT":"18080"
  *NOTE: This file is for JSON files wanting to comminicate with our JSON file
  *NOTE: It clearly states in cff_db.json - ports_type: 18080
"""

import os, time, sys, json

DATA = {
  "use":"connections",
  "connections_with":"ports",
  "ports_type":"18080",
  "port_data":None
  }

# Opening cff_db.json file
with open('cff_db.json','w') as file:
  to_json = json.dumps(DATA, indent=2, sort_keys=True)
  file.write(to_json)
  file.close()

status_codes = [
  # FOUND
  str(202),
  # NOT FOUND
  str(404)
]
status_port = [DATA]

# This will open a file, read for a value and return a 202 or 404
def connect_to(opening_file):
  # Global variabes
  global status_codes
  global status_port

  if not '"connection_with_cff":true' or not '"PORT":"18080"' in open(opening_file,'r').read():
    raise Exception("Error " + status_codes[1] + ": Not found")
    return "Error " + status_codes[1]
  if '"connection_with_cff":true' and '"PORT":"18080"' in open(opening_file,'r').read():
    status_port.append({'status':status_codes[0],'PORT':True})
    with open('cff_db.json','w') as file:
      to_json = json.dumps(status_port,indent=2,sort_keys=True)
      file.write(to_json)
      file.close()
    return "Success. Status " + status_codes[0]
