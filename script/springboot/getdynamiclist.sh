userid=$1
curl --header 'Content-Type: application/json'\
	--request POST\
	--data '{"userid":"'$userid'"}' \
	http://localhost:8888/Dynamic/getList
read -s -n1 -p "press any key to continue... "