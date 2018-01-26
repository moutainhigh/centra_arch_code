FROM 10.19.13.36:5000/jdk:7
MAINTAINER gucl<gucl@asiainfo.com>

#Install tomcat7
ADD ./apache-tomcat-7.0.73.tar.gz /opt/
RUN mv /opt/apache-tomcat-7.0.73 /opt/tomcat &&  ls /opt/tomcat

RUN sed -i '/\# OS/i JAVA_OPTS="$JAVA_OPTS  -server -Xms1400M -Xmx1400M -XX:PermSize=128M -XX:MaxPermSize=256M  -XX:+UseConcMarkSweepGC -XX:ParallelGCThreads=8 -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+HeapDumpOnOutOfMemoryError" \n if [[ "$JAVA_OPTS" != *-Djava.security.egd=* ]]; then \n   JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom" \n  fi'  /opt/tomcat/bin/catalina.sh

RUN sed -i 's%redirectPort="8443" />%redirectPort="8443" URIEncoding="UTF-8"/>%g' /opt/tomcat/conf/server.xml


ENV CATALINA_HOME /opt/tomcat
ENV PATH $PATH:$CATALINA_HOME/bin  
ENV PATH $CATALINA_HOME/bin:$PATH

#Expose ports.  
EXPOSE 8080