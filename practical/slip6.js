var fs = require('fs');
//var http = require('http');
//http.createServer(function (req, res) {
 
// Use fs.readFile() method to read the file
fs.readFile('file1.txt', 'utf8', function(err, data){
 
 /*if (err){
 res.writeHead(404, {'Content-Type': 'text/html'});
 
 
 return res.end("404 Not Found");
 
 }*/
 // Display the file content
 if(err) return console.error(err);
 
 
 console.log(data);
});
 
console.log('readFile called');
