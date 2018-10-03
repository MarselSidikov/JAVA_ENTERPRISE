const formsRoutes = require('./forms_routes');
module.exports = function(app, amqp) {
  formsRoutes(app, amqp);
};