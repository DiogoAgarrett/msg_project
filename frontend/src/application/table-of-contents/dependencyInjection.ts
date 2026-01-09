import { GetAllBooks } from "./use-cases/GetAllBooks";
import { GetEditionsByBook } from "./use-cases/GetEditionsByBook";
import { GetTableOfContents } from "./use-cases/getTableOfContents";

export const getAllTableOfContentsUseCase = new GetTableOfContents();
export const getAllBooksUseCase = new GetAllBooks();
export const getEditionsByBookUseCase = new GetEditionsByBook();