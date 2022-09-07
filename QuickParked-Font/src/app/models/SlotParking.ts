export class SlotParking{
    id: number;
    checkin: Date;

    constructor (_id: number, _checkin: Date){
        this.id = _id;
        this.checkin = _checkin;
    }
}