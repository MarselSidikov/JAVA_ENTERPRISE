const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const port = 80;

app.use(bodyParser.urlencoded({ extended: true }));
require('./app/routes')(app);
app.listen(port, () => {
  console.log('Server started at ' + port);
});