package com.jy.dataBase;

import java.sql.DriverManager;

public class kingDeeBase {
  private final static String CLASSNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  private final static String DBURL = "jdbc:sqlserver://192.168.5.38;databaseName=AIS20130718181714";
  private final static String DBUSER = "sa";
  private final static String DBPWD = "pepco_8kd";
  static {
   // DriverManager.registerDriver( new sun.jdbc.odbc.JdbcOdbcDriver);
  }

}
