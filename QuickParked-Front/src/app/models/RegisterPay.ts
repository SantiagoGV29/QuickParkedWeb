import { Vehicle } from "./Vehicle";

export class RegisterPay{
    id?: number;
    vehicle: Vehicle;
    price: BigInteger;

    constructor (_id: number, _vehicle: Vehicle, _price : BigInteger){
        this.id = _id;
        this.vehicle = _vehicle;
        this.price = _price;
    }
}