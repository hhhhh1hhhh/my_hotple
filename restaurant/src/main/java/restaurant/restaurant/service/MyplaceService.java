package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
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

//    public BoardDTO update(BoardDTO boardDTO) {
//        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
//        boardRepository.save(boardEntity);
//        return findById(boardDTO.getId());
//    }

    public MyplaceDTO edit(MyplaceDTO myplaceDTO) {
        MyplaceEntity myplaceEntity = MyplaceEntity.toEditEntity(myplaceDTO);

        System.out.println("3. place Id = " + myplaceEntity.getId());
        System.out.println("3. placeName = " + myplaceEntity.getPlaceName());
        System.out.println("3. 주소 = " + myplaceEntity.getAddress());

        myplaceRepository.save(myplaceEntity);
        return sharedService.findByPlaceId(myplaceDTO.getId());
    }
}
