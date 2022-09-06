package com.example.quickparkedback.Service;

import com.example.quickparkedback.Model.Slotparking;

public interface ISlotParkingService {
    Slotparking insertSlot(Slotparking slot);
    Boolean DeleteSlot(Integer id);
}
