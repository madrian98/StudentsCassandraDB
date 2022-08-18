import pandas as pd
import requests

data_database = "enterprise.csv"
post_address = "http://localhost:8080/api/persons"

db = pd.read_csv(data_database)

for _, row in db.iterrows():
    id,first_name,last_name,email, gender, city, country, job_title, company_name, car_make, model_year = row
    request_json = {
       "id":id,
       "first_name":first_name,
       "last_name":last_name,
       "email":email,
       "gender":gender,
       "city":city,
       "country":country,
       "job_title":job_title,
       "company_name":company_name,
       "car_make":car_make,
       "model_year":model_year
    }
    r = requests.post(post_address, json=request_json)
    if r.status_code != 200:
        print("Request for id {} unsuccessful".format(id))
