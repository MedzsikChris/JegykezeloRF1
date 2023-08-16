package application.Service;

import application.dao.FelhasznaloDAO;
import application.model.Felhasznalo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class FelhasznaloService implements UserDetailsService {
    @Autowired
    private FelhasznaloDAO felhasznaloDAO;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Felhasznalo felhasznalo = felhasznaloDAO.getFelhasznaloByEmail(username);
        if (felhasznalo == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return felhasznalo;
    }
}
