curl --header 'Content-Type: application/json'\
	--request PATCH\
	--data '{"born":1600}' \
	http://localhost:8888/persons/163
read -s -n1 -p "press any key to continue... "