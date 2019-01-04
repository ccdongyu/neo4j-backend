id=189
curl \
	--request DELETE\
	http://localhost:8888/persons/${id}
read -s -n1 -p "press any key to continue... "