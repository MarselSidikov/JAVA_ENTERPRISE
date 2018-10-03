sudo docker build -t sidikov_marsel/demo-node-js .
sudo docker build -t sidikov_marsel/demo-spring-boot .
sudo docker build -t sidikov_marsel/demo-rabbitmq .


sudo docker run --name spring-boot sidikov_marsel/demo-spring-boot

sudo docker run -p "8800:8800" -d --name node-js sidikov_marsel/demo-node-js

sudo docker run -d -h node-1.rabbit                                      \
           --name rabbit                                                 \
           -p "4369:4369"                                                \
           -p "5672:5672"                                                \
           -p "15672:15672"                                              \
           -p "25672:25672"                                              \
           -p "35197:35197"                                              \
           -v /home/marsel/Docker/RabbitMq/data:/var/lib/rabbitmq        \
           -v /home/marsel/Docker/RabbitMq/data/logs:/var/log/rabbitmq   \
           sidikov_marsel/demo-rabbitmq

sudo docker stop node-js
sudo docker rm node-js

sudo docker stop spring-boot
sudo docker rm spring-boot

sudo docker stop rabbit
sudo docker rm rabbit

sudo docker inspect --format '{{ .NetworkSettings.IPAddress }}' rabbit
