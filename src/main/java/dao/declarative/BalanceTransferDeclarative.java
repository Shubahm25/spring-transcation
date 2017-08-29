package dao.declarative;

import beans.UserAccount;

/**
 * Created by shubham on 7/6/17.
 */
public interface BalanceTransferDeclarative {
    void fundTransfer(UserAccount from, UserAccount To, int amount);
}
