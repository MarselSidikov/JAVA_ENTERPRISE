FROM rabbitmq:3.7-management

ADD rabbitmq.config /etc/rabbitmq/
ADD definitions.json /etc/rabbitmq/

ENV RABBITMQ_USE_LONGNAME true
ENV RABBITMQ_LOGS /var/log/rabbitmq/rabbit.log
