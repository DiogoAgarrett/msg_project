import type { Book } from "./Book";

export interface Edition {
    editionNumber: string;
    editionName: string;
    book: Book;
}