import tensorflow as tf

########## 输入输出设置 ##########
n_input = 784
n_classes = 10
dropout = 1.0
x = tf.placeholder(tf.float32, [None, n_input])
y = tf.placeholder(tf.float32, [None, n_classes])

##################### 网络模型定义 #####################

########## 卷积定义 ##########
def conv2d(name, x, W, b, strides=1, padding='SAME'):
    x = tf.nn.conv2d(x, W, strides=[1, strides, strides, 1], padding=padding)
    x = tf.nn.bias_add(x, b)
    return tf.nn.relu(x, name=name)


########## 池化定义##########
def maxpool2d(name, x, k=3, s=2, padding='SAME'):
    return tf.nn.max_pool(x, ksize=[1, k, k, 1], strides=[1, s, s, 1], padding=padding, name=name)


########## 归一化定义 ##########
def norm(name, l_input, lsize=5):
    return tf.nn.lrn(l_input, lsize, bias=1.0, alpha=0.0001, beta=0.75, name=name)


########## 权值和偏置项 ##########
def weight_var(name, shape):
    return tf.get_variable(name=name, shape=shape, initializer=tf.contrib.layers.xavier_initializer())

def bias_var(name, shape):
    return tf.get_variable(name=name, shape=shape, initializer=tf.constant_initializer(0))

weights = {
    'wc1': weight_var('wc1', [11, 11, 1, 96]),
    'wc2': weight_var('wc2', [5, 5, 96, 256]),
    'wc3': weight_var('wc3', [3, 3, 256, 384]),
    'wc4': weight_var('wc4', [3, 3, 384, 384]),
    'wc5': weight_var('wc5', [3, 3, 384, 256]),
    'wd1': weight_var('wd1', [4 * 4 * 256, 4096]),
    'wd2': weight_var('wd2', [4096, 4096]),
    'out_w': weight_var('out_w', [4096, 10])
}
biases = {
    'bc1': bias_var('bc1', [96]),
    'bc2': bias_var('bc2', [256]),
    'bc3': bias_var('bc3', [384]),
    'bc4': bias_var('bc4', [384]),
    'bc5': bias_var('bc5', [256]),
    'bd1': bias_var('bd1', [4096]),
    'bd2': bias_var('bd2', [4096]),
    'out_b': bias_var('out_b', [n_classes])
}


##################### 网络模型构建 ##########################
def alexnet(x, weights, biases, dropout): # 参数：输入，权值，偏置，dropout
    #### 图片输入处理 ####
    x = tf.reshape(x, shape=[-1, 28, 28, 1])

    #### 第一层 ####
    ## 卷积 ##
    conv1 = conv2d('conv1', x, weights['wc1'], biases['bc1'], padding='SAME')
    ## 池化 ##
    pool1 = maxpool2d('pool1', conv1, k=3, s=2, padding='SAME')
    ## 归一化 ##
    norm1 = norm('norm1', pool1, lsize=5)

    #### 第二层 ####
    ## 卷积 ##
    conv2 = conv2d('conv2', norm1, weights['wc2'], biases['bc2'], padding='SAME')
    ## 池化 ##
    pool2 = maxpool2d('pool2', conv2, k=3, s=2, padding='SAME')
    ## 归一化 ##
    norm2 = norm('norm2', pool2, lsize=5)

    #### 第三层 ####
    ## 卷积 ##
    conv3 = conv2d('conv3', norm2, weights['wc3'], biases['bc3'], padding='SAME')

    #### 第四层 ####
    ## 卷积 ##
    conv4 = conv2d('conv4', conv3, weights['wc4'], biases['bc4'], padding='SAME')

    #### 第五层 ####
    ## 卷积 ##
    conv5 = conv2d('conv5', conv4, weights['wc5'], biases['bc5'], padding='SAME')
    ## 池化 ##
    pool5 = maxpool2d('pool5', conv5, k=3, s=2, padding='SAME')
    ## 归一化 ##
    norm5 = norm('norm5', pool5, lsize=5)

    #### 全连接层1 ####
    fc1 = tf.reshape(norm5, [-1, weights['wd1'].get_shape().as_list()[0]])
    fc1 = tf.add(tf.matmul(fc1, weights['wd1']), biases['bd1'])
    fc1 = tf.nn.relu(fc1)

    ## dropout ##
    fc1 = tf.nn.dropout(fc1, dropout)

    #### 全连接层2 ####
    fc2 = tf.add(tf.matmul(fc1, weights['wd2']), biases['bd2'])
    fc2 = tf.nn.relu(fc2)

    ## dropout ##
    fc2 = tf.nn.dropout(fc2, dropout)

    #### 输出 ####
    out = tf.nn.softmax(tf.matmul(fc2, weights['out_w'])+ biases['out_b'])
    return out


