FROM node:8

WORKDIR /usr/src/app

RUN npm install express && npm install body-parser && npm install amqplib

COPY . .

CMD [ "node", "server.js"]
EXPOSE 8800