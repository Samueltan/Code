package com.sample.basic.connectionpool;

public interface ConnectionPool {

    /**
     * 获取连接
     */
    public Connection getConnection();

    /**
     * 释放连接
     */
    public void releaseConnection(Connection conn);

}
