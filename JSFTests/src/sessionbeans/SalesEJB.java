package sessionbeans;

import entities.Sales;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
@Stateless(name = "SalesEJB")
public class SalesEJB {

    @PersistenceContext(unitName = "JSFPU")
    private EntityManager em;

    public List<Sales> getSales(Date startDate, Date endDate) {

        return em
                .createQuery("select s from Sales s where s.date between :startDate and :endDate", Sales.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
