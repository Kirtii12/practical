var mysql = require('mysql');
var con = mysql.createConnection({
 host: "localhost",
 user: "root",
 password: "Root@123",
database: "node"
});
con.connect(function(err) {
 if (err) throw err;
 console.log("Connected!");
 var sql = "INSERT INTO student (rollno,namee, percentage) VALUES ?"; 
var values = [ 
[1,'abc', 77.6], 
[2,'def', 89.6], 
[3,'ghi', 91.6] 
]; 
con.query(sql, [values], function (err, result) 
{
 if (err) throw err;
 console.log("Number of records inserted: " + result.affectedRows); 
 });
con.query("SELECT * FROM student", function (err, result, fields) {
 if (err) throw err;
 console.log(result);
 });
});
