package restaurant.restaurant.service;

import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import restaurant.restaurant.dto.JoinDTO;
import restaurant.restaurant.entity.UserEntity;
import restaurant.restaurant.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public JoinService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public void joinProcess(JoinDTO joinDTO) {

        // db에 이미 동일한 username을 가진 회원이 존재하는지 검증
        boolean isUser = userRepository.existsByUsername(joinDTO.getUsername());
        if (isUser) {
            return;
        }

        UserEntity data = new UserEntity();

        data.setUsername(joinDTO.getUsername());
        data.setNickname(joinDTO.getNickname());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setRole("ROLE_USER");

        userRepository.save(data);

    }


}