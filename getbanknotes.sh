KEY=$1
VALUE=$2
curl -H "Content-Type: application/json" -X POST -d '{"registerKey":"'"$KEY"'","value":"'"$VALUE"'"}' http://localhost:8080/api/get/banknotes