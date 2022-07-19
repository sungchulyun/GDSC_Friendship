package com.example.friendship;

import com.example.friendship.dto.RegisPlansDto;
import com.example.friendship.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlansService {

    @Autowired
    private PlanRepository planRepository;

    public void regPlansService(RegisPlansDto regisPlansDto){

        planRepository.save(regisPlansDto.toEntity());
    }
}
