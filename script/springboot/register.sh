userid=$1
curl --header 'Content-Type: application/json'\
	--request POST\
	--data '{"userid":"'$userid'", "password":"123456", "username":"cc", "sex":"true" }' \
	http://localhost:8888/user/register
read -s -n1 -p "press any key to continue... "