export class TypeVehicle{
    id?: number;
    typevehicle: string;
    rate: number;

    constructor(_id: number, _typevehicle: string, _rate: number){
        this.id = _id;
        this.rate = _rate;
        this.typevehicle = _typevehicle;
    }
}