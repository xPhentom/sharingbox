package be.odisee.verhuursysteem_sharingbox.dao;

import org.hibernate.*;
import org.springframework.stereotype.Repository;

import be.odisee.verhuursysteem_sharingbox.domain.Rol;

@Repository("rolDao")
public class RolHibernateDAO extends HibernateDao implements RolDAO {

	@Override
	public Rol saveRol(Rol rol) {
		sessionSaveObject(rol);
		return rol;
	}

	@Override
	public Rol getRolById(int id) {
		return (Rol) sessionGetObjectById("Rol", id);
	}

	@Override
	public Rol getRolByUserid(String userid) {

		String qstr = "from Rol where usernaam = :userid";
		String parameter = "userid";
		String value = userid;

		return (Rol) sessionGetObjectBy1StringParameterNamedQuery(qstr, parameter, userid);
	}

	@Override
	public Rol getRolByPersoonId(int persoonid) {
		
		String query = "from Rol where persoon_id = :persoonid";
		String parameter = "persoonid";
		String value = Integer.toString(persoonid);
		
		return (Rol) sessionGetObjectBy1StringParameterNamedQuery(query, parameter, value);
	}

}
