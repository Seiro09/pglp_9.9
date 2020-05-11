package fr.uvsq21504875;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {
  protected Connection conn;


  public abstract T create(T obj);
  public abstract T find(String id);
  public abstract T update(T obj);
  public abstract void delete(T obj);
}
