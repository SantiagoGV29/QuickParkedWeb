export class SlotParking{
    id?: number;
    checkin: string;

    constructor (_id: number, _checkin: string){
        this.id = _id;
        this.checkin = _checkin;
    }
}