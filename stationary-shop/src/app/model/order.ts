import { Product } from "./product";

export interface Order {
    customerId : number;
    products : Product[];
}