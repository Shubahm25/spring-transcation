package dao;

import beans.UserAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import rowmappers.UserAccuntMapper;

import java.util.List;

/**
 * Created by shubham on 7/6/17.
 */
public class UserAccountImpl implements  UserAccountDao {


    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void insert(UserAccount u) {
        String query = "insert into UserAccount (amount,name) values(?,?)";
        template.update(query, new Object[]{u.getAmount(),u.getName() });
    }

    public void update(UserAccount u) {
        String sql = "update UserAccount set amount=?  where account_id=?";
        template.update(sql, new Object[]{u.getAmount(), u.getId()});
    }

    public void delete(UserAccount u) {
        String sql = "delete from UserAccount where account_id=?";
        template.update(sql, new Object[]{u.getId()});
    }

    public List<UserAccount> list() {
        String sql = "select * from UserAccount";
     List<UserAccount> userAccount=  template.query(sql, new UserAccuntMapper());
        return userAccount;

    }
}





