import type { Book } from "../../domain/Book";
import type { Edition } from "../../domain/Edition";
import type { Entry } from "../../domain/Entry";
import type { TableOfContents } from "../../domain/TableOfContents";
import type { EntryDTO } from "../dtos/EntryDTO";
import type { TableOfContentsDTO } from "../dtos/TableOfContentsDTO";


export class TableOfContentsMapper {
  
  static toDomain(
    dto: TableOfContentsDTO, 
    bookCode: string, 
    editionNumber: string
  ): TableOfContents {
    
    const book: Book = {
      code: bookCode,
      title: dto.bookName
    };

    const edition: Edition = {
      editionNumber: editionNumber,
      editionName: dto.editionName,
      book: book
    };

    return {
      book,
      edition,
      totalEntries: dto.totalEntries,
      entries: dto.contents.map(this.entryToDomain)
    };
  }

  private static entryToDomain(dto: EntryDTO): Entry {
    return {
      id: dto.id,
      title: dto.title,
      order: dto.order,
      children: dto.children.map(child => this.entryToDomain(child))
    };
  }
}