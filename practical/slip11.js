var mysql = require('mysql');
 
var con = mysql.createConnection({
 host: "localhost", 
 user: "root", 
 password: "", 
 database: "mydb"
});
con.connect(function(err) {
 if (err) throw err; 
 var sql = "DELETE FROM customers WHERE address = 'Shivajinagar,Sangamner'"; 
 con.query(sql, function (err, result) {
Downloaded by Gurushant Lende (lgurushant@gmail.com)
lOMoARcPSD|29967397
 if (err) throw err; 
 console.log("Number of records deleted: " + result.affectedRows);
 });
});