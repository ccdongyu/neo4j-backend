userid=$1
curl  --header 'Content-Type: application/json'\
    --request GET\
	http://localhost:8888/Dynamic/getList?userid=${userid}
read -s -n1 -p "press any key to continue... "