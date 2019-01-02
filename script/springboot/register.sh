userid=$1
curl --header 'Content-Type: application/json'\
	--request POST\
	--data '{"userid":"'$userid'", "password":"123456", "username":"cc", "sex":"true" }' \
	http://104.160.43.250:8888/user/register
