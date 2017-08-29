package dao.declarative;

import beans.UserAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.BalanceTranferImpl;
import dao.BalanceTransfer;
/**
 * Created by shubham on 7/6/17.
 */
public class Test5 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-transcation.xml");
        BalanceTransferDeclarative balanceTransferDeclarative = (BalanceTransferDeclartiveImpl)context.getBean("decl");
        UserAccount to=new UserAccount();
        to.setId(12);
        UserAccount from=new UserAccount();
        from.setId(13);
        balanceTransferDeclarative.fundTransfer(to,from,1000);
    }
    }



