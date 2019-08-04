package com.czxy.Druid;

import com.czxy.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Druid01 {

    public static void main(String[] args) throws Exception {

        findAll();

    }

    public static void findAll() throws Exception{
        //获取连接
        Connection conn = DruidUtil.getConnection();
        //获取SQL 发射器
        PreparedStatement pps = conn.prepareStatement("select * from user ");
        //发射SQL 语句 得到结果集
        ResultSet rs = pps.executeQuery();
        //处理结果集
        while (rs.next()){
            String username = rs.getString("username");
            System.out.println(username);
        }
        //释放资源
        DruidUtil.closeAll(conn,pps,rs);
    }
}
