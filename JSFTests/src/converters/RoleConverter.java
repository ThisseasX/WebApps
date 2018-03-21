package converters;

import beans.RegisterBean;
import entities.Role;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;

@FacesConverter(value = "RoleConverter")
public class RoleConverter implements Converter {

//    @EJB
//    private RegisterEJB registerEJB;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

//        List<Role> list = registerEJB.fetchAllRoles();

        RegisterBean yourBean = facesContext
                .getApplication()
                .evaluateExpressionGet(
                        facesContext,
                        "#{registerBean}",
                        RegisterBean.class);

        List<Role> list = yourBean.getAvailableRoles();

//                Persistence
//                        .createEntityManagerFactory("JSFPU")
//                        .createEntityManager()
//                        .createNamedQuery(Role.GET_ALL, Role.class)
//                        .getResultList();

        System.out.println("STRING IS: " + s);
        return list.get(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Role r = (Role) o;
        System.out.println("OBJECT IS: " + r + " " + r.getRid() + " " + r.getName());
        return String.valueOf(r.getRid() - 1);
    }
}
