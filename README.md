# medzee
Below are the curls 

#Get by EID - for registration
curl --location --request GET 'http://localhost:8081/medzee/api/v1/eid/784-1989-9475731-1'

save user during registration

curl --location --request POST 'http://localhost:8081/medzee/api/v1/users/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "eid": "784-1989-9475731-1",
    "password": "password"
}'

get user by id
curl --location --request GET 'http://localhost:8081/medzee/api/v1/users/1'






