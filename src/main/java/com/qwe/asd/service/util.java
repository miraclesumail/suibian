package com.qwe.asd.service;

import java.sql.*;
import java.util.*;
public class util {
    public static  List<Map<String, Object>> fullToList(ResultSet rs){


        ArrayList result = new ArrayList();
        try {
            int iColumn = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                System.out.println("qweweqrqrrw");

                Map<String, Object> map = new LinkedHashMap<String, Object>();
                for (int i = 1; i <= iColumn; i++) {
                    String tmpkey = rs.getMetaData().getColumnName(i);// 通过索引找到行的名字

                    Object val = null;
                    System.out.println(rs.getMetaData().getColumnType(i));
                    // switch行类型
                    switch (rs.getMetaData().getColumnType(i)) {
                        case Types.DATE:
                            val = rs.getDate(i);
                            break;
                        case Types.DOUBLE:
                            if(rs.getObject(i)==null)
                                val=null;
                            else
                                val = rs.getDouble(i);
                            break;
                        case Types.NUMERIC:
                            if(rs.getObject(i)==null)
                                val=null;
                            else
                                val = rs.getDouble(i);
                            break;
                        case Types.DECIMAL:
                            if(rs.getObject(i)==null)
                                val=null;
                            else
                                val = rs.getDouble(i);
                            break;
                        case Types.INTEGER:
                            if(rs.getObject(i)==null)
                                val=null;
                            else
                                val = rs.getInt(i);
                            break;
                        default:
                            val = rs.getString(tmpkey);
                            System.out.println(val);
                            break;
                    }

                    if (null != val) {
                        // map找找不到指定键便设置个
                        if (!map.containsKey(tmpkey)) {
                            map.put(tmpkey, val);
                        }
                    }
                }
                result.add(map);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (rs != null)
                    rs.close();
                rs = null;
            } catch (SQLException e) {
            }
        }
        return result;
    }
}
