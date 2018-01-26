# 离线测试工具 支持参数模板智能识别，是RPC服务的测试的重要工具。请按照下列说明获取离线测试工具包应用。
##1.您本地的环境准备
#####准备安装gradle，配置好gradle环境变量。执行 windows cmd或者unix 执行 gradle -version 看是否能看到版本号。如果是，则安装成功
#####安装git。
##2.从gitHub获取源代码
##### 进入指定目录 cd yourdir
##### 执行 git clone git@github.com:AI-OPT/opt-stester.git
##### cd yourdir/opt-stester
##### gradle zipRelease
##### 构建完成后进入 yourdir/opt-stester/release/ 看到 opt-stester.zip；copy到您的某个本地目录解压即可
## 3.修改配置文件 opt-stester/conf/jetty.properties
#####修改jetty监听端口jetty.connector.port=8080
#####如果要是部署在在windows下，需要修改目应用入口为：jetty.web.appRoots=/test=../src/main/webapp
#####如果部署在Linux下则需要需要修改目应用入口为：jetty.web.appRoots=/test=src/main/webapp
#####如果下载代码后在本地使用tomacat作为服务器运行，为预防冲突则需要在build.gradle文件中将compile 'org.mortbay.jetty:jsp-2.1-jetty:6.1.26'注释掉
## 4. 启动服务
#### 执行 opt-stester/bin/  windows下执行start.bat  unix执行start.sh
## 5.访问
#### 访问http//localhost:8080/opt-stester/api/index.html 即可以看到离线测试界面。此时，首页上可能没有服务数据
## 6.服务索引数据导入
#### 测试需要服务的索引数据，您参考离线测试上的帮助手册，在通过gradle插件将数据采集到服务在线，然后在从在线网扎下载数据，导入的服务离线工具上。


