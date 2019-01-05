nodeid=$1
curl \
    --request DELETE \
	http://localhost:8888/Dynamic/delete?nodeid=$nodeid
read -s -n1 -p "press any key to continue... "