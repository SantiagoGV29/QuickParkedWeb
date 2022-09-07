package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Slotparking;
import org.springframework.stereotype.Service;

@Service
public interface ISlotParkingService {
    Slotparking insertSlot(Slotparking slot);
    Boolean DeleteSlot(Integer id);
}
