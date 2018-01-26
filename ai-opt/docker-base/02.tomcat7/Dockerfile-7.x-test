FROM 10.19.13.36:5000/jdk:7
MAINTAINER gucl<gucl@asiainfo.com>

#Install tomcat7
ADD ./apache-tomcat-7.0.73.tar.gz /opt/
RUN mv /opt/apache-tomcat-7.0.73 /opt/tomcat &&  ls /opt/tomcat

RUN sed -i '/\# OS/i JAVA_OPTS="$JAVA_OPTS  -server -Xms1400M -Xmx1400M -XX:PermSize=128M -XX:MaxPermSize=256M -XX:-UseGCOverheadLimit -XX:+UseConcMarkSweepGC -XX:ParallelGCThreads=8 -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+HeapDumpOnOutOfMemoryError" \n if [[ "$JAVA_OPTS" != *-Djava.security.egd=* ]]; then \n   JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom" \n  fi'  /opt/tomcat/bin/catalina.sh

RUN sed -i 's%redirectPort="8443" />%redirectPort="443" URIEncoding="UTF-8"/>%g' /opt/tomcat/conf/server.xml

RUN sed -i 's%<Connector port="8080" protocol="HTTP/1.1"%<Connector port="8080" protocol="HTTP/1.1"  proxyPort="443" minSpareThreads="25" maxSpareThreads="75" enableLookups="false" disableUploadTimeout="true"  acceptCount="300"  maxThreads="300" maxProcessors="1000" minProcessors="10" useURIValidationHack="false"  %g' /opt/tomcat/conf/server.xml

RUN sed -i 's%unpackWARs="true" autoDeploy="true">%unpackWARs="true" autoDeploy="true"> \n <Valve className="org.apache.catalina.valves.RemoteIpValve" \n       remoteIpHeader="x-forwarded-for" \n       remoteIpProxiesHeader="x-forwarded-by"\n       protocolHeader="x-forwarded-proto"/> \n  %g' /opt/tomcat/conf/server.xml

ENV CATALINA_HOME /opt/tomcat
ENV PATH $PATH:$CATALINA_HOME/bin  
ENV PATH $CATALINA_HOME/bin:$PATH

#Expose ports.  
EXPOSE 8080