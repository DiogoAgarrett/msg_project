import type { Book } from "./Book";
import type { Edition } from "./Edition";
import type { Entry } from "./Entry";

export interface TableOfContents {
    book: Book;
    edition: Edition;
    totalEntries: number;
    entries: Entry[];
}