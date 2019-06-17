package ru.atom.chat.Dao;

import java.util.List;

public interface Dao <T> {

   List <T> getAll();

   List <T> getListWhere();

   void insertInto(T t);

   void deleteWhere(T t);
}
