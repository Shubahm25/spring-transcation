package dao;

import beans.UserAccount;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by shubham on 7/6/17.
 */
public interface UserAccountDao {

   void insert(UserAccount u);
   void  update(UserAccount u);
   void delete(UserAccount u);
   List<UserAccount> list();




}
