package Main;

import beans.UserAccount;
import dao.UserAccountDao;
import dao.UserAccountImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-transcation.xml");
        UserAccountDao userAccountDao=(UserAccountImpl)context.getBean("userdao");

        UserAccount userAccount=new UserAccount();
        userAccount.setAmount(7000);

        userAccount.setName("sahil");

        userAccountDao.insert(userAccount);
        UserAccount userAccount1=new UserAccount();
        userAccount1.setAmount(50000);
        userAccount1.setId(8);
       userAccountDao.update(userAccount1);
        UserAccount userAccount2=new UserAccount();
        userAccount2.setId(10);
        userAccountDao.delete(userAccount2);
        List<UserAccount> userAccounts=userAccountDao.list();
        for(UserAccount user:userAccounts)
        {
            System.out.println("Name:"+user.getName()+"\t\t\tamount:"+user.getAmount());
        }

    }


}
