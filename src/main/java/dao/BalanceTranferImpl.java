package dao;

import beans.AccountTranscation;
import beans.UserAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import rowmappers.UserAccuntMapper;

import javax.sql.DataSource;

/**
 * Created by shubham on 7/6/17.
 */
public class BalanceTranferImpl  implements BalanceTransfer
{
    private DataSource dataSource;

    private PlatformTransactionManager transactionManager;

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public DataSource getDataSource() {

        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public  void fundTransfer( UserAccount from, UserAccount To, int amount)
    {
        TransactionDefinition definition= new DefaultTransactionDefinition();
        TransactionStatus status=transactionManager.getTransaction(definition);
UserAccount useraccount=getdata(from.getId());
if(useraccount.getAmount() >= amount) {
    int balance = useraccount.getAmount() - amount;

    String sql = "update UserAccount set amount =? where account_id=?";
    template.update(sql, balance, from.getId());

    UserAccount userAccount = getdata(To.getId());


    int balance1 = userAccount.getAmount() + amount;

    String sql1 = "update UserAccount set amount =? where account_id=?";
    if (template.update(sql1, balance1, To.getId()) > 0) {
        System.out.println("update");
    }
    AccountTranscation accountTranscation = new AccountTranscation();
    accountTranscation.setSendername(useraccount.getName());
    accountTranscation.setRecievername(userAccount.getName());
    System.out.println(accountTranscation.getRecievername());
    String sql2="insert into account_transcation(sendername,recievername) values(?,?)";
    template.update(sql2, accountTranscation.getSendername(), accountTranscation.getRecievername());

}
else {
    System.out.println("Insufficient balance");
}

transactionManager.commit(status);

    }

    public UserAccount getdata(int  id)
    {
        String sql="select * from UserAccount  where account_id=?";
     UserAccount userAccount=   template.queryForObject(sql,new UserAccuntMapper(),id);
     return userAccount;
    }
}
