bodyParser = require('body-parser').json();

module.exports = function(app) {
  app.post('/login', bodyParser, function(req, res) {
    var body = req.body;
    if (body["login"] === 'marsel' && body["password"] === 'qwerty007') {
        var result = { "token" : "123456"};
        res.send(result);
    } else {
        res.send("")
    }
  });
};