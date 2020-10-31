import requests
import json


def send(upload_address):
    # url = 'http://10.10.64.221:8088/saveTraffic'
    url=upload_address
    with open("record.json","r") as f:
        all_data=json.load(f)

    for key in all_data.keys():
        print(all_data[key])
        r=requests.post(url,all_data[key])
        print(r.text)

# upload_address = 'http://10.10.64.221:8088/saveTraffic'
# send(upload_address)