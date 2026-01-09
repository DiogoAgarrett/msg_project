import { useState, useEffect } from 'react';
import type { BookDTO } from '../../application/dtos/BookDTO';
import { getAllBooksUseCase } from '../../application/table-of-contents/dependencyInjection';


export const useBooks = () => {
  const [books, setBooks] = useState<BookDTO[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        setLoading(true);
        const result = await getAllBooksUseCase.execute();
        setBooks(result);
        setError(null);
      } catch (err) {
        setError(err instanceof Error ? err.message : 'An error occurred');
        setBooks([]);
      } finally {
        setLoading(false);
      }
    };

    fetchBooks();
  }, []);

  return { books, loading, error };
};