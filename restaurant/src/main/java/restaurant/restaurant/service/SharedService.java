package restaurant.restaurant.service;

import lombok.RequiredArgsConstructor;
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


}
