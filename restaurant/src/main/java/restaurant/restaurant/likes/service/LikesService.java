package restaurant.restaurant.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.restaurant.dto.LikesDTO;
import restaurant.restaurant.entity.LikesEntity;
import restaurant.restaurant.entity.UserEntity;
import restaurant.restaurant.repository.LikesRepository;
import restaurant.restaurant.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


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

    @Transactional
    public void deleteLike(int userId, int myplaceId) {
        if (likesRepository.existsByUser_IdAndMyplace_Id(userId, myplaceId)) {
            likesRepository.deleteByUser_IdAndMyplace_Id(userId, myplaceId);
            System.out.println("좋아요가 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("좋아요를 찾을 수 없습니다..");
        }
    }

    public List<LikesDTO> findLikesByUserId(int userId) {
        List<LikesEntity> likesEntityList = likesRepository.findByUser_Id(userId);

        // EntityList -> DTOList
        List<LikesDTO> likesDTOList = new ArrayList<>();
        for (LikesEntity likesEntity : likesEntityList) {
            LikesDTO likesDTO = new LikesDTO();
            likesDTO.setId(likesEntity.getId());
            likesDTO.setMyplaceId(likesEntity.getMyplace().getId());
            likesDTO.setUserId(likesEntity.getUser().getId());
            likesDTO.setMyplaceEntity(likesEntity.getMyplace());
            likesDTOList.add(likesDTO);
        }
        return likesDTOList;
    }


}