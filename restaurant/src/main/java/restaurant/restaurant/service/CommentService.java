package restaurant.restaurant.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restaurant.restaurant.dto.CommentDTO;
import restaurant.restaurant.entity.CommentEntity;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.repository.CommentRepository;
import restaurant.restaurant.repository.MyplaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MyplaceRepository myplaceRepository;

    public Integer save(CommentDTO commentDTO) {
        /* 부모 엔티티(MyplaceEntity) 조회 */
        Optional<MyplaceEntity> optionalMyplaceEntity = myplaceRepository.findById(commentDTO.getMyplaceId());

        if (optionalMyplaceEntity.isPresent()) {
            MyplaceEntity myplaceEntity = optionalMyplaceEntity.get();
            CommentEntity commentEntity = CommentEntity.toSaveEntity(commentDTO, myplaceEntity);
            return commentRepository.save(commentEntity).getId();
        } else {
            return null;
        }

    }

    public List<CommentDTO> findAll(int myplaceId) {
        /*
        select *
        from comment_table
        where myplace_id=? order by id desc;
         */
        MyplaceEntity myplaceEntity = myplaceRepository.findById(myplaceId).get();
        List<CommentEntity> commentEntityList = commentRepository.findAllByMyplaceEntityOrderByIdDesc(myplaceEntity);

        /* EntityList -> DTOList */
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (CommentEntity commentEntity: commentEntityList) {
            CommentDTO commentDTO = CommentDTO.toCommentDTO(commentEntity, myplaceId);
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;

    }
}
