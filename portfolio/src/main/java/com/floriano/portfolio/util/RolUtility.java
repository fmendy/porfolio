package com.floriano.portfolio.util;

import java.util.ArrayList;
import java.util.List;

import com.floriano.portfolio.entity.Rol;
import com.floriano.portfolio.model.RolForm;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RolUtility {

	public RolForm rolToForm(Rol Rol) {
		if (Rol == null) {
			return new RolForm();
		}
		RolForm retVal = new RolForm();
		retVal.setId(Rol.getId());
		retVal.setNombre(Rol.getNombre());
		return retVal;
	}

	public List<RolForm> listRolToListForm(List<Rol> list) {
		List<RolForm> retVal = new ArrayList<>();
		for (Rol ca : list) {
			retVal.add(rolToForm(ca));
		}
		return retVal;
	}
}
