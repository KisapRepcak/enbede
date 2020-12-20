#!/usr/bin/python3

import riak


#db connection
myClient = riak.RiakClient(pb_port=8087)
myBucket = myClient.bucket('s23788')

my_new_value = {"firstName": "Pawel", "lastName": "Mieszko", "gender": "male", "age": 98, 
"address": {"streetAddress": "23", "city": "New York", "state": "US", "postalCode": "12341"}, "phoneNumbers": [{ "type": "mobile", "number": "6264234334" }]}
print("*************************")
#add value
print("Adding value.")
key1 = myBucket.new('one', data=my_new_value)
key1.store()
fetched1 = myBucket.get('one')
print("RAW DATA:\n" + str(fetched1.data))
print("*************************")
#modify value
print("Editing value.")
fetched1.data["firstName"] = "Kamil"
fetched1.store()
fetched2 =  myBucket.get('one')
print("RAW DATA:\n" + str(fetched2.data))
print("*************************")
#delete value
print("Deleting value.")
fetched2.delete()
try:
    fetched3 = myBucket.get('one')
    print("RAW DATA:\n" + str(fetched3.data))
except Exception as e:
    print(e)