package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Slotparking;
import com.example.quickparkedback.Repository.ISlotParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotParkingServiceImp implements ISlotParkingService {
    @Autowired
    private ISlotParkingRepository slotParkingRepository;

    @Override
    public Slotparking insertSlot(Slotparking slot) {
        return slotParkingRepository.save(slot);
    }

    @Override
    public Boolean DeleteSlot(Long id) {
        try {
            this.slotParkingRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
