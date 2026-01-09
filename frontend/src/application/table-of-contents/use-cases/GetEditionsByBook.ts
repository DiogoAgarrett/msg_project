import { BookApi } from "../../../infrastructure/api/clients/bookApi";
import type { EditionDTO } from "../../dtos/EditionDTO";


export class GetEditionsByBook {
  async execute(bookCode: string): Promise<EditionDTO[]> {
    return await BookApi.getEditionsByBook(bookCode);
  }
}