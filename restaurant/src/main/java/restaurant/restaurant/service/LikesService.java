package restaurant.restaurant.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.dto.LikesDTO;
import restaurant.restaurant.entity.LikesEntity;
import restaurant.restaurant.entity.UserEntity;
import restaurant.restaurant.repository.LikesRepository;
import restaurant.restaurant.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikesRepository likesRepository;
    private final UserRepository userRepository;

    public void saveLike(LikesDTO likesDTO) {
        LikesEntity likesEntity = new LikesEntity();

        likesEntity.setId(likesDTO.getId());
        likesEntity.setMyplaceId(likesDTO.getMyplaceId());

        UserEntity userEntity = userRepository.findById(likesDTO.getUserId()).orElse(null);
        likesEntity.setUser(userEntity);

        likesRepository.save(likesEntity);
    }

    public boolean isLikedByUser(int userId, int myplaceId) {
        return likesRepository.existsByUser_IdAndMyplace_Id(userId, myplaceId);
    }


}