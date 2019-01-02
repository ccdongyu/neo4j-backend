userid=$1
curl \
	http://localhost:8888/user/friend_list?userid=$userid
