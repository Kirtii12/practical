const fs = require('fs');
console.log("\nFile Contents of file before append:",
a=fs.readFileSync("file1.txt", "utf8"));
fs.appendFile("file2.txt", a, (err) => {
if (err) {
 console.log(err);
}
else {
 console.log("\nFile Contents of file after append:",
 fs.readFileSync("file2.txt", "utf8"));
}
});