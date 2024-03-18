package restaurant.restaurant.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.dto.LikesDTO;
import restaurant.restaurant.entity.LikesEntity;
import restaurant.restaurant.repository.LikesRepository;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikesRepository likesRepository;

    public void saveLike(LikesDTO likesDTO) {
        LikesEntity likesEntity = new LikesEntity();

        likesEntity.setId(likesDTO.getId());
        likesEntity.setMyplaceId(likesDTO.getMyplaceId());
        likesEntity.setUserId(likesDTO.getUserId());

        likesRepository.save(likesEntity);
    }
}
