package beans;

import entities.Sale;
import sessionbeans.SaleEJB;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
@ManagedBean
@SessionScoped
public class SaleBean {

    private Date startDate;
    private Date endDate;
    private List<Sale> sales;

    @EJB
    private SaleEJB saleEJB;

    public List<Sale> fetchSales() {
        return this.sales = saleEJB.getSales(startDate, endDate);
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

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
