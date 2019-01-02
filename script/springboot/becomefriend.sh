userid=$1
friendid=$2
curl \
	--data "userid=$userid&friend_id=$friendid"\
	http://localhost:8888/user/friend_add
