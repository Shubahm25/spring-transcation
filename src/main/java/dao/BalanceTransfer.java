package dao;

import beans.UserAccount;

/**
 * Created by shubham on 7/6/17.
 */
public interface BalanceTransfer {
    void fundTransfer( UserAccount from,UserAccount To,int amount);
}
