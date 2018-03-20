package beans;

import entities.Sales;
import sessionbeans.SalesEJB;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
@ManagedBean
@SessionScoped
public class SalesBean {

    private Date startDate;
    private Date endDate;
    private List<Sales> sales;

    @EJB
    private SalesEJB salesEJB;

    public List<Sales> fetchSales() {
        this.sales = salesEJB.getSales(startDate, endDate);
        return sales;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }
}
