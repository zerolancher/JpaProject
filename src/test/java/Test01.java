import com.zero.pojo.Customer;
import com.zero.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Test01 {
    @Test
    public void Fun01() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyJpa");//
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Customer customer = new Customer();
        customer.setCustName("纬创12");
        manager.persist(customer);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    @Test // 查，立即加载
    public void Fun02() {
        EntityManager manager = JpaUtils.getEntityManager();
        Customer customer = manager.find(Customer.class, 11L);
        //System.out.println(customer);

    }

    @Test
    public void fun03() {  //查，延迟加载
        EntityManager manager = JpaUtils.getEntityManager();
        Customer customer = manager.getReference(Customer.class, 8L);
        System.out.println(customer);
    }

    @Test   // 修改，merge方法
    public void fun04() {
        EntityManager manager = JpaUtils.getEntityManager();
        manager.getTransaction().begin();
        Customer customer = manager.find(Customer.class, 8L);
        customer.setCustName("李旭烧烤店");
        manager.merge(customer);
        manager.getTransaction().commit();
    }

    @Test
    public void fun05() {
        Customer customer = new Customer();
        customer.setCustId(8L);
        customer.setCustName("歌舞厅");
        EntityManager manager = JpaUtils.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(customer);
        manager.getTransaction().commit();
    }

    @Test   // 删除
    public void name() {
        EntityManager manager = JpaUtils.getEntityManager();
        manager.getTransaction().begin();
        Customer customer = manager.find(Customer.class, 8L);

         manager.remove(customer);
        manager.getTransaction().commit();
    }

    @Test
    public void fun06() {
        EntityManager manager = JpaUtils.getEntityManager();
        String jpql = "from Customer ";
        String sql = "select c from Customer c";
        Query query = manager.createQuery(sql);
        List<Customer> resultList = query.getResultList();
        System.out.println(resultList);
    }

    @Test
    public void fun07() {
        EntityManager manager = JpaUtils.getEntityManager();
        String jpql = "from Customer where custName like ? ";
        Query query = manager.createQuery(jpql);
        query.setParameter(1,"纬创");
        List<Customer> resultList = query.getResultList();
        System.out.println(resultList);
    }

    @Test
    public void fun08() {
        EntityManager manager = JpaUtils.getEntityManager();
        String jpql = "from Customer order by custId desc ";
        Query query = manager.createQuery(jpql);
        query.setFirstResult(0);   // 相当于MySQL  limit  分页
        query.setMaxResults(2);
        List<Customer> resultList = query.getResultList();
        System.out.println(resultList);
    }
    @Test
    public void fun09() {
        EntityManager manager = JpaUtils.getEntityManager();
        String jpql1 = "SELECT SUM(c.custId) FROM Customer  c";
        String jpql2 = "select min(c.custId) from Customer c";
        Query query = manager.createQuery(jpql2);
        Number result =(Number) query.getSingleResult();
        System.out.println(result);
    }

}
