userid=$1
curl \
	http://localhost:8888/user/friend_list?userid=$userid
read -s -n1 -p "press any key to continue... "
