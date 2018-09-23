#依赖的镜像
FROM node:latest
#镜像创建者的信息
MAINTAINER samueltango "samueltango@gmail.com"
#执行mkdir helloDocker创建一个helloDocker文件夹
RUN mkdir myDocker
#将app.js添加到helloDocker文件夹中
ADD myDocker /myDocker
WORKDIR /myDocker
RUN npm install
#容器运行时启动的命令
CMD node app.js
