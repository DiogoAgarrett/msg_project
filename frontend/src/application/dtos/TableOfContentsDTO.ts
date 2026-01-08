import type { EntryDTO } from "./EntryDTO";

export interface TableOfContentsDTO {
    bookName: string;
    editionName: string;
    totalEntries: number;
    contents: EntryDTO[];
}