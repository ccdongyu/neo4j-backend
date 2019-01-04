userid=$1
contents=$2
curl --header 'Content-Type: application/json'\
	--request POST\
	--data '{"userid":"'$userid'", "contents":"'$contents'"}' \
	http://localhost:8888/Dynamic/create
read -s -n1 -p "press any key to continue... "