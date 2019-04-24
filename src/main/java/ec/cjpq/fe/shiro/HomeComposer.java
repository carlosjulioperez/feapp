package ec.cjpq.fe.shiro;

import org.apache.shiro.SecurityUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;

public class HomeComposer extends GenericForwardComposer {

	private Hbox account;
	private Label user;
	
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		if(SecurityUtils.getSubject().isAuthenticated()){
			super.doAfterCompose(comp);

			account.setVisible(true);
			user.setValue( SecurityUtils.getSubject().getPrincipal().toString() );
		}
	}
	
	public void onClick$logout(){
		execution.sendRedirect("/home.zul");
		SecurityUtils.getSubject().logout();
	}
	
}
