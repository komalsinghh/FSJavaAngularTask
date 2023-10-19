var app = require('express');
var server=require('http').Server(app);
var io=require('socket.io')(server,{
  cors: {
    origin: '*',
  }
});

const PORT = 3000;

io.on('connection', function(socket){
  console.log('User is connected');
  socket.emit('test event','here is some data komal singh!!');

  socket.on('message', function (data) {
      console.log('Received Message', data);
     socket.broadcast.emit('new message',data);
    });

});

server.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
