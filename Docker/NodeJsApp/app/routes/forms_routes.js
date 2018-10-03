bodyParser = require('body-parser').json();

module.exports = function (app, amqp) {
	app.post('/forms', bodyParser, function(request, response) {
		var body = request.body;
      	amqp.connect('amqp://api-user:qwerty008@172.17.0.3/', function(error, connection) {
  			console.log(error);
        connection.createChannel(function(error, channel) {
    			var queue = 'demo-queue';
				channel.assertQueue(queue);
				console.log(body);
    			channel.sendToQueue(queue, new Buffer(JSON.stringify(body)));
    			console.log("Sent to MQ");
  			});
		});
      response.sendStatus(200);
	});
}