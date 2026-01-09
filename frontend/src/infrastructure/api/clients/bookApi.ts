import type { BookDTO } from "../../../application/dtos/BookDTO";
import type { EditionDTO } from "../../../application/dtos/EditionDTO";
import type { TableOfContentsDTO } from "../../../application/dtos/TableOfContentsDTO";
import { TableOfContentsMapper } from "../../../application/mappers/TableOfContentsMapper";
import type { TableOfContents } from "../../../domain/TableOfContents";
import { apiClient } from "../apiClient";

export class BookApi {
  
  static async getAllBooks(): Promise<BookDTO[]> {
    return await apiClient.get<BookDTO[]>('/books');
  }
  
  static async getEditionsByBook(bookCode: string): Promise<EditionDTO[]> {
    return await apiClient.get<EditionDTO[]>(`/books/${bookCode}/editions`);
  }
  
  static async getTableOfContents(
    bookCode: string, 
    editionNumber: string
  ): Promise<TableOfContents> {
    const dto = await apiClient.get<TableOfContentsDTO>(
      `/books/${bookCode}/editions/${editionNumber}/table-of-contents`
    );
    return TableOfContentsMapper.toDomain(dto, bookCode, editionNumber);
  }
}