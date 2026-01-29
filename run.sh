docker pull mysql:oraclelinux9
docker run --name sistemabecas-db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD -e MYSQL_DATABASE=sistemabecas -d mysql:oraclelinux9