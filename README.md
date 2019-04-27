1.安装虚拟机centos 7.5
  关闭防火墙：systemctl stop iptables
  systemctl disable iptables
  
2.安装docker,docker-compose
	$sudo yum update
	$sudo tee /etc/yum.repos.d/docker.repo<<-'EOF'
	[dockerrepo]
	name=Docker Repository
	baseurl=https://yum.dockerproject.org/repo/main/centos/7/
	enabled=1
	gpgcheck=1
	gpgkey=https://yum.dockerproject.org/gpg
	EOF
	
	$ sudo yum install docker-engine
	$ sudo systemctl enable docker.service
	$ sudo systemctl start docker
	$ sudo docker run --rm hello-world
3.安装jdk、maven,配置环境变量JAVA_HOME,PATH
4.在项目根目录(centos,不是windows)下执行 mvn clean package docker:build
5.在项目根目录(centos,不是windows)下执行 docker-compose up,启动所有服务
