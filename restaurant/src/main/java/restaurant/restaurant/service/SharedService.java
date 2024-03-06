package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.repository.MyplaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SharedService {

    private final MyplaceRepository myplaceRepository;


    public List<MyplaceDTO> findAll() {
        List<MyplaceEntity> myplaceEntityList = myplaceRepository.findAll();
        List<MyplaceDTO> myplaceDTOList = new ArrayList<>();

        for (MyplaceEntity myplaceEntity: myplaceEntityList) {
            myplaceDTOList.add(MyplaceDTO.toMyplaceDTO(myplaceEntity));
        }

        return myplaceDTOList;
    }


    @Transactional
    public void updateViews(int id) {
        myplaceRepository.updateViews(id);
    }

    public MyplaceDTO findByPlaceId(int id) {
        Optional<MyplaceEntity> optionalMyplaceEntity = myplaceRepository.findById(id);
        if (optionalMyplaceEntity.isPresent()) {
            MyplaceEntity myplaceEntity = optionalMyplaceEntity.get();
            return MyplaceDTO.toMyplaceDTO(myplaceEntity);
        } else {
            return null;
        }

    }

    public Page<MyplaceDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1;
        int pageLimit = 10; // 한 페이지에 보여줄 글 갯수

        Page<MyplaceEntity> myplaceEntities = myplaceRepository
                .findAllByShareIsTrue(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        Page<MyplaceDTO> myplaceDTOS = myplaceEntities.map(myplace
                -> new MyplaceDTO(myplace.getId(), myplace.getPlaceName(), myplace.getCategory(),
                myplace.isShare(), myplace.getViews(), myplace.getLikes(), myplace.getCreatedTime(),
                myplace.getUserId(), myplace.getUser().getNickname()));

//        System.out.println("myplaceEntities.getContent() = " + myplaceEntities.getContent()); // 요청 페이지에 해당하는 글
//        System.out.println("myplaceEntities.getTotalElements() = " + myplaceEntities.getTotalElements()); // 전체 글갯수
//        System.out.println("myplaceEntities.getNumber() = " + myplaceEntities.getNumber()); // DB로 요청한 페이지 번호
//        System.out.println("myplaceEntities.getTotalPages() = " + myplaceEntities.getTotalPages()); // 전체 페이지 갯수
//        System.out.println("myplaceEntities.getSize() = " + myplaceEntities.getSize()); // 한 페이지에 보여지는 글 갯수
//        System.out.println("myplaceEntities.hasPrevious() = " + myplaceEntities.hasPrevious()); // 이전 페이지 존재 여부
//        System.out.println("myplaceEntities.isFirst() = " + myplaceEntities.isFirst()); // 첫 페이지 여부
//        System.out.println("myplaceEntities.isLast() = " + myplaceEntities.isLast()); // 마지막 페이지 여부


        return myplaceDTOS;
    }

}
