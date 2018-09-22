var express = require('express');
var app = express();
//设置public目录为静态目录
app.use(express.static('public'));
//监听3000端口
app.listen(3000);
