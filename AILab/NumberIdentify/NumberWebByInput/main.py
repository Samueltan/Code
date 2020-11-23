import numpy as np
import tensorflow as tf
from flask import Flask, jsonify, render_template, request
from mnist import AlexNet,model

sess = tf.Session()
keep_prob = tf.placeholder("float")  # 测试时keep_prob=1.0
x = tf.placeholder("float", [None, 784])

with tf.variable_scope("alexnet"):  # 恢复AlexNet训练数据
    y1= AlexNet.alexnet(x, AlexNet.weights, AlexNet.biases, AlexNet.dropout)  # 参数按照AlexNet.py中的定义：输入，权值，偏置，dropout
saver = tf.train.Saver()
saver.restore(sess, "mnist/data/alexnet.ckpt")

with tf.variable_scope("convolutional"):   # 恢复LeNet训练数据
    y2, variables = model.convolutional(x, keep_prob)
saver = tf.train.Saver(variables)
saver.restore(sess, "mnist/data/lenet.ckpt")


def alexnet(input):
    return sess.run(y1, feed_dict={x: input, keep_prob: 1.0}).flatten().tolist()


def lenet(input):
    return sess.run(y2, feed_dict={x: input, keep_prob: 1.0}).flatten().tolist()


# webapp
app = Flask(__name__)

'''
请求json：
一维数组，784个特征
[255, 161, 0, 0,....]

返回json：
"results":
第一维是AlexNet计算出各数字的概率，由于网络准确率高且最后有Softmax，故概率很接近1
第一维是LeNet计算出各数字的概率
[[0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,1,0,0,0,0,0],]
'''
@app.route('/api/mnist', methods=['POST'])
def mnist():
    input = ((255 - np.array(request.json, dtype=np.uint8)) / 255.0).reshape(1, 784) #标准化数据
    output1 = alexnet(input)  #一维数组，输出10个预测概率
    output2 = lenet(input)
    return jsonify(results=[output1, output2])


@app.route('/')
def main():
    return render_template('index.html')

if __name__ == '__main__':
    app.run(host='0.0.0.0',port=5001)
