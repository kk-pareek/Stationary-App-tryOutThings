import { Product } from "src/app/model/product";

export interface Cart {
    customerId : number,
    products : Product[]
}