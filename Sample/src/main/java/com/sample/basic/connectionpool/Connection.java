package com.sample.basic.connectionpool;

public class Connection {
    /**连接池*/
    private final ConnectionPool pool;

    public Connection(ConnectionPool pool) {
        this.pool = pool;
    }

    /**
     * 关闭连接，将连接返回到连接池中
     */
    public void close() {
        pool.releaseConnection(this);
    }

    //省略其他逻辑方法 ... ...
}
