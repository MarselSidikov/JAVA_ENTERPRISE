module.exports = function(app) {
  app.get('/users', (req, res) => {
    var result = [{      "id" : 1,
    			"name" : "Marsel"
    		},
    		{
    			"id" : 2,
    			"name" : "Andrey"
    		},
    		{
    			"id" : 3,
    			"name" : "Maxim"
    		}];
    	res.send(JSON.stringify(result));
  });
};