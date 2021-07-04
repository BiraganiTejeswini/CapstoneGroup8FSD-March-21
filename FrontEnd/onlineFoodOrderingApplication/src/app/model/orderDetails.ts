import { Address } from "./address";
import { Customer } from "./customer";

export class orderDetails {
    orderId: number = 0;
    totalPrice: number = 0;
    totalQuantity: number = 0;
    address: Address = new Address();
    customer: Customer = new Customer();
}