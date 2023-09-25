#Problem Stmt:
We need to create standard JSON from a predefined csv file
All test data will be filled in csv in given format and we will read and create JSON which can be sent in POST request or anywhere


#sample output json
{"Employee":[{"Name":"Sheetal","Surname":"Singh","Age":"34","Address":{"Hno":"101","Block":"B2","Area":"Kharadi","State":"Maharashtra","AddressGeo":{"Lat":"400","Long":"300"}},"Office":{"Office-A":{"Name":"Xebia","Client":"Grnd","Teamsize":"2"},"Office-B":{"Name":"EPAM","Client":"MC","Teamsize":"10"}}},{"Name":"John","Surname":"Brown","Age":"35","Address":{"Hno":"100","Block":"M2","Area":"VN","State":"Delhi","AddressGeo":{"Lat":"1000","Long":"2000"}},"Office":{"Office-A":{"Name":"Barclays","Client":"VISA","Teamsize":"10"},"Office-B":{"Name":"Quarts","Client":"FK","Teamsize":"20"}}}]}

#Ref:
https://codebeautify.org/jsonviewer/9378c5
http://www.jsonschema2pojo.org/
http://www.convertcsv.com/json-to-csv.htm