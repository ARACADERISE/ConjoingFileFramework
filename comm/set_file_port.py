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
  
  *NOTE:
  - Type "reg": [] and type in files you want to automatically combine within the json file inside the array. it will then be appended to "regulated":[] inside the cff_db.json
"""

import os, time, sys, json

DATA = {
  "use":"connections",
  "connections_with":"ports",
  "ports_type":"18080",
  "port_data":None,
  "regulated":[None]
  }

# Opening cff_db.json file
with open('cff_db.json','w') as file:
  to_json = json.dumps(DATA, indent=1, sort_keys=False)
  file.write(to_json)
  file.close()

# GLOBAL VARIABLES
status_codes = [
  # FOUND
  str(202),
  # NOT FOUND
  str(404)
]
status_port = [DATA]
REGULATE_FILES = [DATA]
APPENDED = []

# This will open a file, read for a value and return a 202 or 404
def connect_to(opening_file):
  # Global variabes
  global status_codes
  global status_port
  global REGULATE_FILES
  global APPENDED
  # Will be needed for getting index of regulated, since status_port is a list
  global DATA

  # This will help render the error or not
  is_invalid = False

  # This will render whether or not the files are ready to be regulated
  is_ready = False

  if not '"connection_with_cff":true' or not '"PORT":"18080"' in open(opening_file,'r').read():
    is_invalid = True
    status_port.append({'status':status_codes[1], 'response':[f'{opening_file}:-->FAILED']})
    with open('cff_db.json','w') as file:
      to_json = json.dumps(status_port,indent=2,sort_keys=False)
      file.write(to_json)
      file.close()

    if is_invalid:
      time.sleep(2)
      raise Exception("Error " + status_codes[1] + ": Not found")
      return "Error " + status_codes[1]
  if '"reg"' in open(opening_file,'r').read():
    # we will only need to check for [ since there has to be a co-responding ending tag
    if not '"reg":[' in open(opening_file,'r').read():
      is_invalid = True
      status_port.append({'status':status_codes[1],'response':[f'{opening_file}:-->FAILED']})
      with open('cff_db.json','w') as file:
        to_json = json.dumps(status_port,indent=1,sort_keys=False)
        file.write(to_json)
        file.close()
      if is_invalid:
        raise Exception("Error " + status_codes[1] + ": \"reg\":[] not found")
        return "Error " + status_codes[1]
    else:
      use = json.loads(open(opening_file,'r').read())
      get_len = len(DATA['regulated'])
      for i in use['reg']:
        got_data = use['reg']
      i = len(got_data)
      # Not the best way to state this, but it's the quickest way
      for i in got_data:
        if None in DATA['regulated']:
          DATA['regulated'] = []
        while True:
          DATA['regulated'].append(f'{i}')
          APPENDED = DATA['regulated']
          break
      is_ready = True
  if is_ready:
    while True:
      for i in range(len(APPENDED)-1):
        DATA['regulated'].append({f'{APPENDED[i]}_REGULATED_WITH_{APPENDED[i+1]}:-->TO':[f'{APPENDED[i]}_{APPENDED[i+1]}']})
      break
  if '"connection_with_cff":true' and '"PORT":"18080"' in open(opening_file,'r').read():
    status_port.append({'status':status_codes[0],'PORT':True})
    with open('cff_db.json','w') as file:
      to_json = json.dumps(status_port,indent=1,sort_keys=False)
      file.write(to_json)
      file.close()
    return "Success. Status " + status_codes[0]
