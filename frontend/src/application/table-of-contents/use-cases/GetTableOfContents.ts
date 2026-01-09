import type { TableOfContents } from "../../../domain/TableOfContents";
import { BookApi } from "../../../infrastructure/api/clients/bookApi";

export class GetTableOfContents {
  
  async execute(bookCode: string, editionNumber: string): Promise<TableOfContents> {
    return await BookApi.getTableOfContents(bookCode, editionNumber);
  }
}