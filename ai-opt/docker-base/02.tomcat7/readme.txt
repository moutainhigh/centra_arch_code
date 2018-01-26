docker build -t 10.19.13.36:5000/tomcat:7 .
docker push 10.19.13.36:5000/tomcat:7
docker run -d --name tomcat7  10.19.13.18:5000/tomcat:7 sleep 99999999
docker exec -it tomcat7 /bin/bash 

#以后的项目，推荐用7.x
docker build -t 10.19.13.36:5000/tomcat:7.x .
docker push 10.19.13.36:5000/tomcat:7.x
docker run -d --name tomcat7  10.19.13.36:5000/tomcat:7.x sleep 99999999
docker exec -it tomcat7.x /bin/bash 

#国际化的项目，推荐用7.x-GMT 
docker build -t 10.19.13.36:5000/tomcat:7.x-GMT .
docker push 10.19.13.36:5000/tomcat:7.x-GMT