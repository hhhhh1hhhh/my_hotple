package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import restaurant.restaurant.dto.MyplaceDTO;
import restaurant.restaurant.entity.MyplaceEntity;
import restaurant.restaurant.repository.MyplaceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyplaceService {

    private final MyplaceRepository myplaceRepository;
    private final SharedService sharedService;

    public void save(MyplaceDTO myplaceDTO) {
        MyplaceEntity myplaceEntity = MyplaceEntity.toSaveEntity(myplaceDTO);
        myplaceRepository.save(myplaceEntity);
    }


    public List<MyplaceDTO> findByUserId(Model model) {
        Integer userId = (Integer) model.getAttribute("id");
        List<MyplaceEntity> myplaceEntityList = myplaceRepository.findByUser_Id(userId);
        List<MyplaceDTO> myplaceDTOList = new ArrayList<>();

        for (MyplaceEntity myplaceEntity : myplaceEntityList) {
            myplaceDTOList.add(MyplaceDTO.toMyplaceDTO(myplaceEntity));
        }

        return myplaceDTOList;
    }

    public Page<MyplaceDTO> paging(Pageable pageable, Model model) {
        int page = pageable.getPageNumber() - 1;
        int pageLimit = 6; // 한 페이지에 보여줄 글 갯수

        Integer userId = (Integer) model.getAttribute("id");

//        Page<MyplaceEntity> myplaceEntities = myplaceRepository
//                .findAllByShareIsTrue(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        Page<MyplaceEntity> myplaceEntities = myplaceRepository
                .findAllByUser_Id(userId, PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));

        Page<MyplaceDTO> myplaceDTOS = myplaceEntities.map(myplace
                -> new MyplaceDTO(myplace.getId(), myplace.getPlaceName(), myplace.getAddress(),
                myplace.getCategory(), myplace.getContents(), myplace.isShare(), myplace.getViews(), myplace.getLikes(),
                myplace.getCreatedTime(), myplace.getUserId(), myplace.getUser().getNickname()));

        return myplaceDTOS;
    }



    public MyplaceDTO edit(MyplaceDTO myplaceDTO) {
        MyplaceEntity myplaceEntity = MyplaceEntity.toEditEntity(myplaceDTO);

        myplaceRepository.save(myplaceEntity);
        return sharedService.findByPlaceId(myplaceDTO.getId());
    }

    public void delete(int id) {
        myplaceRepository.deleteById(id);
    }
}
