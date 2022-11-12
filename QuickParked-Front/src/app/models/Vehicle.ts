import { SlotParking } from "./SlotParking";
import { TypeVehicle } from "./TypeVehicle";

export class Vehicle {
  id?: number;
  licenceplate:string;
  slotparking: SlotParking;
  typevehicle: TypeVehicle;

  constructor(_id: number, _licenceplate:string, _slotparking: SlotParking, _typevehicle: TypeVehicle){
    this.id = _id;
    this.licenceplate = _licenceplate;
    this.slotparking = _slotparking;
    this.typevehicle = _typevehicle;
  }
}
