import { Customer } from "./customer";
import { Partner } from "./partner";

export interface Event {
    eventId: number;
    customer: Customer;
    dateOfEvent: Date;
    amountPaid: number;
    owner: Partner;
}