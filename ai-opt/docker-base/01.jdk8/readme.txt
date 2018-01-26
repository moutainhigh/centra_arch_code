docker build -t 10.19.13.36:5000/jdk:8 .
docker push 10.19.13.36:5000/jdk:8
docker run -d --name jdk8  10.19.13.36:5000/jdk:8 sleep 99999999
docker exec -it jdk7 /bin/bash 

