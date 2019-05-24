
for i in $(seq 101 10000)
do
curl -X POST \
  http://localhost:9000/person \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 8f553439-b534-4375-a4b1-30caa6793fa6' \
  -H 'cache-control: no-cache' \
  -d '{"personId":'$i',"firstName":"wavelabs'$i'","lastName":"company","email":"wavelabs@company.com"}'

curl -X GET \
  http://localhost:9000/person/$i \
  -H 'Postman-Token: 7a01b115-17c8-46ce-9cfd-174489d28960' \
  -H 'cache-control: no-cache'

  echo $i

  sleep `expr $RANDOM % 10`

done
