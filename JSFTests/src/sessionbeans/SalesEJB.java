package sessionbeans;

import entities.Sale;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
@Stateless
public class SalesEJB {

    @PersistenceContext(unitName = "JSFPU")
    private EntityManager em;

    public List<Sale> getSales(Date startDate, Date endDate) {
        return em
                .createQuery("select s from Sale s where s.date between :startDate and :endDate", Sale.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }
}
