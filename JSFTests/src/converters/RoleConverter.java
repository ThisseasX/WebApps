package converters;

import beans.UserBean;
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

        UserBean yourBean = facesContext
                .getApplication()
                .evaluateExpressionGet(
                        facesContext,
                        "#{userBean}",
                        UserBean.class);

        List<Role> list = yourBean.fetchAllRoles();

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
