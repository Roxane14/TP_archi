package com.TP1_archi_log.tp1archi_log.model;

import java.sql.Connection;

import java.sql.Statement;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;



public class BDDfake {
    public static final Map<Integer, Garantie> bddfake  = new HashMap<Integer, Garantie>();
    public static final AtomicInteger seq = new AtomicInteger();

}



