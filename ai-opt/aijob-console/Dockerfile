# Pull base image
FROM 10.19.13.36:5000/tomcat:8.x-GMT
MAINTAINER gucl<gucl@asiainfo.com>

RUN rm -rf /opt/tomcat/webapps/* && mkdir /opt/tomcat/webapps/ROOT

COPY ./build/libs/aijob-console.war /opt/tomcat/webapps/ROOT/ROOT.war
RUN cd /opt/tomcat/webapps/ROOT && jar -xf ROOT.war && rm -rf /opt/tomcat/webapps/ROOT.war

ADD ./script/start-web.sh /start-web.sh
RUN chmod 755 /*.sh

# Define default command.
CMD ["/start-web.sh"]