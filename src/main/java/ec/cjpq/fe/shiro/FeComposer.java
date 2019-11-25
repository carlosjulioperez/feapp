package ec.cjpq.fe.shiro;

import org.apache.shiro.SecurityUtils;
import org.zkoss.zk.ui.util.GenericForwardComposer;

public class FeComposer extends GenericForwardComposer {

	public void onClick$home() {
		execution.sendRedirect("/home.zul");
	}

	public void onClick$logout() {
		SecurityUtils.getSubject().logout();
		execution.sendRedirect("/home.zul");
	}

}
