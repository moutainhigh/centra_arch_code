docker build -t 10.19.13.36:5000/jdk:7 .
docker push 10.19.13.36:5000/jdk:7
docker run -d --name jdk7  10.19.13.36:5000/jdk:7 sleep 99999999
docker exec -it jdk7 /bin/bash 

