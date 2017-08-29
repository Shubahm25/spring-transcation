package rowmappers;

import beans.UserAccount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shubham on 7/6/17.
 */
public class UserAccuntMapper implements RowMapper<UserAccount> {
    public  UserAccount mapRow(ResultSet resultSet,int rownum) throws SQLException
    {
        UserAccount userAccount=new UserAccount();
        userAccount.setId(resultSet.getInt("account_id"));
        userAccount.setName(resultSet.getString("name"));
        userAccount.setAmount(resultSet.getInt("amount"));
        return  userAccount;
    }
}
