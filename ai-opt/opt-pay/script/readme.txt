1.编译打包
#一定要先clean
gradle clean
#然后再打包
gradle build -x test
2.生成镜像
#在本地生成带私服前缀的镜像
docker build -t 10.19.13.20:5000/opt-pay:v1.0 .   (每次打镜像前版本号要更新)
#将镜像推送到私服
docker push 10.19.13.20:5000/opt-pay:v1.0

3. 运行镜像
#--net=host  表示为主机(host)模式  去掉该配置，默认为桥接(bridge)模式
#-e 代表需要设置的环境变量
docker run -d --name opt-pay -p 10886:10886 \
-e "REST_REGISTRY_ADDR=10.19.13.23:29181" \
-e "REST_PORT=10886" \
-e "CONTEXT_PATH=opt-pay" \
-e "SDK_MODE=0" \
-e "PAAS_AUTH_URL=http://10.1.245.4:19811/service-portal-uac-web/service/auth" \
-e "PAAS_AUTH_PID=D14F7D708109471AB6F3084B2ABAE9A6" \
-e "PAAS_CCS_ID=CCS004" \
-e "PAAS_CCS_PWD=123456" \
-e "SRVAREA_ALL=cn.hb,us.ea"  \
-e "SRVAREA_CURR=cn.hb"  \
10.19.13.20:5000/opt-pay:v1.0_5

#查看镜像启动日志
docker logs opt-pay
#进入容器，查看镜像内部的情况
docker exec -it opt-pay /bin/bash
#删除运行的容器
docker rm -fv opt-pay

#=============更新日志========================#
*2016-09-23
1）初始版本