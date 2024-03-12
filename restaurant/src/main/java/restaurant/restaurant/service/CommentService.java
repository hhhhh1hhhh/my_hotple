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


    public CommentDTO findByCommentId(int id) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(id);

        if (optionalCommentEntity.isPresent()) {
            CommentEntity commentEntity = optionalCommentEntity.get();
            return CommentDTO.toCommentDTO(commentEntity, commentEntity.getMyplaceEntity().getId());
        } else {
            return null;
        }
    }


    // 댓글 수정
//    public CommentDTO editComment(int id, String commentContents) {
//        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(id);
//
//        if (optionalCommentEntity.isPresent()) {
//            CommentEntity commentEntity = optionalCommentEntity.get();
//            commentEntity.setCommentContents(commentContents);
//
//            return CommentDTO.toCommentDTO(commentRepository.save(commentEntity), commentEntity.getMyplaceEntity().getId());
//        } else {
//            return null;  // 수정 실패 시 null 반환
//        }
//    }

    public CommentDTO editComment(int id, String commentContents) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(id);

        if (optionalCommentEntity.isPresent()) {
            CommentEntity commentEntity = optionalCommentEntity.get();
            commentEntity.setCommentContents(commentContents);

            // 수정된 댓글을 저장하고, 저장된 엔티티를 DTO로 변환하여 반환
            return CommentDTO.toCommentDTO(commentRepository.save(commentEntity), commentEntity.getMyplaceEntity().getId());
        } else {
            return null;  // 수정 실패 시 null 반환
        }
    }



    public int getMyplaceIdByCommentId(int id) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(id);

        return optionalCommentEntity.map(commentEntity -> commentEntity.getMyplaceEntity().getId()).orElse(-1);
    }

    public int deleteAndGetMyplaceId(int id) {
        Optional<CommentEntity> optionalCommentEntity = commentRepository.findById(id);

        if (optionalCommentEntity.isPresent()) {
            CommentEntity commentEntity = optionalCommentEntity.get();
            int myplaceId = commentEntity.getMyplaceEntity().getId();
            commentRepository.delete(commentEntity);
            return myplaceId;
        } else {
            return -1;
        }
    }

}
