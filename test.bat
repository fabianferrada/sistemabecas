docker pull mysql:oraclelinux9
docker container stop testdb
docker container remove testdb
docker run --name testdb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=sistemabecas -v ./db:/docker-entrypoint-initdb.d -d mysql:oraclelinux9