const usersRoutes = require('./users_routes');
const loginRoutes = require('./login_routes');
module.exports = function(app) {
  usersRoutes(app);
  loginRoutes(app);
};