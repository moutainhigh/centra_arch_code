#!/bin/sh
#env
APP_NAME="aijob.console.web"

#set base home
RESOURCES_HOME=${CATALINA_HOME}/webapps/ROOT/WEB-INF/classes

#change config
pushd ${RESOURCES_HOME}
popd


nohup ${CATALINA_HOME}/bin/catalina.sh run >> /${APP_NAME}.log
