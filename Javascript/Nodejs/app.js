// const http = require('http');
// const hostname = '127.0.0.1';
// const port = 3000;

// const server = http.createServer((req, res) => {
// 	res.statusCode = 200;
// 	res.setHeader('Content-Type', 'text/plain');
// 	res.end('Hello World');
// });

// server.listen(port, hostname, () => {
// 	console.log(`Server running at http://${hostname}:${port}/`);
// });

// const express = require('express')
// const app = express()

// app.get('/', (req, res) => {
// 	res.send('Hi!')
// })

// app.listen(port, () => console.log('Server ready'))

// const fs = require('fs')

// const getFile = fileName => {
// 	return new Promise((resolve, reject) => {
// 		fs.readFile(
// 			fileName,
// 			"utf8",
// 			(err, data) => {
// 				if (err) {
// 					reject(err)
// 					return
// 				}
// 				resolve(data)
// 			}
// 		)
// 	})
// }

// console.log('Before')
// getFile('./test.txt')
// .then(data => console.log(data))
// .catch(err => console.error(err))
// console.log('After')


// const doSomethingAsync = () => {
//   return new Promise(resolve => {
//     setTimeout(() => resolve('I did something'), 1000)
//   })
// }

// // Approach 1: Traditional promise handling
// console.log('Before')
// doSomethingAsync()
// 	.then(data => console.log(data))
// console.log('After')

// // Approach 2: New async/await handling
// const doSomething = async () => {
// 	console.log(await doSomethingAsync())
// }
// console.log('Before')
// doSomething()
// console.log('After')


// const EventEmitter = require('events')
// const eventEmitter = new EventEmitter()

// eventEmitter.on('start', (start, end) => {
//   console.log(`started from ${start} to ${end}`)
// })

// eventEmitter.emit('start', 1, 100)


const https = require('https')
const options = {
  hostname: 'whatever.com',
  port: 443,
  path: '/todos',
  method: 'GET'
}

const req = https.request(options, res => {
  console.log(`statusCode: ${res.statusCode}`)

  res.on('data', d => {
    process.stdout.write(d)
  })
})

req.on('error', error => {
  console.error(error)
})

req.end()

const https = require('https')

const data = JSON.stringify({
  todo: 'Buy the milk'
})

const options = {
  hostname: 'whatever.com',
  port: 443,
  path: '/todos',
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Content-Length': data.length
  }
}

const req = https.request(options, res => {
  console.log(`statusCode: ${res.statusCode}`)

  res.on('data', d => {
    process.stdout.write(d)
  })
})

req.on('error', error => {
  console.error(error)
})

req.write(data)
req.end()