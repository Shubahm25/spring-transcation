package dao.declarative;

import beans.AccountTranscation;
import beans.UserAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rowmappers.UserAccuntMapper;

import javax.sql.DataSource;

/**
 * Created by shubham on 7/6/17.
 */
@Component
public class BalanceTransferDeclartiveImpl  implements BalanceTransferDeclarative{

private DataSource dataSource;

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

@Transactional(propagation = Propagation.NEVER)
    public  void fundTransfer(UserAccount from, UserAccount To, int amount)
    {

        UserAccount userAccount=getdata(from.getId());
        if(userAccount.getAmount() >= amount) {
            int balance = userAccount.getAmount() - amount;

            String sql = "update UserAccount set amount =? where account_id=?";
            template.update(sql, balance, from.getId());

            UserAccount useraccount = getdata(To.getId());


            int balance1 = useraccount.getAmount() + amount;

            String sql1 = "update UserAccount set amount =? where account_id=?";
            if (template.update(sql1, balance1, To.getId()) > 0) {
                System.out.println("update");
            }
            AccountTranscation accountTranscation = new AccountTranscation();
            accountTranscation.setSendername(userAccount.getName());
            accountTranscation.setRecievername(useraccount.getName());
            System.out.println(accountTranscation.getRecievername());
            String sql2="insert into account_transcation(sendername,recievername) values(?,?)";
            template.update(sql2, accountTranscation.getSendername(), accountTranscation.getRecievername());

        }
        else {
            System.out.println("Insufficient balance");
        }



    }

    public UserAccount getdata(int  id)
    {
        String sql="select * from UserAccount  where account_id=?";
        UserAccount userAccount=   template.queryForObject(sql,new UserAccuntMapper(),id);
        return userAccount;
    }
}


