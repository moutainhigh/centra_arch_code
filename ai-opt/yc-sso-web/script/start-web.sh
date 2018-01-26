#!/bin/sh
#env
APP_NAME="yc.sso.web"

#set base home
RESOURCES_HOME=${CATALINA_HOME}/webapps/ROOT/WEB-INF/classes

#change config
pushd ${RESOURCES_HOME}
sed -i "s%casServerLoginUrl=.*%casServerLoginUrl=${casServerLoginUrl}%g" ./sso.properties
sed -i "s%casServerUrlPrefix=.*%casServerUrlPrefix=${casServerUrlPrefix}%g" ./sso.properties
sed -i "s%serverName=.*%serverName=${serverName}%g" ./sso.properties
sed -i "s%logOutServerUrl=.*%logOutServerUrl=${logOutServerUrl}%g" ./sso.properties
sed -i "s%logOutBackUrl=.*%logOutBackUrl=${logOutBackUrl}%g" ./sso.properties
sed -i "s%casServerLoginUrl_Inner=.*%casServerLoginUrl_Inner=${casServerLoginUrl_Inner}%g" ./sso.properties
sed -i "s%casServerUrlPrefix_Inner=.*%casServerUrlPrefix_Inner=${casServerUrlPrefix_Inner}%g" ./sso.properties
sed -i "s%serverName_Inner=.*%serverName_Inner=${serverName_Inner}%g" ./sso.properties
sed -i "s%logOutServerUrl_Inner=.*%logOutServerUrl_Inner=${logOutServerUrl_Inner}%g" ./sso.properties
sed -i "s%logOutBackUrl_Inner=.*%logOutBackUrl_Inner=${logOutBackUrl_Inner}%g" ./sso.properties
sed -i "s%innerDomains=.*%innerDomains=${innerDomains}%g" ./sso.properties

sed -i "s%whiteList=.*%whiteList=${whiteList}%g" ./whitelist.properties

sed -i "s%paas.auth.url=.*%paas.auth.url=${PAAS_AUTH_URL}%g" ./paas/paas-conf.properties
sed -i "s%paas.auth.pid=.*%paas.auth.pid=${PAAS_AUTH_PID}%g" ./paas/paas-conf.properties
sed -i "s%paas.ccs.serviceid=.*%paas.ccs.serviceid=${PAAS_CCS_ID}%g" ./paas/paas-conf.properties
sed -i "s%paas.ccs.servicepassword=.*%paas.ccs.servicepassword=${PAAS_CCS_PWD}%g" ./paas/paas-conf.properties

sed -i "s%paas.sdk.mode=.*%paas.sdk.mode=${SDK_MODE}%g" ./paas/paas-conf.properties
sed -i "s%ccs.appname=.*%ccs.appname=${CCS_NAME}%g" ./paas/paas-conf.properties
sed -i "s%ccs.zk_address=.*%ccs.zk_address=${ZK_ADDR}%g" ./paas/paas-conf.properties

sed -i "s%dubbo.registry.address=.*%dubbo.registry.address=${REST_REGISTRY_ADDR}%g" ./dubbo.properties

#FocusSms.properties
sed -i "s%SoaServerIpAddressA=.*%SoaServerIpAddressA=${SoaServerIpAddressA}%g" ./FocusSms.properties
sed -i "s%SoaServerIpPortA=.*%SoaServerIpPortA=${SoaServerIpPortA}%g" ./FocusSms.properties
sed -i "s%HttpServerIpAddressA=.*%HttpServerIpAddressA=${HttpServerIpAddressA}%g" ./FocusSms.properties
sed -i "s%HttpServerPortA=.*%HttpServerPortA=${HttpServerPortA}%g" ./FocusSms.properties
sed -i "s%TcpServerAddressA=.*%TcpServerAddressA=${TcpServerAddressA}%g" ./FocusSms.properties
sed -i "s%TcpServerPortA=.*%TcpServerPortA=${TcpServerPortA}%g" ./FocusSms.properties
sed -i "s%TcpReceivePort=.*%TcpReceivePort=${TcpReceivePort}%g" ./FocusSms.properties
sed -i "s%soapnamespace=.*%soapnamespace=${soapnamespace}%g" ./FocusSms.properties
sed -i "s%yeecloudUser=.*%yeecloudUser=${yeecloudUser}%g" ./FocusSms.properties
sed -i "s%yeecloudPassword=.*%yeecloudPassword=${yeecloudPassword}%g" ./FocusSms.properties
sed -i "s%MessageFormYeecloud=.*%MessageFormYeecloud=${MessageFormYeecloud}%g" ./FocusSms.properties

popd


nohup ${CATALINA_HOME}/bin/catalina.sh run >> /${APP_NAME}.log