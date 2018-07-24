package com.adpanshi.cashloan.business.system.model;


import com.adpanshi.cashloan.business.system.domain.SysMenu;

import java.util.List;

public class SysMenuCheck extends SysMenu {

	private static final long serialVersionUID = 73161925067707896L;

	private boolean checked;
	  
	private List<SysMenuCheck> children;

	public List<SysMenuCheck> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenuCheck> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
     
	public SysMenuCheck(){
		
	}
}
