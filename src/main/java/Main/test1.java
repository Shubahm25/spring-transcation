package Main;

import beans.UserAccount;
import dao.BalanceTranferImpl;
import dao.BalanceTransfer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shubham on 7/6/17.
 */
public class test1 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-transcation.xml");
        BalanceTransfer balanceTransfer=(BalanceTranferImpl)context.getBean("dao");
        UserAccount from=new UserAccount();
        from.setId(12);
        UserAccount to=new UserAccount();
        to.setId(13);
        balanceTransfer.fundTransfer(from,to,1000);
    }
}
