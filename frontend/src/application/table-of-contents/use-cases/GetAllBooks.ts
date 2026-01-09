import { BookApi } from "../../../infrastructure/api/clients/bookApi";
import type { BookDTO } from "../../dtos/BookDTO";

export class GetAllBooks {
  async execute(): Promise<BookDTO[]> {
    return await BookApi.getAllBooks();
  }
}