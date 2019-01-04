userid=$1
password=$2
curl "http://localhost:8888/user/login?userid=${userid}&password=${password}"
read -s -n1 -p "press any key to continue... "
