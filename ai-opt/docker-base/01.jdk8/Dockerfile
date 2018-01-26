FROM centos:7
MAINTAINER gucl<gucl@asiainfo.com>

RUN cd /etc && rm -f localtime && ln -s  /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
ENV LANG en_US.UTF-8

# Install oracle jdk8
ADD ./jdk-8u101-linux-x64.tar.gz /opt

RUN ls /opt/jdk1.8.0_101 

ENV JAVA_HOME /opt/jdk1.8.0_101
ENV PATH $PATH:$JAVA_HOME/bin
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar