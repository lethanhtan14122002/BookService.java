package lethanhtan.example.demo.services;

import lethanhtan.example.demo.Entity.CustomUserDetail;
import lethanhtan.example.demo.Entity.User;
import lethanhtan.example.demo.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername (String username)throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user== null)
            throw new UsernameNotFoundException("user not found");
        return  new CustomUserDetail(user,userRepository);
    }
}
