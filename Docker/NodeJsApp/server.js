const express = require('express');
const bodyParser = require('body-parser');
const amqp = require('amqplib/callback_api');
const app = express();
const port = 8800;

app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static('public'));

require('./app/routes')(app, amqp);
app.listen(port);
console.log("Server started at " + port);