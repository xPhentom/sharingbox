package be.odisee.verhuursysteem_sharingbox.dao;

import be.odisee.verhuursysteem_sharingbox.domain.Rol;

public interface RolDAO {

    public Rol saveRol(Rol rol);

    public Rol getRolById(int id);

    public Rol getRolByUserid(String userid);
    
    public Rol getRolByPersoonId(int persoonid);
}
